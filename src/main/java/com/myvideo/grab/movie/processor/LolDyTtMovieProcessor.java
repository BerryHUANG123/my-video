package com.myvideo.grab.movie.processor;

import com.google.common.collect.Lists;
import com.myvideo.dao.ILolDyTtGrabErrorDao;
import com.myvideo.grab.BaseProcessor;
import com.myvideo.model.domain.DownloadDo;
import com.myvideo.model.persistant.LolDyTtGrabErrorPo;
import com.myvideo.utils.ExceptionUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class LolDyTtMovieProcessor extends BaseProcessor {

    @Autowired
    private ILolDyTtGrabErrorDao lolDyTtGrabErrorDao;

    @Override
    protected void setSite() {
        //重设site信息
        getSite().setRetryTimes(3).setSleepTime(2000);
    }

    @Override
    public void process(Page page) {
        //分析当前页面是列表页还是详情页,选择不同的处理逻辑
        boolean chart = page.getUrl().get().contains("chart");
        if (chart) {
            processForChart(page);
        } else {
            processForDetail(page);
        }
    }

    /**
     * lol电影天堂列表页处理逻辑
     *
     * @param page 下载好的页面
     */
    private void processForChart(Page page) {
        page.putField("pageType", "chart");

        //获取当前页码
        String currentPageUrl = page.getUrl().get();
        int currentPageNum = Integer.valueOf(Arrays.asList(currentPageUrl.substring((currentPageUrl.indexOf("chart") + 6))
                .split("\\.")).get(0));
        logger.info("当前页码为:{}", currentPageNum);
        page.putField("currentPageNum", currentPageNum);

        //获取当前列表页电影类型
        String type = Arrays.asList(currentPageUrl.split("/")).get(3);
        page.putField("type", type);

        //定义如何抽取页面信息，并保存下来
        Html html = page.getHtml();

        //获取总页码
        Selectable totalPageNumSelectable = html.$("div.pagebox span", "text").nodes().get(0);
        int totalPageNum = Integer.valueOf(Arrays.asList(totalPageNumSelectable.get().split("部")).get(1).split("页")[0]);
        page.putField("totalPageNum", totalPageNum);

        List<Selectable> liSelectableList = html.$("div.box3_mid ul li").nodes();
        //循环li节点集合,取出相关信息
        if (liSelectableList != null && !liSelectableList.isEmpty()) {
            for (Selectable selectable : liSelectableList) {
                Selectable infoDiv = selectable.$("div.img");
                //1.电影名称
                String movieName = infoDiv.$("a", "title").get();
                //2.电影链接
                String movieUrl = infoDiv.$("a", "href").get();
                //3.LOL电影天堂的电影代号(链接中截取,用于去重)
                String[] strs = movieUrl.split("/");
                String movieCode = Arrays.asList(strs).get(strs.length - 1);
                //4.图片地址
                String imgUrl = infoDiv.$("img", "src").get();
//                logger.info("movieName:{}", movieName);
//                logger.info("movieUrl:{}", movieUrl);
//                logger.info("movieCode:{}", movieCode);
//                logger.info("imgUrl:{}", imgUrl);

                //TODO:查询该电影是否已存在于数据库中,若存在则不再抓取
                boolean exist = false;
                if (!exist) {
                    page.addTargetRequest(movieUrl);
                }
            }
        }

        //从页面发现"下一页"的url地址来抓取
        List<Selectable> pageSelectableList = html.$("div.pageBox a[target=\"_self\"]").nodes();
        for (Selectable pageSelectable : pageSelectableList) {
            if (pageSelectable.get().trim().contains("下一页")) {
                page.addTargetRequest(pageSelectable.links().get());
            }
        }
    }

    /**
     * lol电影天堂详情页处理逻辑
     *
     * @param page 下载好的页面
     */
    private void processForDetail(Page page) {

        try {

            page.putField("pageType", "detail");

            //解析详情页,获取相关数据
            String url = page.getUrl().get();
            Html html = page.getHtml();

            //1.电影名称
            String movieName = html.$("div.lm a", "text").get();
            page.putField("name", movieName);

            //2.电影类型
            String movieType = Arrays.asList(url.split("/")).get(3);
            page.putField("type", movieType);

            //3.电影来源地址
            page.putField("sourceUrl", url);
            //5.图片地址
            String imgUrl = html.$("div.haibao a img", "src").get();
            page.putField("imgUrl", imgUrl);
            //6.主演
            String staring = null;
            String zhuYanText = html.$("div.zhuyan ul li", "text").get();
            if (StringUtils.isNotBlank(zhuYanText)) {
                staring = String.join(",", Arrays.asList(zhuYanText.split("主　演 ："))
                        .get(1).replace("/", " ").trim().split("\\s+"));
            }
            page.putField("staring", staring);
            //7.简介
            String information = html.$("div.neirong p", "text").get();
            page.putField("information", information);
            //8.下载地址收集
            //迅雷链接
            List<DownloadDo> downloadDoList = Lists.newArrayList();
            List<Selectable> thunderLiSelectableList = html.$("div[id=\"jishu\"] ul li").nodes();
            List<Selectable> btLiSelectableList = html.$("div[id=\"bt\"] ul li").nodes();
            thunderLiSelectableList.addAll(btLiSelectableList);
            for (Selectable selectable : thunderLiSelectableList) {
                String downloadUrl = selectable.$("a", "href").get();
                String downloadName = selectable.$("a", "text").get();
                DownloadDo downloadDo = new DownloadDo(downloadName, downloadUrl, DownloadDo.TYPE_THUNDER_URL);
                downloadDoList.add(downloadDo);
            }
            //磁力链接
            List<Selectable> magnetLiSelectableList = html.$("div[id=\"ljishu\"] ul li").nodes();
            for (Selectable selectable : magnetLiSelectableList) {
                String downloadUrl = selectable.$("a", "href").get();
                String downloadName = selectable.$("a", "text").get();
                DownloadDo downloadDo = new DownloadDo(downloadName, downloadUrl, DownloadDo.TYPE_MAGNET_URL);
                downloadDoList.add(downloadDo);
            }
            page.putField("downloadDoList", downloadDoList);

        } catch (Exception e) {
            //发生错误,记录发生错误的URL和错误信息到数据库中,以便完善代码
            logger.error("LolDyTtMovieProcessor->processForDetail出错:", e);
            LolDyTtGrabErrorPo grabErrorPo = new LolDyTtGrabErrorPo();
            grabErrorPo.setPageUrl(page.getUrl().get());
            grabErrorPo.setMsg(ExceptionUtil.getExceptionAllinformation(e));
            grabErrorPo.setCreateTime(new Date());
            lolDyTtGrabErrorDao.insertSelective(grabErrorPo);
        }

    }
}

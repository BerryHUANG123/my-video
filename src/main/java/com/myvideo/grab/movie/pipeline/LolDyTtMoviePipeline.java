package com.myvideo.grab.movie.pipeline;

import com.alibaba.fastjson.JSON;
import com.myvideo.dao.ILolDyTtGrabDao;
import com.myvideo.dao.ILolDyTtMovieDao;
import com.myvideo.grab.BasePipeline;
import com.myvideo.model.persistant.LolDyTtGrabPo;
import com.myvideo.model.persistant.LolDyTtGrabPoExample;
import com.myvideo.model.persistant.LolDyTtMoviePo;
import com.myvideo.model.persistant.LolDyTtMoviePoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;

import java.util.Date;
import java.util.List;

@Component
public class LolDyTtMoviePipeline extends BasePipeline {

    @Autowired
    private ILolDyTtMovieDao lolDyTtMovieDao;
    @Autowired
    private ILolDyTtGrabDao lolDyTtGrabDao;

    @Override
    public void process(ResultItems resultItems, Task task) {
        String pageType = resultItems.get("pageType");
        if (pageType.equals("chart")) {
            processForChart(resultItems, task);
        } else if (pageType.equals("detail")) {
            processForDetail(resultItems, task);
        }
    }

    private void processForChart(ResultItems resultItems, Task task) {
        //更新当前类型的grab数据库对应行的上次抓取页码
        String type = resultItems.get("type");
        LolDyTtGrabPoExample grabPoExample = new LolDyTtGrabPoExample();
        LolDyTtGrabPoExample.Criteria criteria = grabPoExample.createCriteria();
        criteria.andTypeEqualTo(type);
        List<LolDyTtGrabPo> grabPoList = lolDyTtGrabDao.selectByExample(grabPoExample);
        if (grabPoList != null && !grabPoList.isEmpty()) {
            LolDyTtGrabPo lolDyTtGrabPo = grabPoList.get(0);
            lolDyTtGrabPo.setLastGrabPageNum(resultItems.get("currentPageNum"));
            lolDyTtGrabPo.setLastTotalPageNum(resultItems.get("totalPageNum"));
            lolDyTtGrabDao.updateByPrimaryKeySelective(lolDyTtGrabPo);
        }

    }

    private void processForDetail(ResultItems resultItems, Task task) {
        LolDyTtMoviePo moviePo = new LolDyTtMoviePo();

        //1.电影名称
        moviePo.setName(resultItems.get("name"));

        //2.电影类型
        moviePo.setType(resultItems.get("type"));

        //3.来源网址Url
        moviePo.setSourceUrl(resultItems.get("sourceUrl"));

        //4.电影图片url
        moviePo.setImgUrl(resultItems.get("imgUrl"));

        //5.主演
        moviePo.setStaring(resultItems.get("staring"));

        //6.电影信息
        moviePo.setInforamation(resultItems.get("information"));

        //7.下载信息
        moviePo.setDownloadInfoList(JSON.toJSONString(resultItems.get("downloadDoList")));

        //8.查询是否有此记录并新增或更新(根据名字和类型查询)
        LolDyTtMoviePoExample lolDyTtMoviePoExample = new LolDyTtMoviePoExample();
        LolDyTtMoviePoExample.Criteria criteria = lolDyTtMoviePoExample.createCriteria();
        criteria.andNameEqualTo(moviePo.getName());
        criteria.andTypeEqualTo(moviePo.getType());
        List<LolDyTtMoviePo> oldMoviePoList = lolDyTtMovieDao.selectByExample(lolDyTtMoviePoExample);
        if (oldMoviePoList != null && !oldMoviePoList.isEmpty()) {
            //更新
            LolDyTtMoviePo oldMoviePo = oldMoviePoList.get(0);
            oldMoviePo.setUpdateTime(new Date());
            oldMoviePo.setImgUrl(moviePo.getImgUrl());
            oldMoviePo.setSourceUrl(oldMoviePo.getSourceUrl());
            oldMoviePo.setStaring(moviePo.getStaring());
            oldMoviePo.setInforamation(moviePo.getInforamation());
            oldMoviePo.setDownloadInfoList(moviePo.getDownloadInfoList());
            lolDyTtMovieDao.updateByPrimaryKeySelective(oldMoviePo);
        } else {
            //新增
            Date date = new Date();
            moviePo.setCreateTime(date);
            lolDyTtMovieDao.insertSelective(moviePo);
        }
    }
}

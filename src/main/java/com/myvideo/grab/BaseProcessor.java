package com.myvideo.grab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * 页面处理者的超类
 */
public abstract class BaseProcessor implements PageProcessor {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    //抓取网站的相关配置，包括编码、抓取间隔、重试次数等(默认重试3次,每次间隔1秒钟)
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    {
        setSite();
    }

    abstract protected void setSite();

    @Override
    public Site getSite() {
        return site;
    }
}

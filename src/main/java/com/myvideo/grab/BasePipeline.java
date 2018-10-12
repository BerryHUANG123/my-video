package com.myvideo.grab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.pipeline.Pipeline;

public abstract class BasePipeline implements Pipeline {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
}

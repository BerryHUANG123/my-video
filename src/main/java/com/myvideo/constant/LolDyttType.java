package com.myvideo.constant;

import com.google.common.collect.Lists;

import java.util.List;

public interface LolDyttType {

    /**
     * 喜剧
     */
    String COMEDY = "Xijudianying";

    /**
     * 惊悚
     */
    String THRILLER = "Kongbudianying";

    /**
     * 战争
     */
    String WAR = "Zhanzhengdianying";

    /**
     * 爱情
     */
    String ROMANCE = "Aiqingdianying";

    /**
     * 剧情
     */
    String DRAMA = "Juqingdianying";

    /**
     * 动作
     */
    String ACTION = "Dongzuodianying";

    /**
     * 科幻
     */
    String SCI_FI = "Kehuandianying";

    /**
     * 动漫
     */
    String ANIME = "Anime";

    /**
     * 所有类型的集合
     */
    List<String> TYPE_LIST = Lists.newArrayList(COMEDY, THRILLER, WAR, ROMANCE, DRAMA, ACTION, SCI_FI, ANIME);
}

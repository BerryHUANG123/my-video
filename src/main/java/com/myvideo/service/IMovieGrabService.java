package com.myvideo.service;

import com.myvideo.model.view.Result;

public interface IMovieGrabService {

    /**
     * 抓取所有电影网站(目前只有lolDyTt)
     *
     * @return 抓取结果
     */
    Result grabForAll();

    /**
     * 重新抓取错误的网页
     *
     * @return
     */
    Result grabForError();

    Result grabForNoDownloadList();
}

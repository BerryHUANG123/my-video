package com.myvideo.controller;

import com.myvideo.model.view.Result;
import com.myvideo.service.IMovieGrabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/movie")
public class MovieController extends BaseController{

    @Autowired
    private IMovieGrabService movieGrabService;

    @RequestMapping(value = "/grabForAll")
    @ResponseBody
    public Result grabForAll() {
        return movieGrabService.grabForAll();
    }

    @RequestMapping(value = "/grabForError")
    @ResponseBody
    public Result grabForError() {
        return movieGrabService.grabForError();
    }

    @RequestMapping(value = "/grabForNoDownloadList")
    @ResponseBody
    Result grabForNoDownloadList(){return movieGrabService.grabForNoDownloadList();}
}
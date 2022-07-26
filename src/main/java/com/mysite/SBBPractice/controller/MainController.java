package com.mysite.SBBPractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @RequestMapping("/sbb")
    @ResponseBody
    public String index() {
        return "sbb에 오신것을 환영합니다.";
    }
}
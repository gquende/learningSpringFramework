package com.vipas.dash.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.ws.RequestWrapper;

@Controller
public class HomeController {


public String index(){
    return "index";
}

@RequestMapping("/")
public String home(){
    return "home";
}



}

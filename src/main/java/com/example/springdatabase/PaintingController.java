package com.example.springdatabase;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PaintingController {
    @RequestMapping("/")
    public String home(){
        return "home.jsp";
    }
}

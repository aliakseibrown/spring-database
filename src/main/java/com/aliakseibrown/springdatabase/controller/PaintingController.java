package com.aliakseibrown.springdatabase.controller;

import com.aliakseibrown.springdatabase.dao.PaintingRepo;
import com.aliakseibrown.springdatabase.model.Painting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PaintingController {
    @Autowired
    PaintingRepo repo;

    @RequestMapping("/")
    public String home(){
        return "home.jsp";
    }
    @RequestMapping("/addPainting")
    public String addPainting(Painting painting){
        repo.save(painting);
        return "home.jsp";
    }

    @RequestMapping("/getPainting")
    public ModelAndView getPainting(@RequestParam Integer id){
        ModelAndView mv = new ModelAndView("showPainting.jsp");
        Painting painting = repo.findById(id).orElse(new Painting());
        mv.addObject(painting);
        return mv;
    }

}
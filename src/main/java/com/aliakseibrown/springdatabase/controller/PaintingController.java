package com.aliakseibrown.springdatabase.controller;

import com.aliakseibrown.springdatabase.dao.PaintingRepo;
import com.aliakseibrown.springdatabase.model.Painting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

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

    @RequestMapping("/paintings")
    @ResponseBody
    public List<Painting> getPaintings(){
        return repo.findAll(); //json format;
    }
    @RequestMapping("/painting/{id}")
    @ResponseBody
    public Optional<Painting> getPainting(@PathVariable("id") int id){
        return repo.findById(id);
    }

    @RequestMapping("/getPainting")
    public ModelAndView getPainting(@RequestParam Integer id){
        ModelAndView mv = new ModelAndView("showPainting.jsp");
        Painting painting = repo.findById(id).orElse(new Painting());

        System.out.println(repo.findByYear(1889));
        System.out.println(repo.findByYearGreaterThan(1880));
        System.out.println(repo.findByYearGreaterThanSorted(1880));
        mv.addObject(painting);
        return mv;
    }


}

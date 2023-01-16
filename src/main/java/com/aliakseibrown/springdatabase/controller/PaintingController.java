package com.aliakseibrown.springdatabase.controller;

import com.aliakseibrown.springdatabase.dao.PaintingRepo;
import com.aliakseibrown.springdatabase.model.Painting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.ReadWriteLock;

@RestController
public class PaintingController {
    @Autowired
    PaintingRepo repo;

    @RequestMapping("/")
    public ModelAndView home(){
        ModelAndView mav = new ModelAndView( "home.jsp");
        return mav;
        // @RestController doesn't return jsp files, works only with @Controller
    }
    @RequestMapping("/addPainting")
    public String addPainting(Painting painting){
        repo.save(painting);
        return "home.jsp";
    }

    @DeleteMapping("/painting/{id}")
    public String deletePainting(@PathVariable int id){
        Painting a = repo.getOne(id);
        repo.delete(a);
        return "deleted";
    }

    @PutMapping(path = "/painting", consumes={"application/json"})
    public Painting updatePaintings(@RequestBody Painting painting){
        repo.save(painting);
        return painting;
    }

    @PostMapping(path = "/painting", consumes={"application/json"})
    public Painting addPaintings(@RequestBody(required=false) Painting painting){
        repo.save(painting);
        return painting;
    }

    @GetMapping(path="/paintings", produces={"application/json"}) //set GET receive only xml format of data
    //@RequestMapping("/paintings")
    public List<Painting> getPaintings(){
        return repo.findAll();
    }

    @RequestMapping(path="/painting/{id}", produces={"application/json"})
    public Optional<Painting> getPainting(@PathVariable("id") int id){
        return repo.findById(id);
    }

    @RequestMapping(path="/getPainting",produces={"application/json"})
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

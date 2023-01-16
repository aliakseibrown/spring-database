package com.aliakseibrown.springdatabase.controller;

import com.aliakseibrown.springdatabase.dao.ArtistRepo;
import com.aliakseibrown.springdatabase.model.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.ReadWriteLock;

@RestController
public class ArtistController {
    @Autowired
    ArtistRepo repo;

//    @RequestMapping("/")
//    public ModelAndView home(){
//        ModelAndView mav = new ModelAndView( "home.jsp");
//        return mav;
//        // @RestController doesn't return jsp files, works only with @Controller
//    }

    @RequestMapping("/addArtist")
    public String addPainting(Artist artist){
        repo.save(artist);
        return "home.jsp";
    }

    @DeleteMapping("/artist/{name}")
    public String deleteArtist(@PathVariable String name){
        Artist a = repo.getOne(name);
        repo.delete(a);
        return "deleted";
    }

    @PutMapping(path="/artist", consumes={"application/json"})
    public Artist updateArtist(@RequestBody Artist artist){
        System.out.println("put");
        repo.save(artist);
        return artist;
    }

    @PostMapping(path="/artist")
    public Artist addArtists(Artist artist){
        //public Artist addArtists(@RequestBody(required=false) Artist artist){
        System.out.println("post");
        repo.save(artist);
        return artist;
    }

    @GetMapping(path="/artists", produces={"application/json"}) //set GET receive only xml format of data
    //@RequestMapping("/paintings")
    public List<Artist> getArist(){
        return repo.findAll();
    }

    @RequestMapping(path="/artist/{name}", produces={"application/json"})
    public Optional<Artist> getPainting(@PathVariable("name") String name){
        return repo.findById(name);
    }


}

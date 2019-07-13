/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movieNIghts.movieNights.controller;

import com.movieNIghts.movieNights.dao.DaoUserAndMovie;
import com.movieNIghts.movieNights.model.UserandmoviePK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author bizmi
 */
@Controller
public class MoviesController {
 
    @Autowired
    DaoUserAndMovie dum;

    @RequestMapping(value="getMovie/{id}",method=RequestMethod.GET)
    public String findMovie(ModelMap mm,@PathVariable("id") int movieId){
    mm.addAttribute("mId",movieId);
    return "movie";    
    }
    
@RequestMapping(value="/findUserIdByMovieId/{id}",method=RequestMethod.GET)
    public String findUserIdByMovieId(@PathVariable UserandmoviePK id){
    dum.findById(id);
    return "";    
    }
    
}

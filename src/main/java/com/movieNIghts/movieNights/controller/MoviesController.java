/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movieNIghts.movieNights.controller;

import com.movieNIghts.movieNights.authentication.AuthenticationFacadeImpl;
import com.movieNIghts.movieNights.conf.UserDetailsImpl;
import com.movieNIghts.movieNights.dao.DaoSeenMovies;
import com.movieNIghts.movieNights.dao.DaoUserAndMovie;
import com.movieNIghts.movieNights.dao.DaoWatchList;
import com.movieNIghts.movieNights.model.Seenmovies;
import com.movieNIghts.movieNights.model.User;
import com.movieNIghts.movieNights.model.Userandmovie;
import com.movieNIghts.movieNights.model.UserandmoviePK;
import com.movieNIghts.movieNights.model.Watchlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author bizmi
 */
@Controller
public class MoviesController {

    @Autowired
    AuthenticationFacadeImpl fa;
    @Autowired
    DaoUserAndMovie dum;
    @Autowired
    DaoSeenMovies dsm;
    @Autowired
    DaoWatchList dw;

    @Autowired
    AuthenticationFacadeImpl authentication;

    @RequestMapping(value = "getMovie/{id}", method = RequestMethod.GET)
    public String findMovie(ModelMap mm, @PathVariable("id") int movieId) {
        mm.addAttribute("mId", movieId);
        return "movie";
    }

    @RequestMapping(value = "/seen/{id}", method = RequestMethod.GET)
    @ResponseBody
    public void addToSeen(@PathVariable("id") int movieId, RedirectAttributes redirAttr) {
        UserDetailsImpl userd = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userd.getUser();
        Seenmovies sm = new Seenmovies(movieId, user.getId());
        sm.setUser(user);
        dsm.addToseenMovies(sm);
//        redirAttr.addFlashAttribute("seen", "Already watched that movie? Recommendations will be made based on your feedback");
//        return "redirect:/getMovie/" + movieId;

    }

    @RequestMapping(value = "/like/{id}", method = RequestMethod.GET)
    @ResponseBody
    public void like(@PathVariable("id") int movieId, RedirectAttributes redirAttr) {
        UserDetailsImpl userd = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userd.getUser();
        Userandmovie um = new Userandmovie(movieId, user.getId());
        um.setUser(user);
        dum.addToUserAndMovie(um);
        Seenmovies sm = new Seenmovies(movieId, user.getId());
        sm.setUser(user);
        dsm.addToseenMovies(sm);
//        redirAttr.addFlashAttribute("like", "This movie has been added to your favorites and to your already have watched list. Recommendations will be made based on your feedback");
//        return "redirect:/getMovie/" + movieId;

    }

    @RequestMapping(value = "/watchlist/{id}", method = RequestMethod.GET)
    @ResponseBody
    public void watchlist(@PathVariable("id") int movieId, RedirectAttributes redirAttr) {
        UserDetailsImpl userd = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userd.getUser();
        Watchlist w = new Watchlist(movieId, user.getId());
        w.setUser(user);
        dw.addToWatchList(w);
//        redirAttr.addFlashAttribute("watchlist", "Added to your watchlist.");
//        return "redirect:/getMovie/" + movieId;

    }

}

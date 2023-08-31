package de.c24.finacc.klt.API.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * IndexController
 */
@Controller
public class IndexController {

    /**
     * Index endpoint to show the index page
     *
     * @param model Spring's view model
     * @return view name
     */
    @GetMapping({"/", "/index"})
    public String index(Model model ) {
//        model.addAttribute("title", "Karten&Konten KLT");
//        model.addAttribute("welcome", "Welcome to Check24");
//        model.addAttribute("applicationTitle", "Check24 Currency Converter");
        return "index";
    }
}

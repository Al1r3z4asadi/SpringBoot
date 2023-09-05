package de.c24.finacc.klt.API.web.controller;

import de.c24.finacc.klt.API.web.controller.DTOs.CurrencyDTO;
import de.c24.finacc.klt.Core.IApplicationService.ICurrencyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;

/**
 * IndexController
 */
@Controller
@AllArgsConstructor
public class IndexController {

    /**
     * Index endpoint to show the index page
     *
     * @param model Spring's view model
     * @return view name
     */
    private final ICurrencyService _currencyService;

    @GetMapping({"/", "/index"})
    public String index(Model model ) {

        CurrencyDTO dto = new CurrencyDTO("usd", new BigDecimal("100.50")) ;
        model.addAttribute("title", "Karten&Konten KLT");
        model.addAttribute("welcome", "Welcome to Check24");
        model.addAttribute("applicationTitle", "Check24 Currency Converter");
        model.addAttribute("USD" , dto) ;
        return "index";
    }
}

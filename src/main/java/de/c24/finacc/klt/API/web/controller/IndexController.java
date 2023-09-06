package de.c24.finacc.klt.API.web.controller;

import de.c24.finacc.klt.API.rest.Models.Request.ConvertRequest;
import de.c24.finacc.klt.API.rest.Models.Response.Envelope;
import de.c24.finacc.klt.API.web.controller.DTOs.ConversionFormDTO;
import de.c24.finacc.klt.API.web.controller.DTOs.CurrencyDTO;
import de.c24.finacc.klt.Core.IApplicationService.ICurrencyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;

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

        var data = _currencyService.getList() ;

        model.addAttribute("data" , data) ;
        ConversionFormDTO conversionForm = new ConversionFormDTO();
        model.addAttribute("conversionForm", conversionForm);
        return "index";
    }
    @PostMapping("/convert")
    public String  convert(ConversionFormDTO conversionForm, Model model)  {
        var to = _currencyService.convert(new ConvertRequest(conversionForm.getCurrencyTo() , conversionForm.getCurrencyFrom() ,
                    conversionForm.getAmountFrom())) ;
        var result = ConversionFormDTO.ToForm(to) ;

        model.addAttribute("conversionForm", result);
        var data = _currencyService.getList() ;

        model.addAttribute("data" , data) ;
        return "index";
    }
}

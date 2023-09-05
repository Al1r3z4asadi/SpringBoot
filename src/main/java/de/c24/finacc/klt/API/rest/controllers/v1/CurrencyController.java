package de.c24.finacc.klt.API.rest.controllers.v1;
import de.c24.finacc.klt.API.rest.Models.Request.ConvertRequest;
import de.c24.finacc.klt.API.rest.Models.Response.Envelope;
import de.c24.finacc.klt.Core.IApplicationService.ICurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;
import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/currency")
@RequiredArgsConstructor
public class CurrencyController {
    private final ICurrencyService _currencyService;
    @GetMapping
    public ResponseEntity<Envelope> getCurrencies() {
        var result = _currencyService.getList() ;
        return ResponseEntity.ok(
                Envelope.builder().timeStamp(now())
                        .data(Map.of("currencies", result))
                        .message("currencies retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        ) ;
    }

    @GetMapping("/convert")
    public ResponseEntity<Envelope> convert(
            @RequestParam(name = "fromName",required = true) String fromName,
            @RequestParam(name = "toName",required = true) String toName,
            @RequestParam(name = "fromAmount" ,required = true) BigDecimal fromAmount
    )  {
        var to = _currencyService.convert(new ConvertRequest(toName , fromName , fromAmount )) ;
        return ResponseEntity.ok(
                Envelope.builder().timeStamp(now())
                        .data(Map.of("Converted", to))
                        .message("Success")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        ) ;
    }

}

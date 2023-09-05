package de.c24.finacc.klt.API.rest.Models.Request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data

public class ConvertRequest {

    public  ConvertRequest(String toName , String fromName , BigDecimal fromAmount){
        this.fromAmount = fromAmount ;
        this.fromName = fromName ;
        this.toName = toName ;
    }
    private String fromName ;
    private String toName ;
    private BigDecimal fromAmount ;
}

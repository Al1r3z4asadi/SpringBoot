package de.c24.finacc.klt.API.rest.Models.Response;

import de.c24.finacc.klt.Core.DomainObject.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConvertResponse {
    private  String fromName ;
    private  String toName ;
    private BigDecimal fromAmount ;
    private BigDecimal toAmount ;

    public static ConvertResponse toResponse(Currency from , Currency to){
        ConvertResponse response = new ConvertResponse() ;
        response.fromName = from.getName() ;
        response.fromAmount = from.getAmount() ;
        response.toName = to.getName() ;
        response.toAmount = to.getAmount() ;
        return response ;
    }
}

package de.c24.finacc.klt.API.web.controller.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CurrencyDTO {
    private String Name ;
    private BigDecimal Amount ;
}

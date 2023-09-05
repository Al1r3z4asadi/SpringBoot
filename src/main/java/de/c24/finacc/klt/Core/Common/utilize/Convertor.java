package de.c24.finacc.klt.Core.Common.utilize;

import de.c24.finacc.klt.Core.DomainObject.Currency;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class Convertor {
    public  static final int convertScale = 6 ;

    public static BigDecimal Convert(Currency from  , BigDecimal fromAmount , BigDecimal toAmount ){
        var fromToEuro = from.getAmount().divide(fromAmount ,  convertScale, RoundingMode.HALF_UP);
        return  fromToEuro.multiply(toAmount.setScale(convertScale , RoundingMode.HALF_UP)).setScale(convertScale , RoundingMode.HALF_UP) ;
    }
}

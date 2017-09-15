package com.lhamacorp.cashtrackerstocks.entity;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;

@Component
public class StockValidator {

    public void validate(Stock stock) throws ServletException {
        if (StringUtils.isBlank(stock.getSymbol()))
            throw new ServletException("You need to specify the stock symbol.");
    }

}

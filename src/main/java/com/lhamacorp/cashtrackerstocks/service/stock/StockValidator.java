package com.lhamacorp.cashtrackerstocks.service.stock;

import com.lhamacorp.cashtrackerstocks.entity.stock.Stock;
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

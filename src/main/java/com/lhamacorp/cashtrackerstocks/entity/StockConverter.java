package com.lhamacorp.cashtrackerstocks.entity;

import org.springframework.stereotype.Component;

@Component
public class StockConverter {

    public Stock convert(StockDTO dto) {
        if (dto == null) return null;
        Stock s = new Stock();

        s.setId(dto.getId());
        s.setSymbol(dto.getSymbol());

        return s;
    }

    public StockDTO convert(Stock bo) {
        if (bo == null) return null;
        StockDTO s = new StockDTO();

        s.setId(bo.getId());
        s.setSymbol(bo.getSymbol());

        return s;
    }

}

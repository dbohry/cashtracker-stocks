package com.lhamacorp.cashtrackerstocks.entity.trade;

import com.lhamacorp.cashtrackerstocks.entity.stock.StockConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TradeConverter {

    private StockConverter stockConverter;

    @Autowired
    public TradeConverter(StockConverter stockConverter) {
        this.stockConverter = stockConverter;
    }

    public Trade convert(TradeDTO dto) {
        if (dto == null) return null;
        Trade bo = new Trade();

        bo.setId(dto.getId());
        bo.setStock(stockConverter.convert(dto.getStock()));
        bo.setType(dto.getType() != null ? dto.getType().getId() : null);
        bo.setData(dto.getData());

        return bo;
    }

    public TradeDTO convert(Trade bo) {
        if (bo == null) return null;

        TradeDTO dto = new TradeDTO();

        dto.setId(bo.getId());
        dto.setStock(stockConverter.convert(bo.getStock()));
        dto.setType(TradeTypeEnum.valueOfId(bo.getType()).orElse(null));
        dto.setData(bo.getData());

        return dto;
    }

}

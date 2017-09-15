package com.lhamacorp.cashtrackerstocks.entity.trade;

import com.lhamacorp.cashtrackerstocks.entity.stock.StockDTO;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.joda.time.LocalDate;

public class TradeDTO {

    private Long id;
    private StockDTO stock;
    private TradeTypeEnum type;
    private LocalDate data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StockDTO getStock() {
        return stock;
    }

    public void setStock(StockDTO stock) {
        this.stock = stock;
    }

    public TradeTypeEnum getType() {
        return type;
    }

    public void setType(TradeTypeEnum type) {
        this.type = type;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        TradeDTO tradeDTO = (TradeDTO) o;

        return new EqualsBuilder()
                .append(id, tradeDTO.id)
                .append(stock, tradeDTO.stock)
                .append(type, tradeDTO.type)
                .append(data, tradeDTO.data)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(stock)
                .append(type)
                .append(data)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("stock", stock)
                .append("type", type)
                .append("data", data)
                .toString();
    }
}

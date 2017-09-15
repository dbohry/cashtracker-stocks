package com.lhamacorp.cashtrackerstocks.entity.trade;

import com.lhamacorp.cashtrackerstocks.entity.stock.StockDTO;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class TradeDTO {

    private Long id;
    private StockDTO stock;
    private Integer shares;
    private TradeTypeEnum type;
    private Long userId;

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

    public Integer getShares() {
        return shares;
    }

    public void setShares(Integer shares) {
        this.shares = shares;
    }

    public TradeTypeEnum getType() {
        return type;
    }

    public void setType(TradeTypeEnum type) {
        this.type = type;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        TradeDTO tradeDTO = (TradeDTO) o;

        return new EqualsBuilder()
                .append(id, tradeDTO.id)
                .append(stock, tradeDTO.stock)
                .append(shares, tradeDTO.shares)
                .append(type, tradeDTO.type)
                .append(userId, tradeDTO.userId)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(stock)
                .append(shares)
                .append(type)
                .append(userId)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("stock", stock)
                .append("shares", shares)
                .append("type", type)
                .append("userId", userId)
                .toString();
    }
}

package com.lhamacorp.cashtrackerstocks.entity.trade;

import com.lhamacorp.cashtrackerstocks.entity.stock.Stock;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.joda.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "trades")
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "stock_id")
    private Stock stock;
    private Integer shares;
    private Integer type;
    private LocalDate data;
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Integer getShares() {
        return shares;
    }

    public void setShares(Integer shares) {
        this.shares = shares;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
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

        Trade trade = (Trade) o;

        return new EqualsBuilder()
                .append(id, trade.id)
                .append(stock, trade.stock)
                .append(shares, trade.shares)
                .append(type, trade.type)
                .append(data, trade.data)
                .append(userId, trade.userId)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(stock)
                .append(shares)
                .append(type)
                .append(data)
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
                .append("data", data)
                .append("userId", userId)
                .toString();
    }
}

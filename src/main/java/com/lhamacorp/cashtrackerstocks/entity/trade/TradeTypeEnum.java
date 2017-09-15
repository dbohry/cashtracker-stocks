package com.lhamacorp.cashtrackerstocks.entity.trade;

import java.util.Arrays;
import java.util.Optional;

public enum TradeTypeEnum {

    BUY(1, "Buy"),
    SELL(2, "Sell");

    TradeTypeEnum(Integer id, String value) {
        this.id = id;
        this.value = value;
    }

    private Integer id;
    private String value;

    public Integer getId() {
        return id;
    }

    public static Optional<TradeTypeEnum> valueOfId(Integer id) {
        return Arrays.stream(values())
                .filter(v -> v.getId().equals(id))
                .findFirst();
    }
}

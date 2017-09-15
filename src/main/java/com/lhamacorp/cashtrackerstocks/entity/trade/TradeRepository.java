package com.lhamacorp.cashtrackerstocks.entity.trade;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TradeRepository extends JpaRepository<Trade, Long> {

    List<Trade> findAllByUserId(Long id);

}

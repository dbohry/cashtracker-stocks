package com.lhamacorp.cashtrackerstocks.service.trade;

import com.lhamacorp.cashtrackerstocks.entity.trade.Trade;
import com.lhamacorp.cashtrackerstocks.entity.trade.TradeRepository;
import com.lhamacorp.cashtrackerstocks.entity.user.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import java.util.List;

@Service
public class TradeService {

    private TradeRepository repository;
    private TradeValidator validator;
    private UserConverter userConverter;

    @Autowired
    public TradeService(TradeRepository repository,
                        TradeValidator validator,
                        UserConverter userConverter) {
        this.repository = repository;
        this.validator = validator;
        this.userConverter = userConverter;
    }

    public List<Trade> getAll() {
        return repository.findAll();
    }

    public List<Trade> getAllByUser(Long id) {
        return repository.findAllByUserId(id);
    }

    public Trade getById(Long id) {
        return repository.findOne(id);
    }

    public Trade save(Trade trade) throws ServletException {
        validator.validate(trade);
        return repository.save(trade);
    }

    public Trade update(Trade trade) throws ServletException {
        validator.validate(trade);
        return repository.save(trade);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

}

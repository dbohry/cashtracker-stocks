package com.lhamacorp.cashtrackerstocks.service;

import com.lhamacorp.cashtrackerstocks.entity.Stock;
import com.lhamacorp.cashtrackerstocks.entity.StockRepository;
import com.lhamacorp.cashtrackerstocks.entity.StockValidator;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import java.util.List;

@Service
public class StockService {

    private StockRepository repository;
    private StockValidator validator;

    @Autowired
    public StockService(StockRepository repository,
                        StockValidator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    public List<Stock> getAll() {
        return repository.findAll();
    }

    public Stock save(Stock stock) throws ServletException {
        validator.validate(stock);
        return repository.save(format(stock));
    }

    public Stock update(Stock stock) throws ServletException {
        validator.validate(stock);
        return repository.save(format(stock));
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    private Stock format(Stock s) {
        s.setSymbol(StringUtils.upperCase(s.getSymbol()));
        return s;
    }
}

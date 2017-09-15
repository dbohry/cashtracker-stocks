package com.lhamacorp.cashtrackerstocks.controller;

import com.lhamacorp.cashtrackerstocks.entity.Stock;
import com.lhamacorp.cashtrackerstocks.entity.StockConverter;
import com.lhamacorp.cashtrackerstocks.entity.StockDTO;
import com.lhamacorp.cashtrackerstocks.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ct/secure/stocks")
public class StockController {

    private StockService service;
    private StockConverter converter;

    @Autowired
    public StockController(StockService service,
                           StockConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<StockDTO>> getAll(@RequestHeader("authorization") String token) {
        List<Stock> response = service.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(response.stream()
                .map(converter::convert)
                .collect(Collectors.toList()));
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<StockDTO> save(@RequestBody StockDTO dto,
                                         @RequestHeader("authorization") String token) throws ServletException {
        Stock response = service.save(converter.convert(dto));
        return ResponseEntity.status(HttpStatus.OK).body(converter.convert(response));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<StockDTO> update(@PathVariable("id") Long id,
                                                  @RequestBody StockDTO dto,
                                                  @RequestHeader("authorization") String token) throws ServletException {
        dto.setId(id);
        Stock response = service.update(converter.convert(dto));
        return ResponseEntity.status(HttpStatus.OK).body(converter.convert(response));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable("id") Long id,
                                         @RequestHeader("authorization") String token) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("");
    }

}

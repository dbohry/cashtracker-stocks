package com.lhamacorp.cashtrackerstocks.controller;

import com.lhamacorp.cashtrackerstocks.client.UserClient;
import com.lhamacorp.cashtrackerstocks.entity.trade.Trade;
import com.lhamacorp.cashtrackerstocks.entity.trade.TradeConverter;
import com.lhamacorp.cashtrackerstocks.entity.trade.TradeDTO;
import com.lhamacorp.cashtrackerstocks.service.trade.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ct/secure/operations")
public class TradeController {

    private TradeService service;
    private TradeConverter converter;
    private UserClient userClient;

    @Autowired
    public TradeController(TradeService service,
                           TradeConverter converter,
                           UserClient userClient) {
        this.service = service;
        this.converter = converter;
        this.userClient = userClient;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<TradeDTO>> getAll(@RequestHeader("authorization") String token) {
        List<Trade> response = service.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(response.stream()
                .map(converter::convert)
                .collect(Collectors.toList()));
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<TradeDTO> save(@RequestBody TradeDTO dto,
                                         @RequestHeader("authorization") String token) throws ServletException {
        TradeDTO response = converter.convert(service.save(converter.convert(dto)));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<TradeDTO> update(@PathVariable("id") Long id,
                                           @RequestBody TradeDTO dto,
                                           @RequestHeader("authorization") String token) throws ServletException {
        dto.setId(id);
        Trade response = service.update(converter.convert(dto));
        return ResponseEntity.status(HttpStatus.OK).body(converter.convert(response));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable("id") Long id,
                                         @RequestHeader("authorization") String token) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("");
    }

}

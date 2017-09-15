package com.lhamacorp.cashtrackerstocks.client;

import com.lhamacorp.cashtrackerstocks.entity.user.UserDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("cashtracker-auth")
@RequestMapping(value = "/ct/secure")
public interface UserClient {

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    UserDTO get(@PathVariable("id") Long id,
                @RequestHeader("authorization") String token);
}

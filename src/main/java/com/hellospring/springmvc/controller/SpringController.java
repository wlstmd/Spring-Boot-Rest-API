package com.hellospring.springmvc.controller;

import com.hellospring.springmvc.dto.ItemDto;
import com.hellospring.springmvc.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class SpringController {

    @GetMapping("/spring")
    public String spring() {
        log.info("Hello, spring");
        return "{}";
    }

    @GetMapping("/member")
    public ResponseDto getMember(@RequestParam("empNo") String empNo, @RequestParam("year") int year) {
        log.info("empNo : {}", empNo);
        log.info("yaer : {}", year);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("success");
        return responseDto;
    }

    @GetMapping("/company/{id}")
    public ResponseDto getCompany(@PathVariable("id") String id) {
        log.info("id : {}", id);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("success");
        return responseDto;
    }

    @PostMapping("/item")
    public ResponseDto registerItem(@RequestBody ItemDto item) {
        log.info("item : {}", item);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("success");
        return responseDto;
    }

}

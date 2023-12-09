package com.hellospring.springmvc.controller;

import com.hellospring.springmvc.dto.ItemDto;
import com.hellospring.springmvc.dto.ResponseDto;
import com.hellospring.springmvc.service.SpringService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class SpringController {
    @Autowired
    private SpringService springService;

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
        boolean b = springService.registerItem(item);
        if (b == true) {
            ResponseDto responseDto = new ResponseDto();
            responseDto.setMessage("success");
            return responseDto;
        }


        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("fail");
        return responseDto;
    }

    @GetMapping("/item")
    public ItemDto getItem(@RequestParam("id") String id) {
        ItemDto res = springService.getItemById(id);
        return res;
    }
}

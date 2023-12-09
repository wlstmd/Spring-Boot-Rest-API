package com.hellospring.springmvc.service;

import com.hellospring.springmvc.dto.ItemDto;
import com.hellospring.springmvc.entity.ItemEntity;
import com.hellospring.springmvc.mapper.SpringMapper;
import com.hellospring.springmvc.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@Slf4j
public class SpringService {

    @Autowired
    private SpringMapper springMapper;

    @Autowired
    private ItemRepository itemRepository;

    public boolean registerItem(ItemDto itemDto) {

//        //  DB insert
//        HashMap<String, Object> paramMap = new HashMap<>();
//        paramMap.put("id", itemDto.getId());
//        paramMap.put("name", itemDto.getName());
//
//        springMapper.registerItem(paramMap);
//        log.info("service...");
//        return true;

        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setId(itemDto.getId());
        itemEntity.setName(itemDto.getName());

        itemRepository.save(itemEntity);

        return true;
    }

    public ItemDto getItemById(String id) {

//        HashMap<String, Object> paramMap = new HashMap<>();
//        paramMap.put("id", id);
//        HashMap<String, Object> res = springMapper.findById(paramMap);
//
//        ItemDto itemDto = new ItemDto();
//        itemDto.setId((String)res.get("ID"));
//        itemDto.setName((String)res.get("NAME"));
//
//        return itemDto;

        ItemEntity itemEntity = itemRepository.findById(id).get();
        ItemDto itemDto = new ItemDto();

        itemDto.setId(itemEntity.getId());
        itemDto.setName(itemEntity.getName());

        return itemDto;
    }
}

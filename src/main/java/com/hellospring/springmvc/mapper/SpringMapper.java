package com.hellospring.springmvc.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface SpringMapper {
    HashMap<String , Object> findById(HashMap<String, Object> paramMap);

    void registerItem(HashMap<String, Object> paramMap);
}

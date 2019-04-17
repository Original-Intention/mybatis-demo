package com.test.mybatis.dao;

import java.util.List;

import com.test.mybatis.javabean.Items;

public interface ItemsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Items record);

    Items selectByPrimaryKey(Integer id);

    List<Items> selectAll();

    int updateByPrimaryKey(Items record);
}
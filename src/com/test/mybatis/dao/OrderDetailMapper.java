package com.test.mybatis.dao;

import java.util.List;

import com.test.mybatis.javabean.OrderDetail;


public interface OrderDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderDetail record);

    OrderDetail selectByPrimaryKey(Integer id);

    List<OrderDetail> selectAll();

    int updateByPrimaryKey(OrderDetail record);
}
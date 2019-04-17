package com.test.mybatis.dao;

import java.util.List;

import com.test.mybatis.javabean.Orders;

public interface OrdersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Orders record);

    Orders selectByPrimaryKey(Integer id);

    List<Orders> selectAll();

    int updateByPrimaryKey(Orders record);
    
    public  List<Orders> findOrderUserDetailById(Integer id);
}
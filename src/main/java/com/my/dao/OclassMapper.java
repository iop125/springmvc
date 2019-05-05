package com.my.dao;

import com.my.domain.po.Oclass;

import java.util.List;

public interface OclassMapper {

    List<Oclass> getA(Long aa);

    void insert(Oclass oclass);
}

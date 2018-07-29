package com.gavin.componentscan.dao.impl;

import com.gavin.componentscan.dao.IPersonDao;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDaoImpl implements IPersonDao {
    @Override
    public void show() {
        System.out.println("执行了dao层的show方法……");
    }
}

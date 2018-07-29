package com.gavin.componentscan.service.impl;

import com.gavin.componentscan.dao.IPersonDao;
import com.gavin.componentscan.service.IPersonService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

//默认是单实例，开启多实例要加Scope注解
//@Service("personService")@Scope("prototype")
@Service("personService")
public class PersonServiceImpl implements IPersonService {

    @Resource
    private IPersonDao personDaoImpl;

    public IPersonDao getPersonDaoImpl() {
        return personDaoImpl;
    }

    public void setPersonDaoImpl(IPersonDao personDaoImpl) {
        this.personDaoImpl = personDaoImpl;
    }

    @Override
    public void show() {
        personDaoImpl.show();
    }
}

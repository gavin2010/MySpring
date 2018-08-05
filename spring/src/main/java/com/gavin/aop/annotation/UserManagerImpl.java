package com.gavin.aop.annotation;

import org.springframework.stereotype.Component;

@Component("userManager")
public class UserManagerImpl implements IUserManager {
    @Override
    public void addUser(String name, String password) {
       int n = 1/0;
        System.out.println("--------UserManagerImpl.addUser()----------");
    }

    @Override
    public void deleteUser(int userId) {
        System.out.println("--------UserManagerImpl.deleteUser()----------");
    }

    @Override
    public String findUser(int userId) {
        System.out.println("--------UserManagerImpl.findUser()----------");
        return null;
    }

    @Override
    public void modifyUser(int userId, String username, String password) {
        System.out.println("--------UserManagerImpl.modifyUser()----------");
    }
}

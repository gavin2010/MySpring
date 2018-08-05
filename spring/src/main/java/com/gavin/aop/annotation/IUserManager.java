package com.gavin.aop.annotation;

public interface IUserManager {
    public void addUser(String name,String password);

    public abstract void deleteUser(int userId);

    public abstract String findUser(int userId);

    public abstract void modifyUser(int userId, String username, String password);
}

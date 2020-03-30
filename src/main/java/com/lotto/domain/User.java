package com.lotto.domain;

/**
 * Created by qkrwpdud1@gmail.com on 2020/03/30
 * Github : http://github.com/jypweback
 * Description :
 */
public class User {

    private String name;

    private int money;

    public User(String name, int money){
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }
}

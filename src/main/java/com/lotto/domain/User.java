package com.lotto.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qkrwpdud1@gmail.com on 2020/03/27
 * Github : http://github.com/jypweback
 * Description :
 */
public class User {

    private String name;
    private int money;
    private List<Lotto> lottos;

    public User(String name, int money) {
        this.name = name;
        this.money = money;
        this.lottos = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public void addLotto(Lotto lotto){
        this.lottos.add(lotto);
    }
}

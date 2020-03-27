package com.lotto.config;

/**
 * Created by qkrwpdud1@gmail.com on 2020/03/24
 * Github : http://github.com/jypweback
 * Description :
 */
public enum LottoConfigEnum {

    LOTTO_MIN_NUMBER(1),
    LOTTO_MAX_NUMBER(45),
    LOTTO_MAX_LENGTH(6),
    LOTTO_PRICE(1000);

    final private int number;

    LottoConfigEnum(int number){
        this.number = number;
    }

    public int get(){
        return number;
    }
}

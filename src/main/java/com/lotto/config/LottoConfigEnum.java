package com.lotto.config;

/**
 * Created by qkrwpdud1@gmail.com on 2020/03/24
 * Github : http://github.com/jypweback
 * Description :
 */
public enum LottoConfigEnum {

    /** 로또번호 범위 start ~ end */
    LOTTO_MIN_NUMBER(1),
    LOTTO_MAX_NUMBER(45),

    /** 로또번호 최대 길이 */
    LOTTO_MAX_LENGTH(6),

    /** 로또 장당 가격 */
    LOTTO_PRICE(1000);

    final private int number;

    LottoConfigEnum(int number){
        this.number = number;
    }

    public int get(){
        return number;
    }
}

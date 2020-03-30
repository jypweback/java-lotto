package com.lotto.config;

/**
 * Created by qkrwpdud1@gmail.com on 2020/03/30
 * Github : http://github.com/jypweback
 * Description :
 */
public enum LottoResultEnum {
    FIRST_PLACE(0),
    SECOND_PLACE(0),
    THIRD_PLACE(0),
    FOURTH_PLACE(0);

    final int count;

    LottoResultEnum(int count) {
        this.count = count;
    }
}

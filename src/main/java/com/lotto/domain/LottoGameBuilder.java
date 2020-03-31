package com.lotto.domain;

import com.lotto.config.LottoConfigEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qkrwpdud1@gmail.com on 2020/03/23
 * Github : http://github.com/jypweback
 * Description : 로또게임 빌더
 */

public class LottoGameBuilder {

    private LottoGameBuilder(){}

    public static List<UserLotto> setup(int money){

        if(money < LottoConfigEnum.LOTTO_PRICE.get())
            throw new IllegalArgumentException("천원 이상 금액을 입력하세요!");

        return createUserLotto(getPossibilityLottoCount(money));
    }

    public static int getPossibilityLottoCount(int money){
        return (int)Math.floor(money / LottoConfigEnum.LOTTO_PRICE.get());
    }

    public static List<UserLotto> createUserLotto(int buyTicketCount){

        List<UserLotto> userLottos = new ArrayList<>();

        for(int i = 0; i < buyTicketCount; i++){
            userLottos.add(
                new UserLotto(LottoNumberGenerator.getLottoNumbers())
            );
        }

        return userLottos;
    }
}

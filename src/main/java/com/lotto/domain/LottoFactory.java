package com.lotto.domain;

import com.lotto.config.LottoConfigEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by qkrwpdud1@gmail.com on 2020/03/23
 * Github : http://github.com/jypweback
 * Description :
 */

public class LottoFactory {

    public static List<Lotto> createLotto(int buyTicketCount){

        List<Lotto> lottos = new ArrayList<>();

        for(int i = 0; i < buyTicketCount; i++){
            lottos.add(
                new Lotto(
                    LottoNumberGenerator.getLottoNumbers()
                )
            );
        }

        return lottos;
    }

    public static int getPossibilityTicketCount(int money){
        return (int)Math.floor(money / LottoConfigEnum.LOTTO_PRICE.get());
    }
}

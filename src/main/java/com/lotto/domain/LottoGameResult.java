package com.lotto.domain;

import com.lotto.config.LottoResultEnum;

import java.util.List;

/**
 * Created by qkrwpdud1@gmail.com on 2020/03/30
 * Github : http://github.com/jypweback
 * Description : 로또 결과를 계산한다.
 */
public class LottoGameResult {

    public static void result(final List<UserLotto> userLottos, final WinningLotto winningLotto){
        userLottos.stream()
                .forEach( userLotto -> {
                    LottoResultEnum.addUserWinningCount(getWinningCount(userLotto, winningLotto));
                });

    }

    public static int getWinningCount(UserLotto userLotto, WinningLotto winningLotto){

        return (int)userLotto
                .getLottoNumbers()
                .stream()
                .filter(uNum -> winningLotto.getLottoNumbers().contains(uNum))
                .count();

    }

}

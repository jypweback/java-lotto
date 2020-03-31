package com.lotto;

import com.lotto.domain.LottoGameBuilder;
import com.lotto.domain.LottoGameResult;
import com.lotto.domain.UserLotto;
import com.lotto.domain.WinningLotto;
import com.lotto.view.InputView;
import com.lotto.view.ResultView;

import java.util.List;

/**
 * Created by qkrwpdud1@gmail.com on 2020/03/23
 * Github : http://github.com/jypweback
 * Description : Main
 */

public class Main {
    public static void main(String[] args) {

        int money = InputView.inputMoney();
        List<UserLotto> userLottos = LottoGameBuilder.setup(money);
        ResultView.resultUserLotto(userLottos);

        WinningLotto winningLotto = InputView.inputWinningLottoNumbers();

        LottoGameResult.result(userLottos, winningLotto);
        ResultView.resultLotto(money);

    }
}

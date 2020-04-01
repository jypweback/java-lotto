package com.lotto.view;

import com.lotto.config.LottoResultEnum;
import com.lotto.domain.UserLotto;

import java.util.Arrays;
import java.util.List;

/**
 * Created by qkrwpdud1@gmail.com on 2020/03/30
 * Github : http://github.com/jypweback
 * Description : 출력 담당 UI 클래스
 */
public class ResultView {

    public static void resultUserLotto(final List<UserLotto> userLottos) {

        System.out.println(userLottos.size() + "개를 구매했습니다.");
        userLottos.stream().forEach(System.out::println);
    }

    public static void resultLotto(int money) {

        System.out.println("\n당첨 통계");
        System.out.println("################################################");
        Arrays.stream(LottoResultEnum.values())
                .forEach(result -> {
                    System.out.printf("%d개 일치 (%d원) - %d개\n", result.getWinningCount(), result.getPrice(), result.getUserWinningCount());
                });

        System.out.printf("총 수익률은 %.2f입니다.\n", LottoResultEnum.getLottoEarningsRate(money));
    }
}

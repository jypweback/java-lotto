package com.lotto.domain;


import com.lotto.config.LottoResultEnum;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by qkrwpdud1@gmail.com on 2020/03/30
 * Github : http://github.com/jypweback
 * Description :
 */
public class LottoGameResultTest {

    private WinningLotto winningLotto;

    @Before
    public void setUp(){
        winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    }


    @Test
    public void 로또당첨결과_계산() {

        List<UserLotto> userLottos = getUserLotto();

        userLottos.stream()
                .forEach(userLotto -> {
                    long count = userLotto
                            .getLottoNumbers()
                            .stream()
                            .filter(uNumber -> winningLotto.getLottoNumbers().contains(uNumber))
                            .count();

                    LottoResultEnum.addUserWinningCount((int) count);

                });

        Arrays.stream(LottoResultEnum.values()).forEach(e -> {
            System.out.println("####### 순위 : " + e.getRanking() + " / " + e.getWinningCount() + " / " + e.getUserWinningCount());
        });
    }

    @Test
    public void 로또_정답_카운팅_테스트() {

        // given
        WinningLotto winningLotto = this.winningLotto;
        UserLotto userLotto = new UserLotto(Arrays.asList(1, 2, 3, 40, 41, 42));
        final int expectedCount = 3;

        // when
        final int count = LottoGameResult.getWinningCount(userLotto, winningLotto);

        // then
        assertThat(count).isEqualTo(expectedCount);

    }

    public static List<UserLotto> getUserLotto() {
        List<UserLotto> userLottos = new ArrayList<>();

        // 1등 3개
        userLottos.add(new UserLotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        userLottos.add(new UserLotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        userLottos.add(new UserLotto(Arrays.asList(1, 2, 3, 4, 5, 6)));

        // 3등 2개
        userLottos.add(new UserLotto(Arrays.asList(1, 2, 3, 4, 5, 9)));
        userLottos.add(new UserLotto(Arrays.asList(1, 2, 3, 4, 8, 9)));

        // 4등 1개
        userLottos.add(new UserLotto(Arrays.asList(1, 2, 3, 7, 8, 9)));

        return userLottos;
    }
}
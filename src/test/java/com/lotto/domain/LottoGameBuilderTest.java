package com.lotto.domain;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Created by qkrwpdud1@gmail.com on 2020/03/27
 * Github : http://github.com/jypweback
 * Description :
 */
public class LottoGameBuilderTest {

    @Test
    public void 구매가능한_티켓_카운트_테스트(){

        // given
        final int money = 6050;

        // when
        int count = LottoGameBuilder.getPossibilityLottoCount(money);

        // then
        assertThat(count).isEqualTo(6);
    }

    @Test
    public void 티켓카운트의_개수만큼_사용자로또가_반환된다(){

        // given
        final int ticketCount = 5;

        // when
        List<UserLotto> userLottoList = LottoGameBuilder.createUserLotto(ticketCount);

        // then
        assertThat(userLottoList.size()).isEqualTo(ticketCount);

    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_천원미만_금액입력시_exeption_발생(){

        // given
        final int money = 900;

        // when
        LottoGameBuilder.setup(money);

        // exception 발생
    }

}
package com.lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Created by qkrwpdud1@gmail.com on 2020/03/27
 * Github : http://github.com/jypweback
 * Description :
 */
public class LottoFactoryTest {

    @Test
    public void 구매가능한_티켓_카운트_테스트(){

        // given
        final int money = 6050;

        // when
        int count = LottoFactory.getPossibilityTicketCount(money);

        // then
        assertThat(count).isEqualTo(6);
    }

}
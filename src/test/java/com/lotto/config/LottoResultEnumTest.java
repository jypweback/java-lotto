package com.lotto.config;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Created by qkrwpdud1@gmail.com on 2020/03/31
 * Github : http://github.com/jypweback
 * Description :
 */
public class LottoResultEnumTest {

    @Before
    public void before() {
        LottoResultEnum.clear();
    }

    @Test
    public void 소수점_자리수_계산() {

        // given
        double pi = Math.PI;

        // when
        double decimalPlace = LottoResultEnum.cutDecimalPlace(pi);

        // then
        assertThat(decimalPlace).isEqualTo(3.14);

    }

    @Test
    public void 로또4등_1개당첨시_맞춘개수_1개가반환된다() {

        // given
        int otherUserWinningCount = 0;
        int userWinningCount = 1;

        // when
        LottoResultEnum.addUserWinningCount(LottoResultEnum.FOURTH.getWinningCount());

        // then
        assertThat(LottoResultEnum.FOURTH.getUserWinningCount()).isEqualTo(userWinningCount);
        assertThat(LottoResultEnum.FIRST.getUserWinningCount()).isEqualTo(otherUserWinningCount);
        assertThat(LottoResultEnum.SECOND.getUserWinningCount()).isEqualTo(otherUserWinningCount);
        assertThat(LottoResultEnum.THIRD.getUserWinningCount()).isEqualTo(otherUserWinningCount);
    }

    @Test
    public void 로또3등_1개당첨시_맞춘개수_1개가반환된다() {

        // given
        int otherUserWinningCount = 0;
        int userWinningCount = 1;

        // when
        LottoResultEnum.addUserWinningCount(LottoResultEnum.THIRD.getWinningCount());

        // then
        assertThat(LottoResultEnum.THIRD.getUserWinningCount()).isEqualTo(userWinningCount);
        assertThat(LottoResultEnum.FIRST.getUserWinningCount()).isEqualTo(otherUserWinningCount);
        assertThat(LottoResultEnum.SECOND.getUserWinningCount()).isEqualTo(otherUserWinningCount);
        assertThat(LottoResultEnum.FOURTH.getUserWinningCount()).isEqualTo(otherUserWinningCount);
    }

    @Test
    public void 로또3등4등_각각당첨시_맞춘개수_각각1개씩반환된다() {

        // given
        int otherUserWinningCount = 0;
        int userWinningCount = 1;

        // when
        LottoResultEnum.addUserWinningCount(LottoResultEnum.THIRD.getWinningCount());
        LottoResultEnum.addUserWinningCount(LottoResultEnum.FOURTH.getWinningCount());

        // then
        assertThat(LottoResultEnum.FIRST.getUserWinningCount()).isEqualTo(otherUserWinningCount);
        assertThat(LottoResultEnum.SECOND.getUserWinningCount()).isEqualTo(otherUserWinningCount);
        assertThat(LottoResultEnum.THIRD.getUserWinningCount()).isEqualTo(userWinningCount);
        assertThat(LottoResultEnum.FOURTH.getUserWinningCount()).isEqualTo(userWinningCount);
    }

    @Test
    public void 로또4등_1개당첨_상금5천원이_반환된다() {

        // given
        int totalPrice = 5000;
        LottoResultEnum.addUserWinningCount(LottoResultEnum.FOURTH.getWinningCount());

        // when
        double price = LottoResultEnum.getTotalPrice();

        // then
        assertThat(price).isEqualTo(totalPrice);
    }

    @Test
    public void 로또4등_2개당첨_상금만원이_반환된다() {
        // given
        int totalPrice = LottoResultEnum.FOURTH.getPrice() * 2;
        LottoResultEnum.addUserWinningCount(LottoResultEnum.FOURTH.getWinningCount());
        LottoResultEnum.addUserWinningCount(LottoResultEnum.FOURTH.getWinningCount());

        // when
        double price = LottoResultEnum.getTotalPrice();

        // then
        assertThat(price).isEqualTo(totalPrice);
    }

    @Test
    public void 로또1등4등_각각당첨_상금이_이십억5천원_반환된다() {
        // given
        int totalPrice = LottoResultEnum.FIRST.getPrice() + LottoResultEnum.FOURTH.getPrice();
        LottoResultEnum.addUserWinningCount(LottoResultEnum.FIRST.getWinningCount());
        LottoResultEnum.addUserWinningCount(LottoResultEnum.FOURTH.getWinningCount());

        // when
        int total = LottoResultEnum.getTotalPrice();

        // then
        assertThat(total).isEqualTo(totalPrice);
    }

    @Test
    public void 로또1등2등3등4등_각각당첨_상금이_이십억5천원_반환된다() {
        // given
        int totalPrice = LottoResultEnum.FIRST.getPrice() +
                LottoResultEnum.SECOND.getPrice() +
                LottoResultEnum.THIRD.getPrice() +
                LottoResultEnum.FOURTH.getPrice();

        LottoResultEnum.addUserWinningCount(LottoResultEnum.FIRST.getWinningCount());
        LottoResultEnum.addUserWinningCount(LottoResultEnum.SECOND.getWinningCount());
        LottoResultEnum.addUserWinningCount(LottoResultEnum.THIRD.getWinningCount());
        LottoResultEnum.addUserWinningCount(LottoResultEnum.FOURTH.getWinningCount());

        // when
        int total = LottoResultEnum.getTotalPrice();

        // then
        assertThat(total).isEqualTo(totalPrice);
    }

    @Test
    public void 만4천원투입_로또4등_1개_당첨_수익률_영점삼오_반환된다() {

        // given
        int money = 14000;
        double rate = 0.35;
        LottoResultEnum.addUserWinningCount(LottoResultEnum.FOURTH.getWinningCount());

        // when
        double earningsRate = LottoResultEnum.getLottoEarningsRate(money);

        // then
        assertThat(earningsRate).isEqualTo(rate);
    }

    @Test
    public void 만원투입_로또4등_2개_당첨_수익률_1_반환된다() {

        // given
        int money = 10000;
        double rate = 1.0;
        LottoResultEnum.addUserWinningCount(LottoResultEnum.FOURTH.getWinningCount());
        LottoResultEnum.addUserWinningCount(LottoResultEnum.FOURTH.getWinningCount());

        // when
        double earningsRate = LottoResultEnum.getLottoEarningsRate(money);

        // then
        assertThat(earningsRate).isEqualTo(rate);
    }

    @Test
    public void 오천원투입_로또4등_2개_당첨_수익률_2_반환된다() {

        // given
        int money = 5000;
        double rate = 2.0;
        LottoResultEnum.addUserWinningCount(LottoResultEnum.FOURTH.getWinningCount());
        LottoResultEnum.addUserWinningCount(LottoResultEnum.FOURTH.getWinningCount());

        // when
        double earningsRate = LottoResultEnum.getLottoEarningsRate(money);

        // then
        assertThat(earningsRate).isEqualTo(rate);
    }
}
package com.lotto.config;

import org.junit.Before;
import org.junit.Test;

import java.text.DecimalFormat;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Created by qkrwpdud1@gmail.com on 2020/03/31
 * Github : http://github.com/jypweback
 * Description :
 */
public class LottoResultEnumTest {

    private int usedMoney;
    private LottoResultEnum lottoEnum;

    @Before
    public void setUp() {
        // 로또 4등 당첨 : 상금 5천원
        usedMoney = 14000;
        lottoEnum = LottoResultEnum.FOURTH;
        LottoResultEnum.addUserWinningCount(lottoEnum.getWinningCount());
    }

    @Test
    public void 소수점_자리수_계산() {

        // given
        double pi = Math.PI;

        System.out.println(pi);

        // when
        double decimalPlace = LottoResultEnum.cutDecimalPlace(pi);

        // then
        assertThat(decimalPlace).isEqualTo(3.14);

    }

    @Test
    public void 토탈_상금_테스트() {

        // given
        int totalPrice = 5000;

        // when
        double price = LottoResultEnum.getTotalPrice();

        // then
        assertThat(price).isEqualTo(totalPrice);
    }

    @Test
    public void 수익률_계산테스트() {

        // given
        double rate = 0.35;

        // when
        double lottoEarningsRate = LottoResultEnum.getLottoEarningsRate(usedMoney);

        // then
        assertThat(lottoEarningsRate).isEqualTo(rate);
    }

}
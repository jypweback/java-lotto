package com.lotto.domain;

import com.lotto.config.LottoConfigEnum;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * Created by qkrwpdud1@gmail.com on 2020/03/27
 * Github : http://github.com/jypweback
 * Description :
 */
public class LottoNumberGeneratorTest {

    private LottoNumberGenerator lottoNumberGenerator;

    @Before
    public void setUp(){
        lottoNumberGenerator = new LottoNumberGenerator();
    }

    @Test
    public void 지정된범위의_랜덤숫자를_반환한다(){

        // given
        final int minNumber = LottoConfigEnum.LOTTO_MIN_NUMBER.get();
        final int maxNumber = LottoConfigEnum.LOTTO_MAX_NUMBER.get();
        final int lottoMaxLength = LottoConfigEnum.LOTTO_MAX_LENGTH.get();

        // when
        List<Integer> lottoNumbers = lottoNumberGenerator.getLottoNumbers();

        // then
        assertThat(lottoNumbers).size().isEqualTo(lottoMaxLength);

        for (Integer lottoNumber : lottoNumbers){
            assertThat(lottoNumber).isBetween(minNumber, maxNumber);
        }
    }

}
package com.lotto.domain;

import com.lotto.config.LottoConfigEnum;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by qkrwpdud1@gmail.com on 2020/03/26
 * Github : http://github.com/jypweback
 * Description : 로또 숫자 생성 클래스
 */

public class LottoNumberGenerator {

    private static final int LIST_MIN_INDEX = 0;

    public static List<Integer> getLottoNumbers() {

        List<Integer> numbers = IntStream.range(
                LottoConfigEnum.LOTTO_MIN_NUMBER.get(),
                LottoConfigEnum.LOTTO_MAX_NUMBER.get())
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(numbers);

        return numbers.subList(LIST_MIN_INDEX, LottoConfigEnum.LOTTO_MAX_LENGTH.get());
    }
}

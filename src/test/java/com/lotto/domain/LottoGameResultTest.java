package com.lotto.domain;


import com.lotto.config.LottoResultEnum;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by qkrwpdud1@gmail.com on 2020/03/30
 * Github : http://github.com/jypweback
 * Description :
 */
public class LottoGameResultTest {

    @Test
    public void 로또당첨결과_계산() {

//        List<Integer> uNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
//        List<Integer> wNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 7, 8, 9));
//
//        List<Integer> cNumbers =
//                uNumbers.stream()
//                        .filter(uNumber -> wNumbers.contains(uNumber))
//                        .collect(Collectors.toList());

        List<UserLotto> userLottos = new ArrayList<>();
        userLottos.add(new UserLotto(Arrays.asList(1,2,3,4,5,6)));
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1,2,3,7,8,9));

        int count3 = 0;
        int count4 = 0;
        int count5 = 0;
        int count6 = 0;

        userLottos.stream()
                .forEach( userLotto -> {
                    userLotto.getLottoNumbers().stream().filter(uNumber -> winningLotto.getLottoNumbers().contains(uNumber)).count();
                });

        /*LottoResultEnum.FIRST_PLACE(5);*/

//        userLottos.stream()
//                .forEach( userLotto -> {
//                    userLotto.getLottoNumbers().stream().filter(uNumber -> winningLotto.getLottoNumbers().stream().)
//                });

    }

}
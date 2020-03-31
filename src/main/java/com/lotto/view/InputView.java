package com.lotto.view;

import com.lotto.domain.WinningLotto;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by qkrwpdud1@gmail.com on 2020/03/30
 * Github : http://github.com/jypweback
 * Description : 입력담당 UI 클래스
 */
public class InputView {

    private static final String SPLIT_STRING = ",";

    public static int inputMoney() {

        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static WinningLotto inputWinningLottoNumbers() {

        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String winningLotto = scanner.next();
        return new WinningLotto(
                Arrays.stream(winningLotto.split(SPLIT_STRING))
                        .map(n -> Integer.parseInt(n))
                        .collect(Collectors.toList())
        );
    }

}

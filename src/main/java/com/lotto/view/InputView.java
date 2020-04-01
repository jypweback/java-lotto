package com.lotto.view;

import com.lotto.domain.WinningLotto;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by qkrwpdud1@gmail.com on 2020/03/30
 * Github : http://github.com/jypweback
 * Description : 입력담당 UI 클래스
 */
public class InputView {

    private static final String SPLIT_STRING = ",";
    private static final String NUMBER_FORMAT_EXCEPTION_MESSAGE = "숫자만 입력 가능합니다.";

    public static int inputMoney() {

        while (true) {
            try {
                System.out.println("\n구입금액을 입력해 주세요.");
                Scanner scanner = new Scanner(System.in);
                return scanner.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println(NUMBER_FORMAT_EXCEPTION_MESSAGE);
                continue;
            } catch (RuntimeException runtimeException) {
                throw new RuntimeException();
            }
        }
    }

    public static WinningLotto inputWinningLottoNumbers() {

        while (true) {
            System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
            Scanner scanner = new Scanner(System.in);
            String winningLotto = scanner.nextLine().replace(" ", "");

            try {

                List<Integer> numbers = Arrays.stream(winningLotto.split(SPLIT_STRING))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

                return new WinningLotto(numbers);
            } catch (NumberFormatException exception) {
                System.out.println(NUMBER_FORMAT_EXCEPTION_MESSAGE);
                continue;
            }
        }
    }

}

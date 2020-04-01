package com.lotto.config;

import java.util.Arrays;

/**
 * Created by qkrwpdud1@gmail.com on 2020/03/31
 * Github : http://github.com/jypweback
 * Description : 로또게임 결과 열거형
 */
public enum LottoResultEnum {

    FIRST(1, 6, 2_000_000_000, 0),
    SECOND(2, 5, 1_500_000, 0),
    THIRD(3, 4, 50_000, 0),
    FOURTH(4, 3, 5_000, 0);

    private static final int ADD_COUNT_NUM = 1;
    private static final int DECIMAL_FLOOR = 100;

    private final int ranking;
    private final int winningCount;
    private final int price;
    private int userWinningCount;

    LottoResultEnum(int ranking, int winningCount, int price, int userWinningCount) {
        this.ranking = ranking;
        this.winningCount = winningCount;
        this.price = price;
        this.userWinningCount = userWinningCount;
    }

    public int getRanking() {
        return this.ranking;
    }

    public int getWinningCount() {
        return this.winningCount;
    }

    public int getPrice() {
        return this.price;
    }

    public int getUserWinningCount() {
        return this.userWinningCount;
    }

    public static void addUserWinningCount(final int userWinningCount) {
        Arrays.stream(LottoResultEnum.values())
                .filter(e -> e.getWinningCount() == userWinningCount)
                .forEach(e -> {
                    e.userWinningCount += ADD_COUNT_NUM;
                });
    }

    public static double getLottoEarningsRate(int money) {
        double rate = (double) getTotalPrice() / money;
        return cutDecimalPlace(rate);
    }

    public static int getTotalPrice() {
        return Arrays.stream(LottoResultEnum.values())
                .mapToInt(e -> e.getPrice() * e.getUserWinningCount())
                .sum();
    }

    public static double cutDecimalPlace(double rate) {
        return (int) (rate * DECIMAL_FLOOR) / (double) DECIMAL_FLOOR;
    }

    public static void clear() {
        Arrays.stream(LottoResultEnum.values())
                .forEach(e -> e.userWinningCount = 0);
    }
}

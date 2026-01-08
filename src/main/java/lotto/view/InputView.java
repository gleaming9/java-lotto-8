package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PAYMENT_MESSAGE = "\n구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE= "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE= "\n보너스 번호를 입력해 주세요.";

    public static String getPayment(){
        System.out.println(PAYMENT_MESSAGE);
        return Console.readLine();
    }

    public static String getWinningNumber(){
        System.out.println(WINNING_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public static String getBonusNumber(){
        System.out.println(BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }
}

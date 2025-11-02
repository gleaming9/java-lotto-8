package lotto.view;

import lotto.domain.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String PAYMENT_COUNT_FORMAT = "\n%d개를 구매했습니다.\n";

    public static void printLotto(List<Lotto> lottos){
        System.out.printf(PAYMENT_COUNT_FORMAT,lottos.size());

        for(Lotto lotto : lottos){
            String lottoString = lotto.getNumbers().stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(",","[","]"));

            System.out.println(lottoString);
        }
    }

    public static void printError(String message){
        System.out.println(message);
    }
}

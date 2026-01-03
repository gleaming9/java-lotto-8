package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private final static String BUY_MESSAGE = "\n%d개를 구매했습니다.\n";
    private final static String RESULT_HEADER = "\n당첨 통계\n ---";
    private final static String RANK_FORMAT = "%s - %d개\n";
    private final static String RATE_FORMAT = "총 수익률은 %.1f%%입니다.";

    public static void printLottos(List<Lotto> lottos) {
        System.out.printf(BUY_MESSAGE, lottos.size());
        for (Lotto lotto : lottos) {
            String lottoString = lotto.getNumbers().stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ", "[", "]"));
            System.out.println(lottoString);
        }
    }

    public static void printResult(LottoResult lottoResult) {
        System.out.println(RESULT_HEADER);
        for (LottoRank rank : LottoRank.values()) {
            if (rank == LottoRank.MISS) continue;

            int cnt = lottoResult.getRankCounts().get(rank);
            System.out.printf(RANK_FORMAT, rank.getDescription(), cnt);
        }
        System.out.printf(RATE_FORMAT, lottoResult.getProfitRate());
    }

    public static void printError(String errorDescription) {
        System.out.println(errorDescription);
    }
}

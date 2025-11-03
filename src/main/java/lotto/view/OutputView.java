package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String PAYMENT_COUNT_FORMAT = "\n%d개를 구매했습니다.\n";
    private static final String STATISTIC_HEADER = "\n당첨 통계";
    private static final String STATISTIC_DIVIDER = "---";
    private static final String STATISTIC_RANK_FORMAT = "%s - %d개\n";
    private static final String PROFIT_RATE_FORMAT = "총 수익률은 %.1f%%입니다.\n";

    public static void printLotto(List<Lotto> lottos) {
        System.out.printf(PAYMENT_COUNT_FORMAT, lottos.size());

        for (Lotto lotto : lottos) {
            String lottoString = lotto.getNumbers().stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ", "[", "]"));

            System.out.println(lottoString);
        }
    }

    public static void printResult(LottoResult lottoResult) {
        System.out.println(STATISTIC_HEADER);
        System.out.println(STATISTIC_DIVIDER);

        for (LottoRank rank : LottoRank.values()) {
            if (rank == LottoRank.MISS) {
                continue;
            }

            String description = rank.getDescription();
            int count = lottoResult.getRankCounts().get(rank);
            System.out.printf(STATISTIC_RANK_FORMAT, description, count);
        }
        System.out.printf(PROFIT_RATE_FORMAT, lottoResult.getProfitRate());
    }

    public static void printError(String message) {
        System.out.println(message);
    }
}

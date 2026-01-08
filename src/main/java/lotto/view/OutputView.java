package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

import java.util.List;

public class OutputView {
    private static final String LOTTO_FORMAT = "%d개를 구매했습니다.\n";
    private static final String RESULT_HEADER = "당첨 통계\n ---";
    private static final String RANK_FORMAT = "%s%d개\n";
    private static final String PROFIT_RATE_FORMAT = "총 수익률은 %.1f%%입니다.";

    public static void printLotto(List<Lotto> lottos) {
        System.out.printf(LOTTO_FORMAT, lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.lottoString());
        }
    }

    public static void printResult(LottoResult lottoResult) {
        System.out.println(RESULT_HEADER);
        for (Rank rank : Rank.values()) {
            if (rank == Rank.MISS) continue;
            int count = lottoResult.getLottoResult().get(rank);
            System.out.printf(RANK_FORMAT, rank.getDescription(), count);
        }
        System.out.printf(PROFIT_RATE_FORMAT, lottoResult.getProfitRate());
    }

    public static void printError(String message) {
        System.out.println(message);
    }
}

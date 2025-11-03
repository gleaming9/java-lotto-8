package lotto.domain;

import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> rankCounts;
    private final double profitRate;

    public LottoResult(Map<LottoRank, Integer> rankCounts, double profitRate) {
        this.rankCounts = rankCounts;
        this.profitRate = profitRate;
    }

    public Map<LottoRank, Integer> getRankCounts() {
        return rankCounts;
    }

    public double getProfitRate() {
        return profitRate;
    }
}

package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private Map<LottoRank, Integer> rankCounts;
    private double profitRate;

    public LottoResult() {
        rankCounts = initializeRankCounts();
    }

    private Map<LottoRank, Integer> initializeRankCounts() {
        Map<LottoRank, Integer> rankCounts = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank, 0);
        }
        return rankCounts;
    }

    public void add(LottoRank rank) {
        rankCounts.put(rank, rankCounts.get(rank) + 1);
    }

    public void calculateProfitRate(long payment) {
        long totalPrize = calculateTotalPrize();
        profitRate = (double) totalPrize / payment * 100.0;
    }

    private long calculateTotalPrize() {
        long sum = 0;
        for (LottoRank rank : rankCounts.keySet()) {
            sum += rankCounts.get(rank) * rank.getAmount();
        }
        return sum;
    }

    public Map<LottoRank, Integer> getRankCounts() {
        return rankCounts;
    }

    public double getProfitRate() {
        return profitRate;
    }
}

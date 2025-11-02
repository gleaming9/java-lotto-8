package lotto.LottoService;

import lotto.domain.*;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoCalculateService {

    public LottoResult calculateStatistic(List<Lotto> lottos,
                                          WinningNumber winningNumber,
                                          BonusNumber bonusNumber,
                                          Payment payment) {
        Map<LottoRank, Integer> rankCounts = initializeRankCounts();

        for (Lotto lotto : lottos) {
            int matchCount = calculateMatchCount(lotto, winningNumber);
            boolean bonus = hasBonusNumber(lotto, bonusNumber);
            LottoRank rank = LottoRank.valueOf(matchCount, bonus);

            rankCounts.put(rank, rankCounts.get(rank) + 1);
        }
        double profitRate = calculateProfitRate(rankCounts, payment);

        return new LottoResult(rankCounts, profitRate);
    }

    private Map<LottoRank, Integer> initializeRankCounts(){
        Map<LottoRank, Integer> rankCounts = new EnumMap<>(LottoRank.class);
        for(LottoRank rank : LottoRank.values()){
            rankCounts.put(rank,0);
        }
        return rankCounts;
    }

    private int calculateMatchCount(Lotto lotto, WinningNumber winningNumber) {
        return (int) lotto.getNumbers().stream().
                filter(lottoNumber -> winningNumber.getNumbers().contains(lottoNumber))
                .count();
    }

    private boolean hasBonusNumber(Lotto lotto, BonusNumber bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber.getNumber());
    }

    private double calculateProfitRate(Map<LottoRank, Integer> rankCounts, Payment payment){
        long sum = 0;
        for(LottoRank key : rankCounts.keySet()){
            long prizeMoney = key.getPriceMoney();
            int count = rankCounts.get(key);

            sum += prizeMoney * count;
        }
        return ((double) sum / payment.getAmount()) * 100.0;
    }
}

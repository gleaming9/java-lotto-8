package lotto.service;

import lotto.domain.*;

import java.util.*;

public class LottoCalcService {
    public LottoResult calculateResult(Payment payment, List<Lotto> lottos,
                                       WinningNumber winningNumber, BonusNumber bonusNumber) {
        Map<Rank, Integer> resultMap = initializeMap();

        for (Lotto lotto : lottos) {
            int matchCount = winningNumber.calcMatchCount(lotto.getNumbers());
            Rank rank = Rank.getRank(matchCount, hasBonus(lotto, bonusNumber));
            resultMap.put(rank, resultMap.get(rank) + 1);
        }
        double profitRate = calcProfitRate(payment, resultMap);

        return new LottoResult(resultMap, profitRate);
    }

    private Map<Rank, Integer> initializeMap() {
        Map<Rank, Integer> resultMap = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            resultMap.put(rank, 0);
        }
        return resultMap;
    }

    private boolean hasBonus(Lotto lotto, BonusNumber bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber.getBonusNumber());
    }

    private double calcProfitRate(Payment payment, Map<Rank, Integer> resultMap) {
        long sum = 0;
        for (Rank rank : Rank.values()) {
            sum += resultMap.get(rank) * rank.getPrice();
        }
        return (double) sum / payment.getPayment() * 100.0;
    }
}

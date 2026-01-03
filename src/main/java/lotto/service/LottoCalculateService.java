package lotto.service;

import lotto.domain.*;

import java.util.List;

public class LottoCalculateService {
    public LottoResult calculateResult(Payment payment, List<Lotto> lottos,
                                       WinningNumber winningNumber, BonusNumber bonusNumber) {
        LottoResult lottoResult = new LottoResult();

        for (Lotto lotto : lottos) {
            int matchCount = calcMatchCount(lotto, winningNumber);
            boolean hasBonus = hasBonusNumber(lotto, bonusNumber);
            LottoRank rank = calcRank(matchCount, hasBonus);
            lottoResult.add(rank);
        }

        lottoResult.calculateProfitRate(payment.getPayment());
        return lottoResult;
    }

    private int calcMatchCount(Lotto lotto, WinningNumber winningNumber) {
        return (int) lotto.getNumbers().stream()
                .filter(num -> winningNumber.getWinningNumber().contains(num))
                .count();
    }

    private boolean hasBonusNumber(Lotto lotto, BonusNumber bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber.getBonusNumber());
    }

    private LottoRank calcRank(int matchCount, boolean hasBonus) {
        LottoRank rank = LottoRank.MISS;
        if (matchCount == 3) rank = LottoRank.FIFTH;
        if (matchCount == 4) rank = LottoRank.FOURTH;
        if (matchCount == 5) rank = LottoRank.THIRD;
        if (matchCount == 5 && hasBonus) rank = LottoRank.SECOND;
        if (matchCount == 6) rank = LottoRank.FIRST;
        return rank;
    }
}

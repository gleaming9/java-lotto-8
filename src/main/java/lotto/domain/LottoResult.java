package lotto.domain;

import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> lottoResult;
    private final double profitRate;

    public LottoResult(Map<Rank, Integer> lottoResult, double profitRate){
        this.lottoResult = lottoResult;
        this.profitRate = profitRate;
    }

    public Map<Rank, Integer> getLottoResult() {
        return lottoResult;
    }

    public double getProfitRate() {
        return profitRate;
    }
}

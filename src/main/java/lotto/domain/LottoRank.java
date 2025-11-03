package lotto.domain;

public enum LottoRank {
    MISS("", 0),
    FIFTH("3개 일치 (5,000원)", 5000),
    FOURTH("4개 일치 (50,000원)", 50000),
    THIRD("5개 일치 (1,500,000원)", 1500000),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
    FIRST("6개 일치 (2,000,000,000원)", 2000000000);

    private final String description;
    private final long priceMoney;

    LottoRank(String description, long priceMoney) {
        this.description = description;
        this.priceMoney = priceMoney;
    }

    public static LottoRank valueOf(int matchCount, boolean bonus) {
        if (matchCount == 6) return FIRST;
        if (matchCount == 5 && bonus) return SECOND;
        if (matchCount == 5) return THIRD;
        if (matchCount == 4) return FOURTH;
        if (matchCount == 3) return FIFTH;

        return MISS;
    }

    public String getDescription() {
        return description;
    }

    public long getPriceMoney() {
        return priceMoney;
    }
}

package lotto.LottoService;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoRule;
import lotto.domain.Payment;

import java.util.ArrayList;
import java.util.List;

public class LottoIssuingService {

    public List<Lotto> issueLotto(String paymentInput) {
        Payment payment = new Payment(paymentInput);
        int lottoCount = payment.getLottoCount();

        List<Lotto> lottos = new ArrayList<Lotto>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(createLotto());
        }

        return lottos;
    }

    private Lotto createLotto() {
        List<Integer> randomNumbers = createRandomNumbers();
        return new Lotto(randomNumbers);
    }

    private List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                LottoRule.MIN_LOTTO_NUMBER.getValue(),
                LottoRule.MAX_LOTTO_NUMBER.getValue(),
                LottoRule.LOTTO_NUMBER_COUNT.getValue());
    }
}

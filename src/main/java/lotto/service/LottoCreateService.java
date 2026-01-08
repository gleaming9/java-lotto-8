package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Payment;

import java.util.ArrayList;
import java.util.List;

public class LottoCreateService {
    public List<Lotto> issueLottos(Payment payment) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < payment.getPayment() / 1000; i++) {
            lottos.add(createLotto());
        }
        return lottos;
    }

    private Lotto createLotto() {
        return new Lotto(getRandomNumbers());
    }

    private List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}

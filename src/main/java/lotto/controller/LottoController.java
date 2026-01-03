package lotto.controller;

import lotto.domain.*;
import lotto.service.LottoCalculateService;
import lotto.service.LottoInputService;
import lotto.service.LottoIssuingService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    LottoIssuingService lottoIssuingService = new LottoIssuingService();
    LottoCalculateService lottoCalculateService = new LottoCalculateService();

    public void run() {
        Payment payment = setUpLottoPrice();

        List<Lotto> lottos = lottoIssuingService.issueLottos(payment);
        OutputView.printLottos(lottos);

        WinningNumber winningNumber = setUpWinningNumber();
        BonusNumber bonusNumber = setUpBonusNumber(winningNumber);

        LottoResult lottoResult = lottoCalculateService.calculateResult(payment, lottos, winningNumber, bonusNumber);
        OutputView.printResult(lottoResult);
    }

    private Payment setUpLottoPrice() {
        try {
            String paymentInput = InputView.getPayment();
            return LottoInputService.createPayment(paymentInput);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return setUpLottoPrice();
        }
    }

    private WinningNumber setUpWinningNumber() {
        try {
            String WinningNumberInput = InputView.getWinningNumber();
            return LottoInputService.createWinningNumber(WinningNumberInput);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return setUpWinningNumber();
        }
    }

    private BonusNumber setUpBonusNumber(WinningNumber winningNumber) {
        try {
            String BonusNumberInput = InputView.getBonusNumber();
            return LottoInputService.createBonusNumber(BonusNumberInput, winningNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return setUpBonusNumber(winningNumber);
        }
    }
}

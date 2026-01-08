package lotto.controller;

import lotto.domain.*;
import lotto.parser.BonusNumberParser;
import lotto.parser.PaymentParser;
import lotto.parser.WinningNumberParser;
import lotto.service.LottoCalcService;
import lotto.service.LottoCreateService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    PaymentParser paymentParser = new PaymentParser();
    WinningNumberParser winningNumberParser = new WinningNumberParser();
    BonusNumberParser bonusNumberParser = new BonusNumberParser();
    LottoCreateService lottoCreateService = new LottoCreateService();
    LottoCalcService lottoCalcService = new LottoCalcService();

    public void run() {
        Payment payment = setUpPayment();
        List<Lotto> lottos = lottoCreateService.issueLottos(payment);
        OutputView.printLotto(lottos);

        WinningNumber winningNumber = setUpWinningNumber();
        BonusNumber bonusNumber = setUpBonusNumber(winningNumber);

        LottoResult lottoResult = lottoCalcService.calculateResult(payment,lottos,winningNumber,bonusNumber);
        OutputView.printResult(lottoResult);
    }

    private Payment setUpPayment() {
        try {
            String input = InputView.getPayment();
            return paymentParser.parsePayment(input);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return setUpPayment();
        }
    }

    private WinningNumber setUpWinningNumber() {
        try {
            String input = InputView.getWinningNumber();
            return winningNumberParser.parseWinningNumber(input);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return setUpWinningNumber();
        }
    }

    private BonusNumber setUpBonusNumber(WinningNumber winningNumber) {
        try {
            String input = InputView.getBonusNumber();
            return bonusNumberParser.parseBonusNumber(input, winningNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return setUpBonusNumber(winningNumber);
        }
    }
}

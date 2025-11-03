package lotto.controller;

import lotto.LottoService.LottoCalculateService;
import lotto.LottoService.LottoInputService;
import lotto.LottoService.LottoIssuingService;
import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final LottoIssuingService lottoIssuingService;
    private final LottoCalculateService lottoCalculateService;
    private final LottoInputService lottoInputService;

    public LottoController(LottoIssuingService lottoIssuingService,
                           LottoCalculateService lottoCalculateService,
                           LottoInputService lottoInputService){
        this.lottoIssuingService = lottoIssuingService;
        this.lottoCalculateService = lottoCalculateService;
        this.lottoInputService = lottoInputService;
    }

    public void run(){
        Payment payment = createPayment();
        List<Lotto> lottos = lottoIssuingService.issueLotto(payment);
        OutputView.printLotto(lottos);

        WinningNumber winningNumber = createWinningNumber();
        BonusNumber bonusNumber = createBonusNumber(winningNumber);
        LottoResult lottoResult = lottoCalculateService.calculateStatistic(lottos, winningNumber, bonusNumber, payment);

        OutputView.printResult(lottoResult);
    }

    private Payment createPayment(){
        while(true){
            try{
                String input = InputView.getPayment();
                return lottoInputService.createPayment(input);
            }
            catch(IllegalArgumentException e){
                OutputView.printError(e.getMessage());
            }
        }
    }

    private WinningNumber createWinningNumber(){
        while(true){
            try{
                String input = InputView.getWinningNumber();
                return lottoInputService.createWinningNumber(input);
            }
            catch(IllegalArgumentException e){
                OutputView.printError(e.getMessage());
            }
        }
    }

    private BonusNumber createBonusNumber(WinningNumber winningNumber){
        while(true){
            try{
                String input = InputView.getBonusNumber();
                return lottoInputService.createBonusNumber(input, winningNumber);
            }
            catch(IllegalArgumentException e){
                OutputView.printError(e.getMessage());
            }
        }
    }
}

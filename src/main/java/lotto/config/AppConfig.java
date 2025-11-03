package lotto.config;

import lotto.LottoService.LottoCalculateService;
import lotto.LottoService.LottoInputService;
import lotto.LottoService.LottoIssuingService;
import lotto.controller.LottoController;

public class AppConfig {

    public LottoInputService lottoInputService() {
        return new LottoInputService();
    }

    public LottoIssuingService lottoIssuingService() {
        return new LottoIssuingService();
    }

    public LottoCalculateService lottoCalculateService() {
        return new LottoCalculateService();
    }

    public LottoController lottoController() {
        return new LottoController(
                lottoIssuingService(),
                lottoCalculateService(),
                lottoInputService()
        );
    }
}

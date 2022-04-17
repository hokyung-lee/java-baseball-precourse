package baseball.controller;

import baseball.domain.StrikeNumber;
import baseball.model.BaseballModel;
import baseball.model.RandomStrikeNumberGenerator;
import baseball.view.BaseballView;

public class BaseballController {

    private final BaseballView baseballView;
    private final BaseballModel baseballModel;

    public BaseballController(BaseballView baseballView, BaseballModel baseballModel) {
        this.baseballView = baseballView;
        this.baseballModel = baseballModel;
    }

    public void play() {
        init();
    }

    private void init() {
        baseballModel.generateComputerNumber(new RandomStrikeNumberGenerator());
    }
}

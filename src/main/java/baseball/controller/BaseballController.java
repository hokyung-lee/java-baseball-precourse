package baseball.controller;

import baseball.model.BaseballModel;
import baseball.model.RandomStrikeNumberGenerator;
import baseball.view.BaseballView;
import camp.nextstep.edu.missionutils.Console;

public class BaseballController {

    private final BaseballView baseballView;
    private final BaseballModel baseballModel;
    private boolean gameContinue = true;

    public BaseballController(BaseballView baseballView, BaseballModel baseballModel) {
        this.baseballView = baseballView;
        this.baseballModel = baseballModel;
    }

    public void play() {
        init();
        continueGame();
    }

    private void init() {
        baseballModel.generateComputerNumber(new RandomStrikeNumberGenerator());
    }

    private void continueGame() throws IllegalArgumentException {
        while(gameContinue) {
            getInputAndReturnResult();
        }
    }

    private void getInputAndReturnResult() throws IllegalArgumentException {
        baseballView.printInputNumberMessage();
        baseballModel.nextPlay(Console.readLine());
        baseballView.printResultMessage(baseballModel.calculateResult());
        checkGameEnd();
    }

    private void checkGameEnd() throws IllegalArgumentException {
        if(baseballModel.isEnd()) {
            baseballView.printGameEnd();
            askRetryGame();
        }
    }

    private void askRetryGame() throws IllegalArgumentException {
        baseballView.printRetryGame();
        gameContinue = baseballModel.retryGame(Console.readLine());

        if (gameContinue) {
            init();
        }
    }
}

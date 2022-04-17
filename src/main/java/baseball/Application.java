package baseball;

import baseball.controller.BaseballController;
import baseball.model.BaseballModel;
import baseball.model.BaseballModelCommandLine;
import baseball.view.BaseballView;
import baseball.view.BaseballViewCommandLine;

public class Application {
    private static final BaseballView baseballView = new BaseballViewCommandLine();
    private static final BaseballModel baseballModel = new BaseballModelCommandLine();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballController baseballController = new BaseballController(baseballView, baseballModel);
        baseballController.play();
    }
}

package baseball.view;

public class BaseballViewCommandLine implements BaseballView {
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAME_RETRY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    @Override
    public void printInputNumberMessage() {
        System.out.print(INPUT_NUMBER_MESSAGE);
    }

    @Override
    public void printResultMessage(String resultMessage) {
        System.out.println(resultMessage);
    }

    @Override
    public void printGameEnd() {
        System.out.println(GAME_END_MESSAGE);
    }

    @Override
    public void printRetryGame() {
        System.out.println(GAME_RETRY_MESSAGE);
    }

}

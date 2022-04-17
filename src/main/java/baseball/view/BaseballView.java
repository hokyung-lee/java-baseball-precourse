package baseball.view;

public interface BaseballView {
    void printInputNumberMessage();

    void printErrorMessage(String message);

    void printResultMessage(String resultMessage);

    void printGameEnd();

    void printRetryGame();
}

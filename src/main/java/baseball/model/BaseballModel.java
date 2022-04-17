package baseball.model;

import baseball.domain.StrikeNumber;

public interface BaseballModel {
    StrikeNumber generateComputerNumber(StrikeNumberGenerator strikeNumberGenerator);

    void nextPlay(String inputNumber) throws IllegalArgumentException;

    String calculateResult();

    boolean isEnd();

    boolean retryGame(String readLine) throws IllegalArgumentException;
}

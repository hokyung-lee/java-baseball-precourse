package baseball.model;

import baseball.domain.StrikeNumber;
import baseball.exception.InvalidInputNumberException;

public interface BaseballModel {
    StrikeNumber generateComputerNumber(StrikeNumberGenerator strikeNumberGenerator);

    void nextPlay(String inputNumber) throws InvalidInputNumberException;

    String calculateResult();

    boolean isEnd();

    void retryGame(String readLine) throws InvalidInputNumberException;
}

package baseball.model;

import baseball.domain.StrikeNumber;

public interface BaseballModel {
    StrikeNumber generateComputerNumber(StrikeNumberGenerator strikeNumberGenerator);
}

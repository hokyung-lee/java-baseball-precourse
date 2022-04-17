package baseball.model;

import baseball.domain.StrikeNumber;

public class BaseballModelCommandLine implements BaseballModel {
    private StrikeNumber strikeNumber;

    @Override
    public StrikeNumber generateComputerNumber(StrikeNumberGenerator strikeNumberGenerator) {
        this.strikeNumber = new StrikeNumber(strikeNumberGenerator.init());
        return this.strikeNumber;
    }
}

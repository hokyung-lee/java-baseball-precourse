package baseball.model;

import baseball.domain.StrikeNumber;
import baseball.exception.InvalidInputNumberException;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class BaseballModelCommandLine implements BaseballModel {
    private static final String  INPUT_SIZE_INVALID_MESSAGE = "입력값은 서로 다른 1~9 사이 3자리 숫자여야 합니다.";

    private StrikeNumber strikeNumber;

    @Override
    public StrikeNumber generateComputerNumber(StrikeNumberGenerator strikeNumberGenerator) {
        this.strikeNumber = new StrikeNumber(strikeNumberGenerator.init());
        return this.strikeNumber;
    }

    @Override
    public void nextPlay(String inputNumber) throws InvalidInputNumberException {
        try {
            convertInputNumber(inputNumber);
        } catch (NumberFormatException ex) {
            throw new InvalidInputNumberException(INPUT_SIZE_INVALID_MESSAGE);
        } catch (IllegalArgumentException ex) {
            throw new InvalidInputNumberException(ex.getMessage());
        }
    }

    private void convertInputNumber(String inputNumber) {
        LinkedHashSet<Integer> inputNumbers = new LinkedHashSet<>();

        if (inputNumber.length() != 3) throw new IllegalArgumentException(INPUT_SIZE_INVALID_MESSAGE);
        if (inputNumber.contains("0")) throw new IllegalArgumentException(INPUT_SIZE_INVALID_MESSAGE);

        for (Character num : inputNumber.toCharArray()) {
            inputNumbers.add(Integer.parseInt(String.valueOf(num)));
        }

        if (inputNumbers.size() != 3) throw new IllegalArgumentException(INPUT_SIZE_INVALID_MESSAGE);
    }
}

package baseball.model;

import baseball.domain.GameResult;
import baseball.domain.StrikeNumber;
import baseball.exception.InvalidInputNumberException;

import java.util.LinkedHashSet;

public class BaseballModelCommandLine implements BaseballModel {
    private static final String  INPUT_SIZE_INVALID_MESSAGE = "입력값은 서로 다른 1~9 사이 3자리 숫자여야 합니다.";
    private static final String RETRY_INVALID_MESSAGE = "1 또는 2 외의 숫자를 입력하여 게임을 종료합니다.";

    private StrikeNumber strikeNumber;
    private StrikeNumber clientNumber;
    private boolean isEnd = false;

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

    @Override
    public String calculateResult() {
        GameResult gameResult = strikeNumber.match(clientNumber);
        isEnd = gameResult.isEnd();

        return gameResult.generateResultMessage();
    }

    @Override
    public boolean isEnd() {
        return isEnd;
    }

    @Override
    public void retryGame(String readLine) throws InvalidInputNumberException {
        if (readLine.equals("1")) {
            isEnd = false;
            return;
        }
        if (readLine.equals("2")) {
            isEnd = true;
            return;
        }
        throw new InvalidInputNumberException(RETRY_INVALID_MESSAGE);
    }

    private void convertInputNumber(String inputNumber) {
        LinkedHashSet<Integer> inputNumbers = new LinkedHashSet<>();

        if (inputNumber.length() != 3) throw new IllegalArgumentException(INPUT_SIZE_INVALID_MESSAGE);
        if (inputNumber.contains("0")) throw new IllegalArgumentException(INPUT_SIZE_INVALID_MESSAGE);

        for (Character num : inputNumber.toCharArray()) {
            inputNumbers.add(Integer.parseInt(String.valueOf(num)));
        }

        if (inputNumbers.size() != 3) throw new IllegalArgumentException(INPUT_SIZE_INVALID_MESSAGE);

        this.clientNumber = new StrikeNumber(inputNumbers);
    }
}

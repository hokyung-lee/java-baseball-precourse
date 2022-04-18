package baseball.model;

import baseball.domain.GameResult;
import baseball.domain.StrikeNumber;

import java.util.LinkedHashSet;

public class BaseballModelCommandLine implements BaseballModel {
    private static final String  INPUT_SIZE_INVALID_MESSAGE = "입력값은 서로 다른 1~9 사이 3자리 숫자여야 합니다.";
    private static final String RETRY_INVALID_MESSAGE = "1 또는 2 외의 숫자를 입력하여 게임을 종료합니다.";
    private static final String RETRY_GAME_NUMBER = "1";
    private static final String END_GAME_NUMBER = "2";
    private static final String ZERO_NUMBER = "0";
    private static final int NUMBER_SIZE = 3;

    private StrikeNumber strikeNumber;
    private StrikeNumber clientNumber;
    private boolean isEnd = false;

    @Override
    public StrikeNumber generateComputerNumber(StrikeNumberGenerator strikeNumberGenerator) {
        this.strikeNumber = new StrikeNumber(strikeNumberGenerator.init());
        return this.strikeNumber;
    }

    @Override
    public void nextPlay(String inputNumber) throws IllegalArgumentException {
        try {
            convertInputNumber(inputNumber);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(INPUT_SIZE_INVALID_MESSAGE);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException(ex.getMessage());
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
    public boolean retryGame(String readLine) throws IllegalArgumentException {
        if (readLine.equals(RETRY_GAME_NUMBER)) {
            return true;
        }
        if (readLine.equals(END_GAME_NUMBER)) {
            return false;
        }
        throw new IllegalArgumentException(RETRY_INVALID_MESSAGE);
    }

    private void convertInputNumber(String inputNumber) {
        LinkedHashSet<Integer> inputNumbers = new LinkedHashSet<>();

        if (inputNumber.length() != NUMBER_SIZE) throw new IllegalArgumentException(INPUT_SIZE_INVALID_MESSAGE);
        if (inputNumber.contains(ZERO_NUMBER)) throw new IllegalArgumentException(INPUT_SIZE_INVALID_MESSAGE);

        for (Character num : inputNumber.toCharArray()) {
            inputNumbers.add(Integer.parseInt(String.valueOf(num)));
        }

        if (inputNumbers.size() != NUMBER_SIZE) throw new IllegalArgumentException(INPUT_SIZE_INVALID_MESSAGE);

        this.clientNumber = new StrikeNumber(inputNumbers);
    }
}

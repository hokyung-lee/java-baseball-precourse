package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashSet;

public class RandomStrikeNumberGenerator implements StrikeNumberGenerator {
    private static final int RANDOM_MIN_VALUE = 1;
    private static final int RANDOM_MAX_VALUE = 9;
    private static final int RANDOM_NUMBER_SIZE = 3;

    @Override
    public LinkedHashSet<Integer> init() {
        LinkedHashSet<Integer> numbers = new LinkedHashSet<>();

        while (numbers.size() < RANDOM_NUMBER_SIZE) {
            numbers.add(Randoms.pickNumberInRange(RANDOM_MIN_VALUE, RANDOM_MAX_VALUE));
        }

        return numbers;
    }
}

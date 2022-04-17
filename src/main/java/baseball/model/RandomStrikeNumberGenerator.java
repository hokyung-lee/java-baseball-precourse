package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashSet;

public class RandomStrikeNumberGenerator implements StrikeNumberGenerator {
    @Override
    public LinkedHashSet<Integer> init() {
        LinkedHashSet<Integer> numbers = new LinkedHashSet<>();

        while (numbers.size() < 3) {
            numbers.add(Randoms.pickNumberInRange(1, 9));
        }

        return numbers;
    }
}

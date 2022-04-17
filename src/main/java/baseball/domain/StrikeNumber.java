package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class StrikeNumber {
    private final List<Integer> numbers = new ArrayList<>();

    public StrikeNumber(LinkedHashSet<Integer> strikeNumbers) {
        for (Integer strikeNumber : strikeNumbers) {
            numbers.add(strikeNumber);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof StrikeNumber))
            return false;
        StrikeNumber sn = (StrikeNumber) o;
        if (sn.numbers.size() != this.numbers.size())
            return false;
        return sn.numbers.get(0) == this.numbers.get(0) && sn.numbers.get(1) == this.numbers.get(1) && sn.numbers.get(2) == this.numbers.get(2);
    }
}

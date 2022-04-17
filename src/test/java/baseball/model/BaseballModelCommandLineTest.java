package baseball.model;

import baseball.domain.StrikeNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballModelCommandLineTest {

    @Test
    @DisplayName("정답 숫자 생성하기 3자리 숫자")
    void generateComputerNumber() {
        // given
        BaseballModel baseballModel = new BaseballModelCommandLine();

        // when
        StrikeNumber strikeNumber = baseballModel.generateComputerNumber(()-> new LinkedHashSet<>(Arrays.asList(5, 3, 8)));

        // then
        assertThat(strikeNumber).isEqualTo(new StrikeNumber(new LinkedHashSet<>(Arrays.asList(5, 3, 8))));
    }

}

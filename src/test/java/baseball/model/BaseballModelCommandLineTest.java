package baseball.model;

import baseball.domain.StrikeNumber;
import baseball.exception.InvalidInputNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.LinkedHashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BaseballModelCommandLineTest {

    BaseballModel baseballModel = new BaseballModelCommandLine();

    @Test
    @DisplayName("정답 숫자 생성하기 3자리 숫자")
    void generateComputerNumber() {

        // when
        StrikeNumber strikeNumber = baseballModel.generateComputerNumber(()-> new LinkedHashSet<>(Arrays.asList(5, 3, 8)));

        // then
        assertThat(strikeNumber).isEqualTo(new StrikeNumber(new LinkedHashSet<>(Arrays.asList(5, 3, 8))));
    }

    @DisplayName("입력값 검증하기")
    @ParameterizedTest
    @ValueSource(strings = {"-315", "553", "x14", "??3", "530"})
    void validateInputNumber(String inputNumber) throws Exception {
        assertThatThrownBy(() -> baseballModel.nextPlay(inputNumber))
                .isInstanceOf(InvalidInputNumberException.class).hasMessage("입력값은 서로 다른 1~9 사이 3자리 숫자여야 합니다.");
    }
}

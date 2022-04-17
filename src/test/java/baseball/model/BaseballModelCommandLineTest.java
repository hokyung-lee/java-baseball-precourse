package baseball.model;

import baseball.domain.StrikeNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.LinkedHashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BaseballModelCommandLineTest {

    private BaseballModel baseballModel;

    @BeforeEach
    void newBaseModel() {
        baseballModel = new BaseballModelCommandLine();
    }

    @DisplayName("정답 숫자 생성하기 3자리 숫자")
    @Test
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
                .isInstanceOf(IllegalArgumentException.class).hasMessage("입력값은 서로 다른 1~9 사이 3자리 숫자여야 합니다.");
    }

    @DisplayName("정답과 입력값을 비교")
    @ParameterizedTest
    @CsvSource(value = {"152:1스트라이크","185:1볼 1스트라이크","245:낫싱","138:3스트라이크"}, delimiter = ':')
    void matchInputNumber(String input, String expected) throws IllegalArgumentException {
        baseballModel.generateComputerNumber(()-> new LinkedHashSet<>(Arrays.asList(1, 3, 8)));
        baseballModel.nextPlay(input);
        String result = baseballModel.calculateResult();

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("게임 종료 여부 확인")
    @ParameterizedTest
    @CsvSource(value = {"138:true","157:false","245:false"}, delimiter = ':')
    void isEndGame(String input, String expected) throws IllegalArgumentException {
        baseballModel.generateComputerNumber(()-> new LinkedHashSet<>(Arrays.asList(1, 3, 8)));
        baseballModel.nextPlay(input);
        baseballModel.calculateResult();

        assertThat(baseballModel.isEnd()).isEqualTo(Boolean.valueOf(expected));
    }

    @DisplayName("게임 종료 후 재시도 여부")
    @ParameterizedTest
    @CsvSource(value = {"1:true","2:false"}, delimiter = ':')
    void retryGame(String inputNumber, String expected) throws Exception {
        baseballModel.generateComputerNumber(()-> new LinkedHashSet<>(Arrays.asList(1, 3, 8)));
        baseballModel.nextPlay("138");
        baseballModel.calculateResult();

        assertThat(baseballModel.retryGame(inputNumber)).isEqualTo(Boolean.valueOf(expected));
    }

    @DisplayName("게임 종료 후 비정상적인 재시도 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"5", "3"})
    void invalidRetryGame(String inputNumber) throws Exception {
        baseballModel.generateComputerNumber(()-> new LinkedHashSet<>(Arrays.asList(1, 3, 8)));
        baseballModel.nextPlay("138");
        baseballModel.calculateResult();

        assertThatThrownBy(() -> baseballModel.retryGame(inputNumber))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("1 또는 2 외의 숫자를 입력하여 게임을 종료합니다.");
    }
}

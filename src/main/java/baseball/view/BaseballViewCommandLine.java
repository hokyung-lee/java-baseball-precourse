package baseball.view;

public class BaseballViewCommandLine implements BaseballView {
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";

    @Override
    public void printInputNumberMessage() {
        System.out.print(INPUT_NUMBER_MESSAGE);
    }

    @Override
    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}

package baseball.domain;

public class GameResult {

    private final static String STRIKE_TEXT = "스트라이크";
    private final static String BALL_TEXT = "볼";
    private final static String NOTHING_TEXT = "낫싱";
    private final static String EMPTY_TEXT = " ";
    private final static int ZERO = 0;
    private final static int ADD_ONE = 1;

    private int strike = 0;
    private int ball = 0;

    public boolean isEnd() {
        if (this.strike == 3) {
            return true;
        }
        return false;
    }

    public String generateResultMessage() {
        StringBuffer sb = new StringBuffer();
        if (ball == ZERO && strike == ZERO) {
            sb.append(NOTHING_TEXT);
            return sb.toString();
        }
        if (ball > ZERO) {
            sb.append(ball);
            sb.append(BALL_TEXT);
            sb.append(EMPTY_TEXT);
        }
        if (strike > ZERO) {
            sb.append(strike);
            sb.append(STRIKE_TEXT);
        }
        return sb.toString();
    }

    public void addStrike() {
        this.strike = strike + ADD_ONE;
    }

    public void addBall() {
        this.ball = ball + ADD_ONE;
    }
}

package coordinate.util;

public enum OutputMessage {

    OUTPUT_AREA_OF_LINE("두 점 사이의 거리는 "),
    OUTPUT_AREA_OF_RECTANGLE("사각형의 넓이는 "),
    OUTPUT_AREA_OF_TRIANGLE("삼각형의 넓이는 ");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

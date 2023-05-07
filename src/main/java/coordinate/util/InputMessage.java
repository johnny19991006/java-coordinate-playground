package coordinate.util;

public enum InputMessage {

    INPUT_COORDINATE("좌표를 입력하세요.");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

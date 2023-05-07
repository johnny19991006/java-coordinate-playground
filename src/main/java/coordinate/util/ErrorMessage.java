package coordinate.util;

import coordinate.domain.Point;

public enum ErrorMessage {

    ERROR_FIGURE_NULL("올바른 Point 값이 아닙니다."),
    ERROR_INVALID_FIGURE_CREATION("입력된 Point 개수가 유효하지 않습니다."),
    ERROR_OUT_OF_POINT_RANGE("잘못된 범위의 입력값입니다. 정수 범위는 " + Point.LOWER_LIMIT + " ~ " + Point.UPPER_LIMIT + " 사이의 수로 입력해 주세요."),
    ERROR_INVALID_RECTANGLE("직사각형 모양이 아닙니다."),
    ERROR_INVALID_TRIANGLE("삼각형 모양이 아닙니다."),
    ERROR_INVALID_COORDINATES("올바르지 않은 입력값입니다."),
    ERROR_DUPLICATE_POINTS("중복된 좌표가 존재합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

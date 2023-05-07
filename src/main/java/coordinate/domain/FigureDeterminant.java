package coordinate.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static coordinate.util.ErrorMessage.ERROR_INVALID_FIGURE_CREATION;
import static coordinate.util.ErrorMessage.ERROR_FIGURE_NULL;

public class FigureDeterminant {

    private static final int NUM_LINE = 2;
    private static final int NUM_TRIANGLE = 3;
    private static final int NUM_RECTANGLE = 4;
    private static final Map<Integer, Function<List<Point>, Figure>> classifier = new HashMap<>();

    static {
        classifier.put(NUM_LINE, Line::new);
        classifier.put(NUM_TRIANGLE, Triangle::new);
        classifier.put(NUM_RECTANGLE, Rectangle::new);
    }

    public static Figure create(List<Point> points) {
        if (points == null) {
            throw new IllegalArgumentException(ERROR_FIGURE_NULL.getMessage());
        }
        if (isInvalidNumberOf(points)) {
            throw new IllegalArgumentException(ERROR_INVALID_FIGURE_CREATION.getMessage());
        }
        return classifyFigure(points);
    }

    private static boolean isInvalidNumberOf(List<Point> points) {
        int numOfPoints = points.size();
        return numOfPoints < NUM_LINE || numOfPoints > NUM_RECTANGLE;
    }

    private static Figure classifyFigure(List<Point> points) {
        return classifier.get(points.size()).apply(points);
    }
}

package coordinate.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import static coordinate.util.ErrorMessage.ERROR_INVALID_RECTANGLE;
import static coordinate.util.OutputMessage.OUTPUT_AREA_OF_RECTANGLE;
import static java.util.stream.Collectors.toSet;

public class Rectangle extends AbstractFigure {

    private static final int NUM_RECTANGLE = 2;

    Rectangle(List<Point> points) {
        super(points);
        checkRectangleWith(points);
    }

    private void checkRectangleWith(List<Point> points) {
        Set<Integer> xValuesOfPoints = convertToUniqueXValues(points);
        Set<Integer> yValuesOfPoints = convertToUniqueYValues(points);

        if (hasNotTwoPoints(xValuesOfPoints) || hasNotTwoPoints(yValuesOfPoints)) {
            throw new IllegalArgumentException(ERROR_INVALID_RECTANGLE.getMessage());
        }
    }

    private Set<Integer> convertToUniqueXValues(List<Point> points) {
        return convertToUniqueValues(points, Point::getX);
    }

    private Set<Integer> convertToUniqueYValues(List<Point> points) {
        return convertToUniqueValues(points, Point::getY);
    }

    private Set<Integer> convertToUniqueValues(List<Point> points, Function<Point, Integer> function) {
        return points.stream()
                .map(function)
                .collect(toSet());
    }

    private boolean hasNotTwoPoints(Set<Integer> valuesOfPoints) {
        return valuesOfPoints.size() != NUM_RECTANGLE;
    }

    @Override
    public double area() {
        List<Point> points = getPoints();
        int differenceOfXValues = calculateDifference(convertToUniqueXValues(points));
        int differenceOfYValues = calculateDifference(convertToUniqueYValues(points));

        return differenceOfXValues * differenceOfYValues;
    }

    private int calculateDifference(Set<Integer> valuesOfPoints) {
        List<Integer> values = new ArrayList<>(valuesOfPoints);
        return Math.abs(values.get(0) - values.get(1));
    }

    @Override
    public String getAreaInfo() {
        return OUTPUT_AREA_OF_RECTANGLE.getMessage() + area();
    }
}

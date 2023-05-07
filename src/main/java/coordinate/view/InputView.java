package coordinate.view;

import coordinate.domain.Point;
import coordinate.domain.Figure;
import coordinate.domain.FigureDeterminant;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static coordinate.util.InputMessage.INPUT_COORDINATE;
import static coordinate.util.ErrorMessage.ERROR_INVALID_COORDINATES;
import static coordinate.util.ErrorMessage.ERROR_DUPLICATE_POINTS;

public class InputView {

    private static final String POINT_DELIMITER = "-";
    private static Scanner scanner = new Scanner(System.in);

    public static Figure inputCoordinates() {
        System.out.println(INPUT_COORDINATE.getMessage());
        return inputCoordinates(scanner.nextLine());
    }

    public static Figure inputCoordinates(String input) {
        try {
            input = input.replace(" ", "");
            List<Point> points = generatePoints(input);
            return FigureDeterminant.create(points);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputCoordinates();
        }
    }

    private static List<Point> generatePoints(String input) {
        String[] inputPoints = input.split(POINT_DELIMITER);

        List<Point> points = new ArrayList<>();
        for (String inputPoint : inputPoints) {
            points.add(generatePoint(inputPoint));
        }
        checkDuplicationOf(points);
        return points;
    }

    private static Point generatePoint(String inputPoint) {
        Pattern pattern = Pattern.compile("\\(([0-9]{1,2}),([0-9]{1,2})\\)");
        Matcher matcher = pattern.matcher(inputPoint);
        if (matcher.find()) {
            int x = Integer.parseInt(matcher.group(1));
            int y = Integer.parseInt(matcher.group(2));
            return new Point(x, y);
        }
        throw new IllegalArgumentException(ERROR_INVALID_COORDINATES.getMessage());
    }

    private static void checkDuplicationOf(List<Point> points) {
        if (points.size() != new HashSet<>(points).size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_POINTS.getMessage());
        }
    }
}

package coordinate.domain;

import java.util.List;

import static coordinate.util.OutputMessage.OUTPUT_AREA_OF_LINE;

public class Line extends AbstractFigure {

    Line(List<Point> points) {
        super(points);
    }

    @Override
    public double area() {
        return getPoints().get(0).calculateDistance(getPoints().get(1));
    }

    @Override
    public String getAreaInfo() {
        return OUTPUT_AREA_OF_LINE.getMessage() + area();
    }
}

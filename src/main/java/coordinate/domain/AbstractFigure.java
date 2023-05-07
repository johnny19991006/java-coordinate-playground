package coordinate.domain;

import java.util.List;
import java.util.Objects;

import static coordinate.util.ErrorMessage.ERROR_FIGURE_NULL;

public class AbstractFigure implements Figure {

    private final List<Point> points;

    AbstractFigure(List<Point> points) {
        if (points == null || points.isEmpty()) {
            throw new IllegalArgumentException(ERROR_FIGURE_NULL.getMessage());
        }
        this.points = points;
    }

    @Override
    public List<Point> getPoints() {
        return points;
    }

    @Override
    public double area() {
        return 0;
    }

    @Override
    public String getAreaInfo() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final AbstractFigure that = (AbstractFigure) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}

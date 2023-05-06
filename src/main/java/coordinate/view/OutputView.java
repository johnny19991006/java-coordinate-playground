package coordinate.view;

import coordinate.domain.Figure;

public class OutputView {
    public static void showArea(Figure figure) {
        System.out.println(figure.getAreaInfo());
    }
}

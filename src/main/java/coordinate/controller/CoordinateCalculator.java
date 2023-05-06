package coordinate.controller;

import coordinate.domain.Figure;
import coordinate.view.InputView;
import coordinate.view.OutputView;

public class CoordinateCalculator {
    public void run() {
        Figure figure = InputView.inputCoordinates();
        OutputView.showArea(figure);
    }
}

package pl.saramak.panel.panels.direction;

import pl.saramak.panel.panels.direction.Direction;

public interface DirectionDetector {
    void eventY(int lastY);
    Direction getDirection();
}

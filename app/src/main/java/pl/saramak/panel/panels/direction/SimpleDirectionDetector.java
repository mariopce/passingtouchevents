package pl.saramak.panel.panels.direction;

import pl.saramak.panel.panels.direction.DirectionDetector;
import timber.log.Timber;

public class SimpleDirectionDetector implements DirectionDetector {

    int prevY = -Integer.MAX_VALUE;
    Direction currentDir = Direction.DOWN;
    @Override
    public void eventY(int eventY) {
        Timber.d("event " +eventY);
        if (prevY == -Integer.MAX_VALUE){
            currentDir = Direction.DOWN;
        }
        if (prevY < eventY){
            currentDir = Direction.DOWN;
            prevY = eventY;
        }else {
            currentDir = Direction.UP;
            prevY = eventY;
        }
    }

    @Override
    public Direction getDirection() {
        Timber.d("current dir " + currentDir);
        return currentDir;
    }
}

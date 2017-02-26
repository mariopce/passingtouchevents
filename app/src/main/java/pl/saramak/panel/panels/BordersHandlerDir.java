package pl.saramak.panel.panels;

import java.util.ArrayList;
import java.util.List;

import pl.saramak.panel.panels.direction.Direction;
import pl.saramak.panel.panels.direction.DirectionDetector;
import timber.log.Timber;

public class BordersHandlerDir implements BordersHandler {
    private static DirectionDetector directionDetector;
    private final List<Integer> borders;

    public BordersHandlerDir(DirectionDetector directionDetector, List<Integer> bord) {
        this.borders = bord;
    }

    public static BordersHandlerDir of(DirectionDetector directionDetector, Integer... borders) {
        BordersHandlerDir.directionDetector = directionDetector;
        List<Integer> bord = new ArrayList<>();
        for (Integer b: borders) {
            bord.add(b);
        }
        return new BordersHandlerDir(directionDetector, bord);
    }

    @Override
    public int findClosest(int newPoint) {
        int min = Integer.MAX_VALUE;
        if (newPoint <= borders.get(0)){
            return borders.get(0);
        }
        int last = borders.get(borders.size()-1);
        if (newPoint >= last){
            return last;
        }
        for (int i = 0; i <borders.size(); i++) {
            if (newPoint > borders.get(i) && newPoint <= borders.get(i+1)){
                if (directionDetector.getDirection() == Direction.DOWN){
                    int res  = borders.get(i+1);
                    Timber.d("Direction to d" + res + " for " + newPoint);
                    return res;
                }else{
                    int res = borders.get(i);
                    Timber.d("Direction to u" + res + " for " + newPoint);
                    return res;
                }
            }
        }
        throw new IllegalStateException("not possible ");
    }
}

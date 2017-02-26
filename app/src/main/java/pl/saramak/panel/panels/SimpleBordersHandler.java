package pl.saramak.panel.panels;

import java.util.ArrayList;
import java.util.List;

public class SimpleBordersHandler implements BordersHandler {
    private List<Integer> borders;

    public SimpleBordersHandler(List<Integer> bord) {
        this.borders = bord;
    }

    public static BordersHandler of(Integer... borders) {
        List<Integer> bord = new ArrayList<>();
        for (Integer b: borders) {
            bord.add(b);
        }
        return new SimpleBordersHandler(bord);
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
            if (newPoint > borders.get(i)){
                int distance = borders.get(i+1) - borders.get(i);
                if (newPoint > (borders.get(i) + distance/2)){
                    return borders.get(i+1);
                }else{
                    return borders.get(i);
                }
            }
        }
        throw new IllegalStateException("ffds");
    }
}

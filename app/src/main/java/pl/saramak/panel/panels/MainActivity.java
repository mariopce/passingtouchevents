package pl.saramak.panel.panels;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pl.saramak.panel.panels.direction.DirectionDetector;
import pl.saramak.panel.panels.direction.SimpleDirectionDetector;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    private ListView panelContent;
    private LinearLayout content;

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MyPanel panel = (MyPanel) findViewById(R.id.topPanelSlight);
      this.panelContent = (ListView) findViewById(R.id.panel_content);
        List<String> items = new ArrayList<>();
        items.add("fdsfs1");
        items.add("fsdfds2");
        items.add("fdsfds34");
        items.add("fdsfds5");
        panelContent.setAdapter( new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items));
        this.content = (LinearLayout)findViewById(R.id.content);
        panel.setContent(this.content);


        final DirectionDetector directionDetector = new SimpleDirectionDetector();
        final BordersHandlerDir bordersHandlerWithDir = BordersHandlerDir.of(directionDetector, 100, 300, 1000, 1500);

        panel.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getActionMasked() == MotionEvent.ACTION_MOVE) {
                    LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) panelContent.getLayoutParams();
                    int lastY = (int) event.getY();
                    directionDetector.eventY(lastY);
                    params.height = lastY;

                    Timber.d("New height " + params.height);
                    panelContent.setLayoutParams(params);

                }
                if (event.getActionMasked() == MotionEvent.ACTION_UP) {
                    int newPoint = (int) event.getY();
                    int close =  bordersHandlerWithDir.findClosest(newPoint);
                    ResizeAnimation ra = new ResizeAnimation(panelContent, close);
                    ra.setDuration(500);
                    panelContent.startAnimation(ra);
                }
                return true;
            }

        });

    }

    public void onClick(View view) {
        Toast.makeText(view.getContext(), "click", Toast.LENGTH_SHORT).show();
    }
}

package pl.saramak.panel.panels;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import timber.log.Timber;


public class MyPanel extends ScrollView {
    private LinearLayout content;

    public MyPanel(Context context) {
        super(context);
    }

    public MyPanel(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyPanel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyPanel(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ((ViewGroup)getParent()).getChildAt(0).setBackgroundColor(Color.RED);

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Timber.d("events   " + ev.getY());
        if (content.dispatchTouchEvent(ev)){
            return true;
        }

        return super.dispatchTouchEvent(ev);
    }

    public void setContent(LinearLayout content) {
        this.content = content;
    }
}

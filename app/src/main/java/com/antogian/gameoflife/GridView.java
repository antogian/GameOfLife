package com.antogian.gameoflife;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;



/**
 * Created by Tony on 15/1/2018.
 */

public class GridView extends View
{
    public static final int PAUSE = 0;
    public static final int RUNNING = 1;
    private Life life;
    private long moveDelay = 100;
    private RefreshHandler redrawHandler = new RefreshHandler();

    class RefreshHandler extends Handler
    {
        @Override
        public void handleMessage(Message message)
        {
            GridView.this.update();
            GridView.this.invalidate();
        }

        public void sleep(long delayMillis)
        {
            this.removeMessages(0);
            sendMessageDelayed(obtainMessage(0), delayMillis);
        }
    }

    public GridView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        /*
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
            @Override
            public void onGlobalLayout()
            {
                getViewTreeObserver().removeGlobalOnLayoutListener(this);
                life = new Life(getHeight(), getWidth());
            }
        });
        */
        //int width = getMeasuredWidth();
        //int height = getMeasuredHeight();
        life = new Life();
        initGrid();
    }

    @Override
    public void onDraw(Canvas canvas)
    {
        Paint background = new Paint();
        Paint cell = new Paint();

        background.setColor(getResources().getColor(R.color.background));
        cell.setColor(getResources().getColor(R.color.cell));

        canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), background);
        for (int h = 0; h < Life.HEIGHT; h++)
        {
            for (int w = 0; w < Life.WIDTH; w++)
            {
                if (Life.getCellGrid()[h][w] != 0)
                {
                    canvas.drawRect(
                            w * Life.CELL_SIZE,
                            h * Life.CELL_SIZE,
                            (w * Life.CELL_SIZE) + (Life.CELL_SIZE -1),
                            (h * Life.CELL_SIZE) + (Life.CELL_SIZE -1),
                            cell);
                }
            }
        }
    }

    public void setMode(int mode)
    {
        if(mode == RUNNING)
        {
            update();
            return;
        }
        if(mode == PAUSE)
        {
            //TODO: Implement
        }
    }

    private void update()
    {
        life.nextGeneration();
        redrawHandler.sleep(moveDelay);
    }

    private void initGrid()
    {
        setFocusable(true);
    }
}

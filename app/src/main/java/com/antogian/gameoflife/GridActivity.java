package com.antogian.gameoflife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tony.gameoflife.R;

public class GridActivity extends AppCompatActivity
{
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        gridView = findViewById(R.id.grid_view);
        gridView.setMode(GridView.RUNNING);
    }

    @Override
    public void onPause()
    {
        super.onPause();
        gridView.setMode(GridView.PAUSE);
    }
}

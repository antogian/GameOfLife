package com.antogian.gameoflife;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.antogian.gameoflife.GridActivity;
import com.example.tony.gameoflife.R;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    public void newButton_onClick(View v)
    {
        Intent gridIntent = new Intent(this, GridActivity.class);
        startActivity(gridIntent);
    }

    public void aboutButton_onClick(View v)
    {
        //Toast toast;
        Toast.makeText(getApplicationContext(),"The Game of Life, or simply known as Life, is a cellular automation devised" +
                " by the British Mathematician John Horton Conway in 1970." +
                "It is the best-known example of cellular automation",Toast.LENGTH_LONG).show();
    }

    public void exitButton_onClick(View v)
    {
        finish();
        System.exit(0);
    }

}

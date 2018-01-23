package com.antogian.gameoflife;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.antogian.gameoflife.GridActivity;

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
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.app_name);
        builder.setMessage("Game of Life is the most known cellular automaton implementation. " +
                "It was devised by the british Mathematician John H. Conway.");
        builder.create();
        builder.show();
    }

    public void exitButton_onClick(View v)
    {
        finish();
        System.exit(0);
    }

}

package com.example.colorpicker2try;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.view.View;
import android.widget.Button;

import java.util.Random;

import me.panavtec.drawableview.DrawableView;
import me.panavtec.drawableview.DrawableViewConfig;

public class Main2Activity extends AppCompatActivity {

    DrawableView drawableView;
    Button up, down, change, undo;
    DrawableViewConfig config;
    int  DefaultColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        drawableView = (DrawableView)findViewById(R.id.paintView);
        up = findViewById(R.id.buttonUp);
        down = findViewById(R.id.buttonDown);
        change = findViewById(R.id.buttonColor);
        undo = findViewById(R.id.buttonUndo);
        final DrawableViewConfig config = new DrawableViewConfig();
        config.setStrokeColor(getResources().getColor(DefaultColor));
        config.setShowCanvasBounds(true); // If the view is bigger than canvas, with this the user will see the bounds (Recommended)
        config.setStrokeWidth(20.0f);
        config.setMinZoom(1.0f);
        config.setMaxZoom(3.0f);
        config.setCanvasHeight(1080);
        config.setCanvasWidth(1920);
        drawableView.setConfig(config);

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                config.setStrokeWidth(config.getStrokeWidth()+5.0f);
            }
        });

        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                config.setStrokeWidth(config.getStrokeWidth()-5.0f);
            }
        });

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // OpenColorPicker(false);
                // config.setStrokeColor(getResources().getColor(DefaultColor));


                 Random random = new Random();
                 config.setStrokeColor(Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256)));
            }
        });

        undo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawableView.undo();
            }
        });

    }

}

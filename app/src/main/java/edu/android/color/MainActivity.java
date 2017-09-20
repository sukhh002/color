package edu.android.color;

import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ColorPickerDialog.OnColorChangedListener{

    RelativeLayout relative_color;
    Button btn_colorPicker;
    int color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relative_color = (RelativeLayout)findViewById(R.id.relative_color);
        btn_colorPicker = (Button)findViewById(R.id.btn_colorPicker);
        btn_colorPicker.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        color = PreferenceManager.getDefaultSharedPreferences(this).getInt("color", Color.WHITE);
        new ColorPickerDialog(this, this, color).show();
    }

    @Override
    public void colorChanged(int color) {
        PreferenceManager.getDefaultSharedPreferences(this).edit().putInt("color", color).commit();
        relative_color.setBackgroundColor(color);
    }
}

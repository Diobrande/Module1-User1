package com.example.smarthouse;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import top.defaults.colorpicker.ColorPickerPopup;

public class MainActivity extends AppCompatActivity {

    //Объявление элементов дизайна
    private View textView;
    private Button button, button2;
    private View mColorPreview;
    private int mDefaultColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);

        mColorPreview = findViewById(R.id.preview_selected_color);

        mDefaultColor = 0;
        //Объявление кнопки button на изменение цвета по клику и выбору в палитре
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        //Задание на запуск палитры по клику
                        new ColorPickerPopup.Builder(MainActivity.this).initialColor(
                                Color.RED)
                                .enableBrightness(
                                        true)
                                .enableAlpha(
                                        true)
                                //Объявление двух элементов кнопок выбрать"Choose" и закрыть"Cancel"
                                .okTitle(
                                        "Choose")
                                .cancelTitle(
                                        "Cancel")
                                .showIndicator(
                                        true)
                                .showValue(
                                        true)
                                .build()
                                .show(
                                        v,
                                        //Объявление палитры на выбор цвета который изменяет цвет серого квадрата на выбранный пользователем
                                        //а также контраст
                                        new ColorPickerPopup.ColorPickerObserver() {
                                            @Override
                                            public void onColorPicked(int color) {
                                                mDefaultColor = color;

                                                mColorPreview.setBackgroundColor(mDefaultColor);
                                            }
                                        });

                    }


                    });
        //Объявление кнопки button2 на применении выбора цвета и отображение его на экране
        button2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) { textView.setBackgroundColor(mDefaultColor);
                    }
                }
        );

    }
}
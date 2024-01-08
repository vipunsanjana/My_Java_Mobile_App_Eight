package com.example.myappeight;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    protected PieChart pie_chart;
    private ArrayList<PieEntry> pieEntries = new ArrayList<>();
    private String label = "type";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pie_chart = findViewById(R.id.pie_chart);

        Map<String, Integer> typeMap = new HashMap<>();
        typeMap.put("Toys",50);
        typeMap.put("Books",200);
        typeMap.put("Pens",400);
        typeMap.put("Clothes",600);

        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.BLUE);
        colors.add(Color.GREEN);
        colors.add(Color.RED);
        colors.add(Color.YELLOW);

        for (String type : typeMap.keySet()){
            pieEntries.add(new PieEntry(typeMap.get(type).floatValue(),type));
        }

        PieDataSet pieDataSet = new PieDataSet(pieEntries, label);

        pieDataSet.setColors(colors);

        pieDataSet.setValueTextColor(Color.parseColor("#899067"));
        pieDataSet.setValueTextSize(30f);

        PieData pieData = new PieData(pieDataSet);

        pie_chart.setData(pieData);

        //slice touch
        pie_chart.setOnChartGestureListener(new OnChartGestureListener() {
            @Override
            public void onChartGestureStart(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {

            }

            @Override
            public void onChartGestureEnd(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {

            }

            @Override
            public void onChartLongPressed(MotionEvent me) {

            }

            @Override
            public void onChartDoubleTapped(MotionEvent me) {

            }

            @Override
            public void onChartSingleTapped(MotionEvent me) {

            }

            @Override
            public void onChartFling(MotionEvent me1, MotionEvent me2, float velocityX, float velocityY) {

            }

            @Override
            public void onChartScale(MotionEvent me, float scaleX, float scaleY) {

            }

            @Override
            public void onChartTranslate(MotionEvent me, float dX, float dY) {

            }
        });
    }
}
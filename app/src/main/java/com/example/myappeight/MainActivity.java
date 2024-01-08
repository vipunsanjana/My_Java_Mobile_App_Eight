package com.example.myappeight;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private PieChart pie_chart;
    private LineChart line_chart;
    private ArrayList<PieEntry> pieEntries = new ArrayList<>();
    private String label_ = "type";



    //Line chart
    ArrayList<DataModel> bindData = new ArrayList<>();
    ArrayList<DataModel> bindData2 = new ArrayList<>();
    ArrayList<Entry> chartEntryArrayList = new ArrayList<>();
    ArrayList<Entry> chartEntryArrayList2 = new ArrayList<>();
    ArrayList<String> lable = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pie_chart = findViewById(R.id.pie_chart);
        line_chart = findViewById(R.id.line_chart);

        setPieChart();

        //Line chart

        bindData.add(new DataModel("1999", 300));
        bindData.add(new DataModel("2000", 400));
        bindData.add(new DataModel("2001", 600));
        bindData.add(new DataModel("2002", 900));

        bindData2.add(new DataModel("1999", 100));
        bindData2.add(new DataModel("2000", 500));
        bindData2.add(new DataModel("2001", 900));
        bindData2.add(new DataModel("2002", 700));


        for (int x=0; x < bindData.size(); x++){

            String year = bindData.get(x).year;
            int sale = bindData.get(x).sales;

            chartEntryArrayList.add(new Entry(x, sale));
            lable.add(year);

        }

        for (int x=0; x < bindData2.size(); x++){

            String year = bindData2.get(x).year;
            int sale = bindData2.get(x).sales;

            chartEntryArrayList2.add(new Entry(x, sale));

        }

        LineDataSet lineDataSet = new LineDataSet(chartEntryArrayList, "Sales");
        lineDataSet.setColor(Color.RED);
        lineDataSet.setCircleColor(Color.YELLOW);

        LineDataSet lineDataSet2 = new LineDataSet(chartEntryArrayList2, "Lose");
        lineDataSet2.setColor(Color.BLUE);

        LineData lineData = new LineData(lineDataSet, lineDataSet2);
        line_chart.setData(lineData);

        //x axis get
        XAxis xAxis = line_chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(lable));

        YAxis yAxis = line_chart.getAxisRight();
        yAxis.setDrawAxisLine(false);
        yAxis.setDrawLabels(false);

        line_chart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {

                Toast.makeText(getApplicationContext(), (lable.get((int) e.getX()) + " - "  + String.valueOf(e.getY())), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected() {

            }
        });


    }

    private void setPieChart() {

        Map<String, Integer> typeMap = new HashMap<>();
        typeMap.put("Toys",50);
        typeMap.put("Books",200);
        typeMap.put("Pens",400);
        typeMap.put("Clothes",600);

//        ArrayList<Integer> colors = new ArrayList<>();
//        colors.add(Color.BLUE);
//        colors.add(Color.GREEN);
//        colors.add(Color.RED);
//        colors.add(Color.YELLOW);

        for (String type : typeMap.keySet()){
            pieEntries.add(new PieEntry(typeMap.get(type).floatValue(),type));
        }

        PieDataSet pieDataSet = new PieDataSet(pieEntries, label_);


        pieDataSet.setValueTextColor(Color.parseColor("#899067"));
        pieDataSet.setValueTextSize(30f);


        //set colors
        pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS);

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
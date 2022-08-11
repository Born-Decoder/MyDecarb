package com.example.mydecarb.ui.dashboard;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mydecarb.databinding.FragmentDashboardBinding;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.view.LineChartView;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    private void showPieChart(PieChart pieChart, Map<String, Integer> typeAmountMap, ArrayList<Integer> colors){

        ArrayList<PieEntry> pieEntries = new ArrayList<>();
        String label = "";
        //input data and fit data into pie chart entry
        for(String type: typeAmountMap.keySet()){
            pieEntries.add(new PieEntry(typeAmountMap.get(type).floatValue(), type));
        }

        //collecting the entries with label name
        PieDataSet pieDataSet = new PieDataSet(pieEntries,label);
        //setting text size of the value
        pieDataSet.setValueTextSize(12f);
        //providing color list for coloring different entries
        pieDataSet.setColors(colors);
        //grouping the data set from entry to chart
        PieData pieData = new PieData(pieDataSet);
        //showing the value of the entries, default true if not set
        pieData.setDrawValues(true);
        pieData.setValueFormatter(new PercentFormatter());

        pieChart.setData(pieData);
        pieChart.invalidate();
    }
    private void initPieChart(PieChart pieChart){
        //using percentage as values instead of amount
        pieChart.setUsePercentValues(true);

        //remove the description label on the lower left corner, default true if not set
        pieChart.getDescription().setEnabled(false);
        pieChart.getDescription().setTextColor(Color.GREEN);

        //enabling the user to rotate the chart, default true
        pieChart.setRotationEnabled(true);
        //adding friction when rotating the pie chart
        pieChart.setDragDecelerationFrictionCoef(0.9f);
        //setting the first entry start from right hand side, default starting from top
        pieChart.setRotationAngle(0);

        //highlight the entry when it is tapped, default true if not set
        pieChart.setHighlightPerTapEnabled(true);
        //adding animation so the entries pop up from 0 degree
        pieChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);
        //setting the color of the hole in the middle, default white
        pieChart.setHoleColor(Color.parseColor("#000000"));
        Legend legend = pieChart.getLegend();
        legend.setTextColor(Color.GREEN);

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDashboard;
        final LineChartView lineChartView = binding.lineGraph;
        String[] axisData = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept",
                "Oct", "Nov", "Dec"};
        int[] yAxisData = {500, 300, 350, 300, 200, 600, 250, 400, 450, 200, 265, 20};
        List yAxisValues = new ArrayList();
        List axisValues = new ArrayList();
        Line line = new Line(yAxisValues).setColor(Color.GREEN);
        for(int i = 0; i < axisData.length; i++){
            axisValues.add(i, new AxisValue(i).setLabel(axisData[i]));
        }

        for (int i = 0; i < yAxisData.length; i++){
            yAxisValues.add(new PointValue(i, yAxisData[i]));
        }
        List lines = new ArrayList();
        lines.add(line);
        LineChartData data = new LineChartData();
        data.setLines(lines);
        lineChartView.setLineChartData(data);
        Axis axis = new Axis();
        axis.setValues(axisValues);
        data.setAxisXBottom(axis);
        Axis yAxis = new Axis();
        data.setAxisYLeft(yAxis);
        axis.setTextColor(Color.GREEN);
        yAxis.setTextColor(Color.GREEN);
        textView.setText("My Carbon Footprint Track");
        textView.setTextColor(Color.GREEN);
        final TextView textView2 = binding.textDashboard2;
        final GraphView bar_Graph = binding.barGraph;
        BarGraphSeries<DataPoint> barGraph_Data = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 10),
                new DataPoint(1, 50),
                new DataPoint(2, 300),
                new DataPoint(3, 20),
                new DataPoint(4, 60)
        });
        bar_Graph.addSeries(barGraph_Data);
        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(bar_Graph);
        staticLabelsFormatter.setHorizontalLabels(new String[] {"Bike Tour", "Work Travel", "Electricity", "Public Travel", "Car"});
        bar_Graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
        barGraph_Data.setColor(Color.GREEN);
        bar_Graph.setTitleColor(Color.GREEN);
        barGraph_Data.setDrawValuesOnTop(true);
        barGraph_Data.setValuesOnTopColor(Color.GREEN);
        textView2.setText("My Emission Sources");
        textView2.setTextColor(Color.GREEN);
        final TextView textView3 = binding.textDashboard3;
        final PieChart pieChart = binding.pieChartView;
        Map<String, Integer> typeAmountMap = new HashMap<>();
        //initializing data
        typeAmountMap.put("Bengaluru",200);
        typeAmountMap.put("Chennai",230);
        typeAmountMap.put("Mumbai",100);
        typeAmountMap.put("Delhi",500);
        typeAmountMap.put("Madurai",50);
        textView3.setText("Locations with my Footprint");
        textView3.setTextColor(Color.GREEN);
        //initializing colors for the entries
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.parseColor("#304567"));
        colors.add(Color.parseColor("#309967"));
        colors.add(Color.parseColor("#476567"));
        colors.add(Color.parseColor("#890567"));
        colors.add(Color.parseColor("#a35567"));
        colors.add(Color.parseColor("#ff5f67"));
        colors.add(Color.parseColor("#3ca567"));
        initPieChart(pieChart);
        showPieChart(pieChart, typeAmountMap, colors);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
package org.example.statistic;

import org.example.Separator;

import java.util.List;

public class FullStatisticDouble implements INumberFullStatistic<Double> {
    public FullStatisticDouble(Separator separate){
        _list = separate.GetDouble();
        _infomin = _list.stream().min(Double::compare).orElseThrow();
        _infomax = _list.stream().max(Double::compare).orElseThrow();
        _infosum = _list.stream().mapToDouble(Double::doubleValue).sum();
        _infoavg = _list.stream().mapToDouble(Double::doubleValue).average().orElseThrow();
        _infosize = _list.size();
    }

    @Override
    public Double getMin() {
        return _infomin;
    }

    @Override
    public Double getMax() {
        return _infomax;
    }

    @Override
    public Double getSum() {
        return _infosum;
    }

    @Override
    public double getAverage() {
        return _infoavg;
    }

    @Override
    public int getCountElements() {
        return _infosize;
    }

    @Override
    public String Statistic(){
        String txt = "\nСтатистика вещественных чисел\n";
        txt += "------------------------------------------\n";
        txt += "Минимальное значение : " + _infomin;
        txt += "\nМaксимальное значение : " + _infomax;
        txt += "\nСумма всех значений : " + _infosum;
        txt += "\nСреднее значение : " + _infoavg;
        txt += "\nКоличество значений : " + _infosize;
        return  txt;
    }

    private Double _infomin;
    private Double _infomax;
    private Double _infosum;
    private double _infoavg;
    private int _infosize;

    private List<Double> _list;


}

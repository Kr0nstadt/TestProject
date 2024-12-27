package org.example.statistic;

import org.example.separator.Separator;

import java.util.List;

public class FullStatisticDouble implements INumberFullStatistic<Double> {
    public FullStatisticDouble(Separator separate){
        list = separate.GetDouble();
        infomin = list.stream().min(Double::compare).orElseThrow();
        infomax = list.stream().max(Double::compare).orElseThrow();
        infosum = list.stream().mapToDouble(Double::doubleValue).sum();
        infoavg = list.stream().mapToDouble(Double::doubleValue).average().orElseThrow();
        infosize = list.size();
    }

    @Override
    public Double getMin() {
        return infomin;
    }

    @Override
    public Double getMax() {
        return infomax;
    }

    @Override
    public Double getSum() {
        return infosum;
    }

    @Override
    public Double getAverage() {
        return infoavg;
    }

    @Override
    public Integer getCountElements() {
        return infosize;
    }

    @Override
    public String statistic(){
        String txt = "\nСтатистика вещественных чисел\n";
        txt += "------------------------------------------\n";
        txt += "Минимальное значение : " + infomin;
        txt += "\nМaксимальное значение : " + infomax;
        txt += "\nСумма всех значений : " + infosum;
        txt += "\nСреднее значение : " + infoavg;
        txt += "\nКоличество значений : " + infosize;
        return  txt;
    }

    private Double infomin;
    private Double infomax;
    private Double infosum;
    private Double infoavg;
    private Integer infosize;

    private List<Double> list;
}

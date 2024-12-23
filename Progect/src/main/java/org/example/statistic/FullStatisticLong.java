package org.example.statistic;

import org.example.Separator;

import java.util.List;

public class FullStatisticLong implements INumberFullStatistic<Long> {
    public FullStatisticLong(Separator separate){
        list = separate.GetLong();
        infomin = list.stream().min(Long::compare).orElseThrow();
        infomax = list.stream().max(Long::compare).orElseThrow();
        infosum = list.stream().mapToLong(Long::longValue).sum();
        infoavg = list.stream().mapToLong(Long::longValue).average().orElseThrow();
        infosize = list.size();
    }

    @Override
    public Long getMin() {
        return infomin;
    }

    @Override
    public Long getMax() {
        return infomax;
    }

    @Override
    public Long getSum() {
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
        String txt = "\nСтатистика чисел\n";
        txt += "------------------------------------------\n";
        txt += "Минимальное значение : " + infomin;
        txt += "\nМaксимальное значение : " + infomax;
        txt += "\nСумма всех значений : " + infosum;
        txt += "\nСреднее значение : " + infoavg;
        txt += "\nКоличество значений : " + infosize;
        return  txt;
    }

    private Long infomin;
    private Long infomax;
    private Long infosum;
    private Double infoavg;
    private Integer infosize;

    private List<Long> list;
}

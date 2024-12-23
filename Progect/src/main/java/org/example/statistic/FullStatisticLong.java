package org.example.statistic;

import org.example.Separator;

import java.util.List;

public class FullStatisticLong implements INumberFullStatistic<Long> {
    public FullStatisticLong(Separator separate){
        _list = separate.GetLong();
        _infomin = _list.stream().min(Long::compare).orElseThrow();
        _infomax = _list.stream().max(Long::compare).orElseThrow();
        _infosum = _list.stream().mapToLong(Long::longValue).sum();
        _infoavg = _list.stream().mapToLong(Long::longValue).average().orElseThrow();
        _infosize = _list.size();
    }

    @Override
    public Long getMin() {
        return _infomin;
    }

    @Override
    public Long getMax() {
        return _infomax;
    }

    @Override
    public Long getSum() {
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
        String txt = "\nСтатистика чисел\n";
        txt += "------------------------------------------\n";
        txt += "Минимальное значение : " + _infomin;
        txt += "\nМaксимальное значение : " + _infomax;
        txt += "\nСумма всех значений : " + _infosum;
        txt += "\nСреднее значение : " + _infoavg;
        txt += "\nКоличество значений : " + _infosize;
        return  txt;
    }

    private Long _infomin;
    private Long _infomax;
    private Long _infosum;
    private double _infoavg;
    private int _infosize;

    private List<Long> _list;


}

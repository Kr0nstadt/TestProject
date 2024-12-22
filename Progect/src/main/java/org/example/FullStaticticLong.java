package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class FullStaticticLong implements IFillStatistic{
    public FullStaticticLong(Separator separate){
        _list = new ArrayList<>();
        _list = separate.GetLong();
        GetMax();
        GetMin();
        GetMid();
        GetSize();
        GetSum();
    }

    @Override
    public void GetMin() {
        _infomin = _list.stream().min(Long::compare).orElse(null).toString();
    }

    @Override
    public void GetMax() {
        _infomax = _list.stream().max(Long::compare).orElse(null).toString();
    }

    @Override
    public void GetSum() {
        _infosum = ((Long)_list.stream().mapToLong(Long::longValue).sum()).toString();
    }

    @Override
    public void GetMid() {
        OptionalDouble average = _list.stream().mapToLong(Long::longValue).average();
        var res = average.isPresent() ? average.getAsDouble() : null;
        _infomid =  res.toString();
    }

    @Override
    public void GetSize() {
        _infosize =((Integer) _list.size()).toString();
    }

    @Override
    public String Statistic(){
        String txt = "\nСтатистика чисел\n";
        txt += "------------------------------------------\n";
        txt += "Минимальное значение : " + _infomin;
        txt += "\nМaксимальное значение : " + _infomax;
        txt += "\nСумма всех значений : " + _infosum;
        txt += "\nСреднее значение : " + _infomid;
        txt += "\nКоличество значений : " + _infosize;
        return  txt;
    }

    private String _infomin;
    private String _infomax;
    private String _infosum;
    private String _infomid;
    private String _infosize;

    private List<Long> _list;
}

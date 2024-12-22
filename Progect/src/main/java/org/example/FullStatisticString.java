package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FullStatisticString implements IFillStatisticString {
    public FullStatisticString(Separator separator){
        _list = new ArrayList<>();
        _list = separator.GetString().stream()
                .sorted(Comparator.comparingInt(String::length)).toList();
        GetMin();
        GetMax();
        GetSize();
    }
    @Override
    public void GetMin() {
        _infomin = ((Integer)_list.getFirst().length()).toString();
    }

    @Override
    public void GetMax() {
        _infomax = ((Integer)_list.getLast().length()).toString();
    }

    @Override
    public void GetSize() {
        _infosize = ((Integer)_list.size()).toString();
    }

    @Override
    public String Statistic() {
        String txt = "\nСтатистика строк ";
        txt += "------------------------------------------\n";
        txt += "Минимальное значение : " + _infomin;
        txt += "\nМaксимальное значение : " + _infomax;
        txt += "\nКоличество значений : " + _infosize;
        return txt;
    }
    private String _infomin;
    private String _infomax;
    private String _infosize;

    private List<String> _list;
}

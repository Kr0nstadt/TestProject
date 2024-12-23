package org.example.statistic;

import org.example.Separator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FullStatisticString implements IStringFullStaticstic {
    public FullStatisticString(Separator separator){
        _list = new ArrayList<>();
        _list = separator.GetString().stream()
                .sorted(Comparator.comparingInt(String::length)).toList();
        _infomin = _list.getFirst().length();
        _infomax = _list.getLast().length();
        _infosize = _list.size();

    }

    @Override
    public int getMinLength() {
        return _infomin;
    }

    @Override
    public int getMaxLength() {
        return _infomax;
    }

    @Override
    public int getCountElements() {
        return _infosize;
    }

    @Override
    public String Statistic() {
        String txt = "\nСтатистика строк \n";
        txt += "------------------------------------------\n";
        txt += "Минимальное значение : " + _infomin;
        txt += "\nМaксимальное значение : " + _infomax;
        txt += "\nКоличество значений : " + _infosize;
        return txt;
    }
    private int _infomin;
    private int _infomax;
    private int _infosize;

    private List<String> _list;


}

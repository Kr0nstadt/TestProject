package org.example.statistic;

import org.example.Separator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FullStatisticString implements IStringFullStaticstic {
    public FullStatisticString(Separator separator){
        list = new ArrayList<>();
        list = separator.GetString().stream()
                .sorted(Comparator.comparingInt(String::length)).toList();
        infomin = list.getFirst().length();
        infomax = list.getLast().length();
        infosize = list.size();

    }

    @Override
    public Integer getMinLength() {
        return infomin;
    }

    @Override
    public Integer getMaxLength() {
        return infomax;
    }

    @Override
    public Integer getCountElements() {
        return infosize;
    }

    @Override
    public String statistic() {
        String txt = "\nСтатистика строк \n";
        txt += "------------------------------------------\n";
        txt += "Минимальное значение : " + infomin;
        txt += "\nМaксимальное значение : " + infomax;
        txt += "\nКоличество значений : " + infosize;
        return txt;
    }
    private Integer infomin;
    private Integer infomax;
    private Integer infosize;

    private List<String> list;
}

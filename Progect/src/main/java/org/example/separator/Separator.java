package org.example.separator;

import java.util.ArrayList;
import java.util.List;

public class Separator {
    public Separator(List<String> lines){
        longList = new ArrayList<>();
        doubleList = new ArrayList<>();
        stringList = new ArrayList<>();
        this.Separate(lines);
    }
    public List<Long> GetLong(){
        return  longList;
    }
    public List<Double> GetDouble(){
        return  doubleList;
    }
    public List<String> GetString(){
        return stringList;
    }
    private void Separate(List<String> lines){
        SeparateLong sapint = new SeparateLong();
        SeparateDouble sapflo = new SeparateDouble();
        if(lines != null||
                !lines.isEmpty()){
            for (int i = 0; i < lines.size(); i++) {
                if (sapint.isMatch(lines.get(i))) {
                    longList.add(sapint.getValue(lines.get(i)));
                } else if (sapflo.isMatch(lines.get(i))) {
                    doubleList.add(sapflo.getValue(lines.get(i)));
                } else {
                    if(!lines.get(i).isEmpty()){
                        stringList.add(lines.get(i));
                    }
                }
            }
        }
    }
    private List<Long> longList;
    private List<Double> doubleList;
    private List<String> stringList;
}

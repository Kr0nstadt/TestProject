package org.example;

import java.util.ArrayList;
import java.util.List;

public class Separator {
    public Separator(List<String> lines){
        _longList = new ArrayList<>();
        _doubleList = new ArrayList<>();
        _stringList = new ArrayList<>();
        this.Separate(lines);
    }
    public List<Long> GetLong(){
        return  _longList;
    }
    public List<Double> GetDouble(){
        return  _doubleList;
    }
    public List<String> GetString(){
        return _stringList;
    }
    private void Separate(List<String> lines){
        SeparateLong sapint = new SeparateLong();
        SeparateDouble sapflo = new SeparateDouble();
        if(lines != null||
        !lines.isEmpty()){
            for (int i = 0; i < lines.size(); i++) {
                if (sapint.IsMath(lines.get(i))) {
                    _longList.add(sapint.getValue(lines.get(i)));
                } else if (sapflo.IsMath(lines.get(i))) {
                    _doubleList.add(sapflo.getValue(lines.get(i)));
                } else {
                    if(!lines.get(i).isEmpty()){
                        _stringList.add(lines.get(i));
                    }
                }
            }
        }
    }
    private List<Long> _longList;
    private List<Double> _doubleList;
    private List<String> _stringList;
}

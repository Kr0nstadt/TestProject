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
    private void Separate(List<String> lines){
        SeparateLong sapint = new SeparateLong();
        SeparateDouble sapflo = new SeparateDouble();
        for(int i = 0; i < lines.size(); i++){
            if(sapint.IsMath(lines.get(i))){
                _longList.add(sapint.getValue(lines.get(i)));
            }
            else if(sapflo.IsMath(lines.get(i))){
                _doubleList.add(sapflo.getValue(lines.get(i)));
            }
            else{
                _stringList.add(lines.get(i));
            }
        }
    }
    private List<Long> _longList;
    private List<Double> _doubleList;
    private List<String> _stringList;
}

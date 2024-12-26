package org.example.statistic;

import org.example.Separator;

public class ShortStatistic implements ICountElementsStaticstic{
    public ShortStatistic(Separator separator){
        count = separator.GetString().size()
                + separator.GetLong().size()
                + separator.GetDouble().size();
    }
    @Override
    public Integer getCountElements() {
        return count;
    }

    @Override
    public String statistic() {
        return "Кол-во элементов : " + count.toString();
    }
    private Integer count;
}

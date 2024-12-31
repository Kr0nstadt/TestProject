package org.example.statistic;

import org.example.separator.Separator;

import java.nio.charset.Charset;

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
        String txt = new String("Кол-во элементов : ".getBytes(Charset.defaultCharset()));
        return txt+ count.toString();
    }
    private Integer count;
}

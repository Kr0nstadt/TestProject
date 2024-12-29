package org.example.collect;

import org.example.configFlaghander.Configuration;
import org.example.configFlaghander.StatisticMode;
import org.example.separator.Separator;
import org.example.statistic.FullStatisticDouble;
import org.example.statistic.FullStatisticLong;
import org.example.statistic.FullStatisticString;
import org.example.statistic.ShortStatistic;

import java.io.File;
import java.util.stream.Collectors;

public class CollectorConsole {
    private String MakeStatistic(){
        String res = "";
        Configuration configuration = Configuration.getInstance();
        Separator separator = new Separator(configuration.getInputFiles()
                .stream().map(File::getAbsolutePath)
                .collect(Collectors.toList()));
        if(configuration.getStatisticMode() == StatisticMode.None){
            res = "Вид статистики не выбран";
        }
        if(configuration.getStatisticMode() == StatisticMode.ShortMode){
            ShortStatistic statistic = new ShortStatistic(separator);
            res = statistic.statistic();
        }
        if(configuration.getStatisticMode() == StatisticMode.FullMode){
            FullStatisticLong statisticLong = new FullStatisticLong(separator);
            FullStatisticString statisticString = new FullStatisticString(separator);
            FullStatisticDouble statisticDouble = new FullStatisticDouble(separator);

            res = statisticDouble.statistic() +
                    statisticLong.statistic() +
                    statisticString.statistic();
        }
        return res;
    }
    @Override
    public  String toString(){
        return MakeStatistic();
    }
}

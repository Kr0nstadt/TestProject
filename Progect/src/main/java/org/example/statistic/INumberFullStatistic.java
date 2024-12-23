package org.example.statistic;

public interface INumberFullStatistic<T extends Number> extends ICountElementsStaticstic {
    T getMin();
    T getMax();
    T getSum();
    Double getAverage();
}

package org.example.statistic;

import org.example.Separator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FullStatisticDoubleTest {
    @Test
    public void StatisticDoubleTest(){
        String[] array = {
                "Lorem ipsum dolor sit amet",
                "45",
                "Пример",
                "",
                "3.1415",
                "consectetur adipiscing",
                "-0.001",
                "тестовое задание",
                "100500",
                "Нормальная форма числа с плавающей запятой",
                "",
                "1.528535047E-25",
                "Long",
                "1234567890123456789"
        };
        Separator separator = new Separator(Arrays.stream(array).toList());
        FullStatisticDouble statistic = new FullStatisticDouble(separator);

        assertEquals(-0.001,statistic.getMin());
        assertEquals(3.1415,statistic.getMax());
        assertEquals(3.1405000000000003,statistic.getSum());
        assertEquals(1.0468333333333335,statistic.getAverage());
        assertEquals(3,statistic.getCountElements());
    }

}
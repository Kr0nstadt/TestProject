package org.example.statistic;

import org.example.separator.Separator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FullStatisticLongTest {
    @Test
    public void StatisticLongTest(){
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
        FullStatisticLong statistic = new FullStatisticLong(separator);

        assertEquals(45,statistic.getMin());
        assertEquals(1234567890123456789L,statistic.getMax());
        assertEquals(1234567890123557334L,statistic.getSum());
        assertEquals(4.115226300411858E17,statistic.getAverage());
        assertEquals(3,statistic.getCountElements());
    }
}
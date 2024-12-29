package org.example.separator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SeparatorTest {
    @Test
    public void SeparatorNull(){
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

        assertEquals(6,separator.GetString().size());
        assertEquals(3, separator.GetLong().size());
        assertEquals(3, separator.GetDouble().size());
    }

}
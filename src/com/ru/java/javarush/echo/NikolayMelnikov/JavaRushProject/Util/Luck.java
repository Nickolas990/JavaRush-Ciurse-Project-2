package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Util;

// TODO: 13.06.2022 Добавить в таблицу растения, не забыть указать номер удачи в классе Plant 
public class Luck {
    public static final Integer[][] luckTable = {
            {null, 0, 0, 0, 0, 10, 15, 60, 80, 60, 70, 15, 10, 40, 0},
            {0, null,  15,  0,  0,  0,  0, 20, 40, 0, 0, 0, 0, 10, 0},
            {0,  0, null, 0, 0, 0, 0, 70, 90, 0, 0, 0, 0, 60, 40},
            {0, 80, 0, null, 0, 40, 80, 80, 90, 70, 70, 50, 20, 10, 0},
            {0, 0, 10, 0, null, 0, 0, 90, 90, 0, 0, 0, 0, 80, 0},
            {0, 0, 0, 0, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, null, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, null, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, null, 0, 0, 0, 0, 0, 90},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 50, 0, 0, null, 0, 0, 90},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, 90},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null}
    };

    public static Integer getLuck(int attacker, int defender) {
        return luckTable[attacker][defender];
    }
}

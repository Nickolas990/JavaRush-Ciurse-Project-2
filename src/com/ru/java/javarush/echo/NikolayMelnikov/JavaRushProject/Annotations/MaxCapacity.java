package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MaxCapacity {
    int value();
}

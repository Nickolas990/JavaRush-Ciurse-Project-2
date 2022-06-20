package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Util;

import java.util.concurrent.ThreadFactory;

public class GrassThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        thread.setPriority(Thread.MIN_PRIORITY);
        return thread;
    }
}

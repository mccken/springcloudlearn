package com.mccken201908.order.config;

import java.util.concurrent.atomic.AtomicBoolean;

import org.springframework.context.ApplicationContext;

public class InstanceFactory {
    private static SpringInstanceProvider instanceProvider;
    private static Long timeStarting = System.currentTimeMillis();
    private static AtomicBoolean initialized = new AtomicBoolean(false);
    private static AtomicBoolean loadFinished = new AtomicBoolean(false);

    public InstanceFactory() {
    }

    public static void setInstanceProvider(SpringInstanceProvider provider) {
        if (instanceProvider == null) {
            instanceProvider = provider;
            initialized.set(true);
        }
    }

    public static void loadFinished(SpringInstanceProvider provider) {
        setInstanceProvider(provider);
        loadFinished.set(true);
    }

    public static boolean isLoadfinished() {
        return loadFinished.get();
    }

    public static <T> T getInstance(Class<T> beanClass) {
        return getInstanceProvider() == null ? null : getInstanceProvider().getInstance(beanClass);
    }

    public static <T> T getInstance(Class<T> beanClass, String beanName) {
        return getInstanceProvider().getInstance(beanClass, beanName);
    }

    public static <T> T getInstance(String beanName) {
        return getInstanceProvider().getInstance(beanName);
    }

    public static SpringInstanceProvider getInstanceProvider() {
        return instanceProvider;
    }

    public static ApplicationContext getContext() {
        return getInstanceProvider().getApplicationContext();
    }

    public static synchronized void waitUtilInitialized() {
        if (!initialized.get()) {
            while(!initialized.get()) {
                try {
                    Thread.sleep(1000L);
                } catch (Exception var2) {
                }

                long waiting = System.currentTimeMillis() - timeStarting;
                if (waiting > 60000L) {
                    throw new RuntimeException("Spring Initialize failture");
                }

                System.out.println("Spring Initializing >>>>>" + waiting + " s");
            }

        }
    }

    public static boolean isInitialized() {
        return initialized.get();
    }
}
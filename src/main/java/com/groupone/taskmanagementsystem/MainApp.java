package com.groupone.taskmanagementsystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class MainApp {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainApp.class);

    private MainApp() {
        throw new UnsupportedOperationException("Esta es una clase utilitaria y no puede ser instanciada");
    }

    public static void main(final String[] args) {
        LOGGER.info("Hola Mundo!");
    }
}
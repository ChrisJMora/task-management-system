package com.groupone.taskmanagementsystem.utils;

/**
 * Implementación de salida de consola usando System.out.
 * <p>
 * Esta clase proporciona una implementación concreta de la interfaz
 * {@link IConsoleOutput} que utiliza System.out.println para imprimir
 * mensajes en la consola estándar.
 * </p>
 * 
 * @author Group One
 * @version 1.0
 * @since 1.0
 */
@SuppressWarnings("PMD.AtLeastOneConstructor")
public class SystemOutConsoleOutput implements IConsoleOutput {

    /**
     * {@inheritDoc}
     */
    @Override
    public void print(final String message) {
        System.out.println(message);
    }

}
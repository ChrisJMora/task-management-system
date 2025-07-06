package com.groupone.taskmanagementsystem.utils;

/**
 * Interfaz que define el contrato para la salida de consola.
 * <p>
 * Esta interfaz proporciona una abstracción para la salida de mensajes
 * a la consola, permitiendo la inyección de dependencias y facilitando
 * las pruebas unitarias.
 * </p>
 * 
 * @author Group One
 * @version 1.0
 * @since 1.0
 */
public interface IConsoleOutput {

    /**
     * Imprime un mensaje en la consola.
     * 
     * @param message el mensaje a imprimir
     */
    void print(String message);

}

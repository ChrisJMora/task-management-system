package com.groupone.taskmanagementsystem.models;

/**
 * Interfaz que define el contrato para entidades identificables en el sistema.
 * <p>
 * Esta interfaz proporciona métodos para obtener información básica de identificación
 * de cualquier entidad que la implemente, incluyendo un índice único y un nombre de entidad.
 * </p>
 * 
 * @author Group One
 * @version 1.0
 * @since 1.0
 */
public interface Identifiable {
    
    /**
     * Obtiene el índice único de la entidad.
     * <p>
     * Este método retorna un identificador numérico único que permite
     * distinguir una entidad de otras del mismo tipo.
     * </p>
     * 
     * @return el índice único de la entidad
     */
    int getEntityIndex();
    
    /**
     * Obtiene el nombre de tipo de la entidad.
     * <p>
     * Este método retorna una cadena que representa el tipo o categoría
     * de la entidad, útil para mensajes de usuario y logging.
     * </p>
     * 
     * @return el nombre del tipo de entidad
     */
    String getEntityName();
}
package com.groupone.taskmanagementsystem.views;

/**
 * Interfaz que define el contrato para la impresión de notificaciones.
 * <p>
 * Esta interfaz proporciona métodos para imprimir notificaciones estándar
 * sobre el resultado de las operaciones CRUD en el sistema, incluyendo
 * mensajes de éxito y error.
 * </p>
 * 
 * @author Group One
 * @version 1.0
 * @since 1.0
 */
public interface INotificationPrinter {

    /**
     * Imprime un mensaje de éxito para la creación de una entidad.
     */
    void printCreateSuccess();

    /**
     * Imprime un mensaje de error para la creación de una entidad.
     * 
     * @param reason la razón del error
     */
    void printCreateFailure(String reason);

    /**
     * Imprime un mensaje de éxito para la lectura de una entidad.
     */
    void printReadSuccess();

    /**
     * Imprime un mensaje de error para la lectura de una entidad.
     * 
     * @param entityIndex el índice de la entidad que no se pudo leer
     */
    void printReadFailure(int entityIndex);

    /**
     * Imprime un mensaje de éxito para la actualización de una entidad.
     * 
     * @param entityIndex el índice de la entidad actualizada
     */
    void printUpdateSuccess(int entityIndex);

    /**
     * Imprime un mensaje de error para la actualización de una entidad.
     * 
     * @param entityIndex el índice de la entidad que no se pudo actualizar
     * @param reason la razón del error
     */
    void printUpdateFailure(int entityIndex, String reason);

    /**
     * Imprime un mensaje de éxito para la eliminación de una entidad.
     * 
     * @param entityIndex el índice de la entidad eliminada
     */
    void printDeleteSuccess(int entityIndex);

    /**
     * Imprime un mensaje de error para la eliminación de una entidad.
     * 
     * @param entityIndex el índice de la entidad que no se pudo eliminar
     * @param reason la razón del error
     */
    void printDeleteFailure(int entityIndex, String reason);

    /**
     * Imprime un mensaje indicando que la lista está vacía.
     */
    void printListEmpty();

    /**
     * Imprime un mensaje de éxito para el listado de entidades.
     * 
     * @param count el número de entidades encontradas
     */
    void printListSuccess(int count);
}

package com.groupone.taskmanagementsystem.views;

import com.groupone.taskmanagementsystem.utils.IConsoleOutput;
import com.groupone.taskmanagementsystem.utils.SystemOutConsoleOutput;

/**
 * Implementación del impresor de notificaciones.
 * <p>
 * Esta clase proporciona funcionalidad para imprimir mensajes de notificación
 * sobre el resultado de las operaciones CRUD. Los mensajes se personalizan
 * según el nombre de la entidad especificada.
 * </p>
 * 
 * @author Group One
 * @version 1.0
 * @since 1.0
 */
public class NotificationPrinter implements INotificationPrinter {

    /**
     * Etiqueta utilizada para identificar el ID de las entidades.
     */
    private static final String ID_LABEL = "ID";

    /**
     * Objeto para manejar la salida de consola.
     */
    private final IConsoleOutput console;

    /**
     * Nombre de la entidad para personalizar los mensajes.
     */
    private final String entityName;

    /**
     * Construye un nuevo impresor de notificaciones con salida de consola por defecto.
     * 
     * @param entityName el nombre de la entidad para personalizar los mensajes
     */
    public NotificationPrinter(final String entityName) {
        this.console = new SystemOutConsoleOutput();
        this.entityName = entityName;
    }

    /**
     * Construye un nuevo impresor de notificaciones con salida de consola personalizada.
     * 
     * @param entityName el nombre de la entidad para personalizar los mensajes
     * @param console la implementación de salida de consola a utilizar
     */
    public NotificationPrinter(final String entityName, final IConsoleOutput console) {
        this.console = console;
        this.entityName = entityName;
    }

    /**
     * Genera una cadena que combina el nombre de la entidad con su ID.
     * 
     * @param entityIndex el índice de la entidad
     * @return una cadena en formato "entidad con ID índice"
     */
    private String getEntityNameWithId(final int entityIndex) {
        return entityName + " con " + ID_LABEL + " " + entityIndex;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void printCreateSuccess() {
        console.print(entityName + " creada con éxito.");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void printCreateFailure(final String reason) {
        console.print("Error al crear " + entityName + ": " + reason);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void printReadSuccess() {
        console.print(entityName + " encontrada.");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void printReadFailure(final int entityIndex) {
        console.print("No existe " + getEntityNameWithId(entityIndex) + ".");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void printUpdateSuccess(final int entityIndex) {
        console.print(getEntityNameWithId(entityIndex) + " actualizada con éxito.");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void printUpdateFailure(final int entityIndex, final String reason) {
        console.print("Error al actualizar " + getEntityNameWithId(entityIndex) + ": " + reason);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void printDeleteSuccess(final int entityIndex) {
        console.print(getEntityNameWithId(entityIndex) + " eliminada correctamente.");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void printDeleteFailure(final int entityIndex, final String reason) {
        console.print("No se pudo eliminar " + getEntityNameWithId(entityIndex) + ": " + reason);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void printListEmpty() {
        console.print("No hay tareas para mostrar.");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void printListSuccess(final int count) {
        console.print("Se encontraron " + count + " " + entityName + "s.");
    }
}

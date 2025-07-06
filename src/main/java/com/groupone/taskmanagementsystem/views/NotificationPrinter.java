package com.groupone.taskmanagementsystem.views;

import com.groupone.taskmanagementsystem.utils.IConsoleOutput;
import com.groupone.taskmanagementsystem.utils.SystemOutConsoleOutput;

public class NotificationPrinter implements INotificationPrinter {

    private static final String ID_LABEL = "ID";

    private final IConsoleOutput console;

    private final String entityName;

    public NotificationPrinter(final String entityName) {
        this.console = new SystemOutConsoleOutput();
        this.entityName = entityName;
    }

    public NotificationPrinter(final String entityName, final IConsoleOutput console) {
        this.console = console;
        this.entityName = entityName;
    }

    private String getEntityNameWithId(final int entityIndex) {
        return entityName + " con " + ID_LABEL + " " + entityIndex;
    }

    @Override
    public void printCreateSuccess() {
        console.print(entityName + " creada con éxito.");
    }

    @Override
    public void printCreateFailure(final String reason) {
        console.print("Error al crear " + entityName + ": " + reason);
    }

    @Override
    public void printReadSuccess() {
        console.print(entityName + " encontrada.");
    }

    @Override
    public void printReadFailure(final int entityIndex) {
        console.print("No existe " + getEntityNameWithId(entityIndex) + ".");
    }

    @Override
    public void printUpdateSuccess(final int entityIndex) {
        console.print(getEntityNameWithId(entityIndex) + " actualizada con éxito.");
    }

    @Override
    public void printUpdateFailure(final int entityIndex, final String reason) {
        console.print("Error al actualizar " + getEntityNameWithId(entityIndex) + ": " + reason);
    }

    @Override
    public void printDeleteSuccess(final int entityIndex) {
        console.print(getEntityNameWithId(entityIndex) + " eliminada correctamente.");
    }

    @Override
    public void printDeleteFailure(final int entityIndex, final String reason) {
        console.print("No se pudo eliminar " + getEntityNameWithId(entityIndex) + ": " + reason);
    }

    @Override
    public void printListEmpty() {
        console.print("No hay tareas para mostrar.");
    }

    @Override
    public void printListSuccess(final int count) {
        console.print("Se encontraron " + count + " " + entityName + "s.");
    }
}

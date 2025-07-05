package com.groupone.taskmanagementsystem;

public class NotificationPrinter implements INotificationPrinter {

    private static final String ID_LABEL = "ID";

    private final Identifiable entity;
    private final IConsoleOutput consoleOutput;

    public NotificationPrinter(final Identifiable entity, final IConsoleOutput consoleOutput) {
        this.entity = entity;
        this.consoleOutput = consoleOutput;
    }

    public NotificationPrinter(final Identifiable entity) {
        this(entity, new SystemOutConsoleOutput());
    }

    private String getEntityNameWithId() {
        return entity.getEntityName() + " con " + ID_LABEL + " " + entity.getEntityIndex();
    }

    @Override
    public void printCreateSuccess() {
        consoleOutput.printMessage(entity.getEntityName() + " creada con éxito.");
    }

    @Override
    public void printCreateFailure(final String reason) {
        consoleOutput.printMessage("Error al crear " + entity.getEntityName() + ": " + reason);
    }

    @Override
    public void printReadSuccess() {
        consoleOutput.printMessage(getEntityNameWithId() + " encontrada.");
    }

    @Override
    public void printReadFailure() {
        consoleOutput.printMessage("No existe " + getEntityNameWithId() + ".");
    }

    @Override
    public void printUpdateSuccess() {
        consoleOutput.printMessage(getEntityNameWithId() + " actualizada con éxito.");
    }

    @Override
    public void printUpdateFailure(final String reason) {
        consoleOutput.printMessage("Error al actualizar " + getEntityNameWithId() + ": " + reason);
    }

    @Override
    public void printDeleteSuccess() {
        consoleOutput.printMessage(getEntityNameWithId() + " eliminada correctamente.");
    }

    @Override
    public void printDeleteFailure() {
        consoleOutput.printMessage("No se pudo eliminar " + getEntityNameWithId() + ". Puede que no exista.");
    }

    @Override
    public void printListEmpty() {
        consoleOutput.printMessage("No hay " + entity.getEntityName() + "s para mostrar.");
    }

    @Override
    public void printListSuccess(final int count) {
        consoleOutput.printMessage("Se encontraron " + count + " " + entity.getEntityName() + "s.");
    }
}

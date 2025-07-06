package com.groupone.taskmanagementsystem.models;

/**
 * Representa una tarea individual en el sistema de gestión de tareas.
 * <p>
 * Esta clase modela una tarea con un identificador único y un título.
 * Implementa la interfaz {@link Identifiable} para proporcionar información
 * básica de identificación.
 * </p>
 *
 * @author Group One
 * @version 1.0
 * @since 1.0
 */
public class TaskItem implements Identifiable {

    /**
     * Nombre de la entidad utilizado para identificar el tipo de objeto.
     */
    public static final String ENTITY_NAME = "tarea";

    /**
     * Índice único de la tarea.
     */
    private int entityIndex;

    /**
     * Título o nombre de la tarea.
     */
    private String taskTitle;

    /**
     * Construye una nueva tarea con el índice y título especificados.
     *
     * @param entityIndex el índice único de la tarea
     * @param taskTitle   el título de la tarea
     */
    public TaskItem(final int entityIndex, final String taskTitle) {
        this.entityIndex = entityIndex;
        this.taskTitle = taskTitle;
    }

    /**
     * Construye una nueva tarea con el título especificado.
     * <p>
     * El índice de la entidad se inicializa en 0 y debe ser establecido
     * posteriormente cuando la tarea sea añadida al repositorio.
     * </p>
     *
     * @param taskTitle el título de la tarea
     */
    public TaskItem(final String taskTitle) {
        this.entityIndex = 0;
        this.taskTitle = taskTitle;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getEntityIndex() {
        return entityIndex;
    }

    /**
     * Establece el índice único de la tarea.
     *
     * @param entityIndex el nuevo índice de la tarea
     */
    public void setEntityIndex(final int entityIndex) {
        this.entityIndex = entityIndex;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    /**
     * Obtiene el título de la tarea.
     *
     * @return el título de la tarea
     */
    public String getTaskTitle() {
        return taskTitle;
    }

    /**
     * Establece el título de la tarea.
     *
     * @param taskTitle el nuevo título de la tarea
     */
    public void setTitle(final String taskTitle) {
        this.taskTitle = taskTitle;
    }

    /**
     * Retorna una representación en cadena de la tarea.
     * <p>
     * El formato incluye el ID, nombre de entidad y título de la tarea.
     * </p>
     *
     * @return representación en cadena de la tarea
     */
    @Override
    public String toString() {
        return "TaskItem{" +
                "id='" + entityIndex + '\'' +
                "nombre='" + ENTITY_NAME + '\'' +
                "título='" + taskTitle + '\'' +
                '}';
    }
}
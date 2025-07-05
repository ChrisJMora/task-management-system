package com.groupone.taskmanagementsystem;

public interface INotificationPrinter {

    void printCreateSuccess();

    void printCreateFailure(String reason);

    void printReadSuccess();

    void printReadFailure(int entityIndex);

    void printUpdateSuccess(int entityIndex);

    void printUpdateFailure(int entityIndex, String reason);

    void printDeleteSuccess(int entityIndex);

    void printDeleteFailure(int entityIndex, String reason);

    void printListEmpty();

    void printListSuccess(int count);
}

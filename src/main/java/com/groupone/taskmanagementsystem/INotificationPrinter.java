package com.groupone.taskmanagementsystem;

public interface INotificationPrinter {

    void printCreateSuccess();

    void printCreateFailure(String reason);

    void printReadSuccess();

    void printReadFailure();

    void printUpdateSuccess();

    void printUpdateFailure(String reason);

    void printDeleteSuccess();

    void printDeleteFailure();

    void printListEmpty();

    void printListSuccess(int count);
}


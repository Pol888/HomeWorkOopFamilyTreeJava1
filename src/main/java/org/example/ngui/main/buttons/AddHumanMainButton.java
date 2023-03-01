package org.example.ngui.main.buttons;

import org.example.ngui.ConsoleUI;
import org.example.ngui.SButton;


public class AddHumanMainButton extends SButton {
    private final String text;
    {
        text = "Добавить человека";
    }
    private final ConsoleUI consoleUI;

    public AddHumanMainButton(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void action() {
        System.out.println("Введите Ф.И.О.\n");
        String input = consoleUI.getScanner().nextLine();
        consoleUI.getPresenter().setCommandFromView("addH", input, -1);
        consoleUI.setPrintList(consoleUI.getPresenter().getPrintList()); // обнавляет лист для печати после операции
    }
    @Override
    public String toString() {
        return text;
    }
}

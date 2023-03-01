package org.example.ngui.tmenu.button;

import org.example.ngui.ConsoleUI;
import org.example.ngui.SButton;

public class EditTheDateOfDeathButton extends SButton {
    private final Integer indexHuman;
    private final String text;
    {
        text = "Изменить данные о дате смерти";
    }
    private final ConsoleUI consoleUI;

    public EditTheDateOfDeathButton(ConsoleUI consoleUI, Integer indexHuman) {
        this.indexHuman = indexHuman;
        this.consoleUI = consoleUI;
    }

    @Override
    public void action() {
        System.out.println("Введите дату в формате <<< |день|пробел|месяц|пробел|год| >>>");
        String input = consoleUI.getScanner().nextLine();
        consoleUI.getPresenter().setCommandFromView("dateD", input, indexHuman);
        consoleUI.setPrintList(consoleUI.getPresenter().getPrintList()); // обнавляет лист для печати после операции
        System.out.println("Данные измененны.");
    }

    @Override
    public String toString() {
        return text;
    }
}

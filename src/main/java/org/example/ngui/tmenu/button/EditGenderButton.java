package org.example.ngui.tmenu.button;

import org.example.ngui.ConsoleUI;
import org.example.ngui.SButton;

public class EditGenderButton extends SButton {
    private final Integer indexHuman;
    private final String text;
    {
        text = "Изменить данные о гендерной пренадлежности";
    }
    private final ConsoleUI consoleUI;

    public EditGenderButton(ConsoleUI consoleUI, Integer indexHuman) {
        this.indexHuman = indexHuman;
        this.consoleUI = consoleUI;
    }

    @Override
    public void action() {
        System.out.println("1 - Мужчина\n2 - Женщина\n");
        String input = consoleUI.getScanner().nextLine();
        consoleUI.getPresenter().setCommandFromView("gender", input, indexHuman);
        consoleUI.setPrintList(consoleUI.getPresenter().getPrintList()); // обнавляет лист для печати после операции
        System.out.println("Данные измененны.");
    }

    @Override
    public String toString() {
        return text;
    }
}

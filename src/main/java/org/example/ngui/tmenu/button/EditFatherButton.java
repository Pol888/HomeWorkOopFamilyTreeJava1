package org.example.ngui.tmenu.button;

import org.example.ngui.ConsoleUI;
import org.example.ngui.SButton;
import org.example.ngui.main.buttons.PrintList;

import java.util.ArrayList;
import java.util.Map;

public class EditFatherButton extends SButton implements PrintList {

    private final Integer indexHuman;
    private final String text;
    {
        text = "Изменить данные об отце";
    }
    private final ConsoleUI consoleUI;

    public EditFatherButton(ConsoleUI consoleUI, Integer indexHuman) {
        this.indexHuman = indexHuman;
        this.consoleUI = consoleUI;
    }

    @Override
    public void action() {
        System.out.println("Выберете отца из списка");
        printList(consoleUI.getPrintList());
        String input = consoleUI.getScanner().nextLine();
        consoleUI.getPresenter().setCommandFromView("father", input, indexHuman);
        consoleUI.setPrintList(consoleUI.getPresenter().getPrintList()); // обнавляет лист для печати после операции
        System.out.println("Данные измененны.");
    }

    @Override
    public String toString() {
        return text;
    }

    @Override
    public void printList(ArrayList<Map<String, String>> list) {
        for (int i = 0; i < list.size(); i++) {
            for (String s : list.get(i).keySet()) {
                System.out.printf("%d - %s%n", i + 1,  s);
            }
        }
    }

}

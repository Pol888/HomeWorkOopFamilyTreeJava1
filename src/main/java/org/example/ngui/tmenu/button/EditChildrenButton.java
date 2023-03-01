package org.example.ngui.tmenu.button;

import org.example.ngui.ConsoleUI;
import org.example.ngui.SButton;
import org.example.ngui.main.buttons.PrintList;

import java.util.ArrayList;
import java.util.Map;

public class EditChildrenButton extends SButton implements PrintList {
    private final Integer indexHuman;
    private final String text;
    {
        text = "Изменить данные о детях";
    }
    private final ConsoleUI consoleUI;

    public EditChildrenButton(ConsoleUI consoleUI, Integer indexHuman) {
        this.indexHuman = indexHuman;
        this.consoleUI = consoleUI;
    }

    @Override
    public void action() {
        System.out.println("Внесите ребенка из списка");
        printList(consoleUI.getPrintList());
        String input = consoleUI.getScanner().nextLine();
        consoleUI.getPresenter().setCommandFromView("children", input, indexHuman);
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

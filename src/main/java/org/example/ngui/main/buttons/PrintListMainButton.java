package org.example.ngui.main.buttons;

import org.example.ngui.ConsoleUI;
import org.example.ngui.SButton;

import java.util.ArrayList;
import java.util.Map;

public class PrintListMainButton extends SButton implements PrintList {
    private final String text;
    {
        text = "Вывод на экран";
    }
    private final ConsoleUI consoleUI;

    public PrintListMainButton(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void action() {
        boolean flag = false;
        while (!flag){
            System.out.println("<<< Выберете человека для печати >>>\n");
            printList(consoleUI.getPrintList());
            System.out.println("m - главное меню\n");
            String input = consoleUI.getScanner().nextLine();
            if (input.equals("m")) {
                flag = true;
            } else {
                System.out.println(consoleUI.getPrintList().get(Integer.parseInt(input) - 1).values());
            }
        }
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

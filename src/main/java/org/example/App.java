package org.example;

import org.example.model.Human;
import org.example.model.Tree;
import org.example.model.communication.Service;
import org.example.model.communication.SystemModelCommunication;

import org.example.model.comparator.ComparatorFunction;
import org.example.model.comparator.ComparatorHuman;
import org.example.model.file.TreeHandlerTxt;
import org.example.ngui.ConsoleUI;
import org.example.ngui.View;
import org.example.presenter.Presenter;

import java.io.IOException;


public class App
{
    public static void main( String[] args ) throws IOException {
        Tree<Human> tree = new TreeHandlerTxt().read("File.txt");
        new ComparatorHuman().sortTree(tree.getBigFamily(), ComparatorFunction.dateOfBirth);

        View view = new ConsoleUI();
        Service sc = new SystemModelCommunication(tree);
        new Presenter(view, sc);
        view.start();


        new ComparatorHuman().sortTree(tree.getBigFamily(), ComparatorFunction.id);    // перед записью сортировка по id
        new TreeHandlerTxt().write(tree);  // сохранение
    }
}

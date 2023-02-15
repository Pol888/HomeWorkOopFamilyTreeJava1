package org.example;

public interface FileOperable {
    void write(Tree tree);
    Tree read(String nameFile);
}

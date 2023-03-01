package org.example.ngui;

import org.example.presenter.Presenter;

public interface View {
    void setPresenter(Presenter presenter);
    void start();
    void print(String string);

}

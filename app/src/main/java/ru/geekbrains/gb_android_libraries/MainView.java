
package ru.geekbrains.gb_android_libraries;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(value = AddToEndSingleStrategy.class)
public interface MainView extends MvpView {
    void setButton1Text(int value);
    void setButton2Text(int value);
    void setButton3Text(int value);
}
package ru.geekbrains.gb_android_libraries;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private Model model = new Model();

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }

    private int calcValue(int index){
        model.setAt(index, model.getAt(index) + 1);
        return model.getAt(index);
    }

    public void counter1Click(int value){
        getViewState().setButton1Text(calcValue(value));
    }

    public void counter2Click(int value){
        getViewState().setButton2Text(calcValue(value));
    }
    public void counter3Click(int value){
        getViewState().setButton3Text(calcValue(value));
    }
}
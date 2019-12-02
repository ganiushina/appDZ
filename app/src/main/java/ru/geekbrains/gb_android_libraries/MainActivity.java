
package ru.geekbrains.gb_android_libraries;

import android.os.Bundle;
import android.widget.Button;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    @BindView(R.id.btnCounter1)
    Button buttonOne;

    @BindView(R.id.btnCounter2)
    Button buttonTwo;

    @BindView(R.id.btnCounter3)
    Button buttonThree;

    @InjectPresenter
    MainPresenter presenter;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnCounter1})
    public void onButton1Click(Button button) {
        presenter.counter1Click(0);
    }

    @OnClick({R.id.btnCounter2})
    public void onButton2Click(Button button) {
        presenter.counter2Click(1);
    }

    @OnClick({R.id.btnCounter3})
    public void onButton3Click(Button button) {
        presenter.counter3Click(2);
    }

    @Override
    public void setButton1Text(int value) {
        buttonOne.setText(String.format(getString(R.string.count_format), value));
    }
    @Override
    public void setButton2Text(int value) {
        buttonTwo.setText(String.format(getString(R.string.count_format), value));
    }
    @Override
    public void setButton3Text(int value) {
        buttonThree.setText(String.format(getString(R.string.count_format), value));
    }
}

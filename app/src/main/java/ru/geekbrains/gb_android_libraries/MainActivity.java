package ru.geekbrains.gb_android_libraries;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnCounter1, R.id.btnCounter2, R.id.btnCounter3})
    public void onButtonClick(Button button) {
        presenter.counterClick(button.getId());
    }

    @Override
    public void setButtonText(int index, int value) {
        switch (index) {
            case 0:
                buttonOne.setText(String.format(getString(R.string.count_format), value));
                break;
            case 1:
                buttonTwo.setText(String.format(getString(R.string.count_format), value));
                break;
            case 2:
                buttonThree.setText(String.format(getString(R.string.count_format), value));
                break;
        }
    }
}

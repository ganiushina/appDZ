package ru.geekbrains.gb_android_libraries;

import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private Model model;
    private FakeRepository repository;

    final int[] val = new int[1];
    final int[] val1 = new int[1];
    final int[] val2 = new int[1];


    public MainPresenter() {
        this.model = new Model();
        repository = new FakeRepository();
    }

    @SuppressLint("TimberArgCount")
    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        model.subscribe((message) -> {
            if (message instanceof MainPresenter) {
                Timber.v("Testing ", ((MainPresenter) message).val[0]+1);
            }
            if (message instanceof Integer) {
                Timber.v("Testing ", message);
            }
        });
    }
    private void calcValue1(int index, int value){
        model.setAt(index, value);
    }

     public void counter1Click(int value){
         calcValue1(value, val[0]);
         model.publish(this, value);
         model.getData(value)
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Observer<Integer>() {
                     @Override
                     public void onSubscribe(Disposable d) {
                         Timber.d("onSubscribe");
                     }

                     @Override
                     public void onNext(Integer value) {
                         val[0] = value+1;
                         getViewState().setButton1Text(val[0]);
                         Timber.d(String.format("onNext111 %d", value));
                     }

                     @Override
                     public void onError(Throwable e) {
                         Timber.e(e, "onError");
                     }

                     @Override
                     public void onComplete() {
                         Timber.d("onComplete");
                     }
                 });
    }

    public void counter2Click(int value){
        calcValue1(value, val1[0]);
        model.getData(value)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Timber.d("onSubscribe");
                    }

                    @Override
                    public void onNext(Integer value) {
                        val1[0] = value+1;
                        getViewState().setButton2Text(val1[0]);
                        Timber.d(String.format("onNext111 %d", value));
                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e(e, "onError");
                    }

                    @Override
                    public void onComplete() {
                        Timber.d("onComplete");
                    }
                });
    }

    public void counter3Click(int value){
        calcValue1(value, val2[0]);
        model.getData(value)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Timber.d("onSubscribe");
                    }

                    @Override
                    public void onNext(Integer value) {
                        val2[0] = value+1;
                        getViewState().setButton3Text(val2[0]);
                        Timber.d(String.format("onNext111 %d", value));
                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e(e, "onError");
                    }

                    @Override
                    public void onComplete() {
                        Timber.d("onComplete");
                    }
                });
    }

}
package ru.geekbrains.gb_android_libraries;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

public class Model {
    private List<Integer> counters;

    private static PublishSubject<Object> sSubject = PublishSubject.create();

    public Model() {
        counters = new ArrayList<>();
        counters.add(0);
        counters.add(0);
        counters.add(0);
    }

    public static Disposable subscribe(@NonNull Consumer<Object> action) {
        return sSubject.subscribe(action);
    }

    public void publish(@NonNull Object message, int value) {
        sSubject.onNext(message);
        sSubject.onNext(this.counters.get(value));
    }

    public Observable<Integer> getData(int value){
        return Observable.fromCallable(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return counters.get(value);
            }
        }).subscribeOn(Schedulers.io());
    }


    public void setAt(int pos, int value) {
        counters.set(pos, value);
    }

}

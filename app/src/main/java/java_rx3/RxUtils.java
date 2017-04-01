package java_rx3;


import android.nfc.Tag;
import android.util.Log;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

/**
 * Created by Administrator on 2017/3/31.
 */

public class RxUtils {
    private static final String TAG=RxUtils.class.getSimpleName();

    /**
     * 使用create方法
     */
    public static void createObserable(){
        //定义被观察者
        Observable<String> observable=Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                if(!subscriber.isUnsubscribed()){
                    subscriber.onNext("Hello world!");
                    subscriber.onNext("Hello futrue!");
                    subscriber.onNext(downloading());
                    subscriber.onCompleted();
                }

            }
        });
        Subscriber<String> subscriber=new Subscriber<String>() {
            @Override
            public void onCompleted() {
                Log.i(TAG,"onCompleted()");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG,"onError");
            }

            @Override
            public void onNext(String s) {
                Log.i(TAG,"onNext"+s);
            }
        };
        observable.subscribe(subscriber);

    }
    public static String downloading(){
        return "json data";
    }
    /**
     * 一个打印的功能
     */
    public static void createPrint(){
        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                if(!subscriber.isUnsubscribed()){
                    for (int i=1;i<10;i++){
                        subscriber.onNext(i);
                    }
                    subscriber.onCompleted();

                }
            }
        }).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                Log.i(TAG,"oncompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG,""+e);
            }

            @Override
            public void onNext(Integer integer) {
                Log.i(TAG,"OnNext:"+integer);
            }
        });

    }

    /**
     * 使用在被观察者，返回的对象一般都是数字类型
     */
    public static void from(){
        Integer[] items={1,2,3,4,5,6,7,8,9};
        Observable obser=Observable.from(items);
        obser.subscribe(new Action1() {
            @Override
            public void call(Object o) {
                Log.i(TAG,o.toString());
            }
        });
    }
    /**
     * RXjava定时器功能
     */
    public static void interval(){
        Integer[] items={1,2,3,4,5,6,7,8,9};
        Observable observable=Observable.interval(1,1, java.util.concurrent.TimeUnit.SECONDS);
        observable.subscribe(new Action1() {
            @Override
            public void call(Object o) {
                Log.i(TAG,o.toString());
            }
        });
    }
}

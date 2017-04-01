package java_rx3;

import android.nfc.Tag;
import android.util.Log;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by Administrator on 2017/3/31.
 */

public class RxUtils {
    private static final String TAG=RxUtils.class.getSimpleName();
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
}

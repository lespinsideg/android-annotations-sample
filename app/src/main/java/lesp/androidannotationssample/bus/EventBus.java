package lesp.androidannotationssample.bus;

import org.androidannotations.annotations.EBean;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

@EBean(scope= EBean.Scope.Singleton)
public class EventBus {
    private final Subject<Object, Object> bus = new SerializedSubject<>(PublishSubject.create());

    public void send(Object o) {
        bus.onNext(o);
    }

    public Observable<Object> toObserverable() {
        return bus;
    }
}

package ggx.com.ioc_api;

/**
 * Created by jerry.guan on 4/21/2017.
 */

public interface MethodCallback<T> {

    void invoke(T source, int requestCode);
    void invokeFail(T source, int requesCode);
}

package com.neocaptainnemo.fragmentsnov29.domain;

public interface Callback<T> {

    void onSuccess(T data);

    void onError(Throwable error);
}

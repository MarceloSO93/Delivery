package com.greenbelly.need.ui.webapi;

public interface SimpleCallback<T> {
    void onResponse (T response);
    void onError (String error);
}

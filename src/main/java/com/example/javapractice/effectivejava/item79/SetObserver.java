package com.example.javapractice.effectivejava.item79;

@FunctionalInterface
public interface SetObserver<E> {

    void added(ObservableSet<E> set, E element);

}

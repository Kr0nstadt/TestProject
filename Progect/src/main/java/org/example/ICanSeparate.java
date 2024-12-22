package org.example;
import java.util.List;

public interface ICanSeparate<T> {
    boolean IsMath(String txt);
    T getValue(String txt);
}
package com.mounacheikhna.rxjavaextensions;

import rx.functions.Func1;

/**
 * Created by cheikhnamouna on 12/13/15.
 */
public final class Functions {

  private Functions() {}

  public static <Boolean> Func1<Boolean, Boolean> isTrue() {
    return identity();
  }

  /**
   * Maps T to itself.
   */
  public static <T> Func1<T, T> identity() {
    return new Func1<T, T>() {
      @Override
      public T call(T t) {
        return t;
      }
    };
  }

  /**
   * Checks if T is null.
   * @param <T>
   * @return
   */
  public static <T> Func1<T, Boolean> isNull() {
    return new Func1<T, Boolean>() {

      @Override
      public Boolean call(T t) {
        return t == null;
      }
    };
  }

  /**
   * Checks if T is not null.
   * @param <T>
   * @return
   */
  public static <T> Func1<T, Boolean> isNotNull() {
    return new Func1<T, Boolean>() {

      @Override
      public Boolean call(T t) {
        return t != null;
      }
    };
  }


}

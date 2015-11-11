package com.mounacheikhna.rxjavaextensions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import rx.Observable;
import rx.Observable.Transformer;
import rx.functions.Action2;
import rx.functions.Func0;
import rx.functions.Func1;

/**
 * Created by cheikhnamouna on 11/11/15.
 */
public final class Transformers {

  /**
   * Returns an Observable that emits a single item, a set composed of all items emitted by the
   * source Observable.
   *
   * @return an Observable that emits a set of the sequence.
   */
  public static <T> Transformer<T, Set<T>> toSet() {
    return new Transformer<T, Set<T>>() {
      @Override public Observable<Set<T>> call(Observable<T> o) {
        return o.collect(new Func0<Set<T>>() {
          @Override public Set<T> call() {
            return new HashSet<T>();
          }
        }, new Action2<Set<T>, T>() {
          @Override public void call(Set<T> ts, T t) {
            ts.add(t);
          }
        });
      }
    };
  }

  /**
   * Returns a sequence of any type as a sequence of strings.
   *
   * @return an Observable that emits the same sequence with each converted to String.
   */
  public static <T> Transformer<T, String> toStringSeq() {
    return new Transformer<T, String>() {
      @Override public Observable<String> call(Observable<T> o) {
        return o.map(new Func1<T, String>() {
          @Override public String call(T t) {
            return String.valueOf(t);
          }
        });
      }
    };

  }

}

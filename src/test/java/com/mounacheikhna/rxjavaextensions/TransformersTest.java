package com.mounacheikhna.rxjavaextensions;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import rx.Observable;
import rx.observers.TestSubscriber;

import static com.mounacheikhna.rxjavaextensions.Transformers.toSet;
import static com.mounacheikhna.rxjavaextensions.Transformers.toStringSeq;

/**
 * Created by cheikhnamouna on 11/11/15.
 */
public class TransformersTest {

  @Test
  public void transformToSet() {
    TestSubscriber<Set<Integer>> subscriber = new TestSubscriber<>();
    Observable.from(new Integer[]{1, 1, 2, 3, 4, 4, 5})
        .compose(toSet())
        .subscribe(subscriber);
    Set<Integer> set = new HashSet<>();
    set.add(1);
    set.add(2);
    set.add(3);
    set.add(4);
    set.add(5);
    subscriber.assertValue(set);
  }

  @Test
  public void transformToString() {
    TestSubscriber<String> subscriber = new TestSubscriber<>();
    Observable.just(2, 3, 55).compose(toStringSeq())
        .subscribe(subscriber);
    subscriber.assertValues("2", "3", "55");
  }

}

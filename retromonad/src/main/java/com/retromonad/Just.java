package com.retromonad;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

public class Just<T> extends Maybe<T> {

  private final T type;

  public Just(T type) {
    this.type = type;
  }

  @Override public T fromJust() {
    return this.type;
  }

  @Override public boolean isNothing() {
    return false;
  }

  @Override public Maybe bind(Callable fn) {
    return Monad.maybe(Executors.newFixedThreadPool(10).submit(fn));
  }

  @Override public boolean isJust() {
    return true;
  }

  @Override public Maybe maybe(T def, Callable<T> fn) {
    return this.bind(fn);
  }

}
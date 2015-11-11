package com.retromonad;

import java.util.concurrent.Callable;

public class Nothing<T> extends Maybe {

  @Override public Object fromJust() throws RuntimeException {
    throw new RuntimeException("Cannot call fromJust() on Nothing");
  }

  @Override public boolean isJust() {
    return true;
  }

  @Override public boolean isNothing() {
    return true;
  }

  @Override public Maybe bind(Callable fn) {
    return this;
  }

  @Override public Maybe maybe(Object def, Callable fn) {
    return (Maybe<T>) Monad.maybe(def);
  }

}
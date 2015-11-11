package com.retromonad;

import java.util.concurrent.Callable;

public abstract class Maybe<T> {
  public abstract T fromJust();
  public abstract boolean isJust();
  public abstract boolean isNothing();
  public abstract Maybe<T> bind(Callable<T> runnable);
  public abstract Maybe<T> maybe(T def, Callable<T> fn);
}
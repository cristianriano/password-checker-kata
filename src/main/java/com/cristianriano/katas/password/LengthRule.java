package com.cristianriano.katas.password;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
class LengthRule implements Rule {

  private final int maxSize;

  LengthRule(final int maxSize) {
    this.maxSize = maxSize;
  }

  @Override
  public boolean isValid(final String password) {
    return password.length() >= maxSize;
  }
}

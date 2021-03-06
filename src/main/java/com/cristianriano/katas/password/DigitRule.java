package com.cristianriano.katas.password;

import java.util.regex.Pattern;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class DigitRule implements Rule {
  private static final Pattern DIGIT = Pattern.compile("[0-9]");

  @Override
  public boolean isValid(final String password) {
    return DIGIT.matcher(password).find();
  }

  @Override
  public String getErrorMessage() {
    return "The passwords requires at least 1 digit";
  }
}

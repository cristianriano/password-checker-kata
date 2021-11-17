package com.cristianriano.katas.password;

import java.util.regex.Pattern;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class LetterRule implements Rule {
  private static final Pattern LETTERS = Pattern.compile("[a-zA-Z]");

  @Override
  public boolean isValid(final String password) {
    return LETTERS.matcher(password).find();
  }

  @Override
  public String getErrorMessage() {
    return "The passwords requires at least 1 letter";
  }
}

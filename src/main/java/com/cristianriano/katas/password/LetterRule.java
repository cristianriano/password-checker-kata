package com.cristianriano.katas.password;

import java.util.regex.Pattern;

public class LetterRule implements Rule {
  private static final Pattern LETTERS = Pattern.compile("[a-zA-Z]");

  @Override
  public boolean isValid(final String password) {
    return LETTERS.matcher(password).matches();
  }
}

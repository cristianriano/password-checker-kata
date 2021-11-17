package com.cristianriano.katas.password;

import java.util.regex.Pattern;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class SpecialCharRule implements Rule {

  private static final Pattern SPECIAL_CHAR_PATTERN = Pattern.compile("[^a-zA-Z0-9]");

  @Override
  public boolean isValid(final String password) {
    return SPECIAL_CHAR_PATTERN.matcher(password).find();
  }

  @Override
  public String getErrorMessage() {
    return "The passwords requires at least 1 special character";
  }
}

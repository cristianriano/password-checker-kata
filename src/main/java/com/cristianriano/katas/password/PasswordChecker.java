package com.cristianriano.katas.password;

import java.util.List;

public class PasswordChecker {
  private final List<Rule> rules;

  private static final PasswordChecker INSTANCE = new PasswordChecker();

  public static PasswordChecker getInstance() {
    return INSTANCE;
  }

  PasswordChecker(List<Rule> rules) {
    this.rules = rules;
  }

  PasswordChecker() {
    this.rules = List.of(
        new LengthRule(7)
    );
  }

  public boolean check(final String password) {
    for(Rule r : rules) {
      if(!r.isValid(password)) {
        return false;
      }
    }
    return true;
  }
}

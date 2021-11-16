package com.cristianriano.katas.password;

import java.util.Arrays;
import java.util.List;

public class PasswordChecker {
  private final List<Rule> rules;

  private static final PasswordChecker INSTANCE = new PasswordChecker();

  public static PasswordChecker getInstance() {
    return INSTANCE;
  }

  PasswordChecker(final Rule... rules) {
    this.rules = Arrays.asList(rules);
  }

  PasswordChecker() {
    this(
        new LengthRule(7),
        new LetterRule(),
        new DigitRule()
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

  List<Rule> getRules() {
    return rules;
  }
}

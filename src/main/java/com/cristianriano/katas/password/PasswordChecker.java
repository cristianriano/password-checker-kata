package com.cristianriano.katas.password;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PasswordChecker {
  private final List<Rule> rules;

  private static final PasswordChecker DEFAULT_CHECKER = new PasswordChecker(
      new LengthRule(7),
      new LetterRule(),
      new DigitRule()
  );

  private static final PasswordChecker ADMIN_CHECKER = new PasswordChecker(
      new LengthRule(10),
      new SpecialCharRule()
  );

  public static PasswordChecker getDefault() {
    return DEFAULT_CHECKER;
  }

  public static PasswordChecker getAdminChecker() {
    return ADMIN_CHECKER;
  }

  PasswordChecker(final Rule... rules) {
    this.rules = Arrays.asList(rules);
  }

  public boolean check(final String password) {
    return rules.stream()
        .allMatch(r -> r.isValid(password));
  }

  public List<String> getInvalidReasons(final String password) {
    return rules.stream()
        .filter(r -> !r.isValid(password))
        .map(Rule::getErrorMessage)
        .collect(Collectors.toUnmodifiableList());
  }

  List<Rule> getRules() {
    return rules;
  }
}

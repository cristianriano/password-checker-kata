package com.cristianriano.katas.password;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PasswordCheckerTest {

  @ParameterizedTest
  @ValueSource(strings = {"any", "", "123456", " "})
  void check_lengthRule(String password) {
    var passwordChecker = new PasswordChecker(new LengthRule(7));
    assertThat(passwordChecker.check(password)).isFalse();
  }

  @ParameterizedTest
  @ValueSource(strings = {"", " ", "123", "!@#"})
  void check_letterRule(String password) {
    var passwordChecker = new PasswordChecker(new LetterRule());
    assertThat(passwordChecker.check(password)).isFalse();
  }

  @ParameterizedTest
  @ValueSource(strings = {"", " ", "abc", "!@#"})
  void check_digitRule(String password) {
    var passwordChecker = new PasswordChecker(new DigitRule());
    assertThat(passwordChecker.check(password)).isFalse();
  }

  @Test
  void check_validPassword() {
    var passwordChecker = PasswordChecker.getInstance();
    assertThat(passwordChecker.check("a234567")).isTrue();
  }

  @Test
  void passwordChecker_hasDefaultRules() {
    var rules = PasswordChecker.getInstance().getRules();
    assertThat(rules).containsOnly(new DigitRule(), new LetterRule(), new LengthRule(7));
  }
}
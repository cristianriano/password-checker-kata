package com.cristianriano.katas.password;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PasswordCheckerTest {

  @ParameterizedTest
  @ValueSource(strings = {"any", "", "123456", " "})
  void check_lengthRule(String password) {
    var passwordChecker = new PasswordChecker(new LengthRule(7));
    assertFalse(passwordChecker.check(password));
  }

  @ParameterizedTest
  @ValueSource(strings = {"", " ", "123", "!@#"})
  void check_letterRule(String password) {
    var passwordChecker = new PasswordChecker(new LetterRule());
    assertFalse(passwordChecker.check(password));
  }

  @ParameterizedTest
  @ValueSource(strings = {"", " ", "abc", "!@#"})
  void check_digitRule(String password) {
    var passwordChecker = new PasswordChecker(new DigitRule());
    assertFalse(passwordChecker.check(password));
  }

  @Test
  void check_validPassword() {
    var passwordChecker = PasswordChecker.getInstance();
    assertTrue(passwordChecker.check("a234567"));
  }
}
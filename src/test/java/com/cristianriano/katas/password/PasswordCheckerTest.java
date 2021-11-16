package com.cristianriano.katas.password;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PasswordCheckerTest {

  @Test
  void check_lengthRule() {
    var passwordChecker = new PasswordChecker(new LengthRule(7));
    assertFalse(passwordChecker.check("any"));
  }

  @Test
  void check_letterRule() {
    var passwordChecker = new PasswordChecker(new LetterRule());
    assertFalse(passwordChecker.check("123"));
  }

  @Test
  void check_digitRule() {
    var passwordChecker = new PasswordChecker(new DigitRule());
    assertFalse(passwordChecker.check("abc"));
  }

  @Test
  void check_validPassword() {
    var passwordChecker = PasswordChecker.getInstance();
    assertTrue(passwordChecker.check("a234567"));
  }
}
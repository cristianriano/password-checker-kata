package com.cristianriano.katas.password;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PasswordCheckerTest {
  private final PasswordChecker passwordChecker = new PasswordChecker();

  @Test
  void check_whenLessThan7_shouldReturnFalse() {
    assertEquals(passwordChecker.check("any"), false);
  }

  void check_whenNoLetters_shouldReturnFalse() {
    assertEquals(passwordChecker.check("123"), false);
  }

  void check_whenValidPassword_shouldReturnTrue() {
    assertEquals(passwordChecker.check("a23456"), true);
  }
}
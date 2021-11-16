package com.cristianriano.katas.password;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PasswordCheckerTest {
  private final PasswordChecker passwordChecker = new PasswordChecker();

  @Test
  void check_whenLessThan7_shouldReturnFalse() {
    assertEquals(passwordChecker.check("any"), false);
  }

  @Test
  void check_whenNoLetters_shouldReturnFalse() {
    assertEquals(passwordChecker.check("123"), false);
  }

  @Test
  void check_whenValidPassword_shouldReturnTrue() {
    assertEquals(passwordChecker.check("a234567"), true);
  }
}
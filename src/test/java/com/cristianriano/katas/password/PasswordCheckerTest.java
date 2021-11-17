package com.cristianriano.katas.password;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class PasswordCheckerTest {

  @ParameterizedTest
  @MethodSource
  void check_lengthRule(String password, boolean isValid) {
    var passwordChecker = new PasswordChecker(new LengthRule(7));
    assertThat(passwordChecker.check(password)).isEqualTo(isValid);
  }

  private static Stream<Arguments> check_lengthRule() {
    return Stream.of(
        Arguments.of("", false),
        Arguments.of("123456", false),
        Arguments.of("abc", false),
        Arguments.of("1234567", true),
        Arguments.of("abcdefg", true)
    );
  }

  @ParameterizedTest
  @MethodSource
  void check_letterRule(String password, boolean isValid) {
    var passwordChecker = new PasswordChecker(new LetterRule());
    assertThat(passwordChecker.check(password)).isEqualTo(isValid);
  }

  private static Stream<Arguments> check_letterRule() {
    return Stream.of(
        Arguments.of("", false),
        Arguments.of("!@# ", false),
        Arguments.of("123", false),
        Arguments.of("a", true),
        Arguments.of("12a", true)
    );
  }

  @ParameterizedTest
  @MethodSource
  void check_digitRule(String password, boolean isValid) {
    var passwordChecker = new PasswordChecker(new DigitRule());
    assertThat(passwordChecker.check(password)).isEqualTo(isValid);
  }

  private static Stream<Arguments> check_digitRule() {
    return Stream.of(
        Arguments.of("", false),
        Arguments.of("!@# ", false),
        Arguments.of("abc", false),
        Arguments.of("1", true),
        Arguments.of("ab3", true)
    );
  }

  @ParameterizedTest
  @ValueSource(strings = {"a234567", "!@ []a1", "p@ssw0rd"})
  void check_validPassword(String password) {
    var passwordChecker = PasswordChecker.getInstance();
    assertThat(passwordChecker.check(password)).isTrue();
  }

  @Test
  void passwordChecker_hasDefaultRules() {
    var rules = PasswordChecker.getInstance().getRules();
    assertThat(rules).containsOnly(new DigitRule(), new LetterRule(), new LengthRule(7));
  }
}
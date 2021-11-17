package com.cristianriano.katas.password;

interface Rule {
  String ERROR_MESSAGE = "Invalid password";

  boolean isValid(final String password);

  default String getErrorMessage() {
    return ERROR_MESSAGE;
  }
}

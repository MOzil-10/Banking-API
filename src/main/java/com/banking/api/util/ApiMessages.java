package com.banking.api.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ApiMessages {

    ACCOUNT_NOT_FOUND("Account does not exist"),
    AMOUNT_EXCEED_100_100_ERROR("Amount cannot be greater than R100,000"),
    AMOUNT_NOT_MULTIPLE_OF_100_ERROR("Amount must be greater than 100"),
    BALANCE_INSUFFICIENT_ERROR("Insufficient balance"),
    CASH_DEPOSIT_SUCCESS("{\"msg\": \"Cash deposited successfully\"}"),
    CASH_TRANSFER_SAME_ACCOUNT_ERROR("Source account and target account cannot be the same"),
    CASH_TRANSFER_SUCCESS("{\"msg\": \"Cash transferred successfully\"}"),
    CASH_WITHDRAWAL_SUCCESS("{\"msg\": \"Cash withdrawn successfully\"}"),
    IDENTIFIER_MISSING_ERROR("Missing identifier"),
    INVALID_AMOUNT_ERROR("Invalid amount"),
    PASSWORD_CONTAINS_WHITESPACE_ERROR("Password cannot contain any whitespace characters"),
    PASSWORD_EMPTY_ERROR("Password cannot be empty"),
    PASSWORD_INVALID_ERROR("Invalid password"),
    PASSWORD_REQUIREMENTS_ERROR("Password must contain at least %s"),
    PASSWORD_RESET_FAILURE("Failed to reset password"),
    PASSWORD_RESET_SUCCESS("{\"message\": \"Password reset successfully\"}"),
    PASSWORD_RESET_TOKEN_ISSUED("{\"passwordResetToken\": \"%s\"}"),
    PASSWORD_TOO_LONG_ERROR("Password must be less than 128 characters long"),
    PASSWORD_TOO_SHORT_ERROR("Password must be at least 8 characters long"),
    PIN_ALREADY_EXISTS("PIN already created"),
    PIN_CREATED("PIN has been created for this account"),
    PIN_CREATION_SUCCESS("{\"hasPIN\": true, \"msg\": \"PIN created successfully\"}"),
    PIN_EMPTY_ERROR("PIN cannot be empty"),
    PIN_FORMAT_INVALID_ERROR("PIN must be 4 digits"),
    PIN_INVALID_ERROR("Invalid PIN"),
    PIN_NOT_CREATED("PIN has not been created for this account"),
    PIN_UPDATE_SUCCESS("{\"hasPIN\": false, \"msg\": \"PIN updated successfully\"}"),
    NEGATIVE_AMOUNT("Amount must be greater than 0"),
    USER_NOT_FOUND_BY_ACCOUNT("User not found for the provided account number: %s"),
    USER_NOT_FOUND_BY_EMAIL("User with provided email does not exist"),
    USER_NOT_FOUND_BY_IDENTIFIER("User not found for the given identifier: %s"),
    USER_PHONE_NUMBER_ALREADY_EXIST_ERROR("Phone number already exists"),
    USER_PHONE_NUMBER_EMPTY_ERROR("Phone number cannot be empty"),
    USER_PHONE_NUMBER_INVALID_ERROR("Invalid phone number: %s for country code: %s"),
    USER_REGISTRATION_SUCCESS("User registered successfully"),
    USER_UPDATE_SUCCESS("User updated successfully");

    private final String message;

}

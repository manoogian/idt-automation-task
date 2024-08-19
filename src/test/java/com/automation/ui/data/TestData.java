package com.automation.ui.data;

import java.time.LocalDate;
import java.time.Month;

import static com.automation.ui.pages.SignUpPage.Title;

public class TestData {

    public static class CardData {

        public static final String CARD_NUMBER = "1234123412341234";
        public static final String CARD_CVC = "123";
        public static final String CARD_EXPIRATION_MONTH = "02";
        public static final String CARD_EXPIRATION_YEAR = "2025";
    }

    public static class UserSignUpData {

        public static final String SIGNUP_NAME = "TestName";
        public static final String SIGNUP_EMAIL = "test@test.com";
        public static final String SIGNUP_PASSWORD = "TestPassword";
        public static final Title USER_TITLE = Title.Mr;
        public static final LocalDate USER_BIRTH_DATE = LocalDate.of(1997, Month.JULY, 7);
        public static final String USER_FIRSTNAME = "TestFirstName";
        public static final String USER_LASTNAME = "TestLastName";
        public static final String COMPANY = "TestCompanyName";
        public static final String ADDRESS_1 = "TestAddress";
        public static final String ADDRESS_2 = "TestAddress2";
        public static final String COUNTRY = "Canada";
        public static final String CITY = "TestCity";
        public static final String STATE = "TestState";
        public static final String ZIP = "TestZip";
        public static final String MOBILE_NUMBER = "TestMobileNumber";

    }
}

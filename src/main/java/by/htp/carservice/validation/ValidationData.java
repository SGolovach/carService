package by.htp.carservice.validation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationData {
    private static Logger logger = LogManager.getLogger();
    private static final String REGEX_LOGIN = "([\\w]{4,15})";
    private static final int MIN_LOGIN = 4;
    private static final int MAX_LOGIN = 15;
    private static final String REGEX_PASSWORD = "([\\w]{8,15})";
    private static final int MIN_PASSWORD = 8;
    private static final int MAX_PASSWORD = 15;
    private static final String REGEX_EMAIL = "(\\w+)@(\\w+\\.)([a-z]{2,4})";
    private static final int MIN_EMAIL = 6;
    private static final int MAX_EMAIL = 50;
    private static final String REGEX_NAME = "([\\w\\W]{3,15})";
    private static final int MIN_NAME = 3;
    private static final int MAX_NAME = 15;
    private static final String REGEX_PHONE = "[\\d]{7,11}";
    private static final int MIN_PHONE = 7;
    private static final int MAX_PHONE = 11;
    private static final String REGEX_YEAR_CAR = "[\\d]{2,4}";
    private static final int MIN_YEAR_CAR = 2;
    private static final int MAX_YEAR_CAR = 4;
    private static final String REGEX_CODE_VIN = "[\\w]{17}";
    private static final int MIN_CODE_VIN = 17;
    private static final int MAX_CODE_VIN = 17;
    private static final String REGEX_DESCRIPTION = "[\\w\\W\\s]{1,90}";
    private static final int MIN_DESCRIPTION = 1;
    private static final int MAX_DESCRIPTION = 90;


    private boolean parserData(String expression, String regex) {
        boolean result;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(expression);
        result = matcher.matches();
        return result;
    }

    private boolean checkLenghtExpression(String expression, int min, int max) {
        boolean result;
        int lenghtExp = expression.length();
        if (lenghtExp >= min && lenghtExp <= max) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public boolean validateLogin(String expression) {
        boolean result;
        boolean flagCheckLenght = checkLenghtExpression(expression, MIN_LOGIN, MAX_LOGIN);
        if (flagCheckLenght) {
            result = parserData(expression, REGEX_LOGIN);
        } else {
            result = false;
        }
        return result;
    }

    public boolean validatePassword(String expression) {
        boolean result;
        boolean flagCheckLenght = checkLenghtExpression(expression, MIN_PASSWORD, MAX_PASSWORD);
        if (flagCheckLenght) {
            result = parserData(expression, REGEX_PASSWORD);
        } else {
            result = false;
        }
        return result;
    }

    public boolean validateName(String expression) {
        boolean result;
        boolean flagCheckLenght = checkLenghtExpression(expression, MIN_NAME, MAX_NAME);
        if (flagCheckLenght) {
            result = parserData(expression, REGEX_NAME);
        } else {
            result = false;
        }
        return result;
    }

    public boolean validatePhone(String expression) {
        boolean result;
        boolean flagCheckLenght = checkLenghtExpression(expression, MIN_PHONE, MAX_PHONE);
        if (flagCheckLenght) {
            result = parserData(expression, REGEX_PHONE);
        } else {
            result = false;
        }
        return result;
    }

    public boolean validateEmail(String expression) {
        boolean result;
        boolean flagCheckLenght = checkLenghtExpression(expression, MIN_EMAIL, MAX_EMAIL);
        if (flagCheckLenght) {
            result = parserData(expression, REGEX_EMAIL);
        } else {
            result = false;
        }
        return result;
    }

    public boolean validateBrand(String expression) {
        boolean result;
        boolean flagCheckLenght = checkLenghtExpression(expression, MIN_NAME, MAX_NAME);
        if (flagCheckLenght) {
            result = parserData(expression, REGEX_NAME);
        } else {
            result = false;
        }
        return result;
    }

    public boolean validateModel(String expression) {
        return validateBrand(expression);
    }

    public boolean validateYear(String expression) {
        boolean result;
        boolean flagCheckLenght = checkLenghtExpression(expression, MIN_YEAR_CAR, MAX_YEAR_CAR);
        if (flagCheckLenght) {
            result = parserData(expression, REGEX_YEAR_CAR);
        } else {
            result = false;
        }
        return result;
    }

    public boolean validateCodeVin(String expression) {
        boolean result;
        boolean flagCheckLenght = checkLenghtExpression(expression, MIN_CODE_VIN, MAX_CODE_VIN);
        if (flagCheckLenght) {
            result = parserData(expression, REGEX_CODE_VIN);
        } else {
            result = false;
        }
        return result;
    }

    public boolean validateFuel(String expression) {
        return validateBrand(expression);
    }

    public boolean validateDescription(String expression) {
        boolean result;
        boolean flagCheckLenght = checkLenghtExpression(expression, MIN_DESCRIPTION, MAX_DESCRIPTION);
        if (flagCheckLenght) {
            result = parserData(expression, REGEX_DESCRIPTION);
        } else {
            result = false;
        }
        return result;
    }


}

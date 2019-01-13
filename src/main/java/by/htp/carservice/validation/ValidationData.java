package by.htp.carservice.validation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The Class ValidationData.
 */
public class ValidationData {

    /**
     * The logger.
     */
    private static Logger logger = LogManager.getLogger();

    /**
     * The Constant REGEX_LOGIN.
     */
    private static final String REGEX_LOGIN = "([\\w]{4,15})";

    /**
     * The Constant MIN_LOGIN.
     */
    private static final int MIN_LOGIN = 4;

    /**
     * The Constant MAX_LOGIN.
     */
    private static final int MAX_LOGIN = 15;

    /**
     * The Constant REGEX_PASSWORD.
     */
    private static final String REGEX_PASSWORD = "([\\w]{8,15})";

    /**
     * The Constant MIN_PASSWORD.
     */
    private static final int MIN_PASSWORD = 8;

    /**
     * The Constant MAX_PASSWORD.
     */
    private static final int MAX_PASSWORD = 15;

    /**
     * The Constant REGEX_EMAIL.
     */
    private static final String REGEX_EMAIL = "(\\w+)@(\\w+\\.)([a-z]{2,4})";

    /**
     * The Constant MIN_EMAIL.
     */
    private static final int MIN_EMAIL = 6;

    /**
     * The Constant MAX_EMAIL.
     */
    private static final int MAX_EMAIL = 50;

    /**
     * The Constant REGEX_NAME.
     */
    private static final String REGEX_NAME = "([\\w\\W]{2,15})";

    /**
     * The Constant MIN_NAME.
     */
    private static final int MIN_NAME = 2;

    /**
     * The Constant MAX_NAME.
     */
    private static final int MAX_NAME = 15;

    /**
     * The Constant REGEX_COST.
     */
    private static final String REGEX_COST = "([\\d]{1,6}.[\\d]{1,2})";

    /**
     * The Constant MIN_COST.
     */
    private static final int MIN_COST = 3;

    /**
     * The Constant MAX_COST.
     */
    private static final int MAX_COST = 9;

    /**
     * The Constant REGEX_NUMBER_INVOICE.
     */
    private static final String REGEX_NUMBER_INVOICE = "[\\d]{1,4}";

    /**
     * The Constant MIN_NUMBER_INVOICE.
     */
    private static final int MIN_NUMBER_INVOICE = 1;

    /**
     * The Constant MAX_NUMBER_INVOICE.
     */
    private static final int MAX_NUMBER_INVOICE = 4;

    /**
     * The Constant REGEX_PHONE.
     */
    private static final String REGEX_PHONE = "[\\d]{7,11}";

    /**
     * The Constant MIN_PHONE.
     */
    private static final int MIN_PHONE = 7;

    /**
     * The Constant MAX_PHONE.
     */
    private static final int MAX_PHONE = 11;

    /**
     * The Constant REGEX_YEAR_CAR.
     */
    private static final String REGEX_YEAR_CAR = "[\\d]{2,4}";

    /**
     * The Constant MIN_YEAR_CAR.
     */
    private static final int MIN_YEAR_CAR = 2;

    /**
     * The Constant MAX_YEAR_CAR.
     */
    private static final int MAX_YEAR_CAR = 4;

    /**
     * The Constant REGEX_CODE_VIN.
     */
    private static final String REGEX_CODE_VIN = "[\\w]{17}";

    /**
     * The Constant MIN_CODE_VIN.
     */
    private static final int MIN_CODE_VIN = 17;

    /**
     * The Constant MAX_CODE_VIN.
     */
    private static final int MAX_CODE_VIN = 17;

    /**
     * The Constant REGEX_DESCRIPTION.
     */
    private static final String REGEX_DESCRIPTION = "[\\w\\W\\s]{1,90}";

    /**
     * The Constant MIN_DESCRIPTION.
     */
    private static final int MIN_DESCRIPTION = 1;

    /**
     * The Constant MAX_DESCRIPTION.
     */
    private static final int MAX_DESCRIPTION = 90;


    /**
     * Parser data.
     *
     * @param expression the expression
     * @param regex      the regex
     * @return true, if successful
     */
    private boolean parserData(String expression, String regex) {
        boolean result;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(expression);
        result = matcher.matches();
        return result;
    }

    /**
     * Check lenght expression.
     *
     * @param expression the expression
     * @param min        the min
     * @param max        the max
     * @return true, if successful
     */
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

    /**
     * Validate login.
     *
     * @param expression the expression
     * @return true, if successful
     */
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

    /**
     * Validate password.
     *
     * @param expression the expression
     * @return true, if successful
     */
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

    /**
     * Validate name.
     *
     * @param expression the expression
     * @return true, if successful
     */
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

    /**
     * Validate phone.
     *
     * @param expression the expression
     * @return true, if successful
     */
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

    /**
     * Validate email.
     *
     * @param expression the expression
     * @return true, if successful
     */
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

    /**
     * Validate brand.
     *
     * @param expression the expression
     * @return true, if successful
     */
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

    /**
     * Validate model.
     *
     * @param expression the expression
     * @return true, if successful
     */
    public boolean validateModel(String expression) {
        return validateBrand(expression);
    }

    /**
     * Validate year.
     *
     * @param expression the expression
     * @return true, if successful
     */
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

    /**
     * Validate code vin.
     *
     * @param expression the expression
     * @return true, if successful
     */
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

    /**
     * Validate fuel.
     *
     * @param expression the expression
     * @return true, if successful
     */
    public boolean validateFuel(String expression) {
        return validateBrand(expression);
    }

    /**
     * Validate description.
     *
     * @param expression the expression
     * @return true, if successful
     */
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

    /**
     * Validate cost.
     *
     * @param expression the expression
     * @return true, if successful
     */
    public boolean validateCost(String expression) {
        boolean result;
        boolean flagCheckLenght = checkLenghtExpression(expression, MIN_COST, MAX_COST);
        if (flagCheckLenght) {
            result = parserData(expression, REGEX_COST);
        } else {
            result = false;
        }
        return result;
    }

    /**
     * Validate NumberInvoice.
     *
     * @param expression the expression
     * @return true, if successful
     */
    public boolean validateNumberInvoice(String expression) {
        boolean result;
        boolean flagCheckLenght = checkLenghtExpression(expression, MIN_NUMBER_INVOICE, MAX_NUMBER_INVOICE);
        if (flagCheckLenght) {
            result = parserData(expression, REGEX_NUMBER_INVOICE);
        } else {
            result = false;
        }
        return result;
    }

}

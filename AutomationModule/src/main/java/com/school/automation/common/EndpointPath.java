package com.school.automation.common;

/**
 * @author jhonny
 */
public interface EndpointPath {
    public static final String STUDENT_PATH = "student";
    public static final String STUDENT_ID_PATH = "student/{id}";
    public static final String LOAN_PATH = "loan";
    public static final String LOAN_AMOUNT_PERIOD_PATH = "loan?amount={amount}&period={period}";
}

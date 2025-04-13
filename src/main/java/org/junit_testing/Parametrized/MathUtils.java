package org.junit_testing.Parametrized;

public class MathUtils {

    public boolean isEven(int number) {
        int evenNumber = number % 2;
        if (evenNumber == 0) {
            return true;
        } else {
            return false;
        }

    }

    public Integer factorial(int number) {
        int Result = 1;
        for (int i = 0; i <= number; i++) {
            Result = Result * i;
        }
        return Result;
    }

    public boolean isWeekDay(Days days) {
        if ((days != (Days.SUNDAY)) && (days != (Days.SATURDAY))) {
            return true;
        } else {
            return false;
        }

    }


}

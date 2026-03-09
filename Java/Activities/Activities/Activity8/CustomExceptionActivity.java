package Activities.Activity8;

public class CustomExceptionActivity {
    public static void exceptionTest(String str) throws CustomException {

        if (str == null) {
            throw new CustomException("String value is null");
        }

        System.out.println(str);
    }

    public static void main(String[] args) {

        try {

            CustomExceptionActivity.exceptionTest("Will print to console");

            CustomExceptionActivity.exceptionTest(null);

        } catch (CustomException e) {

            System.out.println("Custom Exception Caught: " + e.getMessage());

        }
    }
}

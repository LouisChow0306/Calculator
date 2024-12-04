package Calculator;

public class Div extends Calc {
    private String errorMsg = null;

    @Override
    public int calculate() {
        try {
            if (b == 0) {
                throw new ArithmeticException("You can't divide by 0!");
            }
            return a / b;
        } catch (ArithmeticException e) {
            errorMsg = e.getMessage();
            System.out.println(errorMsg);
            return 0;
        }
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}


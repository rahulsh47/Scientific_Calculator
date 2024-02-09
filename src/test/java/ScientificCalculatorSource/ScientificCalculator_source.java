package ScientificCalculatorSource;

import static jdk.internal.org.jline.utils.Colors.s;

public class ScientificCalculator_source {

    public double Addition(double num1,double num2){
        return num1 + num2;
    }

    public double Subtraction(double num1,double num2){
        return num1 - num2;
    }

    public double Multiplication(double num1 , double num2){
        return num1 * num2;
    }

    public double Division(double numerator , double denomenator){
       try {
           if(denomenator <= 0){
               throw  new ArithmeticException();
           }
       }catch (ArithmeticException e){
           System.out.println("Division with Number <= 0 is Unidentified");
       }
        return numerator / denomenator;
    }

    public static double invalidAddition(String operand1, String operand2) throws NumberFormatException{
        double op1 = Double.parseDouble(operand1);
        double op2 = Double.parseDouble(operand2);
        return op1 + op2;
    }
    public static double invalidDivision(double n1, double n2) throws ArithmeticException {
        if (n2 == 0){
            throw new ArithmeticException("cannot be divided by zero");
        }
        return n1 / n2 ;
    }

    public double SquareRoot(double num){
        if(num < 0){
            throw  new IllegalArgumentException("Square root of Negative Number is Unidentified in Real Numbers");
        }
        return Math.sqrt(num);
    }

    public double Power(double base , double power){
        return Math.pow(base , power);
    }

//    public static double add(String operand1, String operand2) throws NumberFormatException{
//        double op1 = Double.parseDouble(operand1);
//        double op2 = Double.parseDouble(operand2);
//        return op1 + op2;
//    }
//    public static double divide(double n1, double n2) throws ArithmeticException {
//        if (n2 == 0){
//            throw new ArithmeticException("cannot be divided by zero");
//        }
//        return n1 / n2 ;
//    }

    public double SinFunction(double angle){
        return Math.sin(Math.toRadians(angle));
    }

    public double CosFunction(double angle){
        return Math.cos(Math.toRadians(angle));
    }

    public double TanFunction(double angle){
        return Math.tan(Math.toRadians(angle));
    }
}

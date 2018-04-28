import java.util.Arrays;
import java.util.Scanner;

public class Task2 {
    private static float[] readInformation(){

        // Initializing variables
        Scanner scanner = new Scanner(System.in);
        String operat;
        float firstOperand, secondOperand,res = 0;
        int op = 0;


        System.out.println("Enter arithmetic operator (+,-,/,*):");


        // Defining operation
        while(true){
            operat = scanner.next();
            if(operat.equals("+") || operat.equals("-") || operat.equals("/") || operat.equals("*")){
                if (operat.equals("-"))
                    op = 1;
                if (operat.equals("/"))
                    op = 2;
                if (operat.equals("*"))
                    op = 3;
                break;
            }
            System.out.println("The answer was wrong. Please Try again.");
        }

        // Getting operands
        System.out.println("Enter first number:");
        firstOperand = scanner.nextFloat();
        System.out.println("Enter second number:");
        secondOperand = scanner.nextFloat();
        return new float[] {(float) op, firstOperand, secondOperand};
    }

    /**
     *
     * @param op is used for defining operation.
     * @param firstOperand is first operand, which will be used in evaluating.
     * @param secondOperand is second operand, which will be used in evaluating.
     */
    private static void outputResult( int op, float firstOperand, float secondOperand){
        float res = 0;
        // Evaluation of the expression
        if(op == 0)
            res = firstOperand + secondOperand;
        if(op == 1)
            res = firstOperand - secondOperand;
        if(op == 2)
            res = firstOperand * secondOperand;
        if(op == 3)
            res = firstOperand / secondOperand;

        // Output of result
        System.out.printf("Res: %20.4f",res);
    }

    public static void main(String args[]) {

        // Choosing task
        System.out.println("Enter task:");
        int task = -1, number = -1;

        Scanner scanner = new Scanner(System.in);
        while(true) {

            task = scanner.nextInt();
            if (task == 1) {
                float[] mass = readInformation();
                outputResult((int) mass[0], mass[1], mass[2]);
                break;
            }
            else if (task == 2){
                System.out.println("THe biggest string: " + findMaxLengthWord(readInformationForArray()));
                break;
            }
        }
        scanner.close();
    }

    /**
     * method reads array of strings
     * @return mas this array includes got strings
     */
    private static String[] readInformationForArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of words:");
        int number = scanner.nextInt();
        String[] mas = new String[number];
        System.out.println("Enter string;");
        for(int i=0;i<mas.length;i++){
            mas[i] = scanner.next();
        }
        return mas;
    }

    /**
     *
     * @param mas is used for data from which is searched the biggest string.
     * @return the longest string
     */
    private static String findMaxLengthWord(String[] mas){
        int max_i = 0;
        for(int i=1;i<mas.length;i++){
            if (mas[max_i].length() < mas[i].length()){
                max_i = i;
            }
        }
        return mas[max_i];
    }
}

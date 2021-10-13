package advancedcalculator;

import java.util.Scanner;

public class AdvancedCalculator {

    public static double duhast(double t1, char op, double t2) {
        // t1 remains t1 from evaluate, switch by math operation input
        // t2 is the last stored term
        switch (op) {
            case '+':
                t1 = t1 + t2;
                break;
            case '-':
                t1 = t1 - t2;
                break;
            case '*':
                t1 = t1 * t2;
                break;
            case '/':
                t1 = t1 / t2;
                break;
        }

        return t1;
        // returns t1
    }

    public static double evaluate(String expr) {
        String term = "";
        // current value of analyzed number
        double t1 = 0;
        // previous or saved value of term
        char op = '+';
        // last saved operation 
        for (char c : expr.toCharArray()) {
            switch (c) {
                case '+':
                    //            System.out.println("" + t1 + op + term); //debug helper
                    t1 = duhast(t1, op, Double.valueOf(term));
                    // function that makes an operation on previously saved t1
                    // and currently stored term ; returns it in form of 
                    // new t1
                    op = c;
                    // stores the current operation to use in duhast
                    term = "";
                    // "wipes out" old term to make a room for a new one 
                    break;
                case '-':
                    //            System.out.println("" + t1 + op + term); //debug helper
                    t1 = duhast(t1, op, Double.valueOf(term));
                    // function that makes an operation on previously saved t1
                    // and currently stored term ; returns it in form of 
                    // new t1
                    op = c;
                    // stores the current operation to use in duhast
                    term = "";
                    // "wipes out" old term to make a room for a new one 
                    break;
                case '*':
                    //            System.out.println("" + t1 + op + term); //debug helper
                    t1 = duhast(t1, op, Double.valueOf(term));
                    // function that makes an operation on previously saved t1
                    // and currently stored term ; returns it in form of 
                    // new t1
                    op = c;
                    // stores the current operation to use in duhast
                    term = "";
                    // "wipes out" old term to make a room for a new one  
                    break;
                case '/':
                    //            System.out.println("" + t1 + op + term); //debug helper
                    t1 = duhast(t1, op, Double.valueOf(term));
                    // function that makes an operation on previously saved t1
                    // and currently stored term ; returns it in form of 
                    // new t1
                    op = c;
                    // stores the current operation to use in duhast
                    term = "";
                    // "wipes out" old term to make a room for a new one 
                    break;
                case '.':
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    term = term + c;
                // concatenate and save term 
                default:
            }
        }
        //System.out.println("" + t1 + op + term); //debug helper
        t1 = duhast(t1, op, Double.valueOf(term));
        return t1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Please enter the expression");
            System.out.println("'+' is for adding");
            System.out.println("'-' is for subtraction");
            System.out.println("'*' is for multiplication");
            System.out.println("'/' is for devision");
            String input = scanner.nextLine();
            System.out.println("your result is: " + evaluate(input));
            // evaluate is a function that breaks down input expression into 
            // different symbols and does operetions as breakdown progres
            System.out.println("do you want to do more math?");
            if (scanner.nextLine().equalsIgnoreCase("no")) {
                // allows to run multiple tests in one go
                break;
            }

        } while (true);
    }

}
// I do understand that this structure has major flaws, such as:
// Operatiom Order Incencetivity (doesn't do '*', '/' before '+', '-')
// I thought that this can be resolved by making function 'evaluate' somehow switch 
// the notation from infix to prefix or postfix one.
// Maybe new function that woud be a buffer between input and evaluate can do
// the job, but it still will have to parse things somehow.
// Current design cannot transfer an expression 
// which it does not see, since 'evaluate' computes everything step by step.
// Second big flaw is that once you went negative it can't work properly since
// because it can not read -1 as a number parsing it as op(-), term(1).
// I would like to know is there a possible and medium-complexity way 
// to keep working on this design or is it better to leave this one just as is and 
// start working on a new one that will actually parse and generate expression 
// and than process it.

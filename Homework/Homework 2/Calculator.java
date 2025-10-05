// Name: Richard He
// Computing ID: rtk8qj@virginia.edu
// Homework Name: Calculator
// Resources used (if applicable): None

public class Calculator { // 'this' is used in variable assignment to ensure that the assignment occurs to
                          // the variables with each new object that is created
    private int mem1, mem2;
    private String op;

    public Calculator() { // default constructor for calculator
        this.mem1 = 0;
        this.mem2 = 0;
        this.op = " ";
    }

    public Calculator(int op1, int op2, String newOp) { // overloaded constructor for calculator where the user can
                                                        // "give" the calculator certain variables

        this.mem1 = op1;
        this.mem2 = op2;

        if (newOp != null && (newOp == "+") || (newOp == "-") || (newOp == "*") || (newOp == "/") || (newOp == "^")) { // makes
                                                                                                                       // sure
                                                                                                                       // that
                                                                                                                       // the
                                                                                                                       // operator
                                                                                                                       // is
                                                                                                                       // valid
            this.op = newOp;
        } else
            this.op = " ";
    }

    public int getMem1() { // get the value stored in mem1
        return mem1;
    }

    public int getMem2() { // get the value stored in mem2
        return mem2;
    }

    public String getOp() { // get the value stored in op
        return op;
    }

    public void setMem1(int op1) { // sets the value of mem1
        this.mem1 = op1;
    }

    public void setMem2(int op2) { // sets the value of mem2
        this.mem2 = op2;
    }

    public void setOp(String newOp) { // sets the value of op IF it is a valid operator (+,-,/,*,^). otherwise, leave
                                      // op unchanged
        if (newOp.equals("+") || newOp.equals("-") || newOp.equals("/") || newOp.equals("*") || newOp.equals("^")) {
            op = newOp;
        }
    }

    @Override
    public String toString() { // returns a String that allows the user to see the current status of all three
                               // variables
        return mem1 + " " + op + " " + mem2;
    }

    public int perform() { // depending on what op is in string form, do the corresponding operation to
                           // mem1 and mem2 then set the result to mem2. if dividion is conducted, first
                           // check if division by zero and return 0 if true; else, call the performDiv
                           // method

        if (op.equals("+")) {
            mem2 = mem1 + mem2;
        } else if (op.equals("-")) {
            mem2 = mem1 - mem2;
        } else if (op.equals("*")) {
            mem2 = mem1 * mem2;
        } else if (op.equals("/")) {
            if (mem2 == 0) {
                return 0;
            } else {

                mem2 = mem1 / mem2;
            }
        } else if (op.equals("^")) {
            mem2 = (int) (Math.pow(mem1, mem2));
        }

        return mem2;
    }

    public double performDiv() { // divides mem1 by mem2 and sets the result to mem2
        // = mem1 / mem2;
        return mem1 / (double) mem2;
    }

    public void swap() { // uses a temporary variable to swap the values assigned to the two variables
        int temp = 0;
        temp = mem1;
        mem1 = mem2;
        mem2 = temp;

    }

}
// Name: Richard He
// Computing ID: rtk8qj@virginia.edu
// Homework Name: Recursion
// Resources used: None

import java.util.*;

public class Password {
    String curPassword; // instantiates curPassword
    boolean firstTimeAround = true;
    String tempPassword;

    public Password() {
        curPassword = ""; // sets curPassword to default value of nothing
        tempPassword = "";
    }

    public Password(String p) {
        if (p != null && p.length() >= 1 && hasDigit(p)) { // if password is not null and has greater than 1 length and
                                                           // has digits

            if (curPassword == null || !isEqual(p)) { // if there is nothing to compare to or new password is
                                                      // not equal to old
                if (curPassword == null) {
                    this.curPassword = p; // sets curPassword to user assigned
                                          // value p
                    // this.tempPassword = p;
                } else if (curPassword != null) {
                    if (differentEnough(p, curPassword.length() / 2)) { // half of the positions
                        this.curPassword = p; // sets curPassword to user assigned value p
                        // this.tempPassword = p;
                    } else {
                        this.curPassword = "";
                        // this.tempPassword = "";
                    }
                }

            } else {
                this.curPassword = "";
                // this.tempPassword = "";
            }

        } else {
            this.curPassword = "";
        }
        this.tempPassword = this.curPassword;
    }

    private static boolean hasDigit(String p) {
        if (p.length() < 1) { // if password length is less than 0, broken and return false
            return false;
        }
        if (p.charAt(0) >= '0' && p.charAt(0) <= '9') { // if first character in beginning of string is a number (0 to
                                                        // 9) return true
            return true;
        }
        return hasDigit(p.substring(1)); // recursively cuts off first value of string (kind of like incrementing
                                         // forwards)
    }

    private boolean isEqual(String p) {
        if (p.length() < 1) { // same edge case but now this means if we searched all of p and everything is
                              // the same its good so return true
            return true;
        }

        if (firstTimeAround == true) {
            // firstTimeAround = false;
            if (Math.abs(p.length() - curPassword.length()) > 0) { // if the length is already

                // different, return false
                // System.out.println("curP: " + curPassword);
                // System.out.println("P: " + p);
                // System.out.println("FIRST TIME AROUND IS TRUE");
                // System.out.println("p length is: " + p.length());
                // System.out.println("curPassword length is: " + curPassword.length());
                // System.out.println("broke into here");
                return false;
            }
        }
        if (p.charAt(0) != curPassword.charAt(curPassword.length() - p.length())) { // if the char at the beginning of p
                                                                                    // is not the same as what's at
            // the beginning of curPassword they are not equal, return false
            // how to increment

            return false;
        }
        // System.out.println("AABAAA");
        return isEqual(p.substring(1, p.length())); // same recursion cutting off first value of string
    }

    private int numDifferentPlaces(String p) { // start the number at the abs value of the two lengths minus each other
                                               // then iterate through the smaller one
        int tempAdd = 0;

        if (p == null || p.length() < 1) { // if traversed entire string and no differences found, return 0
            // System.out.println("FINISHED UP");
            // firstTimeAround = true; // resets firstTimeAround
            return 0;
        }
        // if (Math.abs(p.length() - curPassword.length()) > 0) { // check if iteration
        // hit the end of either password

        // }

        if (firstTimeAround == true) {
            // CASE 1: new password is INITIALLY longer than current password
            if (p.length() - tempPassword.length() > 0) {

                tempAdd = p.length() - tempPassword.length();

                p = p.substring(0, tempPassword.length()); // cut p

            }
            // CASE 2: new password is INITIALLY shorter than current password
            else if (p.length() - tempPassword.length() < 0) { // issue here is editing curPassword

                tempAdd = tempPassword.length() - p.length();
                tempPassword = tempPassword.substring(0, p.length()); // cut current password
            }
        }
        // after all passwords have been cut to the same length

        // System.out.println("---------------------------");

        if ((firstTimeAround == true) || p.charAt(0) != tempPassword.charAt(tempPassword.length() - p.length())) {
            // {
            if (firstTimeAround == true) { // if it's the first time around edit the longer string and add the cut
                                           // length to numDiffPlaces
                firstTimeAround = false;
                return tempAdd + numDifferentPlaces(p.substring(1, p.length()));
            } else
                return 1 + numDifferentPlaces(p.substring(1, p.length()));
        }
        // }
        return numDifferentPlaces(p.substring(1, p.length())); // p length might be bigger than curPassword
    }

    private boolean differentEnough(String p, int i) {
        // System.out.println("NUM DIFF: " + this.numDifferentPlaces(p));
        // System.out.println("I: " + i);
        // System.out.println("NUM DIFF: " + this.numDifferentPlaces(p)); // error is
        // here
        // System.out.println("NUM DIFF: " + this.numDifferentPlaces(p));
        if (this.numDifferentPlaces(p) >= i) {
            // System.out.println("AAAAAAA");

            return true;
        }
        return false;
    }

    public boolean setPassword(String p) {
        if (p == null) {

            return false;
        }
        if (p.length() < 1) {

            return false;
        }

        tempPassword = curPassword;
        firstTimeAround = true;

        if (hasDigit(p)) {

            // System.out.println("has a digit");
            if (!isEqual(p)) {

                if (differentEnough(p, curPassword.length() / 2)) { // half of the positions

                    curPassword = p;
                    tempPassword = p;
                    return true;
                }
            }
        }

        return false;
    }

    public boolean equals(Object o) {
        if (o instanceof Password) { // cast to password
            return curPassword.equals(((Password) o).curPassword);
        }
        return false;
    }

    public String getPassword() {
        return curPassword;
    }

    public String getTempPassword() {
        return tempPassword;
    }

    public String toString() { // .repeat random number between 1 and 20 "*"s using math.random
        return curPassword.substring(0, 1) + "*".repeat((int) (Math.random() * 20) + 1)
                + curPassword.substring(curPassword.length() - 1, curPassword.length());
    }

    // public static void main(String args[]) {
    // Password temp = new Password("johncena25");

    // // // 1. Normal change, enough differences
    // // System.out.println(temp.setPassword("1bc456")); // true

    // // // 2. Shorter password, fewer differences
    // // System.out.println(temp.setPassword("1")); // might crash without reset

    // // // 3. Longer password
    // // System.out.println(temp.setPassword("abcdef123456")); // true

    // // // 4. Single-char password, completely different
    // // System.out.println(temp.setPassword("z")); // might crash if tempPassword
    // // indexing fails

    // // // 5. Edge case: empty string
    // // System.out.println(temp.setPassword("")); // false

    // // 6. Exactly half differences
    // // temp = new Password("1bcdefgh");
    // // System.out.println(temp.setPassword("1bcdZZZZ")); // true (4 differences,
    // // half of 8)

    // // // 7. All same
    // // System.out.println(temp.setPassword("abcdZZZZ")); // false
    // }
}
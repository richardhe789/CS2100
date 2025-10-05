public class LabTwo {

    public static int findLongest(String[] strArr) {
        int longestIndex = 0;
        int longest = 0;
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].length() > longest) {
                longestIndex = i;
                longest = strArr[i].length();
            }

        }
        return longestIndex;
    }

    public static int countSubstring(String[] strArr, String choice) {
        int counts = 0;
        for (int i = 0; i < strArr.length; i++) {
            while (strArr[i].contains(choice)) {

                int occurance = 0;
                strArr[i] = strArr[i].substring(occurance, strArr[i].indexOf(choice))
                        + strArr[i].substring(strArr[i].indexOf(choice) + choice.length(), strArr[i].length());// strArr[i].substring(strArr[i].indexOf(choice2),
                occurance = strArr[i].indexOf(choice) + choice.length();
                counts++;
            }
        }
        return counts;
    }

    public static void removeSubstring(String[] strArr, String choice2) {
        // String[] tempArray = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].contains(choice2)) {
                while (strArr[i].contains(choice2)) {
                    int occurance = 0;
                    strArr[i] = strArr[i].substring(occurance, strArr[i].indexOf(choice2))
                            + strArr[i].substring(strArr[i].indexOf(choice2) + choice2.length(), strArr[i].length());// strArr[i].substring(strArr[i].indexOf(choice2),
                    occurance = strArr[i].indexOf(choice2) + choice2.length();
                }

            }
        }

    }

    public static String[] removeDup(String[] strArr) {
        // boolean hasIt = false;
        String[] tempHold = new String[strArr.length];
        String stringedVersion = "";
        for (int i = 0; i < strArr.length; i++) {
            if (stringedVersion.contains(strArr[i])) {
                continue;
            } else {
                stringedVersion += strArr[i];
                stringedVersion += ",";
            }
        }
        // System.out.println(stringedVersion);
        if (stringedVersion != "") {

            tempHold = stringedVersion.split(",");
        }
        return tempHold;
    }

    public static void main(String args[]) {
        // Normal // String[] temp = { "bob", "jerry", "larryson" }; //3
        // Empty array // String[] temp = {}; // 0
        // Single element // String[] temp = { "joe" }; // 0

        // System.out.println(findLongest(temp));

        // Normal // String[] temp2 = {"bill", "billbob", "joe"} // 2
        // Empty array // String[] temp2 = {} // 0
        // More than one instance // String[] temp2 = { "billbobbill", "billjane",
        // "bill", "tom" };
        // System.out.println(countSubstring(temp2, "bill"));

        // Normal // String[] temp3 = {"harry", "liam", "niall", "zayn"}; // liam,
        // niall, zayn,
        // More than one instance // String[] temp3 = {"harrytomharry", "liam", "niall",
        // "zayn"} // tom, liam, niall, zayn
        // Empty // String[] temp3 = {}; // {}
        // removeSubstring(temp3, "harry");
        // for (int j = 0; j < temp3.length; j++) {
        // System.out.print(temp3[j] + ",");
        // }

        // Normal // String[] temp4 = { "bob", "joe", "bob" }; // joe,
        // Empty // String[] temp4 = {}; //
        // String[] temp5 = removeDup(temp4);
        // for (int k = 0; k < temp5.length; k++) {
        // System.out.print(temp4[k] + ",");
        // }

    }
}

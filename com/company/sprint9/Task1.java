package com.company.sprint9;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Locale;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {
    public static void main(String[] args) {
        String str = "Vasiliy";
        int c = str.indexOf('a', 1);
        System.out.println(c);

        System.out.println(MyUtils.intToRoman(23));
        System.out.println(MyUtils.pigLatinConverter("Pig Latin is simply a form of jargon unrelated to Latin."));

        System.out.println(MyUtils.verifyBrackets("([{(}])[{(])}]{([{])})"));

//        System.out.println(MyUtils.reformatLines("Java    was      originally developed\n" +
//                "   by    James   Gosling at Sun Microsystems (which\n" +
//                " has since been\n" +
//                "acquired by Oracle) and released in 1995\n" +
//                " as a core component of Sun Microsystems' Java platform."));

        System.out.println(MyUtils.differentWords("Java is a programming language that is class-based and designed to have as few implementation dependencies as possible.",
                "Java is a   general-purpose programming   language that is class-based object-oriented and designed to have as few implementation dependencies as possible."));
    }
}

class MyUtils {
    public static String intToRoman(int number) {
        //Можна попробувати з мапом зробити наступні дії  /23
        int[] values = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String[] romans = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };
        StringBuilder res = new StringBuilder();

        for(int i = values.length - 1; i>=0; i--){
            while(number >= values[i]){
                number -= values[i];
                res.append(romans[i]);
            }
        }
        return res.toString();
    }
    public static boolean verifyBrackets(String text) {
        Stack<Character> stack = new Stack<>();
        StringBuilder str = new StringBuilder();
//        ()[]{}   // (())
        for(int i =0; i<text.length(); i++)
            if((text.charAt(i) == '(') || (text.charAt(i) == '[') || (text.charAt(i) == '{' || (text.charAt(i) == ')') || (text.charAt(i) == ']') || (text.charAt(i) == '}')) )
                str.append(text.charAt(i));
//        System.out.println(str);
        for(int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) == '(') || (str.charAt(i) == '[') || (str.charAt(i) == '{'))
                stack.push(str.charAt(i));
            else {
                if (stack.empty()) return false;
                if ((str.charAt(i) == ')') && (stack.peek() != '(')) return false;
                if ((str.charAt(i) == ']') && (stack.peek() != '[')) return false;
                if ((str.charAt(i) == '}') && (stack.peek() != '{')) return false;
                stack.pop();
            }                   // ()
        }
        return stack.empty();
    }
    // [()] // ()[]{} // (())
    //
    public static String pigLatinConverter(String text) {
        String[] words = text.split(" ");

        Pattern pattern = Pattern.compile("[aeiouyAEIOUY]");
        if (text.length() == 0) return "";
        for(int i =0; i< words.length; i++){
            Matcher matcher = pattern.matcher(Character.toString(words[i].toLowerCase().charAt(0)));
            if(matcher.matches())
                words[i] = words[i] + "hay";
            else{
                if (!pattern.matcher(Character.toString(words[i].toLowerCase().charAt(1))).matches() && !pattern.matcher(Character.toString(words[i].toLowerCase().charAt(0))).matches())
                    words[i] = words[i].substring(2) + words[i].substring(0,2) + "ay";
                else {
                    words[i] = words[i].substring(1) + words[i].charAt(0) + "ay";
                }
            }
        }
        String res = String.join(" ", words);
        return res;
    }

    public static String reformatLines(String text) {

//       System.out.println("Java was originally developed by James Gosling at Sun\n" +
//               "Microsystems (which has since been acquired by Oracle) and\n" +
//               "released in 1995 as a core component of Sun Microsystems'\n" +
//               "Java platform");
        System.out.println(text);
        text = text.trim().replaceAll("\\s{2,}", " ");
        return text;

    }

    public static String differentWords(String originalText, String modifyText) {
        String[] original = originalText.split(" ");
        String[] modify = modifyText.split(" ");

//        System.out.println("_______________________________________");
//        System.out.println(Arrays.toString(modify));
//        System.out.println(Arrays.toString(original));
//        System.out.println("_______________________________________");

        for (int i = 0, j = 0; i < original.length; i++, j++) {
            if (!original[i].equals(modify[j])) {
                modify[j] = modify[j].toUpperCase();
                i--;
            }
        }
        String res = "";
        for (int i = 0; i < modify.length; i++)
            res += modify[i] + " ";

        return res;
    }
}



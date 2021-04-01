package com.company.sprint1;

public class Main {
    public static void main(String[] args) {

//        System.out.println(IsPalindrome(121));
//        System.out.println(mySqrt(4));
//        System.out.println(reverse(0));
    }

    static int mySqrt(int x) {
        return (int)Math.sqrt(x*2);
    }

    static int reverse(int x) {
        String reversing = Integer.toString(x);
        String c = reversing.contains("-") ? "-" : "";
        for (int i = reversing.length() - 1; i >= 0; i--) {
            if (reversing.charAt(reversing.length() - 1) != 0)
                c += reversing.charAt(i) == '-' ? "" : reversing.charAt(i);
        }
        return Integer.parseInt(c);
    }

    static boolean IsPalindrome(int x){
        String polindrom = Integer.toString(x);
        String c = "";
        // 1 variant
        //        StringBuffer buffer = new StringBuffer(polindrom);
        //        String c = buffer.reverse().substring(0);

        // 2 variant
        for(int i = polindrom.length()-1; i >= 0; i--)
            c+= polindrom.charAt(i);

        boolean isPalondrome = c.equalsIgnoreCase(polindrom);
        return isPalondrome;
    }
}

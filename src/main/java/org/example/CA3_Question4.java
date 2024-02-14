package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Stack;

/**
 * Name:
 * Class Group:
 */
public class CA3_Question4 {

    /*
        filename: name of the file to test.
     */
    public static boolean validate(String filename) throws FileNotFoundException {
//        File file = new File(filename);
        Scanner sc = new Scanner(new File(filename));
        ArrayDeque<String> stack = new ArrayDeque<>();

        while(sc.hasNext()){
            String tag = sc.next().trim();
//            tag = tag.substring(1, tag.length() - 1);

            if (tag.contains("</")) {
//                String openTag = stack.pollFirst();
                if (stack.isEmpty() || !tag.substring(2).equals(stack.pop().substring(1))) {
                    return false;
                }
            }else if(tag.contains("<")){
                stack.push(tag);
            }
        }
        return stack.isEmpty();
    }

    /*
        This function tests the files in the files array to see if
         they are valid.
         tags_valid.txt should return true;
         tags_invalid.txt should output as invalid;


     */
    public static void main(String[] args) throws FileNotFoundException {
        String[] files = {"src/tags_valid.txt", "src/tags_invalid.txt"};
        for (String fName : files) {
            System.out.print(fName + ": ");
            if (validate(fName)) {
                System.out.println("This file is valid");
            } else {
                System.out.println("This file is invalid");
            }
        }
    }
}


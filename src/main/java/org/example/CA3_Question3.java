package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Name:
 * Class Group:
 */

public class CA3_Question3 {
    public static void readFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner in = new Scanner(file);
        in.useDelimiter("[^A-Za-z0-9_]+");

//        Map<String, ArrayList<Integer>> identifierMap = new HashMap<>();  // Set<Integer>
        Map<String,Set<Integer>> identifierMap = new TreeMap<>();
        int lineNumber = 1;

        while (in.hasNextLine()) {
            String Line = in.nextLine();
            String[] tokens = Line.split("[^A-Za-z0-9_]+"); //"[^A-Za-z0-9_]+" regular Expression
//            String identifier = tokens[0];
            for (String token : tokens) {
                if(token.contains(" ")){
                    identifierMap.clear();
                }
                //case 1 identifier is in Map.
                if (identifierMap.containsKey(token)) {
                    identifierMap.get(token).add(lineNumber);
                } else {
                    //case 2: identifier is not in map
                    Set<Integer> LineNumbersSet = new HashSet<>();
                    LineNumbersSet.add(lineNumber);
                    identifierMap.put(token, LineNumbersSet);
                }
            }
            lineNumber++;
        }
        for (Map.Entry<String, Set<Integer>> entry : identifierMap.entrySet()) {
            String identifier = entry.getKey();
            Set<Integer> lineNumbers = entry.getValue();
            System.out.print("Identifier: " + identifier + ": --> Lines" + lineNumbers );

//                for (int lineNumberEntry : lineNumbers) {
////                    System.out.print("Line:" + lineNumberEntry);
//                    if (lineNumbers.size() > 1) {
//                        System.out.print(",");
//                    }
//                }
            System.out.println();
        }


    }

    public static void main(String[] args) throws FileNotFoundException {
        readFile("CA3_Starter_Code 2/src/CA3_Question1.java");
    }
}


package org.example;

import java.util.LinkedList;
import java.util.*;

/**
 * Name: JianFeng Han
 * Class Group: SD2A
 */

public class CA3_Question5 {

    public static void main(String[] args) {
        Queue<String> TakeOff = new LinkedList<String>();
        Queue<String> Landing = new LinkedList<String>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Enter (takeoff, land (flightSymbol), next, quit):");
            String Input = sc.nextLine();

            if (Input.startsWith("takeoff")) {
                String flightSymbol = Input.substring("takeoff".length());
                takeoff(TakeOff, flightSymbol);
            } else if (Input.startsWith("land")) {
                String flightSymbol = Input.substring("land".length());
                landing(Landing, flightSymbol);
            } else if (Input.equals("next")) {
                Next(TakeOff, Landing);
            } else if (Input.equals("quit")) {
                System.out.println("end");
                break;
            } else {
                System.out.println("Invalid input. Please try again");
            }
        }
        sc.close();
    }

    private static void takeoff(Queue<String> TakeOff, String flightSymbol) {
        TakeOff.add(flightSymbol);
        System.out.println("Plane" + flightSymbol + " added to takeoff queue.");
    }

    private static void landing(Queue<String> Landing, String flightSymbol) {
        Landing.add(flightSymbol);
        System.out.println("Plane" + flightSymbol + " added to landing queue.");
    }

    private static void Next(Queue<String> TakeOff, Queue<String> Landing) {
        if (!Landing.isEmpty()) {
            String flightSymbol = Landing.poll();
            System.out.println("Landing" + flightSymbol);
            if(Landing.isEmpty()){
                System.out.println("No Landing flights in the landing Queue.");
            }
        } else if (!TakeOff.isEmpty()) {
            String flightSymbol = TakeOff.poll();
            System.out.println("Take Off" + flightSymbol);
            if(TakeOff.isEmpty()){
                System.out.println("No Take off flights in the take off Queue.");
            }
        } else {
            System.out.println("No flights in the both queues.");
        }
    }

}


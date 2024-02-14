package org.example;

/**
 *  Name: Jianfeng Han
 *  Class Group: SD2A
 */
import java.util.Map;
import java.util.Stack;
import java.util.Scanner;
public class CA3_Question1
{
    public static void Q1Start()
    {
        Stack<Integer> DriveWay = new Stack<>();
        Stack<Integer> Street = new Stack<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter positive numbers to add a car to the driveway, negative numbers to remove a car from the driveway, and '0' to stop the simulation.");

        while(true){
            System.out.println("Enter positive number or negative number:");
            int input = sc.nextInt();
            if (input > 0) {
                DriveWay.push(input);
            }else if(input < 0){
                int CarToRetrieve = Math.abs(input);
                CarMoveToStreet(DriveWay,Street,CarToRetrieve);
            }else{
                System.out.println("Stop the simulation");
                break;
            }
            PrintStack(DriveWay,Street);
        }
    }

    private static void CarMoveToStreet(Stack<Integer> DriveWay, Stack<Integer> Street, int CarToRetrieve){
        while(!DriveWay.isEmpty()){
            int currentCar = DriveWay.pop();
            if(currentCar == CarToRetrieve){
                System.out.println("Retrieve car " + CarToRetrieve + " from the DriveWay.");
                break;
            }else{
                System.out.println("Moving car " + currentCar + " to the street");
                Street.push(currentCar);
            }
        }

        while(!Street.isEmpty()){
            int carOnStreet = Street.pop();
            DriveWay.push(carOnStreet);
            System.out.println("Moving car " + carOnStreet + " Back to the DriveWay");
        }
        System.out.println("Street:" + Street);
    }

    private static void PrintStack(Stack<Integer> DriveWay, Stack<Integer> Street){
        System.out.println("DriveWay:" + DriveWay);
        System.out.println("Street:" + Street);
    }

    public static void main(String[] args) {
        Q1Start();
    }
}

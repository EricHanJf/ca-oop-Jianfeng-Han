package org.example;


import java.util.LinkedList;
import java.util.Scanner;
import java.util.*;

/**
 * Name:
 * Class Group:
 */
public class CA3_Question6 {

    /*
    Will repeatedly ask the user to enter the commands in the format
    buy qty price
    or
    sell qty price
    or
    quit
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Queue<Integer> Quantity = new LinkedList<Integer>();
        Queue<Double> Price = new LinkedList<Double>();

        double totalProfit = 0;
        String command = "";
        do {
            System.out.print("Do you want to Buy or Sell Stock?");
            command = in.nextLine();
            if (command.equalsIgnoreCase("buy")) {
                System.out.println("How many Shares of Stock do you want to buy?");
                int qty = in.nextInt();
                System.out.println("Enter current Price per stock.");
                double price = in.nextDouble();
                buy(Quantity, Price, qty, price);

            } else if (command.equals("sell")) {
                System.out.println("How many Shares of Stock do you want to Sell?");
                int qty = in.nextInt();
                System.out.println("Enter the latest Price per stock.");
                double price = in.nextDouble();
                totalProfit += sell(Quantity, Price, qty, price);

            }
        } while (!command.equalsIgnoreCase("quit"));

        System.out.println("Total Profit: €" + totalProfit);
        System.out.println("Remaining Stocks: " + Quantity.toString());
    }

    private static void buy(Queue<Integer> quantities, Queue<Double> Prices, int quantity, double price) {
        quantities.add(quantity);
        Prices.add(price);
        System.out.println("You Bought " + quantity + " Shares at €" + price + " pre share");
    }

    private static double sell(Queue<Integer> quantities, Queue<Double> Prices, int quantity, double price) {
        double totalProfit = 0;

        while (quantity > 0 && !quantities.isEmpty()) {
            int availableQualityStock = quantities.poll();
            double PriceOfStock = Prices.poll();

            if (availableQualityStock <= quantity) {
                totalProfit += (price - PriceOfStock) * availableQualityStock;
                quantity -= availableQualityStock;
                System.out.println("Sold " + availableQualityStock + " shares at €" + price + " per share.");
            }else{
                totalProfit += (price - PriceOfStock) * quantity;
                quantities.add(availableQualityStock - quantity);
                Prices.add(PriceOfStock);
                System.out.println("Sold " + quantity + " shares at €" + price + " per share.");
                quantity = 0;
            }
        }
        if (quantity > 0) {
            System.out.println("Not enough shares to sell.");
        }

        return totalProfit;
    }
}

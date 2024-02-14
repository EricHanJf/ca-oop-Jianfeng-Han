package org.example;

import java.util.*;

/**
 * Name:
 * Class Group:
 */
public class CA3_Question7 {

    /*
   Will repeatedly ask the user to enter the commands in the format
   buy company qty price
   or
   sell company qty price
   or
   quit
    */
    static class Block {
        String Company;
        int Quantity;
        double Price;

        public Block(String company, int quantity, double price) {
            Company = company;
            Quantity = quantity;
            Price = price;
        }
    }


    public static void main(String[] args) {
//        Queue<Integer> StockQuantity = new LinkedList<>();
//        Queue<Double> StockPrice = new LinkedList<>();
        Map<String, Queue<Block>> CompanyShares = new HashMap<>();
        double totalProfit = 0;
        Scanner in = new Scanner(System.in);
        String command = "";
        do {
            System.out.print("Please enter the Symbol to (buy / sell / quit)");
            command = in.nextLine();

            if (command.equalsIgnoreCase("buy")) {
                System.out.println("Please enter the company name of the stock which you want to buy. :");
                String companyName = in.nextLine();

                System.out.println("How many Shares of Stock do you want to buy?");
                int qty = in.nextInt();

                System.out.println("Enter current Price per stock.");
                double price = in.nextDouble();
                in.nextLine();
                buy(companyName, qty, price, CompanyShares);
                // Code to buy shares here
            } else if (command.equals("sell")) {
                System.out.println("Please enter the company name of the stock which you want to Sell. :");
                String companyName = in.next();

                System.out.println("How many Shares of Stock do you want to Sell?");
                int qty = in.nextInt();

                System.out.println("Enter the latest Price per stock which you want to sell.");
                double price = in.nextDouble();
                in.nextLine();
                totalProfit += sell(companyName, qty, price, CompanyShares);
                // Code to sell shares and calculate profit here
            }


        } while (!command.equalsIgnoreCase("quit"));
//        System.out.println("Total Profit: €" + totalProfit);

        for (Map.Entry<String, Queue<Block>> entry : CompanyShares.entrySet()) {
            String company = entry.getKey();
            Queue<Block> shares = entry.getValue();
            int totalShares = 0;
            double totalEarnings = 0;

            for (Block block : shares) {
                totalShares += block.Quantity;
//                totalEarnings += (block.Price * block.Quantity);
//                totalEarnings += totalProfit;
//                System.out.println("Company: " + company + ", Remaining Shares: " + totalShares + ", Total Earnings: €" + totalEarnings);
            }
            System.out.println("Company: " + company + ", Remaining Shares: " + totalShares);
        }

    }

    public static void buy(String Company, int Quantity, double Price, Map<String, Queue<Block>> companyShares) {
        Queue<Block> shares = companyShares.containsKey(Company) ? companyShares.get(Company) : new LinkedList<>();
        shares.add(new Block(Company, Quantity, Price));
        companyShares.put(Company, shares);
        System.out.println("Bought " + Quantity + " shares of " + Company + " at €" + Price + " per share.");
    }

    public static double sell(String Company, int Quantity, double Price, Map<String, Queue<Block>> companyShares) {
        double totalProfit = 0;
        if (companyShares.containsKey(Company)) {
            Queue<Block> shares = companyShares.get(Company);
            int remainingQuantity = Quantity;
            while (remainingQuantity > 0 && !shares.isEmpty()) {
                Block block = shares.peek();
                if (block.Quantity <= remainingQuantity) {
                    totalProfit += (Price - block.Price) * block.Quantity;
                    remainingQuantity -= block.Quantity;
                    shares.poll();
                } else {
                    totalProfit += (Price - block.Price) * remainingQuantity;
                    block.Quantity -= remainingQuantity;
                    remainingQuantity = 0;
                }
            }
            if (remainingQuantity > 0) {
                System.out.println("Not enough shares to sell.");
                return 0;
            } else {
                companyShares.put(Company, shares);
                System.out.println("Sold " + Quantity + " shares of " + Company + " at €" + Price + " per share.");
                System.out.println("Company Name: " + Company + " , total Earning: €" + totalProfit);
                return totalProfit;
            }
        } else {
            System.out.println("No shares of " + Company + " available to sell.");
            return 0;
        }
    }

}


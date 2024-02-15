package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.*;

/**
 *  Name:
 *  Class Group:
 */
public class CA3_Question10 {
    public static void readFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        List<DistanceTo> distances = new ArrayList<>();

        System.out.printf("%-13s %-13s %5s\n", "From City", "To City", "Distance");
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");
            String fromCity = tokens[0];
            String toCity = tokens[1];
            int distance = Integer.parseInt(tokens[2]);

            distances.add(new DistanceTo(fromCity, toCity, distance));
            distances.add(new DistanceTo(toCity, fromCity, distance));

            System.out.printf("%-13s %-13s %5d %n", fromCity, toCity, distance);
        }

        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Please enter your start City:");
        String startCity = inputScanner.nextLine();
        System.out.println("Please enter your destination City:");
        String destinationCity = inputScanner.nextLine();

        Map<String, Integer> shortestDistances = new HashMap<>();
        Map<String, List<String>> shortestRoutes = new HashMap<>();
        for (DistanceTo dt : distances) {
            shortestRoutes.putIfAbsent(dt.getTarget(), new ArrayList<>());
            shortestDistances.put(dt.getTarget(), Integer.MAX_VALUE);
        }
        shortestDistances.put(startCity, 0);

        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(shortestDistances::get));
        pq.offer(startCity);

        while (!pq.isEmpty()) {
            String currentCity = pq.poll();
            int currentDistance = shortestDistances.get(currentCity);

            for (DistanceTo next : distances) {
                if (next.getTarget().equals(currentCity)) {
                    int newDistance = currentDistance + next.getDistance();
                    if (newDistance < shortestDistances.get(next.getTo())) {
                        shortestDistances.put(next.getTo(), newDistance);
                        List<String> route = new ArrayList<>(shortestRoutes.get(currentCity));
                        route.add(next.getTo());
                        shortestRoutes.put(next.getTo(), route);
                        pq.offer(next.getTo());
                    }
                }
            }
        }

        int shortestDistance = shortestDistances.get(destinationCity);

        System.out.println("Shortest distance from " + startCity + " to " + destinationCity + " is: " + shortestDistance);
        System.out.println("Shortest route:");
        System.out.print(startCity + " -> ");
        for (String city : shortestRoutes.get(destinationCity)) {
            System.out.print(city + " -> ");

        }
//        System.out.println(destinationCity);
    }

    public static void main(String[] args) throws FileNotFoundException {
        readFile("src/DistanceTo.txt");
    }
}






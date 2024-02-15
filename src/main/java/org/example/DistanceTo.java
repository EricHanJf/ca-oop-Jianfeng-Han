package org.example;

public class DistanceTo implements Comparable<DistanceTo> {
    private String target;
    private String to;
    private int distance;

    public DistanceTo(String city, String to, int dist) {
        target = city;
        this.to = to;
        distance = dist;
    }

    public String getTarget() {
        return target;
    }
    public String getTo() {
        return to;
    }

    public int getDistance() {
        return distance;
    }

    public int compareTo(DistanceTo other) {
        return distance - other.distance;
    }
}


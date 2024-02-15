package org.example;
import java.util.*;

enum DIRECTION {NORTH, SOUTH, EAST, WEST};

public class CA3_Question9 {
    private int[][] maze;
    private boolean[][] visited;
    private Stack<String> path;

    public CA3_Question9(int[][] maze) {
        this.maze = maze;
        this.visited = new boolean[maze.length][maze[0].length];
        this.path = new Stack<>();
    }

    public static void display(int[][] image) {
        for (int x = 0; x < image.length; x++) {
            for (int y = 0; y < image[0].length; y++) {
                System.out.printf("%4d", image[x][y]);
            }
            System.out.println();
        }
    }

    public void solve(int startX, int startY, DIRECTION dir) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{startX, startY});

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int x = current[0];
            int y = current[1];

            if (x < 0 || x >= maze.length || y < 0 || y >= maze[0].length || maze[x][y] == 0 || visited[x][y]) {
                continue;
            }
            visited[x][y] = true;

            path.push("(" + x + "," + y + ")");
            if (maze[x][y] == 2) {
                System.out.println("Path found:");
                displayPath();
                return;
            }
            stack.push(new int[]{x - 1, y}); // North
            stack.push(new int[]{x + 1, y}); // South
            stack.push(new int[]{x, y + 1}); // East
            stack.push(new int[]{x, y - 1}); // West
        }
        System.out.println("No path found.");
    }

    private void displayPath() {
        Stack<String> reversedPath = new Stack<>();
        while (!path.isEmpty()) {
            reversedPath.push(path.pop());
        }
        while (!reversedPath.isEmpty()) {
            System.out.print(reversedPath.pop());
            if (!reversedPath.isEmpty()) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 1, 1, 0, 0},
                {2, 1, 1, 1, 1, 0, 0},
                {0, 1, 1, 1, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0}
        };

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter starting X position: ");
        int startX = scanner.nextInt();
        System.out.print("Enter starting Y position: ");
        int startY = scanner.nextInt();
        System.out.println("Maze Picture:");
        display(maze);
        CA3_Question9 solver = new CA3_Question9(maze);
        solver.solve(startX, startY, DIRECTION.EAST);
    }
}






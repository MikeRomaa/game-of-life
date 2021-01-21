package dev.romashov.helpers;

import java.util.ArrayList;

public class Utils {
    public static int[] rotatePointsAroundCenter(int[] point, int[] center) {
        int relativeX = center[0] - point[0];
        int relativeY = center[1] - point[1];
        return new int[]{relativeY + center[0], -relativeX + center[1]};
    }

    public static ArrayList<int[]> rotatePointsAroundCenter(ArrayList<int[]> points, int[] center) {
        ArrayList<int[]> rotatedPoints = new ArrayList<>();
        for (int[] point : points) {
            rotatedPoints.add(rotatePointsAroundCenter(point, center));
        }
        return rotatedPoints;
    }

    public static ArrayList<int[]> translatePoints(ArrayList<int[]> points, int dx, int dy) {
        ArrayList<int[]> rotatedPoints = new ArrayList<>();
        for (int[] point : points) {
            rotatedPoints.add(new int[]{point[0] + dx, point[1] + dy});
        }
        return rotatedPoints;
    }
}

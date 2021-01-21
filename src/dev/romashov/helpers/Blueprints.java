package dev.romashov.helpers;

import java.util.ArrayList;

public class Blueprints {
    public static final ArrayList<int[]> GLIDER_GUN = new ArrayList<int[]>() {{
        add(new int[]{0, 0});
        add(new int[]{0, 1});
        add(new int[]{1, 0});
        add(new int[]{1, 1});
        add(new int[]{10, 0});
        add(new int[]{10, 1});
        add(new int[]{10, 2});
        add(new int[]{11, -1});
        add(new int[]{11, 3});
        add(new int[]{12, -2});
        add(new int[]{12, 4});
        add(new int[]{13, -2});
        add(new int[]{13, 4});
        add(new int[]{14, 1});
        add(new int[]{15, -1});
        add(new int[]{15, 3});
        add(new int[]{16, 0});
        add(new int[]{16, 1});
        add(new int[]{16, 2});
        add(new int[]{17, 1});
        add(new int[]{20, 0});
        add(new int[]{20, -1});
        add(new int[]{20, -2});
        add(new int[]{21, 0});
        add(new int[]{21, -1});
        add(new int[]{21, -2});
        add(new int[]{22, -3});
        add(new int[]{22, 1});
        add(new int[]{24, -4});
        add(new int[]{24, -3});
        add(new int[]{24, 1});
        add(new int[]{24, 2});
        add(new int[]{34, -2});
        add(new int[]{34, -1});
        add(new int[]{35, -2});
        add(new int[]{35, -1});
    }};

    public static final ArrayList<int[]> PUFFERFISH = new ArrayList<int[]>() {{
        add(new int[]{0, 4});
        add(new int[]{0, 10});
        add(new int[]{1, 3});
        add(new int[]{1, 5});
        add(new int[]{1, 9});
        add(new int[]{1, 11});
        add(new int[]{2, 6});
        add(new int[]{2, 8});
        add(new int[]{3, 0});
        add(new int[]{3, 1});
        add(new int[]{3, 6});
        add(new int[]{3, 8});
        add(new int[]{3, 13});
        add(new int[]{3, 14});
        add(new int[]{4, 0});
        add(new int[]{4, 6});
        add(new int[]{4, 8});
        add(new int[]{4, 14});
        add(new int[]{5, 2});
        add(new int[]{5, 5});
        add(new int[]{5, 9});
        add(new int[]{5, 12});
        add(new int[]{6, 4});
        add(new int[]{6, 10});
        add(new int[]{8, 3});
        add(new int[]{8, 4});
        add(new int[]{8, 5});
        add(new int[]{8, 9});
        add(new int[]{8, 10});
        add(new int[]{8, 11});
        add(new int[]{9, 1});
        add(new int[]{9, 2});
        add(new int[]{9, 5});
        add(new int[]{9, 9});
        add(new int[]{9, 12});
        add(new int[]{9, 13});
        add(new int[]{10, 2});
        add(new int[]{10, 3});
        add(new int[]{10, 4});
        add(new int[]{10, 10});
        add(new int[]{10, 11});
        add(new int[]{10, 12});
        add(new int[]{11, 3});
        add(new int[]{11, 11});
    }};

    /**
     * Given an origin coordiante, returns a list of all coordinates
     * that make up the requested blueprint.
     * @param pos integer array of origin matrix coordinate [x, y]
     * @param blueprint blueprint constant from {@link Blueprints} class
     * @return {@link ArrayList} of coordinates making up the blueprint
     */
    public static ArrayList<int[]> generateBlueprint(int[] pos, ArrayList<int[]> blueprint) {
        ArrayList<int[]> points = new ArrayList<>();
        for (int[] offset : blueprint) {
            points.add(new int[]{pos[0] + offset[0], pos[1] + offset[1]});
        }
        return points;
    }
}

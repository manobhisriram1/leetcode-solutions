
public class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        // If the starting and destination cells are the same, check if the time limit allows for it.
        if (sx == fx && sy == fy) {
            return (t > 1 || t == 0);
        }

        // Calculate the height and width differences between the starting and destination cells.
        int heightDifference = Math.abs(sy - fy);
        int widthDifference = Math.abs(sx - fx);

        // Calculate the extra time needed to cover the extra moves.
        int extraTime = Math.abs(heightDifference - widthDifference);

        // Check if the total time (min of height and width differences + extra time) is within the time limit.
        return (Math.min(heightDifference, widthDifference) + extraTime) <= t;
    }
}
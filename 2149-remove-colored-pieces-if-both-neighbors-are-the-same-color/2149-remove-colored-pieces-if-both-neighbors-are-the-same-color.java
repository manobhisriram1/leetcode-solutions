
public class Solution {
    public boolean winnerOfGame(String colors) {
        int aliceWins = 0;
        int bobWins = 0;
        
        int consecutiveA = 0;
        int consecutiveB = 0;
        
        for (char color : colors.toCharArray()) {
            if (color == 'A') {
                consecutiveA++;
                consecutiveB = 0;
                if (consecutiveA >= 3) {
                    aliceWins++;
                }
            } else if (color == 'B') {
                consecutiveB++;
                consecutiveA = 0;
                if (consecutiveB >= 3) {
                    bobWins++;
                }
            } else {
                consecutiveA = 0;
                consecutiveB = 0;
            }
        }
        
        return aliceWins > bobWins;
    }
}

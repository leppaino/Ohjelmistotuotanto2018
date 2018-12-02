
package ohtu;

public class TennisGame {
    public final static int POINT = 1, // piste
                            MINUSPOINT = -1,
                            PELAAJIENMAARA = 2,
                            POINTLIMIT = 4,  // etu tai voitto
                            WINLIMIT = 2;  // voittiko
    
    private int player1_score = 0;
    private int player2_score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            player1_score += POINT;
        else
            player2_score += POINT;
    }

    public String getScore() {
        String score = "";
        if (player1_score==player2_score)
        {
            switch (player1_score)
            {
                case 0:
                        score = "Love-All";
                    break;
                case 1:
                        score = "Fifteen-All";
                    break;
                case 2:
                        score = "Thirty-All";
                    break;
                case 3:
                        score = "Forty-All";
                    break;
                default:
                        score = "Deuce";
                    break;
                
            }
        }
        else if (player1_score>=POINTLIMIT || player2_score>=POINTLIMIT){
            score = calculateAdvantageOrWin();
        }
        else
        {
            score = calculateScore(score);
        }
        return score;
    }
    public String calculateAdvantageOrWin(){
        String score = "";
        int minusResult = player1_score-player2_score;
        if (minusResult==POINT) score ="Advantage player1";
        else if (minusResult ==MINUSPOINT) score ="Advantage player2";
        else if (minusResult>=WINLIMIT) score = "Win for player1";
        else score ="Win for player2";

        return score;
    }
    public String calculateScore(String score){
        int tempScore=0;
        for (int i=PELAAJIENMAARA-1; i<PELAAJIENMAARA+1; i++)
        {
            if (i==1) tempScore = player1_score;
            else { score+="-"; tempScore = player2_score;}
            switch(tempScore)
            {
                case 0:
                    score+="Love";
                    break;
                case 1:
                    score+="Fifteen";
                    break;
                case 2:
                    score+="Thirty";
                    break;
                case 3:
                    score+="Forty";
                    break;
            }
        }
        return score;
    }
}
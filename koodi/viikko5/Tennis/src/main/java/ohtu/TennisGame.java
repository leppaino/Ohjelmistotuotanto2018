<<<<<<< HEAD

package ohtu;

public class TennisGame {
    public final static int POINT = 1, // piste
                            MINUSPOINT = -1,
                            PELAAJIENMAARA = 2,
                            POINTLIMIT = 4,  // etu tai voitto
                            WINLIMIT = 2;  // voittiko
    
    private int player1_score = 0;
    private int player2_score = 0;
=======
package ohtu;

public class TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;
>>>>>>> 774d9c773f3de5e3119bc23c50590ff1aacc314d
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
<<<<<<< HEAD
            player1_score += POINT;
        else
            player2_score += POINT;
=======
            m_score1 += 1;
        else
            m_score2 += 1;
>>>>>>> 774d9c773f3de5e3119bc23c50590ff1aacc314d
    }

    public String getScore() {
        String score = "";
<<<<<<< HEAD
        if (player1_score==player2_score)
        {
            switch (player1_score)
=======
        int tempScore=0;
        if (m_score1==m_score2)
        {
            switch (m_score1)
>>>>>>> 774d9c773f3de5e3119bc23c50590ff1aacc314d
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
<<<<<<< HEAD
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
=======
        else if (m_score1>=4 || m_score2>=4)
        {
            int minusResult = m_score1-m_score2;
            if (minusResult==1) score ="Advantage player1";
            else if (minusResult ==-1) score ="Advantage player2";
            else if (minusResult>=2) score = "Win for player1";
            else score ="Win for player2";
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = m_score1;
                else { score+="-"; tempScore = m_score2;}
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
>>>>>>> 774d9c773f3de5e3119bc23c50590ff1aacc314d
            }
        }
        return score;
    }
}
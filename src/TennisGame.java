public class TennisGame {

    public static final int LOVE = 0;
    public static final int FIFTEEN = 1;
    public static final int THIRTY = 2;
    public static final int FORTY = 3;
    public static final int DEUCE = 4;

    public static String getScore(String playerOne, String playerTwo, int scoreOfPlayer1, int socoreOfPlayer2) {
        String score = "";
        int tempScore = 0;
        final boolean isDeuce = scoreOfPlayer1 == socoreOfPlayer2;
        if (isDeuce)
        {
            switch (scoreOfPlayer1)
            {
                case LOVE:
                    score = "Love-All";
                    break;
                case FIFTEEN:
                    score = "Fifteen-All";
                    break;
                case THIRTY:
                    score = "Thirty-All";
                    break;
                case FORTY:
                    score = "Forty-All";
                    break;
                default:
                    score = "Deuce";
                    break;

            }
        }
        else {
            boolean isScoreOneGreater = scoreOfPlayer1 >= DEUCE;
            boolean isScoreTwoGreater = socoreOfPlayer2 >= DEUCE;
            if (isScoreOneGreater || isScoreTwoGreater)
            {
                int minusResult = scoreOfPlayer1-socoreOfPlayer2;
                boolean isAdvantagePlayerOne = minusResult == FIFTEEN;
                boolean isAdvantagePlayerTwo = minusResult == -FIFTEEN;
                boolean isPlayerOneWin = minusResult >= THIRTY;
                if (isAdvantagePlayerOne) score ="Advantage player1";
                else if (isAdvantagePlayerTwo) score ="Advantage player2";
                else if (isPlayerOneWin) score = "Win for player1";
                else score ="Win for player2";
            }
            else
            {
                for (int index = FIFTEEN; index< FORTY; index++)
                {
                    if (index==FIFTEEN) tempScore = scoreOfPlayer1;
                    else { score+="-"; tempScore = socoreOfPlayer2;}
                    switch(tempScore)
                    {
                        case LOVE:
                            score+="Love";
                            break;
                        case FIFTEEN:
                            score+="Fifteen";
                            break;
                        case THIRTY:
                            score+="Thirty";
                            break;
                        case FORTY:
                            score+="Forty";
                            break;
                    }
                }
            }
        }
        return score;
    }
}

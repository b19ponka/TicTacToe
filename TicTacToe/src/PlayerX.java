public class PlayerX implements Player{

    private int numberOfWins = 0;

    public boolean myTurn;

    //Player X starts the first game
    public PlayerX(){
        this.myTurn = true;
    }

    @Override
    public String getMark() {
        return "X";
    }

    @Override
    public int getNumberOfWins() {
        return numberOfWins;
    }

    @Override
    public void setNumberOfWins() {
        numberOfWins ++;
    }

    @Override
    public void setMyTurn(boolean turn) {
        this.myTurn = turn;
    }

}

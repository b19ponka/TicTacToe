public class PlayerO implements Player{

    private int numberOfWins = 0;

    public boolean myTurn;

    //Player O does not start the first game
    public PlayerO(){
        this.myTurn = false;
    }

    @Override
    public String getMark() {
        return "O";
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

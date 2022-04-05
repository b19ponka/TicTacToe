import javax.swing.*;

public class GameLogic {

    static PlayerO playerO = new PlayerO();
    static PlayerX playerX = new PlayerX();

    //Check if there is three marks in a row. If so return the player who won, else return null
    public static Player calculateWin(JButton[] spaces){
        if(spaces[0].getText().equalsIgnoreCase("O") && spaces[1].getText().equalsIgnoreCase("O") && spaces[2].getText().equalsIgnoreCase("O")){
            return playerO;
        }
        if(spaces[0].getText().equalsIgnoreCase("O") && spaces[3].getText().equalsIgnoreCase("O") && spaces[6].getText().equalsIgnoreCase("O")){
            return playerO;
        }
        if(spaces[0].getText().equalsIgnoreCase("O") && spaces[4].getText().equalsIgnoreCase("O") && spaces[8].getText().equalsIgnoreCase("O")){
            return playerO;
        }
        if(spaces[1].getText().equalsIgnoreCase("O") && spaces[4].getText().equalsIgnoreCase("O") && spaces[7].getText().equalsIgnoreCase("O")){
            return playerO;
        }
        if(spaces[2].getText().equalsIgnoreCase("O") && spaces[5].getText().equalsIgnoreCase("O") && spaces[8].getText().equalsIgnoreCase("O")){
            return playerO;
        }
        if(spaces[2].getText().equalsIgnoreCase("O") && spaces[4].getText().equalsIgnoreCase("O") && spaces[6].getText().equalsIgnoreCase("O")){
            return playerO;
        }
        if(spaces[3].getText().equalsIgnoreCase("O") && spaces[4].getText().equalsIgnoreCase("O") && spaces[5].getText().equalsIgnoreCase("O")){
            return playerO;
        }
        if(spaces[6].getText().equalsIgnoreCase("O") && spaces[7].getText().equalsIgnoreCase("O") && spaces[8].getText().equalsIgnoreCase("O")){
            return playerO;
        }
        if(spaces[0].getText().equalsIgnoreCase("X") && spaces[1].getText().equalsIgnoreCase("X") && spaces[2].getText().equalsIgnoreCase("X")){
            return playerX;
        }
        if(spaces[0].getText().equalsIgnoreCase("X") && spaces[3].getText().equalsIgnoreCase("X") && spaces[6].getText().equalsIgnoreCase("X")){
            return playerX;
        }
        if(spaces[0].getText().equalsIgnoreCase("X") && spaces[4].getText().equalsIgnoreCase("X") && spaces[8].getText().equalsIgnoreCase("X")){
            return playerX;
        }
        if(spaces[1].getText().equalsIgnoreCase("X") && spaces[4].getText().equalsIgnoreCase("X") && spaces[7].getText().equalsIgnoreCase("X")){
            return playerX;
        }
        if(spaces[2].getText().equalsIgnoreCase("X") && spaces[5].getText().equalsIgnoreCase("X") && spaces[8].getText().equalsIgnoreCase("X")){
            return playerX;
        }
        if(spaces[2].getText().equalsIgnoreCase("X") && spaces[4].getText().equalsIgnoreCase("X") && spaces[6].getText().equalsIgnoreCase("X")){
            return playerX;
        }
        if(spaces[3].getText().equalsIgnoreCase("X") && spaces[4].getText().equalsIgnoreCase("X") && spaces[5].getText().equalsIgnoreCase("X")){
            return playerX;
        }
        if(spaces[6].getText().equalsIgnoreCase("X") && spaces[7].getText().equalsIgnoreCase("X") && spaces[8].getText().equalsIgnoreCase("X")){
            return playerX;
        }
        return null;
    }

}

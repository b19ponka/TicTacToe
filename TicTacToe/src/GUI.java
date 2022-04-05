import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

    private JButton spaces[] = new JButton[9];
    private int markCount = 0;
    private PlayerX playerX = new PlayerX();
    private PlayerO playerO = new PlayerO();
    private JLabel playerTurn = new JLabel("Spelares tur: X");
    private JLabel scoreBoard = new JLabel("X poäng: 0 | O poäng: 0");
    private JButton newGameBtn = new JButton("Spela igen");
    private JPanel board;

    public void createGUI(){
        //Creating the board
        createBoard();

        //Panel for holding the labels
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.PAGE_AXIS));
        textPanel.add(playerTurn);
        textPanel.add(scoreBoard);

        //Adding an actionlistener to the new game-button, calling method newGame when pressed.
        newGameBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newGame();
            }
        });

        /*Creating the frame and adding the textpanel, the board and new game-button to it.
        Setting the program to end when closing the frame*/
        JFrame frame = new JFrame();
        frame.add(board, BorderLayout.CENTER);
        frame.add(textPanel, BorderLayout.NORTH);
        frame.add(newGameBtn, BorderLayout.SOUTH);
        frame.setSize(300,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //Creating a panel for the board
    public void createBoard(){
        board = new JPanel();
        board.setLayout(new GridLayout(3,3));
        newGameBtn.setEnabled(false);

        //Adding buttons to the board to symbolize the spaces, and adding actionListener to the buttons
        for (int i = 0; i < 9; i++) {
            spaces[i] = new JButton(" ");
            spaces[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (int i = 0; i < spaces.length; i++){
                        if(spaces[i]==e.getSource()){
                            /*Depending on which players turn it is the pressed button's text is set to either X or O.
                            Player turn switches and total number of marks on the board is updated */
                            if(playerX.myTurn){
                                spaces[i].setText("X");
                                playerX.setMyTurn(false);
                                playerO.setMyTurn(true);
                                playerTurn.setText("Spelares tur: O");
                            }else{
                                spaces[i].setText("O");
                                playerX.setMyTurn(true);
                                playerO.setMyTurn(false);
                                playerTurn.setText("Spelares tur: X");
                            }
                            spaces[i].setEnabled(false);
                            markCount ++;
                        }
                    }
                    //Get winner and update the player's number of win, and add point to scoreboard
                    Player winner = GameLogic.calculateWin(spaces);
                    if(winner!=null){
                        if(winner.getMark() == "X"){
                            playerX.setNumberOfWins();
                        }else{
                            playerO.setNumberOfWins();
                        }
                        scoreBoard.setText("X poäng: " + playerX.getNumberOfWins() + " | O poäng: " + playerO.getNumberOfWins());
                        playerTurn.setText(winner.getMark() + " vann denna rundan.");

                        //Disable all board buttons when someone has won
                        for (int i = 0; i < spaces.length; i++) {
                            spaces[i].setEnabled(false);
                        }
                        newGameBtn.setEnabled(true);
                    }
                    //Check for draw
                    else if(markCount==9){
                        playerTurn.setText("Oavgjort");
                        newGameBtn.setEnabled(true);
                    }
                }
            });
            spaces[i].setFocusPainted(false);
        }

        //Add buttons to the board-panel
        for (int i = 0; i < spaces.length; i++){
            board.add(spaces[i]);
        }
    }

    //Start new game
    public void newGame(){
        if(playerX.myTurn){
            playerTurn.setText("Spelares tur: X");
        }else{
            playerTurn.setText("Spelares tur: O");
        }
        newGameBtn.setEnabled(false);
        for (int i = 0; i < spaces.length; i++) {
            spaces[i].setEnabled(true);
            spaces[i].setText("");
            markCount = 0;
        }
    }

}

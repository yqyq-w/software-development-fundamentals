package week1.whackamole;

import java.util.*;

public class WhackAMole {
    /**
     *  It contains three integer instance variables called score, molesLeft, and attemptsLeft.
     *  Make one more instance variable called moleGrid which is a 2-dimensional array of chars.
     */
    int score;
    int molesLeft;
    int attemptsLeft;
    char[][] moleGrid;


    /**
     * Constructor for the game, specifies total number of whacks allowed,and the grid dimension.
     * @param numAttempts
     * @param gridDimension
     */
    public WhackAMole(int numAttempts, int gridDimension) {
        this.score = 0;
        this.molesLeft = 0;
        this.attemptsLeft = numAttempts;
        this.moleGrid = new char[gridDimension][gridDimension];
        for (char[] i : moleGrid) {
            Arrays.fill(i, '*');
        }
    }

    /**
     * Given a location, place a mole at that location.
     * @param x
     * @param y
     * @return true if you can. Also update number of moles left.
     */
    public boolean place(int x, int y) {
        if (moleGrid[x][y] == '*'){
            moleGrid[x][y] = 'M';
            molesLeft++;
            return true;
        }
        return false;
    }

    /**
     * Given a location, take a whack at that location. If that location contains a mole,
     * the score, number of attemptsLeft, and molesLeft is updated, otherwise only update attemptsLeft.
     * @param x
     * @param y
     */
    public void whack(int x, int y) {
        if (moleGrid[x][y] == 'M') {
            moleGrid[x][y] = 'W';
            score++;
            attemptsLeft--;
            molesLeft--;
        } else {
            attemptsLeft--;
        }
        System.out.println("Your current score is: " + score);
        if (molesLeft == 0) {
            System.out.println("Congratulations! You've whacked all the moles!");
        }
    }

    /**
     * Print the grid without showing where the moles are. For every spot that has recorded a “whacked mole,”
     * print out a W, or * otherwise.
     */
    public void printGridToUser(){
        System.out.println("The current game grid looks like this: ");
        for (char[] arr : moleGrid) {
            for (char i : arr) {
                if (i != 'W') {
                    System.out.print('*' + " ");
                } else {
                    System.out.print(i + " ");
                }
            } System.out.print("\n");
        } System.out.print("\n");
    }

    /**
     * Print the grid completely. This is effectively dumping the 2d array on the screen.
     * The places where the moles are should be printed as an ‘M’.
     * The places where the moles have been whacked should be printed as a ‘W’.
     * The places that don’t have a mole should be printed as *.
     */
    public void printGrid(){
        System.out.println("The complete game grid: ");
        for (char[] arr : moleGrid) {
            for (char i : arr) { {
                    System.out.print(i + " ");
                }
            } System.out.print("\n");
        } System.out.print("\n");
    }

    /**
     * Putting it all together - main method
     * In order to play this game you need to create a main method.
     * Begin by creating a 10 by 10 grid where you randomly place the moles. Place a total of 10 moles.
     * Now allow the user (remember how to use Scanner?) to enter the x and y coordinates of where they
     * would like to take a whack. Tell them they have a maximum of 50 attempts to get all the moles.
     * At any point in the game, they can input coordinates of -1, -1 in order to indicate that they are giving up.
     * If the user gives up they get to see the entire grid.
     * The game ends if the user is able to uncover all the moles or if the user runs out of attempts.
     */
    public static void main(String[] args) {
        int maxAttempts = 50;
        int gridScale = 10;
        WhackAMole moleGame = new WhackAMole(maxAttempts, gridScale);

        int numMole = 10;
        Random random = new Random();
        while(moleGame.molesLeft < numMole) {
            moleGame.place(random.nextInt(numMole), random.nextInt(numMole));
        }

        Scanner sc = new Scanner(System.in);
        while (moleGame.attemptsLeft > 0 && moleGame.molesLeft > 0){
            moleGame.printGridToUser();
            //moleGame.printGrid();
            System.out.printf("This is attempt number %d / %d !\n", maxAttempts - moleGame.attemptsLeft + 1, maxAttempts);
            System.out.printf("Please enter the coordinates you want to take a whack, each coordinate within 0 to %d, "
                    + "input \"-1 -1\" if you want to give up:\n", gridScale-1);
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (x == -1 && y == -1) {
                break;
            } else {
                moleGame.whack(x, y);
            }
        }
        moleGame.printGrid();

    }
}

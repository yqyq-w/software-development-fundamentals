package test.week2.squarelotron;

import static org.junit.Assert.*;
import org.junit.Test;
import week2.squarelotron.Squarelotron;

/**
* Squarelotron Tester.
*
* @author <yqw>
* @since <pre>10月 27, 2020</pre>
* @version 1.0
*/
public class SquarelotronTest {
    private Squarelotron st4 = new Squarelotron(4);
    private Squarelotron st5 = new Squarelotron(5);

    @Test
    public void testConstructor(){
        assertEquals(4, st4.size);
        assertEquals(5, st5.size);
        int[][] st4Expected = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        int[][] st5Expected = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}};
        assertArrayEquals(st4Expected, st4.squarelotron);
        assertArrayEquals(st5Expected, st5.squarelotron);

    }

    /**
    *
        * Method: upsideDownFlip(int ring)
    *
    */
    @Test
    public void testUpsideDownFlip() throws Exception {
        int[][] st4Expected = {
                {13, 14, 15, 16},
                {9, 6, 7, 12},
                {5, 10, 11, 8},
                {1, 2, 3, 4}};
        int[][] st5Expected = {
                {1, 2, 3, 4, 5},
                {6, 17, 18, 19, 10},
                {11, 12, 13, 14, 15},
                {16, 7, 8, 9, 20},
                {21, 22, 23, 24, 25}};
        assertArrayEquals(st4Expected ,st4.upsideDownFlip(1).squarelotron);
        assertArrayEquals(st5Expected ,st5.upsideDownFlip(2).squarelotron);
    }

    /**
    *
    * Method: mainDiagonalFlip(int ring)
    *
    */
    @Test
    public void testMainDiagonalFlip() throws Exception {
        int[][] st4Expected = {
                {1, 2, 3, 4},
                {5, 6, 10, 8},
                {9, 7, 11, 12},
                {13, 14, 15, 16}};
        int[][] st5Expected = {
                {1, 6, 11, 16, 21},
                {2, 7, 8, 9, 22},
                {3, 12, 13, 14, 23},
                {4, 17, 18, 19, 24},
                {5, 10, 15, 20, 25}};
        assertArrayEquals(st4Expected ,st4.mainDiagonalFlip(2).squarelotron);
        assertArrayEquals(st5Expected ,st5.mainDiagonalFlip(1).squarelotron);
    }

    /**
    *
    * Method: rotateRight(int numberOfTurns)
    *
    */
    @Test
    public void testRotateRight() throws Exception {
        int[][] st4Expected = {
                {16, 15, 14, 13},
                {12, 11, 10, 9},
                {8, 7, 6, 5},
                {4, 3, 2, 1}};
        st4.rotateRight(2);
        assertArrayEquals(st4Expected ,st4.squarelotron);

        st4.rotateRight(4);
        assertArrayEquals(st4Expected ,st4.squarelotron);

        int[][] st4Expected2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        st4.rotateRight(-2);
        assertArrayEquals(st4Expected2 ,st4.squarelotron);

        int[][] st5Expected = {
                {21, 16, 11, 6, 1},
                {22, 17, 12, 7, 2},
                {23, 18, 13, 8, 3},
                {24, 19, 14, 9, 4},
                {25, 20, 15, 10, 5}};
        st5.rotateRight(1);
        assertArrayEquals(st5Expected ,st5.squarelotron);

        int[][] st5Expected2 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}};
        st5.rotateRight(-1);
        assertArrayEquals(st5Expected2 ,st5.squarelotron);

    }

}

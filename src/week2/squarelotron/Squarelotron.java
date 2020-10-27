package week2.squarelotron;

public class Squarelotron {
    public int[][] squarelotron;
    public int size;

    public Squarelotron(int n) {
        this.size = n;
        this.squarelotron = new int[size][size];

        int num = 1;
        for (int i = 0; i < size;i ++) {
            for (int j = 0; j <size;j ++) {
                squarelotron[i][j] = num;
                num++;
                //squarelotron[i][j] = 1 + i * size + j;
            }
        }
    }

    /**
     * This method performs the Upside-Down Flip of the squarelotron, as described above
     * @param ring
     * @return the new squarelotron. The original squarelotron should not be modified
     */
    public Squarelotron upsideDownFlip(int ring) {
        Squarelotron upsideDownSt =  new Squarelotron(size);
        // int[] tempArr = this.squarelotron[ring - 1];
        // upsideDownSt.squarelotron[ring - 1] = this.squarelotron[size - ring];
        // upsideDownSt.squarelotron[size - ring] = tempArr;
        for (int i = 0; i < size;i ++) {
            for (int j = 0; j <size;j ++) {
                if (i == ring - 1 || j == ring - 1 || i == size - ring || j == size - ring) {
                    if (i <= ring - 2 || i >= size - ring  + 1
                            || j <= ring - 2 || j >= size - ring + 1 ) {
                        continue;
                    }
                    upsideDownSt.squarelotron[i][j] = this.squarelotron[size - 1 - i][j];
                }
            }
        }
        return upsideDownSt;
    }

    /**
     * This method performs the Main Diagonal Flip of the squarelotron, as described above
     * @param ring
     * @return returns the new squarelotron. The original squarelotron should not be modified
     */
    public Squarelotron mainDiagonalFlip(int ring) {
        Squarelotron mainDiagonalSt =  new Squarelotron(size);
        for (int i = 0; i < size;i ++) {
            for (int j = 0; j <size;j ++) {
                if (i == ring - 1 || j == ring - 1 || i == size - ring || j == size - ring) {
                    if (i <= ring - 2 || i >= size - ring  + 1
                            || j <= ring - 2 || j >= size - ring  + 1) {
                        continue;
                    }
                    mainDiagonalSt.squarelotron[i][j] = this.squarelotron[j][i];
                }
            }
        }
        return mainDiagonalSt;
    }

    /**
     * The argument numberOfTurns indicates the number of times the entire squarelotron
     * should be rotated 90° clockwise. Any integer, including zero and negative integers,
     * is allowable as the argument. A value of -1 indicates a 90° counterclockwise rotation.
     * This method modifies the internal representation of the squarelotron;
     * it does not create a new squarelotron.
     * @param numberOfTurns
     */
    public void rotateRight(int numberOfTurns) {
        // numberOfTurns -1 & 3; -2 & 2 have same outcomes
        int num = 0;
        while (num < (numberOfTurns % 4 + 4) % 4) {
            Squarelotron rotateRightSt =  new Squarelotron(size);
            for (int i = 0; i < size;i++) {
                for (int j = 0; j <size;j++) {
                    rotateRightSt.squarelotron[j][size - 1 - i] = this.squarelotron[i][j];
                }
            }
            num++;
            this.squarelotron = rotateRightSt.squarelotron; // so can not initialize rotateRightSt as local var
        }
    }


}


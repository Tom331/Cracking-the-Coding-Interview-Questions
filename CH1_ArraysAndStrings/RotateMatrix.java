package CH1_ArraysAndStrings;

import java.util.Arrays;

/**
 * Created by Thomas on 8/21/2017.
 */
public class RotateMatrix {

    public static void main(String[] args) {
        int n = 3;
        int[][] myMatrix = new int[n][n];
        myMatrix[0][0] = '1';
        myMatrix[0][1] = '2';
        myMatrix[0][2] = '3';
        myMatrix[1][0] = '4';
        myMatrix[1][1] = '5';
        myMatrix[1][2] = '6';
        myMatrix[2][0] = '7';
        myMatrix[2][1] = '8';
        myMatrix[2][2] = '9';
        System.out.println(Arrays.deepToString((myMatrix)));
        System.out.println((Arrays.deepToString(rotatedMatrix(myMatrix))));
    }

    static int[][] rotatedMatrix(int[][] matrix)
    {
        //if(matrix.length == 0 || matrix.length != matrix[0].length) return [0][0];
        int n = matrix.length;
        for(int layer = 0; layer < n/2; layer++)
        {
            int first = layer;
            int last = n - 1 - layer;
            for(int i = first; i < last; i++)
            {
                int offset = i - first;
                int top = matrix[first][i]; //save top

                //left -> top
                matrix[first][i] = matrix[last - offset][first];

                //bottom -> left
                matrix[last - offset][first] = matrix[last][last - offset];

                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];

                //top -> right
                matrix[i][last] = top; //right <- saved top

            }
        }
        return matrix;
    }
}

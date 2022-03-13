//Time Complexity: O(m*n)  m = row in a matrix, n = column in a a matrix
//Space Complexity: O(min(m, n))
//runs Successfully
//didn't face any problems


import java.util.LinkedList;
import java.util.Queue;

public class Matrix01LeetCode542 {

        private int[][] directions = {                      //directions that we can iterate from the given point
                {-1, 0},
                {0, -1},
                {1, 0},
                {0, 1}
        };

        public int[][] updateMatrix(int[][] mat) {

            int m = mat.length;                         //number of rows
            int n = mat[0].length;                      //number of columns

            Queue<int[]> q = new LinkedList<>();        //making queue which stores the row and column index

            for(int i =0; i<m; i++){                    //iterating through mat
                for(int j=0; j<n; j++){

                    if(mat[i][j] == 0){                 //check if mat is zero
                        q.add(new int[]{i,j});          //if yes, then add to the queue
                    }
                    else{
                        mat[i][j] = -1;                 //if not then replace with -1
                    }

                }
            }

            int distance = 1;                       //distance of thr 1's from 0's
            while(!q.isEmpty()){                    //iterating till queue is not empty

                Queue<int[]> next = new LinkedList<>(); //creating queue for the next iteration

                while(!q.isEmpty()){                //iterating our previous level till empty

                    int[] temp = q.remove();        //removing one element at a time

                    int row = temp[0];              //getting its row and column index
                    int col = temp[1];

                    for(int[] dir: directions){     //getting the directions

                        int newRow = row + dir[0];      //possible new row and column index
                        int newCol = col + dir[1];

                        if(newRow>=0 && newCol>=0 && newRow<m && newCol<n && mat[newRow][newCol] == -1){ //checking if newrow and new column index are valid or not, also check  mat of new row and column has -1 which means, that element is not visisted yet
                            mat[newRow][newCol] = distance;     //updating that element's value with the distance and add it to the queue
                            next.add(new int[]{newRow, newCol});
                        }

                    }
                }

                distance++;                         //increament the distance
                q = next;                           //and assign next queue to current queue

            }

            return mat;
        }
}

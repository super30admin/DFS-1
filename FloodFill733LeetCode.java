//Time Complexity: O(m*n)  m = row in a matrix, n = column in a a matrix
//Space Complexity: O(min(m, n))
//runs successfully
//didn't face any problems


import java.util.LinkedList;
import java.util.Queue;

public class FloodFill733LeetCode {

        int[][] directions = new int[][]{           //getting the direction that are possible from each element
                {-1, 0},
                {0, -1},
                {0, 1},
                {1, 0}
        };

        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

            int oldColor = image[sr][sc];           //getting the oldColor
            if(oldColor == newColor){               //if newcolor is same as oldcolor then return the array
                return image;
            }

            int m = image.length;                   //getting the row counts
            int n = image[0].length;                //getting the column counts

            Queue<int[]> q = new LinkedList<>();    //creating the queue which stores the row and column index
            q.add(new int[]{sr, sc});               //adding the element to the queue
            image[sr][sc] = newColor;               //setting this image element to newColor

            while(!q.isEmpty()){                    //itearting till queue is not empty

                int[] temp = q.remove();            //removing the element one by one

                int row = temp[0];                  //getting that element's row and column
                int col = temp[1];

                for(int[] dir : directions){        //iterating through directions

                    int newRow = row + dir[0];      //getting new row and new col
                    int newCol = col + dir[1];

                    if(newRow>=0 && newCol>=0 && newRow<m && newCol<n && image[newRow][newCol] == oldColor){ //checking if new row and new col is valid or not, and also check image's new row and new col value is old color or not

                        image[newRow][newCol] = newColor;       //if yes, then set the new row and column value to new color
                        q.add(new int[]{newRow, newCol});       //and add to the queue

                    }
                }

            }
            return image;
        }
}

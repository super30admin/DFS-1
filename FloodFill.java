/*
Time Complexity: O(N), N is the numbers in the image array which is nothing but n*m, where n is the number of rows and m
is the number of cols
Space Complecity: O(N), N is the size of the recursive stack
Run on leetcode: yes
Any difficulties: no

Approach:
1. I would first look for the color present at the given row and col and
2. If that color is not equals to the given newColor, then we will replace all the consecutive occurences of the color with
newColor, using depth first search
 */
public class FloodFill {

    public static int[][] floodFill(int[][] image, int row, int col, int newColor){
        int currColor = image[row][col];

        if(currColor!= newColor){
            depthFirstSearchOnFloodArea(image, row, col, currColor, newColor);
        }
        return image;
    }

    public static void depthFirstSearchOnFloodArea(int[][]image, int row, int col, int currColor, int newColor){
        if(image[row][col] == currColor){
            image[row][col] = newColor;

            if (row > 0) {
                depthFirstSearchOnFloodArea(image, row-1, col, currColor, newColor);
            }
            if (col >0) {
                depthFirstSearchOnFloodArea(image, row, col-1, currColor, newColor);
            }
            if (row< image.length-1) {
                depthFirstSearchOnFloodArea(image, row+1, col, currColor, newColor);
            }
            if (col<image[0].length-1) {
                depthFirstSearchOnFloodArea(image, row, col+1, currColor, newColor);
            }
        }
    }
    public static void main(String[] args){
       int[][] image = {{1,1,1},{1,1,0},{1,0,1}};

       floodFill(image, 1,1, 2);

       for(int i = 0; i<image.length; i++){
           for(int j = 0; j< image[0].length; j++){
               System.out.print(image[i][j] + "\t");
           }
           System.out.println();
       }
    }
}

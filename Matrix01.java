/*
Time Complexity: O(n*m) n is the number of rows and m is the number of cols
Space Complexity: O(n*m) recursive stack size
Run on leetcode: yes
Any difficulties: no

Approach:
1. Everytime I encounter a 0 in the matrix, I will go left, right, up, down in the matrix using recursion and everytime I
will update the distance by 1
2. Depth first search on the matrix would help us to get distance and I will update that distance in the resultant matrix
 */
public class Matrix01 {
    public static int[][] updateMatrix(int[][] mat) {
        int result[][] = new int[mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++) {
            for(int j=0;j<mat[0].length;j++) {
                if(mat[i][j]==0) {
                    depthFirstSearchMatrix(mat,result,i,j, 0);
                }
            }
        }
        return result;
    }
    private static void depthFirstSearchMatrix(int[][] mat, int[][] result, int i, int j, int currentDistance) {
        if(i<0||j<0||i==mat.length||j==mat[0].length)
            return;
        if(currentDistance ==0 || mat[i][j]==1 && (result[i][j]==0 || result[i][j] > currentDistance)) {
            result[i][j] = currentDistance;
            depthFirstSearchMatrix(mat,result,i+1,j,currentDistance+1);
            depthFirstSearchMatrix(mat,result,i,j+1,currentDistance+1);
            depthFirstSearchMatrix(mat,result,i-1,j,currentDistance+1);
            depthFirstSearchMatrix(mat,result,i,j-1,currentDistance+1);
        }
    }

    public static void main(String[] args){
        int[][] mat = {{0,0,0},{0,1,0},{0,0,0}};

        int [][] result = updateMatrix(mat);

        for(int i = 0; i<result.length; i++){
            for(int j = 0; j<result[0].length; j++){
                System.out.print(result[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

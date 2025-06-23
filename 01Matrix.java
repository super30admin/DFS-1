//This code recursively calculates the minimum distance from each cell to the nearest 0 using DFS by checking neighboring cells and caching partial results in the result matrix. It explores all four directions from every cell and returns the shortest path to a 0, incrementing the count at each level.
//Time Complexity: O((m × n) × 4ᵈ)
//Time Complexity: O(m × n)

class Solution {



private int m;



private int n;



public int[][] updateMatrix(int[][] matrix) {



m = matrix.length;



// edge case



if(matrix == null || m == 0) return matrix;



n= matrix[0].length;



int [][] result = new int [m][n];



for(int i = 0; i < m; i++){



for(int j = 0; j < n; j++){



result[i][j] = dfs(matrix,result, i, j);



}



}



return result;



}



private int dfs(int[][] matrix, int [][] result,int i, int j){



// base case



if(i < 0 || i >= m || j < 0 || j >= n) return 9999;



if(matrix[i][j] == 0) return 0;



if(i > 0 && matrix[i-1][j] == 0) return 1;



if(j > 0 && matrix[i][j-1] == 0) return 1;



if(i < m - 1 && matrix[i+1][j] == 0) return 1;



if(j < n-1 && matrix[i][j+1] == 0) return 1;



// Don't have any neighboring zero'



int top, left, right, bottom;



top = left = 9999; // Declare them as infinity



if(i > 0 && result[i-1][j] != 0){



top = result[i-1][j];



}



if(j > 0 && result[i][j-1] != 0){



left = result[i][j-1];



}



bottom = dfs(matrix, result, i+1, j);



right = dfs(matrix, result, i, j+1 );



return Math.min(Math.min(left, right), Math.min(top, bottom)) + 1;



}



}


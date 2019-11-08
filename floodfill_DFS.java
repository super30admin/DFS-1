//Leetcode all test cases passed
//Time Complexity : O(n)
//Space Complexity : O(n)

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //Edge case : 
        /*(if given pixel's color is already equa to the coor it is to be changed to)*/
        if(image[sr][sc]==newColor) return image;
        //Code
        Stack<int[]> stack = new Stack<>();
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        stack.push(new int[] {sr,sc});
        int oldColor = image[sr][sc];
        image[sr][sc] = newColor;
        while(!stack.isEmpty()){
            int size = stack.size();
            for(int k=0;k<size;k++){
                int[] pixel = stack.pop();                
                for(int dir[] : dirs){
                    int i = dir[0]+pixel[0];
                    int j = dir[1]+pixel[1];
                    if((i>=0&&i<image.length)&&(j>=0&&j<image[0].length)&&(image[i][j]==oldColor)){
                        stack.push(new int[] {i,j});
                        image[i][j]=newColor;
                    }
                }
            }
        }
     return image;   
    }
}

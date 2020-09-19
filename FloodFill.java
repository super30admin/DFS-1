// *Iterative approach*
// Time Complexity : O(n*m)
// Space Complexity : O(n*m) for the queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// similar to BFS, use ques to store indexes and store the source color with the new color and pass the oldcolor as a refernce to check for the other indexes.
// After changing add them to the queue. while the queue is not empty, check for the condition if the cell element is oldcolor then change it to new, else continue.

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image==null || image.length==0 || image[0].length==0 || image[sr][sc]==newColor){
            return image;
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        int oldColor = image[sr][sc];
        image[sr][sc] = newColor;
        
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        
        while(!q.isEmpty()){
            int[] pop = q.poll();
            
            for(int[] i:dirs){
                int r = pop[0]+i[0];
                int c = pop[1]+i[1];
                
                if(r>=0 && r<image.length && c>=0 && c<image[0].length && image[r][c]==oldColor){
                    image[r][c] = newColor;
                    q.add(new int[]{r,c});
                }
            }
        }
        return image;
    }
}

// *Recursive approach*
// Time Complexity : O(n*m)
// Space Complexity : O(n*m) for the recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// The basic description is explained above but using recursion for the same method.

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        if(image==null || image.length==0 || image[0].length==0 || image[sr][sc]==newColor){
            return image;
        }
        int oldColor = image[sr][sc];
        image[sr][sc] = newColor;
        recur(image,sr,sc,oldColor,newColor);
        return image;

    }
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    private void recur(int[][] image, int i, int j, int oldColor, int newColor){
        for(int[] dir:dirs){
            int r=dir[0]+i;
            int c=dir[1]+j;

            if(r>=0 && c>=0 && r<image.length && c<image[0].length && oldColor==image[r][c]){
                image[r][c] = newColor;
                recur(image,r,c,oldColor,newColor);
            }
        }
    }
}
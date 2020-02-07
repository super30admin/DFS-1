// S30 Big N Problem #62 {Easy}
// 733. Flood Fill
// Time Complexity :O(m*n)
// Space Complexity :O(m*n) {worst case all the indexes needs to be stored in the queue}
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :None


// Your code here along with comments explaining your approach
// BFS Solution
// Entering the rows and columns (indexs) in a queue, traversing through neighbours with directions array, keep changing the color,
// add the index if color changed to check the neighbours of that member 
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //bfs solution
        //edge case
        if(image==null || image.length==0 || image[sr][sc]==newColor) return image;
        Queue <int []> q=new LinkedList<>();
        int color = image[sr][sc];
        image[sr][sc] = newColor;
        q.add(new int[]{sr,sc});
        
        //makes code scalable as in neighbours can be redefined
        int [][] dirs={{0,1},{0,-1},{1,0},{-1,0}}; //direction array
        while(!q.isEmpty()){
            int [] curr =q.poll();
            for(int [] dir:dirs){
                int r=dir[0]+curr[0];
                int c=dir[1]+curr[1];
                if(r>=0 && c>=0 && r<image.length && c<image[0].length && image[r][c]==color){
                    image[r][c]=newColor;
                    q.add(new int[]{r,c});
                }
            }   
        }
        return image;   
    }
}
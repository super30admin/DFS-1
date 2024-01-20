// Time Complexity :O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode :Yess
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach: BFS

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n= image[0].length;

        if(image[sr][sc]==color) return image;

        Queue<int[]> q=new LinkedList<>();

        q.offer(new int[]{sr, sc});

        int old= image[sr][sc];

        int directions[][]= {{-1,0},{0,-1},{1,0},{0,1}};

        while(!q.isEmpty()){
            int current[]= q.poll();
            image[current[0]][current[1]]=color;
            for(int dir[]:directions){
                int newR= current[0]+dir[0];
                int newC= current[1]+dir[1]; 

                if(newR>=0 && newR<m && newC>=0 && newC<n && image[newR][newC]==old){
                    
                    q.offer(new int[]{newR,newC});
                }
            }
        }
        return image;
    }
}
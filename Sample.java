//DFS-1

Problem1 (https://leetcode.com/problems/flood-fill/)
	
// Time Complexity : O(m*n)
// Space Complexity : (m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach: BFS approach - mark and insert each traversed element in the queue.
// check all direcions if color is same. if same mark theat element with the new color.  
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image==null || image.length==0 || image[sr][sc]==newColor) return image;
        int m = image.length; int n=image[0].length;
        int color=image[sr][sc];
        Queue<Integer> q = new LinkedList<>();
        q.add(sr);q.add(sc);
        image[sr][sc]=newColor;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int cr=q.poll();
            int cc=q.poll();
            for(int[] dir:dirs){
                int r=cr+dir[0];
                int c=cc+dir[1];
                if(r>=0 && c>=0 && r<m && c<n && image[r][c]==color){
                    image[r][c]=newColor;
                    q.add(r); q.add(c);
                }
            }
        }
    return image;
    }
}
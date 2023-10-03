// Time Complexity :O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :
/*first we check if the image[sr][sc]==color if true then return image no need to change else as below */
/*used two queue bfs approach for each element having the orginal color ==image[][] replace with new color */
/*if replaced with new color add the element in row and col queue and check for them in all dirs
 * continue till the queue is empty
*/

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image==null||image.length==0||image[sr][sc]==color){
            return image;
        }
        int m=image.length;
        int n= image[0].length;
        Queue<Integer> row=new LinkedList<>();
        Queue<Integer> col=new LinkedList<>();
        int original_color=image[sr][sc];
        int[][] dirs={{-1,0},{1,0},{0,-1},{0,1}};//U D L R
        
        image[sr][sc]=color;
        row.add(sr);
        col.add(sc);
        while(!row.isEmpty()){
            int r=row.poll();
            int c=col.poll();
            for(int[] dir:dirs){
                int nr=r+dir[0];
                int nc=c+dir[1];
                if(nr>=0 && nr<m && nc>=0 && nc<n && image[nr][nc]==original_color){
                    image[nr][nc]=color;
                    row.add(nr);
                    col.add(nc);
                }
            }
        }
        return image;
    }
}
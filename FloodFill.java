/*
Desc : BFS is conducted by considering all the independent elements, while checking for nieghbors of current level elements,
if an orginal colour is found we change the colour to the new colour. This fashion is followed till the last level and the image array 
is returned back.
Time Complexity : O(mn)
Space Complexity : O(mn)
*/

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]==newColor || image==null ) return image;
        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        int color = image[sr][sc];
        image[sr][sc] = newColor;
        int dirs[][] = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int curr[] = q.poll();
            
            for(int dir[] : dirs){
                int r = dir[0]+curr[0];
                int c = dir[1]+curr[1];
                if(r>=0 && c>=0 && r<image.length && c<image[0].length && image[r][c]==color){
                    image[r][c] = newColor;
                    q.add(new int[]{r,c});
                }
            }
        }
        return image;
    }
}

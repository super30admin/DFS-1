//way1
//BFS
//Place first row and col in a queue
//Change it's color to new color before placing
//Move with dir array by popping the element out of queue
//If the resultant boundary have old color - place in queue and change it's color
//TC: O(m*n); SC:O(m*n)
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color){
            return image;
        }

        int m=image.length;
        int n=image[0].length;

        int old=image[sr][sc];

        Queue<int[]> queue=new LinkedList<>();
        int[][] dir=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        queue.add(new int[]{sr,sc});
        image[sr][sc]=color;

        while(!(queue.isEmpty())){
            int[] curr=queue.poll();
            
            for(int[] d:dir){
                int r=curr[0]+d[0];
                int c=curr[1]+d[1];

                if((r>=0 && r<m) && (c>=0 && c<n)){
                    if(image[r][c]==old){
                        image[r][c]=color;
                        queue.add(new int[]{r,c});
                    }
                }
            }
            

        }

        return image;
        
    }
}

//way2
//DFS
//Pass source row and col to helper method
//Helper method: if row and col are within bounds and if color of grid is old color - replace it with new color. And call the helper method recursively with it's boundaries.
//TC: O(m*n); SC:O(m*n)
class Solution {
    int[][] dir=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color){
            return image;
        }
        int old=image[sr][sc];

       helper(image,sr,sc,old,color);
        return image;
        
    }

    private void helper(int[][] image,int r, int c, int old, int newColor){
        //
        if(r<0 || c<0 || r==image.length || c==image[0].length || image[r][c]!=old){
            return;
        }

        //
        image[r][c]=newColor;
        for(int[] d:dir){
            int nr=r+d[0];
            int nc=c+d[1];

            helper(image,nr,nc,old,newColor);
        }

    }
}

//way3
//DFS
//Pass source row and col to helper method
//Helper method: if row and col are within bounds and if color of grid is old color - replace it with new color. And call the helper method recursively with it's boundaries.
//TC: O(m^2 * n^2); SC:O(m*n)
class Solution {
    int[][] dir=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color){
            return image;
        }
        int old=image[sr][sc];

       helper(image,sr,sc,old,color);
        return image;
        
    }

    private void helper(int[][] image,int r, int c, int old, int newColor){
        //
        if(r<0 || c<0 || r==image.length || c==image[0].length || image[r][c]!=old){
            return;
        }

        //
        image[r][c]=newColor;
        for(int[] d:dir){
            int nr=r+d[0];
            int nc=c+d[1];

            helper(image,nr,nc,old,newColor);
        }

    }
}

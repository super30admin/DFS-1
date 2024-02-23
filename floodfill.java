//TC: O(m*n)
//SC: O(m*n)
class Solution {
    int dirs[][]={{-1,0},{1,0},{0,1},{0,-1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color)
        return image;
        int  e_color=image[sr][sc]; 
        Queue<Integer> q= new LinkedList<>();
        q.add(sr);
        q.add(sc);
     image[sr][sc]=color;

        while(!q.isEmpty())
        {
            int cr=q.poll();
            int cc=q.poll();
            for(int[] dir:dirs)
            {
               int cr1=cr+dir[0];
               int cc1=cc+dir[1];
                if(cr1>=0&&cc1>=0&&cr1<image.length&&cc1<image[0].length&&image[cr1][cc1]==e_color)
                {
                   q.add(cr1);
                   q.add(cc1);
                    image[cr1][cc1]=color;
                }
            }
        }
return image;

        
    }
}
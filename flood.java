//time: O(n)
// space;O(n)    
class Solution {
    int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
    int n=0;
    int m=0;
    int color=0;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int n=image.length;
        if(image==null || n==0) return null;
        int m=image[0].length;
        color=image[sr][sc];
        if(color==newColor) return image;
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{sr,sc});
        // through bfs we are finding and changing to new color
        while(!queue.isEmpty())
        {
            int[] arr=queue.poll();
            int i=arr[0];
            int j=arr[1];
            //System.out.print(arr[0]+""+arr[1]);
            image[i][j]=newColor;
            for(int[] dir: dirs)
            {
                int r=i+dir[0];
                int c=j+dir[1];
                if(r>=0 && r<image.length && c>=0 && c<image[0].length && image[r][c]==color)
                {
                    queue.add(new int[]{r,c});
                }
            }
        }
        return image;
    }
   
}
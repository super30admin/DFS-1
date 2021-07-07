//Time Complexity:O(m*n)
//Space Complexity:O(m*n)

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image==null || image.length==0 || image[sr][sc]==newColor){
            return image;
        }
        Queue<int[]> q=new LinkedList();
        int color=image[sr][sc];
        q.add(new int[] {sr,sc});
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            int[] arr=q.poll();
            image[arr[0]][arr[1]]=newColor;
            for(int[] dir:dirs){
                int row=arr[0]+dir[0];
                int col=arr[1]+dir[1];
                if(row>=0 && col>=0 && row<image.length && col<image[0].length && image[row][col]==color){
                    q.add(new int[] {row,col});
                    image[row][col]=newColor;
                }
            }
        }
        return image;
    }
}
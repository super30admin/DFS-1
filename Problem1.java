class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> queue= new LinkedList<>();
        int m = image.length;
        int n= image[0].length;
        int[][] dirs= new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        int orgColor= image[sr][sc];
        if(image[sr][sc]== color) return image;
        queue.add(new int[]{sr,sc});
        image[sr][sc]=color;
        while(!queue.isEmpty()){
            int[] curr=queue.poll();
            for(int[] dir:dirs){
                int nr= curr[0]+dir[0];
                int nc= curr[1]+dir[1];
                if(nr>=0 && nr< m && nc >=0 && nc<n && image[nr][nc]==orgColor){
                    image[nr][nc]=color;
                    queue.add(new int[]{nr,nc});
                }
            }
        }
        return image;
    }
}
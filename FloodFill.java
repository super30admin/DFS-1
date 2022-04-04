class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        int originalColor = image[sr][sc];
        int[][] dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        if(originalColor==newColor) return image;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            if(image[curr[0]][curr[1]]==originalColor){
                image[curr[0]][curr[1]] = newColor;
                for(int[] dir : dirs){
                    if(curr[0]+dir[0]>=0 && curr[1]+dir[1]>=0 && curr[0]+dir[0] < image.length && curr[1]+dir[1] < image[curr[0]+dir[0]].length && image[curr[0]+dir[0]][curr[1]+dir[1]]==originalColor){
                        q.add(new int[]{curr[0]+dir[0],curr[1]+dir[1]});                        
                    }
                }
            }
        }
        return image;
    }
}

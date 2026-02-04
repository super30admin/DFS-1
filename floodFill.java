class Solution {
    int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        Queue<int[]> q = new LinkedList<>();
        int srcColor = image[sr][sc];

        q.add(new int[] {sr,sc});
        image[sr][sc] = color;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int currR = curr[0];
            int currC = curr[1];

            for(int[] dir : dirs){
                int newR = dir[0] + currR;
                int newC = dir[1] + currC;

                if(newR >=0 && newC >=0 && newR < image.length && newC < image[0].length && image[newR][newC] == srcColor){
                    image[newR][newC] = color;
                    q.offer(new int[] {newR, newC});
                }
            }

        }
    return image;
    }
}
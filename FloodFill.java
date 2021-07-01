/*   SC -o(M*N) 
 *   TC - O(M*N)
 *   */


class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor){return image;}

        int origColor = image[sr][sc];
        image[sr][sc] = newColor;
        // add the position of original color to queue and start exploringits enighbours from there
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr,sc});

        int m = image.length;
        int n = image[0].length;
        int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ; i < size; i++){
                int[] curr = queue.poll();
                for (int[] dir:dirs){
                    int nr = dir[0] + curr[0];
                    int nc = dir[1] + curr[1];
		    // for every legit neighbour, check if its of the same color , add the node to queue to process its children 
                    if (nr < m && nc < n && nr >= 0 && nc >=0 && image[nr][nc] == origColor){
                        image[nr][nc]= newColor;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }

        }
        return image;

    }
}

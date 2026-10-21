//Add the given element in queue and then poll the element , then add the directions to the element, the elements whose indexing are inbound and are same value are added to the queue and change it's value to 2. This is BFS

//Time complexity: O(M*N);
//Space Complexity: O(M*N);
// Problem got solved in leetcode perfectly

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<Integer> q = new LinkedList<>();
        int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        //base case
        if(image == null || image.length == 0) return image;
        //add to queue
        q.add(sr);
        q.add(sc);

        //original color
        int original = image[sr][sc];
        //if original colour == final colour
        if(image[sr][sc] == color) return image;

        image[sr][sc] = color;
        while(!q.isEmpty()){
            int r = q.poll();
            int c= q.poll();
            for(int[] dir: dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr >= 0 && nc >= 0 && nr < image.length
                        && nc < image[0].length && image[nr][nc] == original ){
                    q.add(nr);
                    q.add(nc);
                    image[nr][nc] = color;
                }
            }
        }

        return image;
    }
}
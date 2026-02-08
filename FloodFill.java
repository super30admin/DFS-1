
// Solution -1

// TimeComplexity: O(m*n);
// SpaceComplexity: O(m*n)
// Explanation: I traverse the image using DFS starting from the given cell. I color each cell and recursively visit its neighbors that have the original color. 
// This ensures all connected cells are updated exactly once.
class Solution {
    int[][] dirs = {{0,-1}, {0,1}, {1,0}, {-1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        dfs(sr,sc,image,color, image[sr][sc]);
        return image;     
    }

    private void dfs(int sr, int sc, int[][] image, int color,int initColor) {
        image[sr][sc] = color;
        for(int i =0; i<dirs.length; i ++) {
            int r = sr+ dirs[i][0];
            int c = sc+ dirs[i][1];
            if(r>=0 && r<image.length && c>=0 && c<image[0].length) {
                if(image[r][c] == initColor) {
                    image[r][c] = color;
                    dfs(r,c,image,color, initColor);
                }
            }
        }

    }
}



// Solution-2

// TimeComplexity: O(m*n);
// SpaceComplexity: O(m*n)
// Explanation: I traverse the image using BFS starting from the given cell. I color each cell and enqueue its neighbors with the original color. 
// This ensures all connected cells are updated efficiently, layer by layer.
// class Solution {
//     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//         if(image[sr][sc] == color) return image;
//         int[][] dirs = {{0,-1}, {0,1}, {1,0}, {-1,0}};
//         int initColor = image[sr][sc];
//         image[sr][sc] = color;
//         Queue<Integer> q = new LinkedList<>();
//         q.add(sr);
//         q.add(sc);
//         while(!q.isEmpty()) {
//             int currR = q.poll();
//             int currC = q.poll();
//             for(int i =0; i<dirs.length; i ++) {
//                 int r = currR+ dirs[i][0];
//                 int c = currC+ dirs[i][1];
//                 if(r>=0 && r<image.length && c>=0 && c<image[0].length) {
//                     if(image[r][c] == initColor) {
//                         image[r][c] = color;
//                         q.add(r);
//                         q.add(c);
//                     }
//                 }
//             }
//         }
//         return image;
        
//     }
// }

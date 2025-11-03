// 733. Flood Fill
// https://leetcode.com/problems/flood-fill/description/

// Solution 1 => BFS

/**
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */


class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int []> q = new LinkedList<>();

        int m = image.length;
        int n = image[0].length;

        int dirs[][] = new int[][]{ {1, 0},  {-1, 0}, {0, 1}, {0, -1} };

        // store originalImage to compare it with adjacent cells 
        int originalImage = image[sr][sc];


        // if original image is equal to color, there wont be any change in matrix
        if(originalImage == color){
            return image;
        }

        // add given image to q
        q.add(new int[] { sr, sc} );

        // process q till all images are converted to color
        while(!q.isEmpty()){

            int curr[] = q.poll();

            image[curr[0]][curr[1]] = color;

            for(int[] dir: dirs){
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];


                // Check if within bounds and adjacent image is equal to originalImage
                // if yes, update to color and add to q
                if(r >= 0 && c >= 0 && r < m && c < n && image[r][c] == originalImage){
                    q.add(new int[] {r, c});
                }
            }
        } 

        return image;  
    }
}

// Solution 2 => DFS

/**
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */

class Solution {
    int m;
    int n;
    int dirs[][];

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        dirs = new int[][]{ {1, 0},  {-1, 0}, {0, 1}, {0, -1} };

        m = image.length;
        n = image[0].length;

        int originalImage = image[sr][sc];

        if(originalImage == color){
            return image;
        }

        // start dfs from given image
        dfs(sr, sc, image, color, originalImage);

        return image;
    }

    private void dfs(int i, int j, int[][] image, int color, int originalImage){
        
        // logic

        // update given image with color
        image[i][j] = color;

        for(int [] dir: dirs){
            int r = i + dir[0];
            int c = j + dir[1];

            // check bounds and only give next dfs call if adjacent image is equal to original image
            if(r >= 0 && c >=0 && r < m && c < n && image[r][c] == originalImage){
                dfs(r, c, image, color, originalImage);
            }
        }

    }
}
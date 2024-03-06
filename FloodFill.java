//BFS approach
// Time Complexity : O(m*n), going over all the nodes
// Space Complexity : O(m*n), if all values need to be updated. then, apart from the first addition, at each level we will be adding 3 neighbours for each node. At the last level there will be (m*n)/3 ~ to m*n space.
// in the case if we start BFS from top left corner, space complexity would min(m,n)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : push all the neighbours with the same orgcolor in the queue, and then mark all neighbours as new color to avoid duplicated enteries
// before putting them in queue. Continue until all connected components are put in the queue.

class Solution {
    int[][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        Queue<Integer> q = new LinkedList<>();
        this.dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int orgColor = image[sr][sc];

        if(orgColor == color){
            return image;
        }
        image[sr][sc] = color; // to mark it visited.
        q.add(sr);
        q.add(sc);

        while(!q.isEmpty()){
            int r = q.poll();
            int c = q.poll();

            for(int[] dir : dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nc >= 0 && nr >= 0 && nr < m && nc < n && image[nr][nc] == orgColor){
                   // System.out.println("found");
                    image[nr][nc] = color; // to mark it visited.
                    q.add(nr);
                    q.add(nc);
                }
            }
        }

        return image;
    }
}

//DFS approach
// Time Complexity : O(m*n), going over all the nodes
// Space Complexity : O(m*n), we will be moving in all directions and if all values in the matrix need to be updated, at one point all neighbours will be in the stack.
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : for each neighbour recursively move in all directions, marking them visited along the way.


class Solution {
    int[][] dirs;
    int m;
    int n;
    int orgColor;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        m = image.length;
        n = image[0].length;
        Queue<Integer> q = new LinkedList<>();
        this.dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        this.orgColor = image[sr][sc];

        if (orgColor == color) {
            return image;
        }
        dfs(image, sr, sc, color);

        return image;
    }

    private void dfs(int[][] image, int r, int c, int color) {
        if (r < 0 || c < 0 || r == m || c == n || image[r][c] != orgColor) {
            return;
        }

        image[r][c] = color;
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            dfs(image, nr, nc, color);
        }
    }
}

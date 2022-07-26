//This problem can be solved by BFS or DFS. The problem represents the connected componenet structure. DFS gives better performance when the answer lies close to the root.

// Time Complexity: O(m*n).
//Space Complexity: O(m*n).


class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image.length == 0 || image[sr][sc] == color) return image;
        Queue<Integer> rows = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        
        int[][] dirs = {{-1, 0},{1, 0},{0, -1},{0, 1}}; //UP, DOWN, LEFT, RIGHT.
        int oldcolor = image[sr][sc];
        rows.add(sr);
        cols.add(sc);
        
        image[sr][sc] = color;
        while(!rows.isEmpty()){
            int currrow = rows.poll();
            int currcol = cols.poll();
            for(int[] dir : dirs){
                int newrow = currrow + dir[0];
                int newcol = currcol + dir[1];
            if(newrow >= 0 && newrow < image.length && newcol >= 0 && newcol < image[0].length && image[newrow][newcol] == oldcolor){
                rows.add(newrow);
                cols.add(newcol);
                image[newrow][newcol] = color;
              }
            }
        }
        
        return image;
    }
}


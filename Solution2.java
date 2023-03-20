// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * I created an inner class Coord with fields int i,int j (ith and jth index) and int step(Distance from nearest 0). I also maintain a visited
 * matrix which is initially set to false. I traverse through each element and add those elements to the queue for which mat[i][j] = 0 and set
 * visited[i][j] to true. Now I perform BFS and pop objects of the class from the queue and add neighbours which aren't visited to the queue 
 * with step as initial step+1. When each object is popped from the queue, I set mat[i][j] to step.
 */

 class Solution {
    class Coord
    {
        int i;
        int j;
        int step;

        Coord(int i,int j,int step)
        {
            this.i=i;
            this.j=j;
            this.step=step;
        }

    }
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int columns = mat[0].length;
        Queue<Coord> q = new LinkedList<>();
        boolean [][]visited = new boolean[rows][columns];
        int [][]dirs = {{1,0},{-1,0},{0,1},{0,-1}}; 
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<columns;j++)
            {
                if(mat[i][j]==0)
                {
                    Coord c = new Coord(i,j,0);
                    q.add(c);
                    visited[i][j]=true;
                }
            }
        }
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int k=0;k<size;k++)
            {
                Coord temp = q.poll();
                int r = temp.i;
                int c = temp.j;
                int step = temp.step;
                mat[r][c]=step;
                for(int dir[] : dirs)
                {
                    int i = r+dir[0];
                    int j = c+dir[1];
                    if(i>=0 && i<rows && j>=0 && j<columns && visited[i][j]==false)
                    {
                        visited[i][j]=true;
                        q.add(new Coord(i,j,step+1));
                    }
                }
            }
        }
        return mat;
    }
}
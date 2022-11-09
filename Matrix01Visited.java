package s30.DFS1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//BFS
// Time Complexity O(mn) traverse through all the elements
// Space Complexity O(mn)
public class Matrix01Visited {
    private int[][] directions = {
            {1,0},
            {0,1},
            {-1,0},
            {0,-1}
    };
    private boolean[][] visited;

    private boolean isVisited(int i, int j){
        return visited[i][j];
    }

    public int[][] updateMatrix(int[][] mat) {


        int  m = mat.length;
        int n = mat[0].length;
        visited = new boolean[m][n];

        Queue<Pair> q = new LinkedList();

        for(boolean[] row : visited){
            Arrays.fill(row,false);
        }



        for(int i = 0 ; i < m; i++){
            for(int j=0; j < n; j++){
                if(mat[i][j] == 0){
                    visited[i][j] = true;
                    q.add(new Pair(i,j));
                }
            }
        }

        // propagate distance from 0 to nearest 1 via levels
        int dist = 0;
        while(!q.isEmpty()){

            int size = q.size();

            while(size >0){
                Pair p = q.poll();
                mat[p.i][p.j] = dist;

                // adding neighbours
                for(int d[] : directions){
                    int tempI = p.i + d[0];
                    int tempJ = p.j + d[1];

                    if(tempI >=0
                            && tempI < m
                            && tempJ >= 0
                            && tempJ < n
                            && !isVisited(tempI, tempJ)){
                        q. add(new Pair(tempI, tempJ));
                        visited[tempI][tempJ] = true;
                    }
                }

                --size;
            }

            dist++;
        }

        return mat;
    }

    class Pair {
        int i;
        int j;

        Pair(int i, int j){
            this.i =i;
            this.j= j;
        }
    }
    public static void main(String[] args) {

    }
}

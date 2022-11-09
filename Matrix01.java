package s30.DFS1;

import java.util.LinkedList;
import java.util.Queue;

// BFS without visited array
// Time complexity O(mn) traversing through all elements
//Space Complexity O(mn) at max we'll have all the elements in the queue if matrix has all zeros
public class Matrix01 {

    private int[][] directions = {
            {1,0},
            {0,1},
            {-1,0},
            {0,-1}
    };

    public int[][] updateMatrix(int[][] mat) {


        int  m = mat.length;
        int n = mat[0].length;

        Queue<Pair> q = new LinkedList();

        for(int i = 0 ; i < m; i++){
            for(int j=0; j < n; j++){
                if(mat[i][j] == 0){
                    // visited[i][j] = true;
                    q.add(new Pair(i,j));
                }
                else mat[i][j] = -1;
            }
        }

        // propagate distance from 0 to nearest 1 via  BFS levels
        int dist = 0;
        while(!q.isEmpty()){

            int size = q.size();

            while(size >0){
                Pair p = q.poll();

                // adding neighbours
                for(int d[] : directions){
                    int tempI = p.i + d[0];
                    int tempJ = p.j + d[1];

                    if(tempI >=0
                            && tempI < m
                            && tempJ >= 0
                            && tempJ < n
                            && mat[tempI][tempJ] == -1){
                        q. add(new Pair(tempI, tempJ));
                        mat[tempI][tempJ] = dist+1;
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

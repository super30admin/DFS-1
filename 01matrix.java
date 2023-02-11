//T.C-O(r X c) 
//S.C- O(r x c)- used queue to store
import java.util.LinkedList;
import java.util.Queue;

class Node{
    int first, second, third;
    Node(int _first, int _second, int _third){
        this.first= _first;
        this.second= _second;
        this.third= _third;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int r= mat.length;
        int c= mat[0].length;
        int [][] visited= new int[r][c]; //make a visited array
        int [][] dist= new int[r][c]; //array to maintain distance
        Queue<Node> queue= new LinkedList<>(); //for bfs
        for(int i=0; i< r; i++){
            for(int j=0; j<c; j++){//wherever there is 0, bfs should start from there
                if(mat[i][j]==0){
                    visited[i][j]=1; //so mark as visited and add to node
                    queue.add(new Node(i,j,0));//(row,col),step
                }else{
                    visited[i][j]=0;
                }
            }
        }
        //System.out.print(queue);
        int []rowlist={-1,0,1,0}; //top->right->down->left
        int [] collist= {0,1,0,-1}; //top->right->down->left

        while(!queue.isEmpty()){
            int row= queue.peek().first;
            int col= queue.peek().second;
            int step= queue.peek().third;
            queue.remove();
            dist[row][col]= step; //add th step

            for(int i=0; i<4;i++){
                int nrow= row+ rowlist[i]; //move in all4 directions
                int ncol= col+ collist[i]; //check if it is out of bounds or not visited
                if(nrow>=0 && nrow <r && ncol>=0 && ncol<c && visited[nrow][ncol]==0){
                    visited[nrow][ncol]=1; //mark visited
                    queue.add(new Node(nrow, ncol, step+1)); //add to queue and plus the step
                }
            }

        }
        return dist;
    }
}
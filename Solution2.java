/*
    Time Complexity : O(rows * columns)
    Space Complexity : O(Math.min(rows, columns))
*/
class Solution {
    
    class Pair{
        int row;
        int col;
        int cost;
        
        Pair(int row, int col, int cost){
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }
    
    public int[][] updateMatrix(int[][] mat) {
        LinkedList<Pair> queue = new LinkedList<>();
        int[][] ans = new int[mat.length][mat[0].length];
        
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[i].length; j++){
                ans[i][j] = -1;
                if(mat[i][j]==0){
                    queue.addLast(new Pair(i, j, 0));
                    ans[i][j] = 0;
                }
            }
        }
        
        return bfs(mat, ans, queue);
    }
    
    public int[][] bfs(int[][] mat, int[][] ans, LinkedList<Pair> queue){
        while(queue.size() > 0){
            Pair rp = queue.removeFirst();
            // row , col - 1
            // row , col + 1
            // row - 1, col
            // row + 1, col
                if(rp.row >= 0 && rp.col - 1 >= 0 && rp.row <= ans.length-1 && rp.col - 1 <= ans[0].length - 1 && ans[rp.row][rp.col - 1]==-1){
                    if(mat[rp.row][rp.col - 1] == 1){
                        ans[rp.row][rp.col -1 ] = rp.cost + 1;
                        queue.addLast(new Pair(rp.row, rp.col - 1, rp.cost + 1));
                    }
                }
                
                if(rp.row >= 0 && rp.col + 1 >= 0 && rp.row <= ans.length-1 && rp.col + 1 <= ans[0].length - 1 && ans[rp.row][rp.col + 1]==-1){
                    if(mat[rp.row][rp.col + 1] == 1){
                        ans[rp.row][rp.col + 1] = rp.cost + 1;
                        queue.addLast(new Pair(rp.row, rp.col + 1, rp.cost + 1));
                    }
                }
                
                if(rp.row - 1 >= 0 && rp.col >= 0 && rp.row - 1 <= ans.length-1 && rp.col <= ans[0].length - 1 && ans[rp.row - 1][rp.col]==-1){
                    if(mat[rp.row - 1][rp.col] == 1){
                        ans[rp.row - 1][rp.col] = rp.cost + 1;
                        queue.addLast(new Pair(rp.row - 1, rp.col, rp.cost + 1));
                    }
                }
                
                if(rp.row + 1 >= 0 && rp.col >= 0 && rp.row + 1 <= ans.length-1 && rp.col <= ans[0].length - 1 && ans[rp.row + 1][rp.col]==-1){
                    if(mat[rp.row + 1][rp.col] == 1){
                        ans[rp.row + 1][rp.col] = rp.cost + 1;
                        queue.addLast(new Pair(rp.row + 1, rp.col, rp.cost + 1));
                    }
                }
            
        }
        
     return ans;
    }
}

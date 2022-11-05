// Approach : BFS
// Time Complexity : O(mn), we traverse through the whole grid once and then process each element in the grid one time
// Space Complexity : O(mn), worst case if all the elements are zeroes we add them all to the queues
public class Solution {
    public int[][] UpdateMatrix(int[][] mat) {
        Queue<Pair> q = new Queue<Pair>();
        int rows = mat.Length, cols = mat[0].Length;
        
        int[][] dirs = new int[4][]{
            new int[2]{0, 1},
            new int[2]{1, 0},
            new int[2]{0, -1},
            new int[2]{-1, 0}
        };
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(mat[i][j] == 0)
                {
                    q.Enqueue(new Pair(i, j));
                }else{
                    mat[i][j] = -1;
                }
            }
        }
        
        while(q.Count!=0){
            Queue<Pair> next = new Queue<Pair>();
            
            while(q.Count!=0){
                Pair p = q.Dequeue();
                for(int i=0; i<4; i++){
                    int nR = p.Row + dirs[i][0];
                    int nC = p.Col + dirs[i][1];
                    
                    if(nR>=0 && nR<rows && nC>=0 && nC<cols){
                        if(mat[nR][nC] == -1){
                            mat[nR][nC] = mat[p.Row][p.Col] + 1;
                            next.Enqueue(new Pair(nR,nC));
                        }
                    }
                }
            }
            
            q=next;
        }
        
        return mat;
    }
}

public class Pair{
    public int Row;
    public int Col;
    public Pair(int row, int col){
        Row = row;
        Col = col;
    }
}
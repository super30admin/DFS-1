// Approach : BFS. start from the source node and keep propagating the change to its neighbours level by level
// Time Complexity : O(mn) we go through each node once and process it
// Space Complexity : O(Min(m, n)) worst case our source node is at center and we propogate change around it level by level. the max size of the queue would be at 2*diagonal length and asymptoically O(diagonal length), which in turn is Min(m, n)

public class Solution {
    public int[][] FloodFill(int[][] image, int sr, int sc, int color) {
        
        int oldcolor = image[sr][sc];
        if(oldcolor == color) return image;
        
        int[][] dir = new int[4][]{
            new int[2]{0, 1},
            new int[2]{1, 0},
            new int[2]{-1, 0},
            new int[2]{0, -1}
        };
        
        image[sr][sc] = color;
        
        Queue<Pair> q = new Queue<Pair>();
        q.Enqueue(new Pair(sr,sc));
        
        while(q.Count!=0){
            Pair p = q.Dequeue();
            for(int i=0; i<4; i++){
                int nR = p.Row + dir[i][0];
                int nC = p.Col + dir[i][1];
                
                if(nR >= 0 && nC >=0 && nR<image.Length && nC < image[0].Length && image[nR][nC] == oldcolor){
                    image[nR][nC] = color;
                    q.Enqueue(new Pair(nR, nC));
                }
            }
        }
        
        return image;
    }
    
}
public class Pair {
    public int Row;
    public int Col;
    public Pair(int row, int col){
        Row = row;
        Col = col;
    }
}
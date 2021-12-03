// 733 Flood Fill
// Solved on leetcode
// Time Complexity : O(n)
// space complexity: O(n)

class Solution {
    
    class Pair{
        int i;
        int j;
        Pair(int i,int j){
            this.i=i;
            this.j=j;
        }
        
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue<Pair> queue = new LinkedList();
        
        if(image[sr][sc]== newColor){
            return image;
        }
        queue.add(new Pair(sr,sc));
        int existing= image[sr][sc];
        while(!queue.isEmpty()){
         
                Pair curr= queue.poll();
                
                image[curr.i][curr.j]= newColor;
                
                int [][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
                for(int [] view: directions){
                    int row= curr.i + view[0];
                    int col = curr.j+ view[1];
                    
                    if(row>=0 && col>=0 && row< image.length && col<image[0].length && image[row][col]==existing){
                                 queue.add(new Pair(row,col));
                    }
           }
        }
        return image;
    }
}
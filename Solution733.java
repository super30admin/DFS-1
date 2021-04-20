class Solution {
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image==null || image[sr][sc]==newColor|| image.length==0){
            return image;
        }
        
        Queue<Integer>q=new LinkedList<>();
        int m=image.length;
        int n=image[0].length;
        int oriCol=image[sr][sc];
        q.add(sr);
        q.add(sc);
        image[sr][sc]=newColor;
        
        
        int [][] dir={{0,1},{0,-1},{1,0},{-1,0}};
        
        while(!q.isEmpty()){
            int r=q.poll();
            int c=q.poll();
            for(int[] direc:dir){
                int cr = r + direc[0];
                
                int cc = c + direc[1];
                if(cr>=0 && cr<m && cc>=0 & cc<n && image[cr][cc]==oriCol&&image[cr][cc]!=newColor){
                    image[cr][cc]=newColor;
                    q.add(cr);
                    q.add(cc);
                }
            }
            
        }
        return image;
        
        
    }
}
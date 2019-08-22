class Solution {
    public void dfsFlood(int[][] image, int sr, int sc, int newColor, int val){

        if(sr<0 || sr>image.length-1 || sc<0 || sc>(image[0].length-1)) return;
        
        image[sr][sc] = newColor;
        
        if(sr>0 && image[sr-1][sc] == val) {
            image[sr-1][sc] = newColor; 
            dfsFlood(image, sr-1,sc,newColor, val);           
        }
        if(sr<image.length-1 && image[sr+1][sc] == val){
            image[sr+1][sc] = newColor;
            dfsFlood(image, sr+1, sc, newColor, val);           
        }
        if(sc>0 && image[sr][sc-1] == val){
            image[sr][sc-1] = newColor;
            dfsFlood(image, sr, sc-1, newColor, val);
        } 
        if(sc<image[0].length-1 && image[sr][sc+1] == val){          
            image[sr][sc+1] = newColor;  
            dfsFlood(image, sr, sc+1, newColor, val);            
        }                          
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(newColor == image[sr][sc]) return image;
        dfsFlood(image, sr, sc, newColor, image[sr][sc]);
        return image;
        
    }
}
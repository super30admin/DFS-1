/*
Time Complexity: Asymptotically O(n) as we are checking and returning back 4 times for the already colored element
Space Complexity: O(n)

*/
class Solution {
	void helper(int[][] image,int sr,int sc,int color,int original){
        // if(sr<0||sr>=image.length){
        //     return;
        // }
        // if(sc<0||sc>=image[0].length){
        //     return;
        // }
         if(image[sr][sc]!=original){
             return;
         }
         if(image[sr][sc]==original){
             image[sr][sc]=color;
         }
           
         if((sc-1)>=0){helper(image, sr,sc-1,color,original);}
         if((sr-1)>=0){helper(image,sr-1,sc,color,original);}
        if((sc+1)<image[0].length){helper(image,sr,sc+1,color,original);} 
         if((sr+1)<image.length){helper(image,sr+1,sc,color,original);}
     }
 
	public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        final int original=image[sr][sc];
        if(original==color){
            return image;
        }
        helper(image,sr,sc,color,original);
        return image;
	}
}

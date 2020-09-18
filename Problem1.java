
//Time: O(m*n)
//Space :(m*n)
// Steps - check when color not equal to new ccolor then go dfs and
// check boundary condition and if position has old color update with new and keep going in other 
//4 directions updating color
public class Problem1 {
	 public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
	        
	      if(image==null || image.length==0){
	          return null;
	      }
	        int color=image[sr][sc];
	        if(color!=newColor){
	             dfs(image,sr,sc,newColor,color);
	        }
	    return image;
	    }
	    
	    private void dfs(int[][] image,int i,int j,int nwcolor,int color){
	        if(i<0 || i>image.length-1 || j<0 || j>image[0].length-1){
	            return;
	        }
	        
	       if(image[i][j]==color){
	        image[i][j]=nwcolor;
	        dfs(image,i+1,j,nwcolor,color);
	        dfs(image,i-1,j,nwcolor,color);
	        dfs(image,i,j+1,nwcolor,color);
	        dfs(image,i,j-1,nwcolor,color);
	       }
	        
	        return;
	    }
}

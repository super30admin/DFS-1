import java.util.Arrays;
//Time Complexity : O(m*n)
//Space Complexity : O(m*n)
public class FloodFill {	
	int[][] dirs;
	/**Approach1: DFS**/	
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image==null || image[sr][sc]==newColor) return image;
        
        //DFS
        int m=image.length; int n= image[0].length;
        int color=image[sr][sc];
        dirs= new int[][] {{0,1},{1,0},{0,-1},{-1,0}};//right,down,left,up
        
        dfs(image,sr,sc,color,newColor,m,n);
        return image;
    }
    
    private void dfs(int[][] image, int i, int j, int color, int newColor, int m, int n){
        //base
        if(i<0 || j<0 || i>=m || j>=n || image[i][j] != color) return;
        
        //logic
        image[i][j]=newColor;   
        for(int[] dir : dirs){
            int r= i+dir[0];
            int c= j+dir[1];
            dfs(image,r,c,color,newColor,m,n);
        }        
    }
	
	
	/**Approach2: BFS**/	
    /*public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image==null || image[sr][sc]==newColor) return image;
        
        //BFS
        int m=image.length; int n= image[0].length;
        int color=image[sr][sc];
        dirs= new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
        Queue<int[]> q= new LinkedList<>();
        
        //color the start cell
        image[sr][sc]= newColor;
        q.add(new int[] {sr,sc});       
        
        //process neighbors
        while(!q.isEmpty()){
            int[] curr= q.poll();           
            for(int[] dir: dirs){
                int r= curr[0]+dir[0];
                int c= curr[1]+dir[1];
                
                if(r>=0 && c>=0 && r<m && c<n && image[r][c]==color){
                    image[r][c]=newColor;
                    q.add(new int[] {r,c});
                }
            }
        }        
        return image;
    }*/	
	    
	public static void main (String[] args) {
		FloodFill ob= new FloodFill();
		int[][] image= {{1,1,1},{1,1,0},{1,0,1}};
		int sr=1;
		int sc=1;
		int newcolor=2;
		ob.floodFill(image, sr, sc, newcolor);
		
		System.out.println("Filled Image : ");	
		for(int i=0; i<image.length; i++) {
			System.out.println(Arrays.toString(image[i]));
		}
	}
}

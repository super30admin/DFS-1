package DFS;

public class FloodFill {

	public static void main(String[] args) {
		int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
		int[][] modifiedImage = floodFill(image, 1, 1, 2);
		for(int i=0; i<image.length; i++) {
			for(int j=0; j<image[0].length; j++) {
				System.out.println(modifiedImage[i][j]);
			}
		}
	}
/**
 * Depth First Traversal
 * Time: O(N)
 * Space: O(N) Stack space used by recursive calls
 * Leetcode accepted: yes
 * Problems faced: NA
 */
	private static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		 int currColor = image[sr][sc];
		 	//If the color is same, the recursion never ends
	        if(currColor != newColor){
	             helper(image, sr, sc, newColor, currColor);
	        }
	     return image;
	}
	
	private static void helper(int[][] image, int sr, int sc, int newColor, int currColor){
        image[sr][sc] = newColor;
        //top
        if(sr > 0 && image[sr-1][sc] == currColor){
            helper(image, sr-1, sc, newColor, currColor);
        }
        //bottom
        if(sr < image.length-1 && image[sr+1][sc] == currColor) {
            helper(image, sr+1, sc, newColor, currColor);
        }
        //right
        if(sc < image[0].length-1 && image[sr][sc+1] == currColor) {
            helper(image, sr, sc+1, newColor, currColor);
        }
        //left
        if(sc > 0 && image[sr][sc-1] == currColor) {
            helper(image, sr, sc-1, newColor, currColor);
        }
    }

}

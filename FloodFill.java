// TC: O(N) since we are visiting every element in the 2D matrix in worst case.
// SC: O(N) for recursion stack

// We have the 2D matrix and we need to take the srcColor for the given indices in the matrix and update all the matrix elements with srcColor to the given newColor.
// We will be implementing it using DFS bacause we know that we need to traverse through the depth the matrix and find all the adjacent elements of a element.
// We traverse in all 4 directions and check if the matrix element is srcColor, if its srcColor, we udpate it to newColor. If there is some other than srcColor,
// we just ignore that matrix element and move for other adjacents cells in matrix


public class FloodFill {

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor){
		
		int srcColor = image[sr][sc];
		if(image[sr][sc]!=newColor) {
			dfs(image, sr, sc, newColor, srcColor);
		}
		return image;
	}
	
	public void dfs(int[][] image, int px, int py, int newColor, int srcColor) {
		
		if(px<0 || py<0 || px>=image.length || py >= image[0].length || image[px][py]!=srcColor)
			return;
		image[px][py] = newColor;
		
		dfs(image, px+1, py, newColor, srcColor);
		dfs(image, px-1, py, newColor, srcColor);
		dfs(image, px, py+1, newColor, srcColor);
		dfs(image, px, py-1, newColor, srcColor);
	}
	
	public static void main(String[] args) {
		
		FloodFill ff = new FloodFill();
		int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
		int[][] res = ff.floodFill(image, 1, 1, 2);
		for(int i=0;i<res.length;i++) {
			for(int j=0;j<image[0].length;j++) {
				System.out.print(res[i][j]+" ");
			}
			System.out.println();
		}
	}
}

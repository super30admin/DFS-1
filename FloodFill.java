//Approach - BFS
//Time Complexity - O(N) - size of the image, total no of pixels in the images
//Space Complexity - O(N) - worst case - queue size, total no of pixels in the images

class Solution {
  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

    if(image == null || image.length == 0 || image[sr][sc] == newColor){
      return image;
    }

    //     System.out.println("check:"+image[sr][sc]+" " +newColor);

    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{sr,sc});

    int color = image[sr][sc];
    image[sr][sc] = newColor;

    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    while(!queue.isEmpty()){
      int size = queue.size();

      for(int i=0; i<size; i++){
        int[] coord = queue.poll();

        for(int[] dir : dirs){

          int r = dir[0]+coord[0];
          int c = dir[1]+coord[1];

          if(r >=0 & r<image.length && c >=0 & c<image[0].length && image[r][c] == color){

            image[r][c] = newColor;
            queue.add(new int[]{r,c});
          }
        }
      }
    }

    return image;
  }
}



//Approach - DFS
//Time Complexity - O(N) - size of the image, total no of pixels in the images
//Space Complexity - O(N) - worst case - queue size, total no of pixels in the images


class Solution {
  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

    if(image == null || image.length == 0 || image[sr][sc] == newColor){
      return image;
    }
    int color = image[sr][sc];

    dfs(image, sr, sc, newColor, color);
    return image;
  }

  public void dfs(int[][] image, int sr, int sc, int newColor, int color){

    if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color)         {
      return;
    }

    image[sr][sc] = newColor;

    dfs(image, sr+1, sc, newColor, color);
    dfs(image, sr-1, sc, newColor, color);
    dfs(image, sr, sc+1, newColor, color);
    dfs(image, sr, sc-1, newColor, color);
  }
}
/*
BFS solution.
The time complexity is O(N) and the space complexity is O(N) where N is the number of pixels in the given array image.
Here we will be starting from the source pixel and take its value. Change it to newColor. Add its neighbours and move

Yes, the solution passed all the test cases in leet code.
 */

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        Queue<Integer> queue = new LinkedList<>();

        int[][] visited = new int[image.length][image[0].length];

        queue.add(sr); queue.add(sc);

        int startColor = image[sr][sc];

        image[sr][sc] = newColor; visited[sr][sc] = 1;

        while(queue.size()>0){
            int row = queue.poll();
            int col = queue.poll();

            if(row-1>=0 && image[row-1][col]==startColor && visited[row-1][col]==0){
                queue.add(row-1); queue.add(col);
                image[row-1][col]=newColor;
                visited[row-1][col]=1;

            }
            if(row+1<image.length && image[row+1][col]==startColor && visited[row+1][col]==0){
                queue.add(row+1); queue.add(col);
                image[row+1][col] = newColor;
                visited[row+1][col]=1;
            }
            if(col-1>=0 && image[row][col-1]==startColor && visited[row][col-1]==0){
                queue.add(row); queue.add(col-1);
                image[row][col-1]=newColor;
                visited[row][col-1]=1;
            }
            if(col+1<image[0].length && image[row][col+1]==startColor && visited[row][col+1]==0){
                queue.add(row); queue.add(col+1);
                image[row][col+1]=newColor;
                visited[row][col+1]=1;
            }
        }

        return image;
    }
}

/*
DFS solution
The time complexity is O(N) and the space complexity is O(N)
Here we use recursion where we add the present node to the stack, explore one of its unprocessed neighbour and its neighbours

Yes, the solution passed all the test cases in leet code.
 */
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]!=newColor){
            dfs(sr,sc,image,image[sr][sc],newColor);
        }
        return image;
    }

    public void dfs(int row, int col, int[][] image, int startColor,int newColor){
        if(image[row][col]!=startColor){return;}

        image[row][col]=newColor;

        if(row-1>=0){
            dfs(row-1,col,image,startColor,newColor);
        }
        if(row+1<image.length){
            dfs(row+1,col,image,startColor,newColor);
        }
        if(col-1>=0){
            dfs(row,col-1,image,startColor,newColor);
        }
        if(col+1<image[0].length){
            dfs(row,col+1,image,startColor,newColor);
        }

        return;
    }
}
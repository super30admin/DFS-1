// Time Complexity : O(m*n) where m*n is the size of image, no of pixels
// Space Complexity : O(m*n) where m*n is the size of image, no of pixels
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.*;

class FloodFill {
    List<int[]> directions = Arrays.asList(
            new int[]{+1,0},
            new int[]{-1,0},
            new int[]{0,+1},
            new int[]{0,-1}
    );

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue <int[]> queue = new LinkedList<>();
        int target = image[sr][sc];
        if(target == newColor) return image;
        queue.add(new int[]{sr,sc});
        //int[][] visited = new int[image.length][image[0].length];

        while(!queue.isEmpty()){
            int[] node = queue.poll();
            image[node[0]][node[1]]=newColor;
            //visited[node[0]][node[1]]=-1;

            for(int[] direction : directions){
                int newr = node[0]+direction[0];
                int newc = node[1]+direction[1];

                if(newr<0 || newc<0 || newr>=image.length || newc>=image[0].length || image[newr][newc]!=target /*|| visited[newr][newc]==-1*/){
                    continue;
                }
                else{
                    queue.add(new int[]{newr,newc});
                }
            }
        }

        return image;
    }

    public static void main(String[] args){
        FloodFill ff = new FloodFill();
        int [][] image = new int[][]{{1,1,1},{1,1,0},{1,0,1}};
        System.out.println(Arrays.deepToString(ff.floodFill(image, 1, 1, 2)));
    }
}
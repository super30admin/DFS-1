package DFS1;

import java.util.LinkedList;
import java.util.Queue;
/**
 * 
 * Initially we find the given cell and then we keep doing BFS (ie keep going to neighbour and then  neighbour's neighbour
 * and so on) to spread the color.
 * 
 * Time Complexity : O(mn) where m is no of rows and n is cols
 * 
 * 
 * Space Complexity : O(mn) since we use a queue
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 */
public class Problem1 {
    int [][]dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<Integer []> q=new LinkedList<>();
        if(image[sr][sc]==color)
            return image;
        int reqColor=image[sr][sc];
        q.add(new Integer[]{sr,sc});
        image[sr][sc]=color;

        while(!q.isEmpty()){
                Integer []curr=q.poll();
                for(int i=0;i<dirs.length;i++){
                    Integer targetRow=curr[0]+dirs[i][0];
                    Integer targetCol=curr[1]+dirs[i][1];

                    if(targetRow>=0 && targetRow<image.length && targetCol>=0 &&
                    targetCol < image[0].length && image[targetRow][targetCol]==reqColor){
                        q.add(new Integer[]{targetRow,targetCol});
                        image[targetRow][targetCol]= color;
                    }
            }
        }
        return image;
    }

}

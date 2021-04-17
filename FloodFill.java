   /**
     *
     *  Time Complexity: O(M*N) Where N is the number of rows and M is number of columns.
     *  Space Complexity: O(M*N) Where N is the number of rows and M is number of columns.
     *
     *  Did this code successfully run on Leetcode : Yes
     *  Any problem you faced while coding this : None
     *
     *  Explanation: We can solve this problem with either DFS or BFS approach. In BFS we add the given index to a queue. While the queue is not empty, we poll the element in the queue and change the color of the element to the new color, we also check if its neighbours also have the original colors, if so we add that to the queue. We repeat this till there are no neighbours with the original color.
     */
class Solution {
    //BFS:
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image==null || image.length==0 || image[sr][sc]==newColor){
            return image;
        }
        Queue<Integer[]> queue = new LinkedList<>();
        Integer[] arr=new Integer[]{sr,sc}; 
        int orgColor = image[sr][sc];
        int dir[][]=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        queue.offer(arr);
        while(!queue.isEmpty()){
            Integer[] currIdx = queue.poll();
            image[currIdx[0]][currIdx[1]]=newColor;
                for(int[] d: dir){
                    int newR = currIdx[0]+d[0], newC= currIdx[1]+d[1];
                    if(newR>=0 && newR<image.length && newC>=0 && newC<image[0].length && image[newR][newC]==orgColor){
                        queue.offer(new Integer[]{newR, newC});
                    }
                }    
        }
        return image;
    }
    
    // DFS:
//     public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
//         if(image==null || image.length==0 || image[sr][sc]==newColor) return image;
//         dfs(image, image[sr][sc], newColor, sr, sc);
//         return image;
//     }
    
//     private void dfs(int[][] image, int orgColor, int newColor, int newR, int newC){
//         if(newR<0 || newR>=image.length || newC<0 || newC>=image[0].length || image[newR][newC]!=orgColor){
//             return;
//         }
//         int dir[][]=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
//         image[newR][newC]=newColor;
//         for(int[] d: dir){
//             int r = newR+d[0];
//             int c = newC+d[1];
//             dfs(image, orgColor, newColor, r, c);
//         }
        
//     }
}

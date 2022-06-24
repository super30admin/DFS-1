// Time Complexity: O(m*n)
// Space Complexity: O(m*n)
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color) return image;
        if(image==null) return null;
        int [][]dirs = new int [][]{{-1,0},{1,0},{0,-1},{0,1}};
        int orig = image[sr][sc];
        Queue<int []> q = new LinkedList<>();
        image[sr][sc]=color;
        q.add(new int []{sr,sc});
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int []curr = q.poll();
                for(int []dir : dirs){
                    int a = curr[0]+dir[0];
                    int b = curr[1]+dir[1];
                        if(a>=0 && b>=0 && a<image.length && b<image[0].length && image[a][b]==orig){
                        image[a][b]=color;
                        q.add(new int[]{a,b});
                    }
                }
            }
        }
        return image;
    }
}

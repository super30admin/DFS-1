// TC: O(mxn)
// SC: O(mxn)

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newcolor) {
        if(image==null || image[sr][sc]==newcolor) return image;

        int m=image.length;
        int n= image[0].length;
        int [][]dirs=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};

        int color= image[sr][sc];
        Queue<Integer> q= new LinkedList<>();
        q.add(sr);
        q.add(sc);
        image[sr][sc]=newcolor;

        //logic
        while(!q.isEmpty()){
            int cr=q.poll();
            int cc=q.poll();

            for(int []dir:dirs){
                int nr= dir[0]+cr;
                int nc= dir[1]+cc;

                //bound check
                if(nr>=0 && nc>=0 && nr<m && nc <n && image[nr][nc]==color){
                    q.add(nr);
                    q.add(nc);
                    image[nr][nc]=newcolor;
                }
            }
        }return image;
    }
}
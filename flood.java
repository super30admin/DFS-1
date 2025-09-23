class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image==null||image.length==0||image[sr][sc]==color){
            return image;
        }
        int[][] dirs={{-1,0},{0,1},{1,0},{0,-1}};
        int m=image.length;
        int n=image[0].length;
        Queue<Integer>r=new LinkedList<>();
        Queue<Integer>c=new LinkedList<>();
        int old=image[sr][sc];
        r.add(sr);
        c.add(sc);
        image[sr][sc]=color;
        while(!r.isEmpty()){
            int row=r.poll();
            int col=c.poll();
            for(int[] dir:dirs){
                int nr=row+dir[0];
                int nc=col+dir[1];
                if(nr>=0&&nr<m&&nc>=0&&nc<n&&image[nr][nc]==old){
                    r.add(nr);
                    c.add(nc);
                    image[nr][nc]=color;
                }
            }

        }
 return image;       
    }
}
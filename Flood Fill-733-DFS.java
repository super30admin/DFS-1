class Solution {
    // Time Complexity: O(m*n)
    //Space Complexity: O(m+n) 
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image==null || image.length==0 || image[sr][sc]==color)
        {
            return image;
        }

        int main_val = image[sr][sc];
        image[sr][sc] = color;
        Queue<Integer> row = new  LinkedList<Integer>();
        Queue<Integer> col = new  LinkedList<Integer>();
        int rowLength = image.length-1;
        int colLength = image[0].length-1;
        int[][] dirs = {{-1,0},{+1,0},{0,+1},{0,-1}};
        row.add(sr);
        col.add(sc);
        while(!(row.isEmpty() && col.isEmpty()))
        { 
                int rowMain = row.remove();
                int colMain = col.remove();
                for(int[]dir: dirs)
                {
                    int row1 = rowMain+dir[0];
                    int col1 = colMain+dir[1];
                    if(row1>=0 && row1<=rowLength && col1>=0 && col1<=colLength 
                && image[row1][col1]==main_val)
                {
                     image[row1][col1] = color;
                       row.add(row1);
                       col.add(col1);
                }
                }
                // if(row1-1>=0 && row1-1<=rowLength && col1>=0 && col1<=colLength 
                // && image[row1-1][col1]==main_val)
                //    {
                //        image[row1-1][col1] = color;
                //        row.add(row1-1);
                //        col.add(col1);
                //    }

                //     if(row1+1>=0 && row1+1<=rowLength && col1>=0 && col1<=colLength && image[row1+1][col1]==main_val)
                //    {
                //        image[row1+1][col1] = color;
                //        row.add(row1+1);
                //        col.add(col1);
                //    }

                //    if(row1>=0 && row1<=rowLength && col1+1>=0 && col1+1<=colLength && image[row1][col1+1]==main_val)
                //    {
                //        image[row1][col1+1] = color;
                //        row.add(row1);
                //        col.add(col1+1);
                //    }

                //    if(row1>=0 && row1<=rowLength && col1-1>=0 && col1-1<=colLength && image[row1][col1-1]==main_val)
                //    {
                //        image[row1][col1-1] = color;
                //        row.add(row1);
                //        col.add(col1-1);
                //    }
        }
       return image; 
        
    }
}

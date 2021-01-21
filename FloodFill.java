// Time Complexity : The time complexity is O(m*n) where m is the number of rows and n is the number of columns
// Space Complexity : The space complexity is O(m*n) where m is the number of rows and n is the number of columns
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        if(image == null || image[0] == null){
            return image;
        }

        int val = image[sr][sc];

        if(val == newColor){
            return image;
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(sr);
        q.offer(sc);
        image[sr][sc] = newColor;

        int rows = image.length;
        int columns = image[0].length;

        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};

        while(!q.isEmpty()){

            int row = q.poll();
            int column = q.poll();

            for(int i=0;i<dir.length;i++){

                int newRow = row + dir[i][0];
                int newColumn = column + dir[i][1];

                // replace the values in the same that are same as starting pixel with new color
                if(newRow >=0 && newRow < rows && newColumn >=0 && newColumn < columns && image[newRow][newColumn] == val){
                    q.offer(newRow);
                    q.offer(newColumn);
                    image[newRow][newColumn] = newColor;
                }
            }
        }

        return image;

    }
}
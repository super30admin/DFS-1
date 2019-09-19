// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// Approach: Traverse from source in BFS fashion, 
// until queue is empty, pop out first node
// if node's value is equal to source val, update the value to source value
// if a child(out of 4 children of the parent) is 
//  1.within the matrix range,
//  2. not visited 
//  3. has value equal to source val, 
// then add child to queue and mark as visited.

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        return bfs(image,sr,sc,newColor);
    }
    public int[][] bfs(int[][] image, int sr, int sc, int newColor){
        boolean[][] visited = new boolean[image.length][image[0].length];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(sr,sc));
        visited[sr][sc]=true;
        int sourceVal=image[sr][sc];
        int[] a = new int[]{-1,0,1,0};
        int[] b = new int[]{0,1,0,-1};
            
        while(!q.isEmpty()){
            Point p = q.poll();
            if(image[p.x][p.y]==sourceVal){
                image[p.x][p.y]=newColor;
                
                for(int i=0;i<a.length;i++){
                    int childX = p.x + a[i];
                    int childY = p.y + b[i];
                    if(isValid(childX, childY, visited, image.length, image[0].length, image, sourceVal)){
                        q.add(new Point(childX, childY));
                        visited[childX][childY]=true;
                    }
                }
            }
        }
        return image;
    }
    public boolean isValid(int childX, int childY, boolean[][] visited, int R, int C, int[][] image, int sourceVal){
        if(0<=childX && childX<R && 0<=childY && childY<C && visited[childX][childY]==false && image[childX][childY]==sourceVal){
            return true;
        }
        return false;
    }
}

class Point {
    int x;
    int y;
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}

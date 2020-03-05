// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//SOLUTION ITERATIVELY
class Solution {  
    int[] dx ={-1,0,1,0};
   int[] dy ={0,1,0,-1};
public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
   //SOLUTION RECURSIVELY
   if(image ==null || image.length==0)return image;
         int m=image.length;
    int n=image[0].length;
if(image[sr][sc] ==newColor) return image;
 int srcColor=image[sr][sc];
Queue<Pair> queue =new LinkedList<>();
   queue.add(new Pair(sr,sc));
   image[sr][sc]=newColor;
   
   while(!queue.isEmpty()){
       int count=queue.size();
       for(int k=0;k<count;k++){
        Pair cell = queue.poll();
   for(int i=0;i<4;i++){
       int x=cell.x+dx[i];
       int y=cell.y+dy[i];
       if(x<m && x>=0 && y<n && y>=0 && image[x][y]==srcColor)
       {
       image[x][y] =newColor;
           queue.add(new Pair(x,y));
       }  
        
   }
       }
   }
return image;
}
}
class Pair{
int x,y;
Pair(int x,int y){
    this.x=x;
    this.y=y;
}
}

//SOLUTION RECURSIVELY
// class Solution {

//          int[] dx ={-1,0,1,0};
//         int[] dy ={0,1,0,-1};
//     public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
//         
//         if(image ==null || image.length==0)return image;

//   int srcColor = image[sr][sc];
//            if(srcColor ==newColor) return image;
//      dfs(image,sr,sc,newColor,srcColor);
//     return image;
//     }
//     private void dfs(int[][] image, int sr, int sc, int newColor,int srcColor){
//         image[sr][sc]=newColor;
//            int m=image.length;
//         int n=image[0].length;
//        Pair cell = new Pair(sr,sc);
//         for(int i=0;i<4;i++){
//             int x=cell.x+dx[i];
//             int y=cell.y+dy[i];
       
//             if(x<m &&x >=0 && y<n && y>=0 && image[x][y]==srcColor)
//             {
//                 dfs(image,x,y,newColor,srcColor);
//             }
//         }

//     }
// }
//  class Pair{
//      int x,y;
//      Pair(int x,int y){
//          this.x=x;
//          this.y=y;
//      }
//  }
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//BFS

 func floodFill(image [][]int, sr int, sc int, color int) [][]int {
     if len(image) == 0 ||  image[sr][sc] == color{
      
         return image
     }
  
     m := len(image)
     n := len(image[0])
  
     //2 queue soln - 1 queue for row & 1 queue for col
  
     rows := []int{}
     cols := []int{}
  
     dirs := [][]int{{-1,0},{1,0},{0,-1},{0,1}} //UDLR
  
     old_color := image[sr][sc]
  
     rows = append(rows,sr)
     cols = append(cols,sc)
  
     image[sr][sc] = color
  
     for len(rows) > 0{
         row := rows[0]
         rows = rows[1:]
      
         col := cols[0]
         cols = cols[1:]
      
         for _,dir := range dirs{
             nr := row + dir[0]
             nc := col + dir[1]
             if nr >= 0 && nc >= 0 && nr<m && nc<n && image[nr][nc] == old_color{
                 image[nr][nc] = color
                 rows = append(rows,nr)
                 cols = append(cols,nc)
             }
         }
     }
  
     return image
  
 }


//DFS

var m int
var n int
//var Image [][]int

func floodFill(image [][]int, sr int, sc int, color int) [][]int {
    if len(image) == 0 ||  image[sr][sc] == color{
        
        return image
    }
    m = len(image)
    n = len(image[0])
    
    old_color := image[sr][sc]
    
    dfs(image,sr,sc,color,old_color)
    fmt.Println(image)
    return image
}

func dfs( image [][]int, sr,sc,color,old_color int){
    //base
    if sr < 0 || sc < 0 || sr==m || sc==n || image[sr][sc] != old_color{
        return
     }
    
    
    //logic
    image[sr][sc] = color
    
    dirs := [][]int{{-1,0},{1,0},{0,-1},{0,1}}
    for _,dir := range dirs{
        nr := sr + dir[0]
        nc := sc + dir[1]
        dfs(image,nr,nc,color,old_color)
    }
    
    return
}

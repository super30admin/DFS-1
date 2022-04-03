
/*
    Connected components  == BFS/DFS
    - We need starting point(s) -- all independant nodes 
    There is a domino effect of changing 1 cell color to new color 
    """
        plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, 
        plus any pixels connected 4-directionally to those pixels (also with the same color), and so on.
    """
    
    approach : using BFS
    - We are given a starting point ( sr, sc )
    - Enqueue that starting
    - Save the color we are changing from ( oldColor, so we can compare with its neighbors )
    - Change the sr,sc to new color
    - Start processing the queue
    - As soon as we add an item to our queue, we will change the color right away to newColor
    - So that we do not visit this node again
    - if we are not allowed to modify the matrix ( save the visited poins in a set )
    time: o(mn)
    space: o(mn) - for the queue
    
    approach: DFS is also possible
    - Deploy a DFS in each neighbor and use base case to handle exits.
    

*/


// using level order with BFS
// func floodFill(image [][]int, sr int, sc int, newColor int) [][]int {
    
//     if image == nil || len(image) == 0 {
//         return image
//     }
//     oldColor := image[sr][sc]
    
//     if oldColor != newColor {
//         queue := [][]int{ {sr,sc} } // [ [r,c] ]
//         dirs := [][]int{ {1,0},{-1,0},{0,1},{0,-1} }
//         image[sr][sc] = newColor
//         m := len(image)
//         n := len(image[0])

//         for len(queue) != 0 {
//             dq := queue[0]
//             queue = queue[1:]

//             for _, dir := range dirs {
//                 r := dq[0] + dir[0]
//                 c := dq[1] + dir[1]
//                 if r >= 0 && r < m && c >= 0 && c < n && image[r][c] == oldColor {
//                     image[r][c] = newColor
//                     queue = append(queue, []int{r,c})
//                 }
//             }
//         }
//     }
    
//     return image
// }

func floodFill(image [][]int, sr int, sc int, newColor int) [][]int {
    if image == nil {return image}
    if image[sr][sc] == newColor {return image}
    m := len(image)
    n := len(image[0])
    o := image[sr][sc]
    var dfs func(grid [][]int, r, c, oldColor, newColor int)
    dfs = func(grid [][]int, r, c, oldColor, nc int) {
        
        // base
        if r < 0 || r >= m || c < 0 || c >= n || grid[r][c] != oldColor || grid[r][c] == nc {
            return
        }
        
        
        //logic
        grid[r][c] = nc
        dfs(grid, r+1,c,oldColor,nc)
        dfs(grid, r-1,c,oldColor,nc)
        dfs(grid, r,c+1,oldColor,nc)
        dfs(grid, r,c-1,oldColor,nc)
        
    }
    dfs(image, sr,sc,o,newColor)
    return image
}

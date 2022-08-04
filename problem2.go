// Time Complexity : O(mxn)
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
func updateMatrix(mat [][]int) [][]int {
    if len(mat) == 0{
        return [][]int{}
    }
    
    m := len(mat)
    n := len(mat[0])
    
    q := [][]int{}

    dirs := [][]int{{-1,0},{1,0},{0,-1},{0,1}} //UDLR
    
    for i:=0; i<m;i++{
        for j:=0;j<n;j++{
            if mat[i][j] == 0{
                q = append(q,[]int{i,j})
            }else{
                 mat[i][j] = -1
            }

        }
    }
    
    for len(q) > 0{
        curr := q[0]
        q = q[1:]
        for _,dir := range dirs{
            nr := dir[0] + curr[0]
            nc := dir[1] + curr[1]
            if nr >= 0 && nc >= 0 && nr<m && nc<n && mat[nr][nc] == -1{
                q = append(q,[]int{nr,nc})
                mat[nr][nc] = mat[curr[0]][curr[1]] + 1
            }
        }
    }
    
    return mat
}

// ## Problem2 (https://leetcode.com/problems/01-matrix/)


// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : understanding the trick that going from 0 to 1 rather than 1 to 0 was hard
//!PENDING DFS approach
// https://www.youtube.com/watch?v=uO4RjFV915Y&ab_channel=%7BS30%7D
//Time Stamp for DFS 56:00
var updateMatrix = function(mat) {
    // Time Complexity : O(N∗M)
    // Space Complexity : O(N∗M)
    let n = mat.length
    let m = mat[0].length
    let direction = [[1,0],[-1,0],[0,1],[0,-1]]

    let queue = []
    
    for(let i =0;i<n;i++){
        for(let j =0;j<m;j++){
            if(mat[i][j] === 0){
            queue.push([i,j])
            } 
            else{
                mat[i][j] = -1
            
        }
    }
    }
    console.log(mat)
    while(queue.length){
        let [r,c] = queue.shift()
        for(let [dr,dc] of direction){
            let nr = r+dr
            let nc = c+dc
            if(
                nr >= 0 && nr < n && nc >=0 && nc < m && mat[nr][nc] == -1
            ){
                mat[nr][nc] = mat[r][c] + 1
                queue.push([nr,nc])
            }
        }
    }
    return mat
};
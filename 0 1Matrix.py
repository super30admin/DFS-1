#Time Complexity: O(m*n)
#Space Complexity: O(m*n)
#Successfully ran on leetcode

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        if len(mat)==0:
            return mat
        queue = []
        rows = len(mat)
        cols = len(mat[0])
        for i in range(rows):
            for j in range(cols):
                if mat[i][j]==0:
                    queue.append([i,j])
                else:
                    mat[i][j]=-1
        dirs = [[-1,0],[1,0],[0,-1],[0,1]]
        while queue:
            curr = queue.pop(0)
            for i in dirs:
                row = curr[0]+i[0]
                col = curr[1]+i[1]
                if row>=0 and row<rows and col>=0 and col<cols and mat[row][col]==-1:
                    mat[row][col]=mat[curr[0]][curr[1]]+1
                    queue.append([row,col])
        return mat


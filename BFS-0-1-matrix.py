
# // Time Complexity : O(m*n)
# // Space Complexity :O(m*n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this 
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        if mat == None or len(mat) == 0:
            return mat
        m = len(mat)
        n = len(mat[0])
        queue = list()
        dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        for i in range(m):
            for j in range(n):
                if (mat[i][j] == 0):
                    queue.append([i,j])
                else:
                    mat[i][j] = -1
        
        dist = 1
        while queue:
            size = len(queue)
            for i in range(size):
                curr = queue.pop(0)
                for direction in dirs:
                    nr = curr[0] + direction[0]
                    nc = curr[1] + direction[1]
                    if nr >= 0 and nc >= 0 and nr < m and nc < n and mat[nr][nc] == -1:
                        queue.append([nr,nc])
                        mat[nr][nc] = dist
            dist += 1
        return mat
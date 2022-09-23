#Time: O(n)
#Space: O(n)
#Program ran on leetcode successfully

class Solution(object):
    def updateMatrix(self, mat):
        """
        :type mat: List[List[int]]
        :rtype: List[List[int]]
        """
        if mat is None:
            return
        queue = []
        row_len = len(mat)
        col_len = len(mat[0])
        dirs=[[0, 1], [-1, 0], [0, -1], [1, 0]]
        
        for i in range(row_len):
            for j in range(col_len):
                if mat[i][j] == 0:
                    queue.append([i, j])
                else:
                    mat[i][j] = -1
        
        while queue:
            curr = queue.pop(0)
            for dir in dirs:
                nr = curr[0] + dir[0]
                nc = curr[1] + dir[1]
                
                if (nr >= 0 and nc >= 0 and nr < row_len and nc < col_len and mat[nr][nc] == -1):
                    mat[nr][nc] = mat[curr[0]][curr[1]] + 1
                    queue.append([nr, nc])
        
        return mat
from typing import List
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        if mat == None or len(mat) == 0:
            return mat
        
        m = len(mat)
        n = len(mat[0])
        q = []
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.append([i,j])
                else:
                    mat[i][j] = -1
        
        
        dirs = [[1,0], [-1,0], [0,1], [0,-1]]

        # dist = 1
        # while len(q) != 0:
        #     size = len(q)
        #     for i in range(size):
        #         curr = q.pop(0)
        #         for direx in dirs:
        #             r = curr[0] + direx[0]
        #             c = curr[1] + direx[1]
        #             if r >= 0 and c >= 0 and r < m and c < n and mat[r][c] == -1:
        #                 q.append([r,c])
        #                 mat[r][c] = dist
        #     dist += 1

        while len(q) != 0:
            curr = q.pop(0)
            for direx in dirs:
                r = curr[0] + direx[0]
                c = curr[1] + direx[1]
                if r >= 0 and c >= 0 and r < m and c < n and mat[r][c] == -1:
                    q.append([r,c])
                    mat[r][c] = mat[curr[0]][curr[1]] + 1   
        return mat

obj = Solution()
print(obj.updateMatrix([[0,0,0],[0,1,0],[0,0,0]]))
print(obj.updateMatrix([[0,0,0],[0,1,0],[1,1,1]]))

# Time Complexity : O( m * n) where m = rows and n = columns
# Space Complexity : O( m * n) where m = rows and n = columns
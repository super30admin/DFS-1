# Problem2 (https://leetcode.com/problems/01-matrix/)


# Time Complexity : O(mn)
# Space Complexity : O(mn)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach


class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m = len(mat)
        n = len(mat[0])
        q = deque()
        dirs = [[-1,0],[1,0],[0,-1],[0,1]]

        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.append([i,j])
                else:
                    mat[i][j] = -1
        

        dist = 1
        while q:
            len_q = len(q)
            for i in range(len_q):
                curr = q.popleft()
                for d in dirs:
                    nr = curr[0] + d[0]
                    nc = curr[1] + d[1]
                    if (nr >= 0 and nr < m and nc >= 0 and nc < n and mat[nr][nc] == -1):
                        mat[nr][nc] = dist
                        q.append([nr,nc])
            dist +=1
        
        return mat


        



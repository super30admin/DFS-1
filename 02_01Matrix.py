#appraoch 1 : BFS
# https://leetcode.com/problems/flood-fill
# // Time Complexity : O(m x n), because we visit each element atleast once
# // Space Complexity : O(m x n) because we can add all elements to stack at intial if they are all zero
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        q = collections.deque()
        directions = [[1,0], [-1,0], [0,1], [0,-1]]
        m = len(mat)
        n = len(mat[0])

        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.append([i,j])
                else:
                    mat[i][j] = -1

        distance = 1
        
        while(q):
            size = len(q)
            while(size > 0):
                i,j = q.popleft()
                for r, c in directions:
                    newR = i+r
                    newC = j+c
                    if (0<= newR< m and 0<=newC< n) and (mat[newR][newC] == -1):
                        mat[newR][newC] = distance
                        q.append([newR, newC])
                size -= 1
            distance += 1

        return mat
                
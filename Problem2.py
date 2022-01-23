# // Time Complexity : O(nm) where n and m are the size of the matrix.
# // Space Complexity : O(nm) where n and m are the size of the matrix.
# // Did this code successfully run on Leetcode : Yes.
# // Any problem you faced while coding this : Yes.

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m = len(mat)
        n = len(mat[0])
        dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        queue = deque()
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    queue.append([i,j])
                else:
                    mat[i][j] = -1
        d = 1
        while(len(queue) != 0):
            for i in range(len(queue)):
                x,y = queue.popleft()
                for i in range(len(dirs)):
                    x1 = x+ dirs[i][0]
                    y1 = y + dirs[i][1]
                    if x1 >= 0 and y1 >=0 and x1<m and y1<n and mat[x1][y1] == -1:
                        mat[x1][y1] = d
                        queue.append([x1,y1])
            d += 1
        return mat

# Time Complexity : O(mn)
# Space Complexity : O(mn)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


#BFS ON 0'S TO GET APPROPRIATE DISTANCE
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        
        queue = deque()
        
        m = len(mat)
        n = len(mat[0])
        out = [[0 for i in range(n)] for j in range(m)]
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    queue.append([i,j])
                else:
                    mat[i][j] = -1
        
        dist = 1
        while len(queue) != 0:
            length = len(queue)
            for i in range(length):
                node = queue.popleft()
                dirs = [[1,0],[-1,0],[0,-1],[0,1]]

                for i in dirs:
                    x = node[0] + i[0]
                    y = node[1] + i[1] 

                    if x >= 0 and x < m and y >= 0 and y < n and mat[x][y] == -1:
                        mat[x][y] = dist
                        queue.append([x,y])
            dist += 1
        return mat
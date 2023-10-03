# Time Complexity: O(m*n)
# Space Complexity: O(m*n)

class Solution(object):
    def updateMatrix(self, mat):
        """
        :type mat: List[List[int]]
        :rtype: List[List[int]]
        """
        m=len(mat)
        n=len(mat[0])
        dir = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        queue=collections.deque()
        for i in range(m):
            for j in range(n):
                if mat[i][j]==0:
                    queue.append([i,j])
                else:
                    mat[i][j]=-1
        level = 1
        while queue:
            for i in range(len(queue)):
                curr=queue.popleft()
                for d in dir:
                    newRow=curr[0]+d[0]
                    newCol=curr[1]+d[1]
                    if 0<=newRow<m and 0<=newCol<n and mat[newRow][newCol]==-1:
                        mat[newRow][newCol]=level
                        queue.append([newRow,newCol])
            level+=1
        return mat

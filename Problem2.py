'''
Problem: 01 Matrix
Time Complexity: O(m * n)
Space Complexity: O(m * n)
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        Applied BFS
        Add all cells with value 0 to queue as these are independent elements
        Then traverse the neighbors and keep on increasing level   
'''

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m = len(mat)
        n = len(mat[0])
        dirs = [(0,1), (1, 0), (-1,0), (0,-1)]

        queue = deque()

        for i in range(m):
            for j in range(n):
                if mat[i][j]==0:
                    queue.append((i,j))
                else:
                    mat[i][j]= -1
        
        level = 0
        while queue:
            size = len(queue)
            level+=1
            for i in range(size):
                i, j = queue.popleft()
                for d in dirs:
                    r = i + d[0]
                    c = j + d[1]
                    if r>=0 and c>=0 and r<m and c<n and mat[r][c]==-1:
                        queue.append((r,c))
                        mat[r][c] = level
        
        return mat
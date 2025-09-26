# Time Complexity: O(m*n)
# Space Complexity: O(m*n)

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        # We want to perform BFS from each zero, to each one. 

        # first, lets apprach this problem using BFS, where we store all '0's in the queue. 
        # we maintain the level variable, and if we find a 1 lets update the level. To avoid an issue lets make all 1's as -1's to make things simpler

        dirs = [(-1,0), (1,0), (0,1), (0,-1)]
        m,n = len(mat), len(mat[0])
        q = collections.deque()
        for i in range(m): 
            for j in range(n): 
                if mat[i][j] == 1:
                    mat[i][j] = -1
                elif mat[i][j] == 0: 
                    q.append((i,j))
        level = 1
        while q: 
            size = len(q)
            for _ in range(size): 
                i,j = q.popleft()
                for dx, dy in dirs: 
                    nx = i + dx
                    ny = j + dy
                    
                    if 0<=nx<m and 0<=ny<n and mat[nx][ny] == -1: 
                        q.append((nx,ny))
                        mat[nx][ny] = level

            level +=1
        return mat

                    
        

        f

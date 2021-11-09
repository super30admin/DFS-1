# 542. 01 Matrix
# https://leetcode.com/problems/01-matrix/

# Inefficient Solution 
# Logic: Use BFS. From each 1, fire a BFS. If you find a 0, update the answer matrix and empty the queue.

# Time Complexiety: O((nm)^2)
# Space Complexiety: O(min(n,m))
class Solution:
    def updateMatrix(self, mat):
        n = len(mat)
        m = len(mat[0])
        neighbours = [(0,1),(0,-1),(1,0),(-1,0)]
        size = 0
        
        res = [[0 for _ in range(m)] for i in range(n)]
        
        for i in range(n):
            for j in range(m):
                if mat[i][j] == 0:
                    res[i][j] = 0
                else:
                    visited = set()
                    q = [(i,j,0)]
                    visited.add((i,j))
                    trueRow = i
                    trueCol = j

                    while q:
                        size = len(q)
                        row, col, lvl = q.pop(0)

                        for _ in range(size):
                            for neighbour in neighbours:
                                newRow = row + neighbour[0]
                                newCol = col + neighbour[1]

                                if (newRow >= 0 and newRow < n) and (newCol >= 0 and newCol < m) and (newRow, newCol) not in visited:
                                    if mat[newRow][newCol] == 0:
                                        res[trueRow][trueCol] = lvl + 1
                                        q = []
                                        break
                                    else:
                                        q.append((newRow, newCol, lvl + 1))
                                        visited.add((newRow, newCol))
        return res


obj = Solution()
print(obj.updateMatrix([[0,0,0],[0,1,0],[1,1,1]]))


# Efficient Solution
# Logic: 0 is the independent node here. We will preprocess the input mat like this, 
# all the 0s will be pushed to the queue (as they are independent nodes) and all the 
# 1s will me marked with -1 (-1 means distance is not calculated for it so far or it 
# is not visited). We will then start the BFS. If for a node the neighbour is a -1 
# (not visited 1), we will update it with the distance so far. Return the input matrix.

# Time Complexiety: O(n*m)
# Space Complexiety: O(n*m)
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        neighbours = [(0,1),(0,-1),(1,0),(-1,0)]
        n = len(mat)
        m = len(mat[0])
        q = []
        dist = 0
        
        for i in range(n):
            for j in range(m):
                if mat[i][j] == 0:
                    q.append((i,j))
                else:
                    mat[i][j] = -1
        
        while q:
            size = len(q)
            
            for i in range(size):
                row, col = q.pop(0)
                
                
                for neighbour in neighbours:
                    newRow = row + neighbour[0]
                    newCol = col + neighbour[1]
                    
                    if 0 <= newRow < n and 0 <= newCol < m:
                        if mat[newRow][newCol] == -1:
                            mat[newRow][newCol] = dist + 1
                            q.append((newRow, newCol))
            dist += 1    
        return mat
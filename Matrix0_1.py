# Time Complexity :
# Space Complexity :
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


'''Basic Idea: Do a BFS on Each 1 and update the distance to the nearest 0'''
# Passes 48/50 Test Cases. But gives a TLE. Hence, I need to somehow cache my results. DP!!!!

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        
        numRows = len(mat)
        numCols = len(mat[0])
        
        dirs = [(1,0),(-1,0),(0,1),(0,-1)]
        
        def bfs(i, j):
            q = deque([ ])
            visited = set()
            
            q.append((i, j))
            visited.add((i, j))
            
            distance = 0
            while q:
                size = len(q)
                for _ in range(size):
                    row, col = q.popleft()
                    for d in dirs:
                        adjRow, adjCol = row + d[0], col + d[1]
                        if 0 <= adjRow < numRows and 0 <= adjCol < numCols:
                            if mat[adjRow][adjCol] == 0:
                                distance += 1
                                return distance
                            else:
                                q.append((adjRow, adjCol))
                                visited.add((adjRow, adjCol))
                
                distance += 1

                
        result = [[0] * numCols for _ in range(numRows)]
        
        for i in range(numRows):
            for j in range(numCols):
                if mat[i][j] == 1:
                    result[i][j] = bfs(i, j)
        
        return result


'''Two Pass DP Algorithm'''
# Passing all Test Cases

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        
        numRows = len(mat)
        numCols = len(mat[0])
        
        result = [[float("inf")] * numCols for _ in range(numRows)] 
        #Since we want to take minimums, I will set defaults to infinity to avoid garbage results
        

        # The first pass is responsible for handling initialisations to 0 and finding the
        # minimum 0 distance to the current 1 in the search spase to its top and left.
        for i in range(numRows):
            for j in range(numCols):
                if mat[i][j] == 0: #In the top down pass, we will set 0s if the matrix had 0
                    result[i][j] = 0
                else:
                    if i - 1 > -1:
                        result[i][j] = result[i-1][j] + 1
                    if j - 1 > -1:
                        result[i][j] = min(result[i][j], result[i][j-1] + 1)
        
        # The second pass is responsible for finding the minimum 0 distance to the current 1 
        # in the search spase to its top and left and updating the result if it is better than 
        # what the first pass found.

        for i in range(numRows - 1, -1, -1):
            for j in range(numCols - 1, -1, -1):
                if i + 1 < numRows:
                    result[i][j] = min(result[i][j], result[i + 1][j] + 1)
                if j + 1 < numCols:
                    result[i][j] = min(result[i][j], result[i][j + 1] + 1)
        
        return result
# Time Complexity : O(n * M)
# Space Complexity : O(n*M)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        
        numRows = len(mat)
        numCols = len(mat[0])
        result = [[float("inf")] * numCols for _ in range(numRows)] 
      
        for i in range(numRows):
            for j in range(numCols):
                if mat[i][j] == 0:
                    result[i][j] = 0
                else:
                    if i - 1 > -1:
                        result[i][j] = result[i-1][j] + 1
                    if j - 1 > -1:
                        result[i][j] = min(result[i][j], result[i][j-1] + 1)
  
        for i in range(numRows - 1, -1, -1):
            for j in range(numCols - 1, -1, -1):
                if i + 1 < numRows:
                    result[i][j] = min(result[i][j], result[i + 1][j] + 1)
                if j + 1 < numCols:
                    result[i][j] = min(result[i][j], result[i][j + 1] + 1)
        
        return result
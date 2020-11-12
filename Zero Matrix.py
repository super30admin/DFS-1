# BFS:
class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        row = len(matrix)
        col = len(matrix[0])
        
        def helper(i,j, curr):
            ans = 100
            queue = deque([(i,j,curr)])
            while queue:
                i,j, curr = queue.popleft()
                if 0<=i<row and 0<=j<col:
                    if matrix[i][j] == 0:
                        return curr
                    else:
                        dir = [[1,0],[0,1],[-1,0],[0,-1]]
                        for d in dir:
                            queue.append((i+d[0],j+d[1], curr+1))
                
                
        for i in range(row):
            for j in range(col):
                if matrix[i][j] == 1:
                    # print("ji",i,j)
                    val = helper(i,j, 0)
                    matrix[i][j] = val
            
        return matrix

Time : O(N^2)
Space: O(N^2)

#DFS
class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        row = len(matrix)
        col = len(matrix[0])
        
        def helper(i,j, curr):
            # print("po",i,j)
            ans = 100
            if 0<=i<row and 0<=j<col and matrix[i][j]!=2:
               
                if matrix[i][j] == 0:
                    # print("in",i,j,curr)
                    return curr
                elif matrix[i][j] == 1:
                    matrix[i][j] = 2
                    ans = min(helper(i+1,j,curr+1), helper(i,j+1, curr+1), helper(i-1, j, curr+1), helper(i,j-1, curr+1))
                    matrix[i][j] = 1
                    return ans
                else:
                    print("problem", matrix[i][j])
                    return curr+matrix[i][j]
            else:
                return curr+123
                
                
        for i in range(row):
            for j in range(col):
                if matrix[i][j] == 1:
                    # print("ji",i,j)
                    val = helper(i,j, 0)
                    matrix[i][j] = val
            
        return matrix
Time: (MN^2)
Space: O(MN)
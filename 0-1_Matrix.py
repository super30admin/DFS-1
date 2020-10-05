// Time Complexity : O(M*N) -rows and cols
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach:

def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        
        q = deque()
        
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == 0:
                    q.append([i,j])
                else:
                    matrix[i][j] = -1
        dist = 1
        dirs = [[-1,0], [1,0], [0,1], [0,-1]]
        
        while q:
            size = len(q)
            
            for i in range(size):
                temp = q.popleft()
                
                for d in dirs:
                    r = temp[0] + d[0]
                    c = temp[1] + d[1]
                
                    if (r>=0 and r<len(matrix) and c>=0 and c<len(matrix[0]) and matrix[r][c] == -1):
                        matrix[r][c] = dist
                        q.append([r,c])
            dist += 1
        return matrix

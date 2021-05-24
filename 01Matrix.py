# TC: O(M x N) where M os the number of rows and N is the number of columns
# SC: O(M x N) 

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        if not mat or len(mat) == 0:
            return
        
        queue = collections.deque()
        rows = len(mat)
        cols = len(mat[0])
        
        for i in range(rows):
            for j in range(cols):
                if mat[i][j] == 0:
                    queue.append((i,j))
                else:
                    mat[i][j] = -1
        while queue:
            curr_x, curr_y = queue.popleft()
            dirs = [(0,1),(0,-1),(1,0),(-1,0)]
            for x, y in dirs:
                new_x, new_y = curr_x + x, curr_y + y
                    
                if new_x >= 0 and new_x < rows and new_y >= 0 and new_y < cols and mat[new_x][new_y] == -1:
                    queue.append((new_x,new_y))
                    mat[new_x][new_y] = mat[curr_x][curr_y] + 1
        
        return mat

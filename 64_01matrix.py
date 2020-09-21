# S30 Big N Problem #64 {Medium}

# LC - 542. 
# 01 Matrix

# Time Complexity : O(n*m) n=no. of rows m=no. of columns
# Space Complexity : O(n*m) n=no. of rows m=no. of columns
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No 

# Aproach 
# add the elements with 0 value in queue 
# pop each element from queue, if the adjacent cells is not visited, 
# and is not 0, then update the value 
# this follows the DFS traversal of graph 

class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        
        m=len(matrix)
        n=len(matrix[0])
        
        visited=set()
        queue=[]
        
        direction=((1,0),(-1,0),(0,1),(0,-1))
        
        for i in range(m):
            for j in range(n):
                if matrix[i][j]==0:
                    queue.append((i,j))
                    visited.add((i,j))
                    
        while queue:
            x,y=queue.pop(0)
            
            
            for dx,dy in direction:
                
                if x+dx>=0 and x+dx<m and y+dy>=0 and y+dy<n:
                    if matrix[x+dx][y+dy]!=0 and (x+dx,y+dy) not in visited:
                        visited.add((x+dx,y+dy))
                        queue.append((x+dx,y+dy))
                        matrix[x+dx][y+dy]=matrix[x][y]+1
        
        return matrix
                    
                    
                    
            
            
            
        
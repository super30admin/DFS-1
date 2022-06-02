#Time Complexity : O(n)
#Space Complexity : O(n)
#Approach : BFS

from collections import deque
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        
        if image == [[]] or image[sr][sc] == newColor:
            return image
        
        m = len(image)
        n = len(image[0])
        
        dirs = [[0,1],[0,-1],[-1,0],[1,0]]
        
        rows_q = deque()
        cols_q = deque()
        rows_q.append(sr)
        cols_q.append(sc)
        original_color = image[sr][sc]
        
        image[sr][sc] = newColor
        
        while(len(rows_q) != 0):
            curr_sr = rows_q.popleft()
            curr_sc = cols_q.popleft()
            
            for dire in dirs:
                nr = curr_sr + dire[0]
                nc = curr_sc + dire[1]
                
                if(nr >= 0 and nc >= 0 and nr < m and nc < n):
                    if image[nr][nc] == original_color:
                        rows_q.append(nr)
                        cols_q.append(nc)
                        image[nr][nc] = newColor
        
        return image

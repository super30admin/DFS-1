# Time Complexity : O(n * m)
# Space Complexity : O(n * m)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        dirs=((0,-1),(-1,0),(1,0),(0,1))
        
        queue = deque([(sr,sc)])
        s_color = image[sr][sc]
        
        while queue:
            x,y = queue.popleft()
            image[x][y] = newColor
            
            for r_x,r_y in dirs:
                    r = x + r_x
                    c = y + r_y
                    if r>=0 and r<len(image) and c>=0 and c<len(image[0]) and image[r][c] == s_color:  
                        if (r,c) not in queue and image[r][c] != newColor:
                            queue.append((r,c))
        
        return image
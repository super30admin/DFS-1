# // Time Complexity : O(mn)
# // Space Complexity : O(mn)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

from collections import deque
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if not image or not newColor: return image
        if sr == None or sc == None or image[sr][sc]==newColor: return image
        m = len(image)
        n = len(image[0])
        prev = image[sr][sc]
        image[sr][sc] = newColor
        
        q = deque([(sr,sc)])
        # visited = set()
        dirs = [(1,0), (0,1), (-1,0), (0,-1)]
        
        while q:
            ele = q.popleft()
            # visited.add(ele)
            
            for d in dirs:
                r = d[0] + ele[0]
                c = d[1] + ele[1]
                if r<m and r>=0 and c>=0 and c<n and image[r][c]==prev:
                    image[r][c] = newColor
                    # if (r,c) not in visited:
                    q.append( (r,c) )
            
        return image
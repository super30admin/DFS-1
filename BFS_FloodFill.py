# // Time Complexity : O(m*n)
# // Space Complexity :O(m*n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if image == None or image[sr][sc] == newColor:
            return image
        dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        m = len(image)
        n = len(image[0])
        q = list()
        color = image[sr][sc]
        q.append(sr)
        q.append(sc) 
        image[sr][sc] = newColor
        while q:
            cr = q.pop(0)
            cc = q.pop(0)
            for direction in dirs:
                nr = cr + direction[0]
                nc = cc + direction[1]
                if nr >= 0 and nc >= 0 and nr< m and nc < n and image[nr][nc] == color:
                    q.append(nr)
                    q.append(nc)
                    image[nr][nc] = newColor
        
        return image
                    
                    
                
        
        
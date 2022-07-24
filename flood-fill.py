# Time Complexity :O(n)
# Space Complexity : O(n) as recurion use implicit stack as data structure
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No


class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        
        R=len(image)
        C=len(image[0])
        prev_paint=image[sr][sc]
        if prev_paint == color:
            return image
        def dfs(r,c):
            if image[r][c]==prev_paint:
                image[r][c]=color
                if r>0:
                    dfs(r-1,c)
                if c>0:
                    dfs(r,c-1)
                if c+1<C:
                    dfs(r,c+1)
                if r+1<R:
                    dfs(r+1,c)

            
        dfs(sr,sc)
        return image
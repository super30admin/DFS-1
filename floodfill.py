# // Time Complexity :O(hw)
# // Space Complexity :O(hw)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        
        h, w = len(image), len(image[0])
        
		
        def dfs( r, c, src_color):
            
            if r < 0 or c < 0 or r >= h or c >= w or image[r][c] == newColor or image[r][c] != src_color:
                # Reject for invalid coordination, repeated traversal, or different color
                return
            
            # update color
            image[r][c] = newColor
            
            
            # DFS to 4-connected neighbors
            dfs( r-1, c, src_color )
            dfs( r+1, c, src_color )
            dfs( r, c-1, src_color )
            dfs( r, c+1, src_color )
            
        # ---------------------------------------------------------------------------
        
        dfs(sr, sc, src_color = image[sr][sc] )
        
        return image
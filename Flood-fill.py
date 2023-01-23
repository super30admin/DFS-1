# Time Complexity : O(M*N)
# Space Complexity : O{M*N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#Do DFS on the source pixel in all 4 directions
#Check the boundary conditions and also if it has already been visited
#Assign the color to the unvisited nodes




def floodFill(self, image, sr, sc, color):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type color: int
        :rtype: List[List[int]]
        """
           
        
        start_color = image[sr][sc]
        
        def flood_fill(x, y):
            if x < 0 or x >= len(image): return
            if y < 0 or y >= len(image[0]): return
            
            if image[x][y] == color: return
            if image[x][y] != start_color: return
            
            image[x][y] = color
            
            flood_fill(x-1, y)
            flood_fill(x+1, y)
            flood_fill(x, y+1)
            flood_fill(x, y-1)
        
        flood_fill(sr, sc)
        return image
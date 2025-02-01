######### Flood fill

# Time Complexity : O(m*n)
# Space Complexity : O(m+n)
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :


# Perform dfs and as we process the cell modify the color

def flood_fill(image, sr, sc, color):
        start_color = image[sr][sc]

        if start_color == color:  
            return image

        stack = [(sr,sc)]

        while stack:
            r, c = stack.pop()
            if image[r][c] == start_color:
                image[r][c] = color
                for x,y in [(r-1,c),(r,c-1),(r+1,c), (r,c+1)]:
                    if (0 <= x < len(image)) and (0 <= y  < len(image[0])) and (image[x][y]==start_color):
                        stack.append((x,y)) 
        	
        return image
     

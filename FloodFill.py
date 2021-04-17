class Solution(object):
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        # Time Complexity O(mn)
        # Space Complexity O(mn)
        # Perform DFS using Stack and visit all the nodes that are equal to the current cell
        stack = [(sr,sc)]
        dirs = [(0,1),(0,-1),(1,0),(-1,0)]
        while(stack):
            r,c = stack.pop()
            currColor = image[r][c]
            for i in range(len(dirs)):
                row = r + dirs[i][0]
                col = c + dirs[i][1]
                if(0 <= row < len(image) and 0 <= col < len(image[0]) and image[row][col] == currColor and image[row][col]!=newColor):
                    stack.append((row,col))
            image[r][c] = newColor
        return image
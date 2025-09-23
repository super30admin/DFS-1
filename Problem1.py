class Solution(object):
   # tc : O(m*n) process all the cells in worst case
   # sc : O(m*n) recrussive stack space
    def floodFill(self, image, sr, sc, color):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type color: int
        :rtype: List[List[int]]
        """
        # intution start with the start index and process its neighbors and it's neighors neighbors ..  by dfs
        # if the neighbor color is same as the start index color then updte to the new color
        # such that all the neighbors in the images have been processed with the new color

        self.dirs = [[-1, 0], [1, 0], [0, 1], [0, -1]]
        self.m = len(image)
        self.n = len(image[0])
        
        start_color = image[sr][sc]

        # edge case if the start color is alos the given color then no changes just retutn thr image
        if start_color == color:
            return image
            

        def dfs(i,j):
            if i < 0 or j < 0 or i == self.m or j == self.n or image[i][j] != start_color:
                return

            image[i][j] = color # update the current index cell to the new color

            for dir in self.dirs: # update its neighbors 
                r = dir[0] + i
                c = dir[1] + j
                dfs(r, c)

        dfs(sr,sc)

        return image

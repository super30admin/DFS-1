"""BFS without visited array"""
#Accepted by leetcode
#Time complexity - O(n) as we are visting every pixel
#Space complexity - O(n) as we are using queue



class Solution(object):
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        #Edge case
        if image[sr][sc] == newColor:
            return image
        if image == None or len(image) == 0:
            return image
        q =[]
        color = image[sr][sc]
        q.append((sr, sc))
        dirs = ((0,1),(1,0),(-1,0),(0,-1))
        while len(q) > 0:
            curr = q.pop(0)
            image[curr[0]][curr[1]] = newColor
            for d in dirs:
                i = d[0] + curr[0]
                j = d[1] + curr[1]
                if i >= 0 and i < len(image) and j >= 0 and j < len(image[0]) and image[i][j] == color:
                    q.append((i,j))
        return image
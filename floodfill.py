'''
Time Complexity: O(mn)
Space Complexity: O(m+n)
'''
class Solution(object):
    def floodFill(self, image, sr, sc, color):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type color: int
        :rtype: List[List[int]]
        """
        row = len(image)
        col = len(image[0])
        if(image[sr][sc]==color):
            return image
        oldval = image[sr][sc]
        image[sr][sc] = color
        direction = [[-1,0], [1, 0], [0, -1], [0,1]]
        def dfs(nr, nc):
            for i in direction:
                nnr = nr+i[0]
                nnc = nc+i[1]
                if(nnr>=0 and nnr<row and nnc>=0 and nnc<col and image[nnr][nnc]==oldval):
                    image[nnr][nnc] = color
                    dfs(nnr, nnc)
            return None
        dfs(sr, sc)
        return image
            
            
        
        
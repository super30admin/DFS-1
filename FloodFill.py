#Time: O(n)
#Space: O(n)
#Program ran on leetcode successfully
class Solution(object):
    def floodFill(self, image, sr, sc, color):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type color: int
        :rtype: List[List[int]]
        """
        
        if image is None or image[sr][sc] == color:
            return image
        
        prev_color = image[sr][sc]
        queue = []
        row_len = len(image)
        col_len = len(image[0])
        dirs = [[0,1], [-1, 0], [0, -1], [1, 0]]
        queue.append(sr)
        queue.append(sc)
        image[sr][sc] = color
        
        while queue:
            cr = queue.pop(0)
            cc = queue.pop(0)
            for dir in dirs:
                nr = cr + dir[0]
                nc = cc + dir[1]
            
                if (nr >= 0 and nc >= 0 and nr < row_len and nc < col_len and image[nr][nc] == prev_color):
                    queue.append(nr)
                    queue.append(nc)
                    image[nr][nc] = color
        
        return image

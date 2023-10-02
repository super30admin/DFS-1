# Time Complexity: O(m*n)
# Space Complexity: O(m*n)

class Solution(object):
    def floodFill(self, image, sr, sc, color):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type color: int
        :rtype: List[List[int]]
        """
        queue = collections.deque()
        m = len(image)
        n = len(image[0])
        original_Color = image[sr][sc]
        dir = [[0,-1], [0,1], [1,0], [-1,0]]
        if image[sr][sc] == color:
            return image
        image[sr][sc] = color
        queue.append([sr,sc])
        
        while queue:
            for i in range(len(queue)):
                curr_pos = queue.popleft()
                for d in dir:
                    newRow = curr_pos[0]+d[0]
                    newCol = curr_pos[1]+d[1]

                    if 0<=newRow<m and 0<=newCol<n and image[newRow][newCol] == original_Color:
                        image[newRow][newCol] = color
                        queue.append([newRow,newCol])
        return image

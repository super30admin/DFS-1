#Time Complexity : O(N)  where N is number of elements in Matrix
#Space Complexity :O(B) where B is min(len of row),(len of column)

class Solution(object):
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        dirs = [(-1,0),(0,-1),(1,0),(0,1)]
        colour = image[sr][sc]
        Queue = []
        if len(image) == None or colour == newColor:
            return image
        image[sr][sc] = newColor
        Queue.append([sr,sc])
        
        while len(Queue) > 0 :
            curr = Queue.pop(0)
            for i in dirs:
                r = curr[0] + i[0] 
                c = curr[1] + i[1]
                if r >=0 and c >=0 and r < len(image) and c < len(image[0]) and image[r][c] == colour: 
                    image[r][c] = newColor
                    Queue.append([r,c])
        return image
    
===========================================================================================
#Time Complexity : O(N)  where N is number of elements in Matrix
#Space Complexity :O(N) where N is number of Nodes
class Solution(object):
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        dirs = [(-1,0),(0,-1),(1,0),(0,1)]
        color = image[sr][sc]
        if len(image) == None or color == newColor:
            return image
        def dfs(image,sr,sc):
            if sr < 0 or sr >=len(image) or sc < 0 or sc >=len(image[0]) or image[sr][sc]!=color:
                return
            image[sr][sc]=newColor
            for i in dirs:
                r = i[0] + sr
                c = i[1] +sc
                dfs(image,r,c)
        dfs(image,sr,sc)
        return image
            
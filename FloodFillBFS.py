class Solution(object):
    def floodFill(self, image, sr, sc, color):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type color: int
        :rtype: List[List[int]]
        """
        '''We can do either BFS or DFS as we have connected components.'''
        #Time Complexity: O(mn)
        #Space Complexity: O(1)
        #null case
        if len(image)==0 or image[sr][sc]==color:
            return image
        
        m=len(image)
        n=len(image[0])
        #direction array right, left, top, bottom
        dirs=[[0,1],[0,-1],[-1,0],[1,0]]
        
        ogcolor=image[sr][sc]
        print(ogcolor)
        
        #BFS
        queue=deque([(sr,sc)])
        image[sr][sc]=color
        visited=set()
        visited.add((sr,sc))
        while len(queue) !=0:
            ind=queue.popleft()
            currentRow=ind[0]
            currentCol=ind[1]
            #iterating to all the directions
            for direction in dirs:
                nr=direction[0]+currentRow
                nc=direction[1]+currentCol
                #Check bound
                if nr >=0 and nc >=0 and nr<m and nc<n and image[nr][nc] == ogcolor and (nr,nc) not in visited:
                    queue.append((nr,nc))
                    image[nr][nc]=color
                    visited.add((nr,nc))
                    
        return image
        
        

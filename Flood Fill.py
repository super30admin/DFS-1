# TC : O((m-1)x(n-1))
# SC : O(1) - always 4 neighbours
class Solution(object):
    def floodFill(self, image, sr, sc, color):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type color: int
        :rtype: List[List[int]]
        """
        if image[sr][sc] == color :
            return image
        
        m = len(image)
        n = len(image[0])
        color_tbc = image[sr][sc]
        dirs = [[1,0],[0,1],[-1,0],[0,-1]]
        q = deque()
        
        q.append([sr,sc])
        image[sr][sc]=color
        
        
        while q:
            #size = len(q) 
            x,y = q.popleft()
            for dx,dy in dirs:
                nr = dx +x
                nc = dy +y
                if nc>=0 and nc<n and nr>=0 and nr<m and image[nr][nc] == color_tbc:
                    q.append([nr,nc])
                    image[nr][nc] = color
                    
        return image
        
        
class Solution(object):
    def floodFill(self, image, sr, sc, color):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type color: int
        :rtype: List[List[int]]
        """
        if image[sr][sc]==color:
            return image
        
        color_tbc=image[sr][sc]
        
        r = len(image)
        c = len(image[0])
        
        st=[(sr,sc)]
        
        directions=[(1,0),(-1,0),(0,1),(0,-1)]
        while len(st)>0:
            row,col=st.pop()
            image[row][col]=color
            for dr,dc in directions:
                nr=row+dr
                nc=col+dc
                if 0<=nr<r and 0<=nc<c and image[nr][nc]==color_tbc:
                    st.append((nr,nc))
        return image
from collections import deque

class Solution:
    #Solution 1
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        #Approach: DFS, recursive
        #Time Complexity: O(m * n)
        #Space Complexity: O(m * n)
        
        if image[sr][sc] == newColor:
            return image
        
        m = len(image)
        n = len(image[0])
        
        color = image[sr][sc]
        dirArr = [(-1, 0), (0, -1), (0, 1), (1, 0)]
        
        def dfs(sr, sc, newColor):
            #base
            if sr < 0 or sr == m or sc < 0 or sc == n or image[sr][sc] != color:
                return
            
            #logic
            image[sr][sc] = newColor
            for d in dirArr:
                dfs(sr + d[0], sc + d[1], newColor)
        
        dfs(sr, sc, newColor)
        return image
    
    #Solution 2
    """
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        #Approach: BFS
        #Time Complexity: O(m * n)
        #Space Complexity: O(m * n)
        
        if image[sr][sc] == newColor:
            return image
        
        m = len(image)
        n = len(image[0])
        
        color = image[sr][sc]
        dirArr = [(-1, 0), (0, -1), (0, 1), (1, 0)]
        
        de = deque()
        de.append((sr, sc))
        image[sr][sc] = newColor
        
        while de:
            popped = de.popleft()
            print(popped)
            
            for d in dirArr:
                r = popped[0] + d[0]
                c = popped[1] + d[1]
                
                if r >= 0 and r < m and c >= 0 and c < n and image[r][c] == color:
                    de.append((r, c))
                    image[r][c] = newColor
                    
        return image
    """
    
    #Solution 3
    """
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        #Approach: DFS, iterative
        #Time Complexity: O(m * n)
        #Space Complexity: O(m * n)
        
        if image[sr][sc] == newColor:
            return image
        
        m = len(image)
        n = len(image[0])
        
        color = image[sr][sc]
        dirArr = [(-1, 0), (0, -1), (0, 1), (1, 0)]
        
        st = []
        st.append((sr, sc))
        image[sr][sc] = newColor
        
        while st:
            popped = st.pop()
            print(popped)
            
            for d in dirArr:
                r = popped[0] + d[0]
                c = popped[1] + d[1]
                
                if r >= 0 and r < m and c >= 0 and c < n and image[r][c] == color:
                    st.append((r, c))
                    image[r][c] = newColor
                    
        return image
    """
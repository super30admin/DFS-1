#Time Complexity : O(m*n)
#Space Complexity : O(m*n)


def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        
        if not image:
            return []
        
        #init queue with srtarting row and column
        queue = deque([(sr,sc)])
       
        #visited set of nodes
        visited = set([])
        
        rows = len(image)
        cols = len(image[0])
        
        #store original color of the given starting position
        original = image[sr][sc]
        
        # #if starting node already in newColor
        # if image[sc][sr] == newColor:
        #     return    
        
        #doing bfs
        while(queue):
            x, y = queue.popleft()
            
            if (x,y) in visited:
                continue
                
            image[x][y] = newColor
            visited.add((x,y))
                        
            for nx, ny in [[x+1,y], [x-1,y], [x,y+1], [x,y-1]]:
                if 0 <= nx < rows and 0 <= ny < cols and image[nx][ny] == original:
                    queue.append([nx,ny])
        
        return image
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if image == None:
            return image
        q = []
        q.append(sr)
        q.append(sc)
        orig = image[sr][sc]
        if image[sr][sc] == orig:
            return image
        
        dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        m = len(image)
        n = len(image[0])
        image[sr][sc] = color
        

        while q:
            cr = q.pop(0)
            cc = q.pop(0)

            for dir in dirs:
                print(dir)
                nr = cr + dir[0]
                nc = cc + dir[1]
                print('nr '+str(nr)+' nc'+str(nc))

                if(nr>=0 and nc>=0 and nr<m and nc<n and image[nr][nc] == orig):
                    q.append(nr)
                    q.append(nc)
                    
                    image[nr][nc] = color
        return image


        
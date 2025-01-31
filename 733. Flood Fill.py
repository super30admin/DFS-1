#Time: O(m*n)
#Space: O (m*n)
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:

        m= len(image)
        n= len(image[0])
        initial_color= image[sr][sc]
        if color == 0 or image[sr][sc] == color:
            return image
        dirs= [[0,1],[0,-1],[1,0],[-1,0]]
        r= [sr]
        c= [sc]
        image[sr][sc]= color
        while len(r) != 0:
            cur_r= r.pop(0)
            cur_c = c.pop(0)
            for direction in dirs:
                nr= direction[0] + cur_r
                nc= direction[1] + cur_c
                if nr >= 0 and nc >= 0 and nr < m and nc < n:
                    if image[nr][nc] == initial_color and image[cur_r][cur_c] == color:
                        image[nr][nc] = color
                        r.append(nr)
                        c.append(nc)
        return image

#TC-O(mn)
#SC-O(mn)
#logic-start from given node and do bfs on each of the nodes if its value is initial value
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if not image or len(image)==0:
            return image
        if image[sr][sc] == color: 
            return image
        dir =  [(-1,0),(0,-1),(0,1),(1,0)]
        li=[(sr,sc)]
        xl=image[sr][sc]
        image[sr][sc]=color
        while li!=[]:
            x=li.pop(0)
            cr=x[0]
            cc=x[1]
            for i in dir:
                print('hi')
                nr=cr+i[0]
                nc=cc+i[1]
                if nr >= 0 and nr<len(image) and nc >= 0 and nc < len(image[0]) and image[nr][nc]==xl:
                    li.append((nr,nc))
                    image[nr][nc]=color
        return image
        
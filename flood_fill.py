# time: O(n)
# space: O(n)
class Solution(object):
    def floodFill(self, image, sr, sc, color):
        srcColor = image[sr][sc]
        if srcColor == color:
            return image
        dirs = [[-1,0], [1,0], [0,1], [0,-1]]
        q = []
        q.append([sr,sc])
        image[sr][sc]= color
        while q:
            curr = q.pop(0)
            r, c = curr[0], curr[1]
            for d in dirs:
                rn = r + d[0]
                cn = c + d[1]
                if rn >= 0 and rn < len(image) and cn >= 0 and cn < len(image[0]):
                    if image[rn][cn] == srcColor:
                        image[rn][cn] = color
                        q.append([rn,cn])
        return image



        
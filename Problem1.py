# Time Complexity : O(n)
# Space Complexity : Confused between O(n) and O(n^2). HELP NEEDED.......
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No



class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:

        rows = len(image)
        cols = len(image[0])
        oldColor = image[sr][sc]
        image[sr][sc] = newColor
        if oldColor == newColor:
            return image
        queue = [(sr, sc)]

        def validindex_finder(r, c):
            for vr, vc in [(r - 1, c), (r + 1, c), (r, c - 1), (r, c + 1)]:
                if vr >= 0 and vr < rows and 0 <= vc and vc < cols:
                    yield vr, vc

        while queue:
            r, c = queue.pop(0)

            for vr, vc in validindex_finder(r, c):
                if image[vr][vc] == oldColor:
                    image[vr][vc] = newColor
                    queue.append((vr, vc))
        return image

# Here I am initially checking, if the new color is same as the old color then I will simply return the matrix. Otherwise,
# I will perform BFS where I will find  the adjacent nodes besides the one that I popped and if the node has old color
# then I will replace it with the new color otherwise I will continue to the next node
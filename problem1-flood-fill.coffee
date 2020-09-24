#https://leetcode.com/problems/flood-fill/
#// Time Complexity : O(NxM)
#// Space Complexity : O(NxM)
#// Did this code successfully run on Leetcode : yes
#// Any problem you faced while coding this :
#
# none
#// Your code here along with comments explaining your approach
#recurse(matrix, i, j, oldColor, newColor, directions)
#  change oldcolor to new color
#  for each direction
#    if in bounds and color is oldcolor, recurse(...,new i, new j, ...)

directions = [[-1,0],[1,0],[0,-1],[0,1]]

floodFill = (image, sr, sc, newColor) ->

  recurse = (i, j, oldColor) ->
    image[i][j] = newColor

    directions.forEach (dir) ->
      r = i + dir[0]
      c = j + dir[1]

      if r >= 0 && r < image.length && c >= 0 && c < image[0].length && image[r][c] == oldColor
        recurse(r, c, oldColor)

  return image if image is null or image.length is 0 or image[0].length is 0 or image[sr][sc] is newColor

  recurse(sr, sc, image[sr][sc])

  image

// Time Complexity : 0(N)
// Space Complexity : 0(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

    func floodFill(_  image: [[Int]], _ sr: Int, _ sc: Int, _ newColor: Int) -> [[Int]] {
        var image = image
        var stack = [[Int]]()
        stack.append([sr,sc])
        var oldColor = image[sr][sc]
        while !stack.isEmpty {
            print(stack)
            var pixel = stack.removeLast()
            var row = pixel[0]
            var col = pixel[1]
            image[row][col] = -1
            if row - 1 >= 0 && image[row-1][col] == oldColor {
                image[row-1][col] = -1
                stack.append([row-1,col])
            }
            if row + 1 < image.count && image[row+1][col] == oldColor {
                image[row+1][col] = -1
                stack.append([row+1,col])
            }
            if col - 1 >= 0 && image[row][col-1] == oldColor {
                image[row][col-1] = -1
                stack.append([row,col-1])
            } 
            if col + 1 < image[0].count && image[row][col+1] == oldColor {
                image[row][col+1] = -1
                stack.append([row,col+1])
            }
            
        }
        for row in 0..<image.count {
            for col in 0..<image[0].count {
                if image[row][col] == -1 {
                    image[row][col] = newColor
                }
            }
        }
        return image
    }
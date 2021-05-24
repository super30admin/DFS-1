/*
Intuition: Can be done via both BFS and DFS. We make sure that we mark visited nodes.
Explore neighbour nodes using dirs array.

BFS Solution
Time Complexity: O(N) where N = total number of pixels
Space Complexity: O(N) where N = total number of pixels
//////////////////////
DFS Solution
Time Complexity: O(N) where N = total number of pixels
Space Complexity: O(N) where N = total number of pixels

*/

class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        
        if ( image.size() == 0 or image[0].size() == 0  or image[sr][sc] == newColor) return image;
        
        int rows = image.size();
        int cols = image[0].size();
        int oldColor = image[sr][sc];
        vector<pair<int, int>> queue; 
        vector<pair<int, int>> dirs; 
        dirs = {{1,0}, {0,1}, {-1,0}, {0, -1}};

        image[sr][sc] = newColor;
        queue.push_back({sr,sc});

        while (queue.size()!= 0){

            pair <int, int> currentIJ = queue.front();
            queue.erase(queue.begin());
            int currentI = currentIJ.first;
            int currentJ = currentIJ.second;
            image[currentI][currentJ] = newColor;

            for (auto dir: dirs){

                int newI = dir.first + currentI;
                int newJ = dir.second + currentJ;
                if ( newI >= 0 and newI < rows and newJ >= 0 and newJ <cols and image[newI][newJ] == oldColor){ 
                    image[newI][newJ] = newColor;
                    queue.push_back({newI, newJ});
                }
            }
        }

        
        
        
        return image;
    }
};


//DFS
class Solution {
public:
    vector<pair<int, int>> dirs; 

    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        
        if ( image.size() == 0 or image[0].size() == 0  or image[sr][sc] == newColor) return image;
        
        int rows = image.size();
        int cols = image[0].size();
        int oldColor = image[sr][sc];
        dirs = {{1,0}, {0,1}, {-1,0}, {0, -1}};
        image[sr][sc] = newColor;
        dfs(image, sr, sc, newColor, rows, cols, oldColor);
        return image;
    }
    
    void dfs(vector<vector<int>>image, int sr, int sc, int newColor, int rows, int cols, int oldColor){
        if ( sr < 0 or sr == rows or sc < 0 or sc == cols or image[sr][sc] != oldColor){ 
            return;
        }
        cout << sr << "Current I ";
        cout << sc << "Current J" <<endl;
        image[sr][sc] = newColor;
        for (auto dir: dirs){
                int newI = dir.first + sr;
                int newJ = dir.second + sc;
                if ( newI >= 0 and newI < rows and newJ >= 0 and newJ < cols and image[newI][newJ] == oldColor){ 
                    dfs(image, newI, newJ, newColor, rows, cols, oldColor);
                }
        } 
    }
};
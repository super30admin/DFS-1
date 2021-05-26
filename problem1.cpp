/*
Time complexity - O(MN)
Space complexity - O(MN)
*/
class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        if (image.size() == 0 || image[0].size() == 0 || image[sr][sc] == newColor) return image;
        int rows = image.size(), cols = image[0].size();
        queue<vector<int>> q;
        q.push({sr, sc});
        int oldColor = image[sr][sc];
        image[sr][sc] = newColor;
        vector<vector<int>> dirs = {{0,1},{1,0},{-1,0},{0,-1}};        
        while (!q.empty()){
            cout << q.size() << endl;
            vector<int> temp = q.front(); q.pop();
            for (auto dir:dirs){
                int r = temp[0] + dir[0];
                int c = temp[1] + dir[1];
                if (r >= 0 && c >= 0 && r < rows && c < cols && image[r][c] == oldColor){
                    image[r][c] = newColor;
                    q.push({r,c});
                }
            }
        }
        return image;
    }
};
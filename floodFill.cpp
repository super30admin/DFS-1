class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        queue<pair<int, int>> q;
        unordered_set<string> visited;
        int original = image[sr][sc];

        q.push({sr, sc});

        auto getKey = [&](int x, int y){
            return to_string(x) + "," + to_string(y);
        };

        visited.insert(getKey(sr, sc));


        auto isSafe = [&](int x, int y) -> bool {
            if (x >= 0 && y >=0 && x < image.size() && y < image[0].size()) {
                return true;
            }
            return false;
        };

        auto isVisited = [&](pair<int, int> cell) -> bool {
            string key = getKey(cell.first, cell.second);

            if (visited.find(key) == visited.end()) {
                visited.insert(key);
            } else {
                return false;
            }
            return true;
        };

        auto addAdjacentCells = [&](pair<int, int> cell) -> void {
            vector<vector<int>> dirs = {{0,1}, {0,-1}, {1, 0}, {-1,0}};
            for (int i=0;i<dirs.size();i++) {
                int newX = cell.first + dirs[i][0];
                int newY = cell.second + dirs[i][1];
                if  (isSafe(newX, newY) && isVisited({newX, newY})) {
                    q.push({newX, newY});
                }
            }
        };

        while (!q.empty()) {
            auto cell = q.front();
            q.pop();

            if (image[cell.first][cell.second] == original) {
                image[cell.first][cell.second] = color;
                addAdjacentCells(cell);
            }
        }

        return image;
    }
};

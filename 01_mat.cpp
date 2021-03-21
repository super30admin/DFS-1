//TC: O(m*n) where m, n are no. of rows and number of columns respectively
//SC: O(m*n)


//We use BFS and not DFS here since in DFS, the distance may vary depending on the starting point. In BFS, we start from 0s and go in a level order fashion.
//Hence the nodes at earlier levels will have the updated distance before nodes at later levels.

class Solution {
public:
    vector<vector<int> > updateMatrix(vector<vector<int> >& matrix)
    {
        int rows = matrix.size();
        if (rows == 0)
            return matrix;
        int cols = matrix[0].size();
        //initialize 2D vector with int max
        vector<vector<int>> dist(rows, vector<int>(cols, INT_MAX));
        queue<pair<int, int> > q;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                //only for nodes with 0, put distance as 0
                if (matrix[i][j] == 0) {
                    dist[i][j] = 0;
                    q.push({ i, j }); //Put all 0s in the queue.
                }

        int dir[4][2] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        while (!q.empty()) {
            pair<int, int> curr = q.front();
            q.pop();
            for (int i = 0; i < 4; i++) {
                int new_r = curr.first + dir[i][0], new_c = curr.second + dir[i][1];
                if (new_r >= 0 && new_c >= 0 && new_r < rows && new_c < cols) {
                    //if the distance at newr, newc is greater than the distance from current node+1, then assign distance newr, newc to distance from curr+1, and put this in the queue to modify it's neighbours.
                    if (dist[new_r][new_c] > dist[curr.first][curr.second] + 1) {
                        dist[new_r][new_c] = dist[curr.first][curr.second] + 1;
                        q.push({ new_r, new_c });
                    }
                }
            }
        }
        return dist;
    }
};
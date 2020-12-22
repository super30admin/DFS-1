//Time - O(n) n is the number of elements in matrix
//Space - O(n)
class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& matrix) {
        int r = matrix.size(), c = matrix[0].size();
        vector<vector<int>> d (r,vector<int>(c,INT_MAX));
        
        queue<pair<int,int>> q;
        for (int i = 0; i <r; i++)
        for (int j = 0; j <c; j++)
            if (matrix[i][j] == 0) {
                d[i][j] = 0;
                q.push({ i, j }); //Put all 0s in the queue.
            }

    vector<vector<int>> dir { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    while (!q.empty()) {
        pair<int, int> curr = q.front();
        q.pop();
        for (int i = 0; i < 4; i++) {
            int x = curr.first + dir[i][0]; 
            int y= curr.second + dir[i][1];
            if (x>= 0 &&  y>= 0 && x< r &&  y< c) {
                if (d[x][y] > d[curr.first][curr.second] + 1) {
                    d[x][y] = d[curr.first][curr.second] + 1;
                    q.push({ x, y});
                }
            }
        }
    }
    return d;
        
        
    }
};
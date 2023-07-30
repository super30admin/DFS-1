// Time Complexity :O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

//Simple BFS, keeps pushing all elements into the queue that has the same color as the root element and changes its color



// Your code here along with comments explaining your approach
class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {

        vector<vector<int>> dirs = {{1,0},{0,1},{-1,0},{0,-1}};

        queue<vector<int>> q;

        int m = image.size();
        int n = image[0].size();
        int oldColor = image[sr][sc];


        if(oldColor==color){
            return image;

        }
        else{
            image[sr][sc]=color;

        }
        q.push({sr,sc});
        
        

        while(!q.empty()){
            int size = q.size();
            

            for(int i=0;i<size;i++){
                vector<int> curr = q.front();
                q.pop();
                for(vector<int> dir:dirs){

                    int nr = curr[0]+dir[0];
                    int nc = curr[1]+dir[1];

                    if(nr>=0 && nc>=0 && nr<m && nc<n && image[nr][nc]==oldColor){
                        q.push({nr,nc});
                        image[nr][nc]=color;

                    }

                    
                }
            }
            
        }

        return image;
       
        
    }
};
// Time Complexity : o(n*m * log(m*n)) where n is number of rows and m is number of colums
// Space Complexity : o(n*m) where n is number of rows and m is number of colums
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//Dijkstra Algorithm to find shortest distance

class Solution {

    int[] xArr = {0,0,-1,1};
    int[] yArr = {1,-1,0,0};

    public int[][] updateMatrix(int[][] mat) {

        boolean[][] visited = new boolean[mat.length][mat[0].length];
        int[][] distance = new int[mat.length][mat[0].length];

        //Queue<Data> q = new LinkedList<>();
        Queue<Data> q = new PriorityQueue<>((a,b) -> Integer.min(a.len, b.len));
        Pair<Integer,Integer> p = getCellofAnyZero(mat);
        q.add(new Data(p.getKey(), p.getValue(), 0));
        visited[p.getKey()][p.getValue()] = true;


        while(!q.isEmpty()){

            Data d  = q.poll();

            int x = d.x;
            int y = d.y;
            int len = d.len;

            for(int i = 0; i<xArr.length; i++){
                int newX = x + xArr[i];
                int newY = y + yArr[i];

                if(newX >= 0 && newX < mat.length && newY >= 0 && newY < mat[0].length){

                    if(visited[newX][newY] && (distance[newX][newY]  < len+1)){
                        continue;
                    }

                    visited[newX][newY]  = true;

                    int value = mat[newX][newY];

                    if(value  == 0){
                        distance[newX][newY] = 0;
                        q.add(new Data(newX, newY, 0));
                    }
                    else if(value == 1){
                        distance[newX][newY]  = len+1;
                        q.add(new Data(newX, newY, len+1));
                    }
                }
            }

        }

        return distance;
    }

    public Pair<Integer,Integer> getCellofAnyZero(int[][] max){

        for(int i = 0; i<max.length; i++){
            for(int j = 0; j<max[0].length; j++){
                if(max[i][j] == 0)
                    return new Pair<>(i,j);
            }
        }

        return new  Pair<>(-1,-1);
    }

    class Data{
        public int x,y,len;
        public Data(int x , int y, int len){
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }
}

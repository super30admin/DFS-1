//Time Complexity; O(mn)
//Space Complexity: O(mn)

class Solution {
    class Location{
        int x, y, distance;
        Location(int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        int getX(){
            return this.x;
        }

        int getY(){
            return this.y;
        }

        int getDistance(){
            return this.distance;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int[][] result = new int[mat.length][mat[0].length];

        for(int i=0;i<mat.length;i++)
            for(int j=0;j<mat[0].length;j++)
                result[i][j] = Integer.MAX_VALUE;

        Queue<Location> queue = new LinkedList<>();

        for(int i=0;i<mat.length;i++)
            for(int j=0;j<mat[0].length;j++)
                if(mat[i][j]==0)
                    queue.add(new Location(i,j,0));

        bfs(queue, result);

        return result;
    }

    public void bfs(Queue<Location> queue, int[][] result){
        Location l;
        int lx, ly, dist;
        while(!queue.isEmpty()){
            l = queue.remove();
            lx = l.getX();
            ly = l.getY();
            dist = l.getDistance();
            if( lx<0 || lx >= result.length || ly < 0 || ly >= result[0].length )
                continue;

            if( result[lx][ly] <= dist)
                continue;

            result[lx][ly] = dist;
            queue.add(new Location(lx+1, ly, dist + 1));
            queue.add(new Location(lx-1, ly, dist + 1));
            queue.add(new Location(lx, ly+1, dist + 1));
            queue.add(new Location(lx, ly-1, dist + 1));
        }
    }
}
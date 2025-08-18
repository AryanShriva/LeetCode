import java.util.*;

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{entrance[0], entrance[1], 0});
        maze[entrance[0]][entrance[1]] = '+'; // mark entrance as visited

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1], steps = curr[2];
            
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                
                if (nr < 0 || nr >= m || nc < 0 || nc >= n || maze[nr][nc] == '+') continue;
                
                // Check if it's an exit
                if (nr == 0 || nr == m-1 || nc == 0 || nc == n-1) {
                    return steps + 1;
                }
                
                // mark visited & push to queue
                maze[nr][nc] = '+';
                q.offer(new int[]{nr, nc, steps + 1});
            }
        }
        return -1;
    }
}

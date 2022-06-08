package com.example;

import java.util.List;

public class PathFinderAlgorith {

  public static boolean searchPath(int[][] maze, int x, int y, List<Integer> path) {
    // checking if target node is reached

    if (maze[y][x] == 3) {
      path.add(x);
      path.add(y);
      return true;
    }

    // path fill
    if (maze[y][x] == 0) {
      maze[y][x] = 2;

      // algorith to visit all node
      int dx = 0;
      int dy = -1;
      if (searchPath(maze, x + dx, y + dy, path)) {
        path.add(x);
        path.add(y);
        return true;
      }

      dx = 0;
      dy = 1;
      if (searchPath(maze, x + dx, y + dy, path)) {
        path.add(x);
        path.add(y);
        return true;
      }

      dx = -1;
      dy = 0;
      if (searchPath(maze, x + dx, y + dy, path)) {
        path.add(x);
        path.add(y);
        return true;
      }

      dx = 1;
      dy = 0;
      if (searchPath(maze, x + dx, y + dy, path)) {
        path.add(x);
        path.add(y);
        return true;

      }
    }
    return false;
  }
}
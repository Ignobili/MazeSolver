package com.example;

import javax.swing.JFrame;

import com.google.gwt.dom.client.Text;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View extends JFrame {

    int startX;
    int startY;
    List<Integer> path = new ArrayList<Integer>();

    /*
     * maze[row][col]
     * 0 = not visited
     * 1 = wall
     * 2 = visited
     * 3 = target
     */

    // border must be filled with "1" to avoid Error

    int[][] maze = {
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1 },
            { 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1 },
            { 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1 },
            { 1, 0, 1, 0, 0, 4, 0, 0, 1, 1, 1, 0, 1 },
            { 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1 },
            { 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1 },
            { 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1 },
            { 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }

    };

    public void startCord() {
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[0].length; col++) {
                if (maze[row][col] == 4) {
                    startY = row;
                    startX = col;
                    maze[row][col] = 0;
                }
            }
        }

    }

    public View() {
        setTitle("Maze Solver");
        setSize(640, 480);
        startCord();
        System.out.println(maze);
        PathFinderAlgorith.searchPath(maze, startX, startY, path);
        System.out.println(path);
        System.out.println(startX + " " + startY);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.translate(50, 50);
        // Generating Maze
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[0].length; col++) {
                Color color;
                switch (maze[row][col]) {
                    // wall
                    case 1:
                        color = Color.BLACK;
                        break;
                    // visited
                    case 3:
                        color = Color.RED;
                        break;
                    // start
                    case 4:
                        color = Color.GREEN;
                        break;
                    // path
                    default:
                        color = Color.WHITE;

                }
                g.setColor(color);
                g.fillRect(30 * col, 30 * row, 30, 30);
                g.setColor(Color.BLACK);
                g.drawRect(30 * col, 30 * row, 30, 30);
            }
        }
        // path fill
        for (int p = 2; p < path.size(); p += 2) {
            int pathX = path.get(p);
            int pathY = path.get(p + 1);
            g.setColor(Color.BLUE);
            g.fillRect(pathX * 30, pathY * 30, 30, 30);
        }
        g.setColor(Color.GREEN);
        g.fillRect(startX * 30, startY * 30, 30, 30);

    }
}

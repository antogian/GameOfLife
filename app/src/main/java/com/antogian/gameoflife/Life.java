package com.antogian.gameoflife;

/**
 * Created by Tony on 16/1/2018.
 */

public class Life
{
    public static final int CELL_SIZE = 24;
    //public static int HEIGHT;
    //public static int WIDTH;
    public static int WIDTH=1080/24;
    public static int HEIGHT=1584/24;

    private static final int[][] cellGrid = new int[HEIGHT][WIDTH];

    public Life()
    {
        initializeGrid();
    }

    public Life(int height, int width)
    {
        HEIGHT = height;
        WIDTH = width;
        initializeGrid();
    }

    public static int[][] getCellGrid()
    {
        return cellGrid;
    }

    private void initializeGrid()
    {
        resetGrid(cellGrid);
        for(int h=0; h<HEIGHT; h++)
        {
            for(int w=0; w<WIDTH; w++)
            {
                if(Randomizer.getRandomInteger(0,10) > 5)
                {
                    cellGrid[h][w] = 1;
                }
            }
        }
        /*
        cellGrid[8][(WIDTH / 2) - 1] = 1;
        cellGrid[8][(WIDTH / 2) + 1] = 1;
        cellGrid[9][(WIDTH / 2) - 1] = 1;
        cellGrid[9][(WIDTH / 2) + 1] = 1;
        cellGrid[10][(WIDTH / 2) - 1] = 1;
        cellGrid[10][(WIDTH / 2)] = 1;
        cellGrid[10][(WIDTH / 2) + 1] = 1;
        */
    }

    private void resetGrid(int[][] grid)
    {
        for(int h=0; h<HEIGHT; h++)
        {
            for(int w=0; w<WIDTH; w++)
            {
                grid[h][w] = 0;
            }
        }
    }

    public void nextGeneration()
    {
        int neighbours;
        int minimum = 2;
        int maximum = 3;
        int spawn = 3;

        int[][] nextLifeGrid = new int[HEIGHT][WIDTH];

        for (int h = 0; h < HEIGHT; h++)
        {
            for (int w = 0; w < WIDTH; w++)
            {
                neighbours = calculateNeighbours(h, w);
                if (cellGrid[h][w] != 0)
                {
                    if ((neighbours >= minimum) && (neighbours <= maximum))
                    {
                        nextLifeGrid[h][w] = neighbours;
                    }
                }
                else
                {
                    if (neighbours == spawn)
                    {
                        nextLifeGrid[h][w] = spawn;
                    }
                }
            }
        }
        copyGrid(nextLifeGrid, cellGrid);
    }

    private int calculateNeighbours(int y, int x)
    {
        int total;
        if (cellGrid[y][x] != 0)
        {
            total = -1;
        }
        else
        {
            total = 0;
        }
        for (int h = -1; h <= +1; h++)
        {
            for (int w = -1; w <= +1; w++)
            {
                if (cellGrid
                        [(HEIGHT + y + h) % HEIGHT]
                        [(WIDTH + x + w) % WIDTH]
                        != 0)
                {
                    total++;
                }
            }
        }
        return total;
    }

    private void copyGrid(int[][] source, int[][] target)
    {
        for(int h=0; h<HEIGHT; h++)
        {
            for(int w=0; w<WIDTH; w++)
            {
                target[h][w] = source[h][w];
            }
        }
    }
}

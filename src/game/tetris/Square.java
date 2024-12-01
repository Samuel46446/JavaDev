package game.tetris;

import java.awt.*;

public class Square
{
    private int x;
    private int y;
    private int h;
    private int w;
    private Color c;

    public Square(int xPos, int yPos, int heigh, int with, Color color)
    {
        this.x=xPos;
        this.y=yPos;
        this.h=heigh;
        this.w=with;
        this.c=color;
    }

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }

    /* Setter X or Y */
    public void setX(int x)
    {
        this.x=x;
    }

    public void setY(int y)
    {
        this.y=y;
    }

    public int getW()
    {
        return this.w;
    }

    public int getH()
    {
        return this.h;
    }

    public Color getColor()
    {
        return this.c;
    }
}

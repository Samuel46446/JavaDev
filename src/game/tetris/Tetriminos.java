package game.tetris;

import java.awt.*;

public class Tetriminos
{
    private int[][] f;
    private int baseX = 100;
    private int baseY = 0;
    private Color col;

    public Tetriminos(int[][] form, Color color)
    {
        this.f=form;
        this.col=color;
    }

    public int[][] getForm()
    {
        return this.f;
    }

    public void setForm(int[][] fm) {
        this.f = fm;
    }

    public void displayForm() {
        for (int i = 0; i < getForm().length; i++) {
            for (int k = 0; k < getForm()[i].length; k++) {
                System.out.print(f[i][k]);
            }
            System.out.println();
        }
    }

    public int getBaseX() {
        return baseX;
    }

    public int getBaseY() {
        return baseY;
    }

    public Color getColor() {
        return col;
    }

    public void setCol(Color col) {
        this.col = col;
    }

    public void setRender(RendererHandler panel)
    {
        for (int i = 0; i < getForm().length; i++)
        {
            for (int k = 0; k < getForm()[i].length; k++)
            {
                if(getForm()[i][k] == 1)
                {
                    panel.addTo(new Square(baseX + 20*k, baseY+20*i, 20, 20, getColor()));
                }
            }
        }
    }

    public void moveXorY(int xMove, int yMove)
    {
        baseX=baseX+xMove;
        baseY=baseY+yMove;
    }

    public void updateRender(RendererHandler panel) {
        panel.graphicsTetris.clear(); // Efface les anciens blocs
        setRender(panel);            // Recrée les blocs avec les nouvelles positions
    }

    public int[][] rotate()
    {
        int[][] rotated = new int[4][4];

        for(int i = 0; i < f.length; i++)
        {
            for(int k = 0; k < f[i].length; k++)
            {
                rotated[k][3 - i] = f[i][k];
            }
        }
        return rotated;
    }
}

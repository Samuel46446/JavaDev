package game.tetris;

import java.awt.*;

public class Tetriminos
{
    private int[][] f;
    private int baseX = 100;
    private int baseY = 20;

    public Tetriminos(int[][] form)
    {
        this.f=form;
    }

    public int[][] getForm()
    {
        return this.f;
    }

    public void setRender(RendererHandler panel)
    {
        for (int i = 0; i < getForm().length; i++)
        {
            for (int k = 0; k < getForm()[i].length; k++)
            {
                if(getForm()[i][k] == 1)
                {
                    panel.addTo(new Square(baseX + 20*k, baseY+20*i, 20, 20, Color.BLUE));
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

    public void rotate()
    {
        for(int i = 0; i < f.length; i++)
        {
            for(int k = 0; k < f[i].length; k++)
            {
                f[i][k] = 0;
            }
        }
    }
}

package game.tetris;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RendererHandler extends JPanel
{
    protected List<Square> graphicsTetris = new ArrayList<>();
    private JLabel score = new JLabel();

    private void setScore()
    {
        this.addTo(new Square(300, 0, 400, 100, Color.BLACK));
        score.setText("Score : "+Game.iScore);
        score.setForeground(Color.WHITE);
        score.setBounds(310, 50, 150, 30);
        this.add(score);
        score.repaint();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        setScore();
        super.paintComponent(g);
        Graphics2D graphs2d = (Graphics2D) g;
        for(Square c : graphicsTetris)
        {
            graphs2d.setColor(c.getColor());
            graphs2d.fillRect(c.getX(), c.getY(), c.getW(), c.getH());
        }
    }

    public void addTo(Square carre)
    {
        graphicsTetris.add(carre);
        repaint();
    }

    public void deplacer(int x, int y)
    {
        for (Square c : graphicsTetris) {
            c.setX(x);
            c.setY(y);
        }
        repaint(); // Redessiner après le déplacement
    }
}
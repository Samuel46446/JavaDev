package game.tetris;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public final class Game
{
    private Game(){}

    public static Tetriminos iBarre = new Tetriminos(TetraReferences.ITetra);
    public static Tetriminos oBarre = new Tetriminos(TetraReferences.OTetra);
    public static Tetriminos tBarre = new Tetriminos(TetraReferences.TTetra);
    public static Tetriminos jBarre = new Tetriminos(TetraReferences.JTetra);
    public static Tetriminos lBarre = new Tetriminos(TetraReferences.LTetra);
    public static Tetriminos sBarre = new Tetriminos(TetraReferences.STetra);
    public static Tetriminos zBarre = new Tetriminos(TetraReferences.ZTetra);

    private static final List<Tetriminos> tetriList = new ArrayList<>();
    public static int iScore = 0;

    public static void main(String[] args) {
        tetriList.add(iBarre);
        tetriList.add(oBarre);
        tetriList.add(tBarre);
        tetriList.add(jBarre);
        tetriList.add(lBarre);
        tetriList.add(sBarre);
        tetriList.add(zBarre);

        init();
    }

    private static void init()
    {
        JFrame frame = new JFrame("Mon Appli");
        RendererHandler panel = new RendererHandler();

        tBarre.setRender(panel);
        KeysRegistry.setupKeyBindings(panel, tBarre);

        //panel.addTo(new Carre(600, 0, 50, 50, Color.MAGENTA));

        frame.setResizable(false);
        frame.setSize(new Dimension(400, 400));
        frame.setContentPane(panel);
        panel.setBackground(Color.WHITE);
        frame.setVisible(true);
    }
}

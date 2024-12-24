package game.tetris;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

public final class Game
{
    private Game(){}

    public static Tetriminos iBarre = new Tetriminos(TetraReferences.ITetra, Color.CYAN);
    public static Tetriminos oBarre = new Tetriminos(TetraReferences.OTetra, Color.YELLOW);
    public static Tetriminos tBarre = new Tetriminos(TetraReferences.TTetra, Color.MAGENTA);
    public static Tetriminos jBarre = new Tetriminos(TetraReferences.JTetra, Color.BLUE);
    public static Tetriminos lBarre = new Tetriminos(TetraReferences.LTetra, Color.ORANGE);
    public static Tetriminos sBarre = new Tetriminos(TetraReferences.STetra, Color.GREEN);
    public static Tetriminos zBarre = new Tetriminos(TetraReferences.ZTetra, Color.RED);

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

        frame.setResizable(false);
        frame.setSize(new Dimension(400, 405));
        frame.setContentPane(panel);
        panel.setBackground(Color.WHITE);
        frame.setVisible(true);
    }
}

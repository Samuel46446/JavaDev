package game.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public final class KeysRegistry
{
    private KeysRegistry() {}

    public static void setupKeyBindings(RendererHandler panel, Tetriminos tetris) {
        // Obtenir l'InputMap et l'ActionMap
        InputMap inputMap = panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = panel.getActionMap();

        inputMap.put(KeyStroke.getKeyStroke("A"), "keyPressedA");
        actionMap.put("keyPressedA", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tetris.getColor() != Color.LIGHT_GRAY) {
                    tetris.setForm(tetris.rotate());
                    tetris.updateRender(panel);
                    panel.repaint();
                    Game.iScore++;
                    System.out.println("Rotation du tetriminos");
                } else {
                    System.out.println("Rotation du tetriminos impossible");
                }
            }
        });

        inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "keyPressedRight");
        actionMap.put("keyPressedRight", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tetris.getBaseX()+150 < panel.getWidth() && tetris.getColor() != Color.LIGHT_GRAY) {
                    tetris.moveXorY(10, 0);
                    tetris.updateRender(panel);
                    panel.repaint();
                    Game.iScore++;
                    System.out.println("Déplacement vers la droite");
                } else {
                    System.out.println("Déplacement vers la droite impossible");
                }
            }
        });

        inputMap.put(KeyStroke.getKeyStroke("LEFT"), "keyPressedLeft");
        actionMap.put("keyPressedLeft", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tetris.getBaseX() > 0 && tetris.getColor() != Color.LIGHT_GRAY) {
                    tetris.moveXorY(-10, 0);
                    tetris.updateRender(panel);
                    panel.repaint();
                    Game.iScore++;
                    System.out.println("Déplacement vers gauche");
                } else {
                    System.out.println("Déplacement vers gauche impossible");
                }
            }
        });

        // Associer une action à une touche
        inputMap.put(KeyStroke.getKeyStroke("DOWN"), "keyPressedDown");
        actionMap.put("keyPressedDown", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int YSizedOf = 0;
                YSizedOf = CollisionY(tetris, TetraReferences.TTetra, TetraReferences.TTetraR,
                        TetraReferences.TTetraUp, TetraReferences.TTetraL, 42, 62,
                        82, 82, YSizedOf);

                /*if(Arrays.deepEquals(tetris.getForm(), TetraReferences.TTetra))
                {
                    YSizedOf = 42;
                }

                if(Arrays.deepEquals(tetris.getForm(), TetraReferences.TTetraR))
                {
                    YSizedOf=62;
                }

                if(Arrays.deepEquals(tetris.getForm(), TetraReferences.TTetraUp))
                {
                    YSizedOf=82;
                }

                if(Arrays.deepEquals(tetris.getForm(), TetraReferences.TTetraL))
                {
                    YSizedOf=82;
                }*/

                if(tetris.getBaseY()+YSizedOf < panel.getHeight())
                {
                    tetris.displayForm();
                    tetris.moveXorY(0, 10);
                    tetris.updateRender(panel);
                    panel.repaint();
                    Game.iScore++;
                    System.out.println("Descente");
                }
                else
                {
                    tetris.setCol(Color.LIGHT_GRAY);
                    tetris.updateRender(panel);
                    panel.repaint();
                    System.out.println("peut pas descendre plus");
                    Game.iBarre.setRender(panel);
                }
            }
        });
    }

    private static int CollisionY(Tetriminos tetris, int[][] type, int[][] typeR, int[][] typeUp, int[][] typeL, int value, int valueR, int valueUp, int valueL, int baseValue)
    {
        if(Arrays.deepEquals(tetris.getForm(), TetraReferences.TTetra))
        {
            return value;
        }

        if(Arrays.deepEquals(tetris.getForm(), TetraReferences.TTetraR))
        {
            return valueR;
        }

        if(Arrays.deepEquals(tetris.getForm(), TetraReferences.TTetraUp))
        {
            return valueUp;
        }

        if(Arrays.deepEquals(tetris.getForm(), TetraReferences.TTetraL))
        {
            return valueL;
        }

        return baseValue;
    }
}
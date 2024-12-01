package game.tetris;

import javax.swing.*;
import java.awt.event.ActionEvent;

public final class KeysRegistry
{
    private KeysRegistry() {}

    public static void setupKeyBindings(RendererHandler panel, Tetriminos tetris) {
        // Obtenir l'InputMap et l'ActionMap
        InputMap inputMap = panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = panel.getActionMap();

        // Associer une action à une touche
        inputMap.put(KeyStroke.getKeyStroke("DOWN"), "keyPressedDown");
        actionMap.put("keyPressedDown", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tetris.moveXorY(0, 50);
                tetris.updateRender(panel);
                panel.repaint();
                Game.iScore++;
                System.out.println("Descente");
            }
        });
    }
}

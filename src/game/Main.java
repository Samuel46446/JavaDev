package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public final class Main
{
    private Main(){}

    public static void main(String[] args)
    {
        init();
    }

    private static void init()
    {
        JFrame frame = new JFrame("Mon Appli");
        JPanel panel = new JPanel();
        JButton resumeBut = new JButton();
        JLabel label = new JLabel();
        JTextField field = new JTextField(20);
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Choix du mod");
        resumeBut.setPreferredSize(new Dimension(200, 200));
        resumeBut.setText("Solo");
        label.setText(Entities.SET_ENTITIES.get(0).getName());
        field.setPreferredSize(new Dimension(200, 200));

        menu.setPreferredSize(new Dimension(200, 200));
        List<String> list = List.of("Fraise", "Framboise", "Myrtille");

        for(String i : list)
        {
            JMenuItem item = new JMenuItem(i);
            item.addActionListener((ActionEvent e) -> {
                JOptionPane.showMessageDialog(frame, "Vous avez choisis : "+item.getText());
            });
            menu.add(item);
        }

        menuBar.add(menu);
        panel.add(label);
        panel.add(resumeBut);
        panel.add(field);
        frame.setJMenuBar(menuBar);
        frame.setSize(new Dimension(1280, 720));
        frame.setContentPane(panel);
        panel.setBackground(Color.BLUE);
        frame.setVisible(true);

        //field.addActionListener(new ButtonClick(field, b(panel, field, resumeBut)));
        //resumeBut.addActionListener(new ButtonClick(resumeBut, a(panel)));

        field.addActionListener((ActionEvent e) -> {
            // Récupère le texte entré dans le JPasswordField
            String password = field.getText();
            
            // Vérifie si le mot de passe est "samuel"
            if ("samuel".equals(password)) {
                // Affiche un message de succès
                JOptionPane.showMessageDialog(frame, "Hello world Samuel !");
            } else {
                // Affiche un message d'erreur
                JOptionPane.showMessageDialog(frame, "Mot de passe incorrect.");
            }
        });
    }

    /* 
    public static Runnable b(JPanel panel, JPasswordField field, JButton resumeBut)
    {
        return () -> {
            String password = new String(field.getPassword());

            if(password.equals("samuel"))
            {
                resumeBut.addActionListener(new ButtonClick(resumeBut, a(panel)));
            }
            else {
                System.out.println("");
            }
        };
    }

    public static Runnable a(JPanel panel)
    {
        return () -> {
            Random rand = new Random();
            int red = rand.nextInt(0, 255);
            int green = rand.nextInt(0, 255);
            int blue = rand.nextInt(0, 255);
            panel.setBackground(Color.getHSBColor(red, green, blue));
            System.out.println("Hello world");
            System.out.println("Change Color");
        };
    }

    public static class ButtonClick implements ActionListener
    {
        protected JComponent but;
        protected Runnable actions;

        public ButtonClick(JComponent b, Runnable a)
        {
            this.but = b;
            this.actions=a;
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource().equals(this.but) || e.getActionCommand().equals("Enter"))
            {
                this.actions.run();
                System.out.println("Hello samuel");
            }
        }
    }*/
    
}
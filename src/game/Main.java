package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

public final class Main
{
    private Main(){}

    public static class Tetriminos
    {
        private int[][] f;

        public Tetriminos(int[][] form)
        {
            this.f=form;
        }

        public int[][] getForm()
        {
            return this.f;
        }

        public void setRender(Renderer panel)
        {
            int baseX = 100;
            for (int i = 0; i < getForm().length; i++)
                {
                    for (int k = 0; k < getForm()[i].length; k++)
                    {
                        if(getForm()[i][k] == 1)
                        {
                            panel.addTo(new Carre(baseX + 20*k, 20*i, 20, 20, Color.BLUE));
                        }
                    }
                }    
        }

        public void moveXorY(Carre c1, Carre c2, Carre c3, Carre c4, int xMove, int yMove)
        {
            
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

    static class Renderer extends JPanel
    {
        List<Carre> graphicsTetris = new ArrayList<>();

        @Override
        protected void paintComponent(Graphics g)
        {
            Graphics2D graphs2d = (Graphics2D) g;

            for(Carre c : graphicsTetris)
            {
                graphs2d.setColor(c.getColor());
                graphs2d.fillRect(c.getX(), c.getY(), c.getW(), c.getH());
            }
        }

        public void addTo(Carre carre)
        {
            graphicsTetris.add(carre);
            repaint();
        }
    }

    public static class Carre
    {
        private int x;
        private int y;
        private int h;
        private int w;
        private Color c;

        public Carre(int xPos, int yPos, int heigh, int with, Color color)
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

    private static final int[][] tbI = 
        {{0,0,0,1},
        {0,0,0,1},
        {0,0,0,1},
        {0,0,0,1}};

    private static final int[][] tbO = 
    {{0,1,1,0},
    {0,1,1,0},
    {0,0,0,0},
    {0,0,0,0}};

    private static final int[][] tbT = 
    {{0,1,0,0},
    {1,1,1,0},
    {0,0,0,0},
    {0,0,0,0}};

    private static final int[][] tbJ = 
    {{0,1,0,0},
    {0,1,0,0},
    {1,1,0,0},
    {0,0,0,0}};

    private static final int[][] tbL = 
    {{0,1,0,0},
    {0,1,0,0},
    {0,1,1,0},
    {0,0,0,0}};

    private static final int[][] tbS = 
    {{0,0,0,0},
    {0,0,1,1},
    {0,1,1,0},
    {0,0,0,0}};

    private static final int[][] tbZ = 
    {{0,0,0,0},
    {1,1,0,0},
    {0,1,1,0},
    {0,0,0,0}};

    public static Tetriminos iBarre = new Tetriminos(tbI);
    public static Tetriminos oBarre = new Tetriminos(tbO);
    public static Tetriminos tBarre = new Tetriminos(tbT);
    public static Tetriminos jBarre = new Tetriminos(tbJ);
    public static Tetriminos lBarre = new Tetriminos(tbL);
    public static Tetriminos sBarre = new Tetriminos(tbS);
    public static Tetriminos zBarre = new Tetriminos(tbZ);

    private static final List<Tetriminos> tetriList = new ArrayList<>();

    public static void main(String[] args)
    {
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
        Renderer panel = new Renderer();

        tBarre.setRender(panel);

        //panel.addTo(new Carre(300, 0, 20, 20, Color.RED));
        //panel.addTo(new Carre(600, 0, 50, 50, Color.MAGENTA));

        //JButton resumeBut = new JButton();
        //JLabel label = new JLabel();
        //JTextField field = new JTextField(20);
        //JMenuBar menuBar = new JMenuBar();
        //JMenu menu = new JMenu("Choix du mod");
        /*resumeBut.setPreferredSize(new Dimension(200, 200));
        resumeBut.setText("Solo");
        label.setText(Entities.SET_ENTITIES.get(0).getName());
        field.setPreferredSize(new Dimension(200, 200));*/

        //menu.setPreferredSize(new Dimension(200, 200));
        //List<String> list = List.of("Fraise", "Framboise", "Myrtille");

        /*for(String i : list)
        {
            JMenuItem item = new JMenuItem(i);
            item.addActionListener((ActionEvent e) -> {
                JOptionPane.showMessageDialog(frame, "Vous avez choisis : "+item.getText());
            });
            menu.add(item);
        }*/

        /*menuBar.add(menu);
        panel.add(label);
        panel.add(resumeBut);
        panel.add(field);
        frame.setJMenuBar(menuBar);*/
        frame.setResizable(false);
        frame.setSize(new Dimension(300, 400));
        frame.setContentPane(panel);
        panel.setBackground(Color.BLUE);
        frame.setVisible(true);

        //field.addActionListener(new ButtonClick(field, b(panel, field, resumeBut)));
        //resumeBut.addActionListener(new ButtonClick(resumeBut, a(panel)));

        /*field.addActionListener((ActionEvent e) -> {
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
        });*/
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
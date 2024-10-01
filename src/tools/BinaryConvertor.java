package tools;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public final class BinaryConvertor
{
    private BinaryConvertor() {}
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Binary Convertor");
        JPanel panel = new JPanel();
        JTextField binText = new JTextField();

        binText.setPreferredSize(new Dimension(200, 100));
        binText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int number = Integer.parseInt(binText.getText());
                String textRep = "";
                int rep[]={0,0,0,0,0,0,0,0,0};
                int tab[]={256, 128, 64, 32, 16, 8, 4, 2, 1 };
                int i = 0;

                do { 
                    if(number - tab[i] > 0)
                    {
                        number = number - tab[i];
                        rep[i]=1;
                    }
                    else if(number - tab[i] == 0)
                    {
                        number = number - tab[i];
                        rep[i]=1;
                    }
                    i++;
                } while (number != 0);

                for(int k : rep)
                {
                    textRep=textRep+k;
                }
                JOptionPane.showMessageDialog(frame, textRep);
            }
            
        });
        panel.add(binText);
        panel.setBackground(Color.BLUE);
        frame.setContentPane(panel);
        frame.setSize(new Dimension(640, 480));
        frame.setVisible(true);
    }   
}
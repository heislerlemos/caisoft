import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;



public class InventoryView  implements ActionListener {



    @Override
    public void actionPerformed(ActionEvent e){
        JFrame frame2 = new JFrame();


        frame2.setSize(900,500);
        frame2.setResizable(false);
        frame2.setLocationRelativeTo(null);

        Container c = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        c.setBackground(new Color(94, 115, 117));


        JButton button=new JButton("Fechar Janela" );
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addActionListener(event->{
        frame2.dispose();
        });


         c.add(button);

        c.add(Box.createRigidArea(new Dimension(700,0)));

        JLabel numerofunct = new JLabel("Numero :  ");
        numerofunct.setForeground(Color.WHITE);
        JTextField numerofunctfield = new JTextField(80 ) ;

        c.add(numerofunct);
        c.add(numerofunctfield);


        JLabel nomefucnt = new JLabel("Nome : ");
        nomefucnt.setForeground(Color.WHITE);
        JTextField nomefucntfield = new JTextField(80) ;
        c.add(nomefucnt);
        c.add(nomefucntfield);
        c.add(Box.createVerticalStrut(5));


     JLabel nomeartigos = new JLabel("Artigos : ");
     nomeartigos.setForeground(Color.WHITE);
     JTextField nomeartigosfield = new JTextField(80) ;
     c.add(nomeartigos);
     c.add(nomeartigosfield);

    frame2.add(c,BorderLayout.CENTER);
    frame2.setVisible(true);
    }
}
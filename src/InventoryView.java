import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;



public class InventoryView  implements ActionListener {



    @Override
    public void actionPerformed(ActionEvent e){
        JFrame frame2 = new JFrame();
       frame2.setLayout(new FlowLayout());


        frame2.setSize(900,500);
        frame2.setResizable(false);
        frame2.setLocationRelativeTo(null);
        Container c = frame2.getContentPane();


        JLabel titulo = new JLabel("Teste");
        JTextField titulofield = new JTextField(20) ;

        c.add(titulo);
        c.add(titulofield);
        c.add(Box.createVerticalStrut(160));
        JLabel titulo2 = new JLabel("Teste");
        JTextField titulofield2 = new JTextField(20) ;
        c.add(titulo2);
        c.add(titulofield2);


         JButton button=new JButton("Fechar Janela" );
         button.setBounds(30,21,100, 40);

         button.setCursor(new Cursor(Cursor.HAND_CURSOR));

         button.addActionListener(event->{
         frame2.dispose();
         });


        c.add(button);

        frame2.setVisible(true);
    }
}
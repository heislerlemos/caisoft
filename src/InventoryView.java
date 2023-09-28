import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;



public class InventoryView  implements ActionListener {
    public  static JTextField nomeartigosfield;

    public static  JTextField nomefucntfield;

    public static JTextField numerofunctfield;

    public static  JTextField nomedatafied;

    public static JTextArea textArea;

    public static JScrollPane sp ;

    @Override
    public void actionPerformed(ActionEvent e){
        JFrame frame2 = new JFrame();


        frame2.setSize(900,500);
        frame2.setResizable(false);
        frame2.setLocationRelativeTo(null);
     //   frame2.setBounds(400, 400, 900, 900);
        Container c = new JPanel(new FlowLayout(FlowLayout.LEFT));

        c.setBackground(new Color(105,105,105));


        JButton button=new JButton("Fechar Janela" );
        button.setBackground(Color.RED);
        button.setForeground(Color.WHITE);
        button.setOpaque(true);

        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addActionListener(event->{
            frame2.dispose();
        });


        c.add(button);

        c.add(Box.createRigidArea(new Dimension(750,0)));

        JLabel titulo =  new JLabel("Inventario dos utilizadores ");
        titulo.setForeground(Color.WHITE);
        c.add(titulo);
        c.add(Box.createRigidArea(new Dimension(850,0)));


        JLabel numerofunct = new JLabel("Numero :  ");
        numerofunct.setForeground(Color.WHITE);
        numerofunctfield = new JTextField(70 ) ;


        c.add(numerofunct);
        c.add(numerofunctfield);


        JLabel nomefucnt = new JLabel("Nome :      ");
        nomefucnt.setForeground(Color.WHITE);
        nomefucntfield = new JTextField(70) ;
        c.add(nomefucnt);
        c.add(nomefucntfield);


        JLabel nomeartigos = new JLabel("Artigos :   ");
        nomeartigos.setForeground(Color.WHITE);
        nomeartigosfield = new JTextField(70) ;
        c.add(nomeartigos);
        c.add(nomeartigosfield);


        JLabel nomedata = new JLabel("Data :       ");
        nomedata.setForeground(Color.WHITE);
        nomedatafied = new JTextField(10) ;
        c.add(nomedata);
        c.add(nomedatafied);

        JButton buttsubmit=new JButton("Guardar" );
        buttsubmit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        buttsubmit.setBackground(Color.GREEN);
        buttsubmit.setForeground(Color.WHITE);

        buttsubmit.addActionListener(new InventoryController());

        JButton buttsubmitshow=new JButton("Ver Todos Artigos" );
        buttsubmitshow.setCursor(new Cursor(Cursor.HAND_CURSOR));
        buttsubmitshow.setBackground(Color.BLUE);
        buttsubmitshow.setForeground(Color.WHITE);
        buttsubmitshow.addActionListener(new InventoryShowController());


        c.add(Box.createRigidArea(new Dimension(850,0)));
        c.add(Box.createRigidArea(new Dimension(850,0)));


        c.add(buttsubmit);
        c.add(buttsubmitshow);
        sp = new JScrollPane(textArea);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        textArea = new JTextArea(15, 80);
        textArea.setForeground(Color.BLUE);
       // textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));



        sp.getViewport().setBackground(Color.WHITE);
        sp.getViewport().add(textArea);
        c.add(sp);
        frame2.add(c);
        frame2.setVisible(true);

    }
}
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Products_admin extends JFrame implements ActionListener{

    private JPanel panel;
    private JButton b1,b2;


    public Products_admin() {
        super("SuperMarket User Login ");
        setBackground(new Color(255, 255, 204));
        setBounds(600, 300, 600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setBackground(new Color(179, 255, 153));
        setContentPane(panel);
        panel.setLayout(null);

        JLabel l1 = new JLabel("Welcome Admin");
        l1.setFont(new Font("Tahoma", Font.PLAIN, 30));
        l1.setBounds(184, 89, 300, 24);
        panel.add(l1);


        b1 = new JButton("Add Products");
        b1.setFont(new Font("Tahoma", Font.PLAIN, 25));
        b1.addActionListener(this);

        b1.setForeground(new Color(0, 0, 0));
        b1.setBackground(new Color(255, 255, 0));
        b1.setBounds(170, 181, 300, 39);
        panel.add(b1);

        b2 = new JButton("Products List");
        b2.setFont(new Font("Tahoma", Font.PLAIN, 25));
        b2.addActionListener(this);

        b2.setForeground(new Color(139, 69, 19));
        b2.setBackground(new Color(0, 255, 255));
        b2.setBounds(170, 250, 300, 39);
        panel.add(b2);




    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            this.setVisible(false);
            new Add_product().setVisible(true);
        }
        if(ae.getSource() == b2){
            this.setVisible(false);
            new Product_list().setVisible(true);
        }

    }

    public static void main(String[] args) {
        new Products_admin().setVisible(true);
    }

}

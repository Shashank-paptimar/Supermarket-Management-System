import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;

public class Help extends JFrame implements ActionListener{

    private JPanel contentPane;

    public static void main(String[] args) {
        new Help().setVisible(true);
    }

    public Help() {

        super("SuperMarket Management System(Help) ");

        setBackground(new Color(173, 216, 230));
        setBounds(500, 250, 800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel l1 = new JLabel("New label");
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("Images/img_2.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l1 = new JLabel(i3);
        l1.setBounds(500, 40, 100, 100);
        contentPane.add(l1);


        JLabel l3 = new JLabel("SuperMarket");
        l3.setForeground(new Color(0, 250, 154));
        l3.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 34));
        l3.setBounds(160, 40, 400, 55);
        contentPane.add(l3);

        JLabel l4 = new JLabel("Management System");
        l4.setForeground(new Color(127, 255, 0));
        l4.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 34));
        l4.setBounds(70, 90, 405, 40);
        contentPane.add(l4);

        JLabel l5 = new JLabel("v1.0");
        l5.setForeground(new Color(30, 144, 255));
        l5.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        l5.setBounds(185, 140, 100, 21);
        contentPane.add(l5);


        JTextArea l6 = new JTextArea("Developed By :\n Yogeshwar K \n Manoj S \n Surya S \n Shashank P ");
        l6.setForeground(new Color(0xFF0000));
        l6.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        l6.setBounds(70, 198, 500, 170);
        contentPane.add(l6);

        JTextArea l7 = new JTextArea("A supermarket management system is a system where users \n can find the quantity of the products remaining \n before purchasing and admins can add new products and \ntheir quantities");
        l7.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        l7.setBounds(70, 400, 600, 150);
        contentPane.add(l7);



        JButton b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setBorder(new CompoundBorder(new LineBorder(new Color(105, 105, 105)), null));
        b2.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        b2.setBounds(500, 578, 108, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);


    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        this.setVisible(false);
        new Home().setVisible(true);

    }


}
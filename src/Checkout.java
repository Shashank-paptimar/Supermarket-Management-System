import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Checkout extends JFrame implements ActionListener {

    private JPanel panel;
    private JButton b1,b2;
    private JLabel l2;

    public static void main(String[] args) {

        new Checkout().setVisible(true);
    }



    public Checkout() {
        super("SuperMarket User Login ");
        setBackground(new Color(255, 255, 204));
        setBounds(600, 300, 600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setBackground(new Color(179, 255, 153));
        setContentPane(panel);
        panel.setLayout(null);

        JLabel l1 = new JLabel("Amount to be Paid");
        l1.setFont(new Font("Tahoma", Font.PLAIN, 30));
        l1.setBounds(124, 89, 300, 24);
        panel.add(l1);

        l2 = new JLabel();
        l2.setFont(new Font("Tahoma", Font.PLAIN, 30));
        l2.setBounds(124, 189, 300, 24);
        panel.add(l2);



        b1 = new JButton("Home");
        b1.setFont(new Font("Tahoma", Font.PLAIN, 25));
        b1.addActionListener(this);

        b1.setForeground(new Color(0, 0, 0));
        b1.setBackground(new Color(255, 255, 0));
        b1.setBounds(180, 281, 300, 39);
        panel.add(b1);

        try {
            connections con = new connections();
            String sql = "select sum(price) as sumprice from cart";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if(rs.next())
            {
                String sum= rs.getString("sumprice");
                l2.setText(sum);
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }


    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1){
            try {
                connections con =new connections();
                String sql = "truncate table cart";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.executeQuery();

            }
            catch(Exception e){
                e.printStackTrace();
            }

            this.setVisible(false);
            new Home().setVisible(true);
        }

    }

}


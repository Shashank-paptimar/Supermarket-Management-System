
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;

public class Buy_product extends JFrame implements ActionListener{

    private JPanel contentPane;
    JDateChooser dateChooser;
    private JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14;
    private JLabel l10;
    private JButton b1,b2,b3,b4;
    private int num=0;

    public static void main(String[] args) {
        new Buy_product().setVisible(true);

    }

    public Buy_product() {
        super("SuperMarket Management System (Buy Products) ");
        setBounds(300, 200, 700, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel l1 = new JLabel("Product_id");
        l1.setForeground(new Color(47, 79, 79));
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setBounds(73, 84, 90, 22);
        contentPane.add(l1);

        JLabel l2 = new JLabel("Name");
        l2.setForeground(new Color(47, 79, 79));
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setBounds(73, 132, 90, 22);
        contentPane.add(l2);

        JLabel l3 = new JLabel("Price");
        l3.setForeground(new Color(47, 79, 79));
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l3.setBounds(73, 182, 90, 22);
        contentPane.add(l3);

        JLabel l4 = new JLabel("Quantity");
        l4.setForeground(new Color(47, 79, 79));
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setBounds(73, 232, 90, 22);
        contentPane.add(l4);


        t1 = new JTextField();
        t1.setForeground(new Color(47, 79, 79));
        t1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t1.setBounds(169, 85, 198, 20);
        contentPane.add(t1);
        t1.setColumns(10);

        b1 = new JButton("Search");
        b1.addActionListener(this);
        b1.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        b1.setBounds(450, 80, 100, 30);

        contentPane.add(b1);

        t2 = new JTextField();
        t2.setEditable(false);
        t2.setForeground(new Color(47, 79, 79));
        t2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t2.setBounds(169, 135, 208, 20);
        contentPane.add(t2);
        t2.setColumns(10);

        t3 = new JTextField();
        t3.setEditable(false);
        t3.setForeground(new Color(47, 79, 79));
        t3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t3.setColumns(10);
        t3.setBounds(169, 185, 208, 20);
        contentPane.add(t3);

        t4 = new JTextField();
        t4.setEditable(false);
        t4.setForeground(new Color(47, 79, 79));
        t4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t4.setColumns(10);
        t4.setBounds(169, 235, 208, 20);
        contentPane.add(t4);


        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(47, 79, 79), 2, true), "Product Details",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
        panel.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.setBounds(10, 38, 550, 288);
        panel.setBackground(Color.WHITE);
        contentPane.add(panel);

        l10 = new JLabel("Number of products added");
        l10.setForeground(new Color(47, 79, 79));
        l10.setFont(new Font("Tahoma", Font.BOLD, 18));
        l10.setBounds(114, 342, 300, 23);
        contentPane.add(l10);


        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        b2.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
        b2.setBounds(47, 397, 118, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);

        b3 = new JButton("Add to cart");
        b3.addActionListener(this);
        b3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        b3.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
        b3.setBounds(229, 397, 100, 33);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        contentPane.add(b3);

        b4 = new JButton("Buy");
        b4.addActionListener(this);
        b4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        b4.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
        b4.setBounds(410, 397, 100, 33);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        contentPane.add(b4);
    }

    public void actionPerformed(ActionEvent ae){
        try{
            connections con = new connections();
            if(ae.getSource() == b1){
                String sql = "select * from product where product_id = ?";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1, t1.getText());
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("price"));
                    t4.setText(rs.getString("quantity"));

                }
                st.close();
                rs.close();

            }

            if(ae.getSource() == b3){
                try{
                    String sql = "insert into cart(product_id, name, quantity, price) values(?, ?, ?, ?)";
                    PreparedStatement st = con.c.prepareStatement(sql);
                    st.setString(1, t1.getText());
                    st.setString(2, t2.getText());
                    st.setString(3, t4.getText());
                    st.setString(4, t3.getText());


                    int rs = st.executeUpdate();

                    if (rs > 0)
                    {
                        JOptionPane.showMessageDialog(null, "Successfully Added to cart");
                        num=num+1;
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Error");

                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");

                    st.close();

                    l10.setText("Number of products added = "+num);


                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            if(ae.getSource() == b2){
                this.setVisible(false);
                new Products_user().setVisible(true);

            }
            if(ae.getSource() == b4){
                this.setVisible(false);
                new Checkout().setVisible(true);

            }

            con.c.close();
        }catch(Exception e){

        }
    }
}

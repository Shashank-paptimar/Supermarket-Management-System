import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class Add_product extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField t1,t2,t3,t4,t5,t6;
    private JButton b1,b2;
    JComboBox comboBox;

    public static void main(String[] args) {
        new Add_product().setVisible(true);
    }

    public void random() {
        Random rd = new Random();
        t1.setText("" + rd.nextInt(1000 + 1));
    }

    public Add_product() {
        super("SuperMarket Management System (Add product) ");
        setBounds(600, 200, 500, 442);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
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
        l2.setBounds(73, 117, 90, 22);
        contentPane.add(l2);

        JLabel l3 = new JLabel("Price");
        l3.setForeground(new Color(47, 79, 79));
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l3.setBounds(73, 150, 90, 22);
        contentPane.add(l3);

        JLabel l4 = new JLabel("Quantity");
        l4.setForeground(new Color(47, 79, 79));
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setBounds(73, 186, 90, 22);
        contentPane.add(l4);



        t1 = new JTextField();
        t1.setForeground(new Color(47, 79, 79));
        t1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t1.setBounds(169, 88, 198, 20);
        contentPane.add(t1);
        t1.setColumns(10);

        t2 = new JTextField();
        t2.setForeground(new Color(47, 79, 79));
        t2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t2.setColumns(10);
        t2.setBounds(169, 120, 198, 20);
        contentPane.add(t2);

        t3 = new JTextField();
        t3.setForeground(new Color(47, 79, 79));
        t3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t3.setColumns(10);
        t3.setBounds(169, 154, 198, 20);
        contentPane.add(t3);


        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        comboBox.setBounds(169, 186, 194, 20);
        contentPane.add(comboBox);

        b1 = new JButton("Add");
        b1.addActionListener(this);
        b1.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128)), null));
        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        b1.setBounds(102, 300, 100, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setBorder(new CompoundBorder(new LineBorder(new Color(105, 105, 105)), null));
        b2.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        b2.setBounds(212, 300, 108, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        contentPane.add(b2);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(138, 43, 226), 2), "Add Product", TitledBorder.LEADING,
                TitledBorder.TOP, null, new Color(0, 0, 255)));
        panel.setBounds(10, 29, 398, 344);
        contentPane.add(panel);
        panel.setBackground(Color.WHITE);
        contentPane.setBackground(Color.WHITE);
        random();

    }

    public void actionPerformed(ActionEvent ae){
        try{
            connections con = new connections();
            if(ae.getSource() == b1){
                String sql = "insert into product(product_id, name, price, quantity) values(?, ?, ?, ?)";
                PreparedStatement st = con.c.prepareStatement(sql);
                //st.setInt(1, Integer.parseInt(textField.getText()));
                st.setString(1, t1.getText());
                st.setString(2, t2.getText());
                st.setString(3, t3.getText());
                st.setString(4, (String) comboBox.getSelectedItem());


                int rs = st.executeUpdate();
                if (rs > 0)
                    JOptionPane.showMessageDialog(null, "Successfully Added");
                else
                    JOptionPane.showMessageDialog(null, "Error");
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                st.close();
            }
            if(ae.getSource() == b2){
                this.setVisible(false);
                new Products_admin().setVisible(true);

            }
            con.c.close();
        }catch(Exception e){

        }
    }
}


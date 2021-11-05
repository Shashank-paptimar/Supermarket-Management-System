import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Login_user extends JFrame implements ActionListener{

    private JPanel panel;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton b1,b2;


    public Login_user() {
        super("SuperMarket User Login ");
        setBackground(new Color(255, 255, 204));
        setBounds(600, 300, 500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        setContentPane(panel);
        panel.setLayout(null);

        JLabel l1 = new JLabel("Username : ");
        l1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        l1.setBounds(124, 89, 95, 24);
        panel.add(l1);

        JLabel l2 = new JLabel("Password : ");
        l2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        l2.setBounds(124, 124, 95, 24);
        panel.add(l2);

        textField = new JTextField();
        textField.setBounds(210, 93, 157, 20);
        textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel.add(textField);

        passwordField = new JPasswordField();
        passwordField.setBounds(210, 128, 157, 20);
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel.add(passwordField);

        JLabel l3 = new JLabel("");
        l3.setBounds(377, 79, 46, 34);
        panel.add(l3);

        JLabel l4 = new JLabel("");
        l4.setBounds(377, 124, 46, 34);
        l4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel.add(l3);

        b1 = new JButton("Login");
        b1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        b1.addActionListener(this);

        b1.setForeground(new Color(0, 0, 0));
        b1.setBackground(new Color(255, 255, 0));
        b1.setBounds(149, 181, 113, 39);
        panel.add(b1);

        b2 = new JButton("SignUp");
        b2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        b2.addActionListener(this);

        b2.setForeground(new Color(139, 69, 19));
        b2.setBackground(new Color(0, 255, 255));
        b2.setBounds(289, 181, 113, 39);
        panel.add(b2);



        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(255, 255, 204));
        panel2.setBorder(new TitledBorder(new LineBorder(new Color(255, 80, 80), 3), "Welcome to SuperMarket",
                TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel2.setBounds(24, 40, 434, 263);
        panel.add(panel2);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            Boolean status = false;
            try {
                connections con = new connections();
                String sql = "select * from account where username=? and password=?";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, textField.getText());
                st.setString(2, passwordField.getText());

                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    this.setVisible(false);
                    new Products_user().setVisible(true);
                } else
                    JOptionPane.showMessageDialog(null, "Invalid Login Details...!.");

            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if(ae.getSource() == b2){
            setVisible(false);
            Signup su = new Signup();
            su.setVisible(true);
        }

    }

    public static void main(String[] args) {
        new Login_user().setVisible(true);
    }

}

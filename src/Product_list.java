import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.awt.event.*;

public class Product_list extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTable table;
    private JTextField search;
    private JButton b1,b2,b3;

    public static void main(String[] args) {
        new Product_list().setVisible(true);
    }

    public void Book() {

        try {
            connections con = new connections();
            String sql = "select * from product";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            table.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            st.close();
            con.c.close();
        } catch (Exception e) {

        }
    }

    public Product_list() {
        super("SuperMarket Management System (Book Details) ");
        setBounds(350, 200, 890, 475);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(79, 133, 771, 282);
        contentPane.add(scrollPane);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                int row = table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row, 1).toString());
            }
        });
        table.setBackground(new Color(240, 248, 255));
        table.setForeground(Color.DARK_GRAY);
        table.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        scrollPane.setViewportView(table);

        JButton b1 = new JButton("Search");
        b1.addActionListener(this);
        b1.setBorder(new LineBorder(new Color(255, 20, 147), 2, true));

        b1.setForeground(new Color(199, 21, 133));
        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        b1.setBounds(564, 89, 138, 33);
        contentPane.add(b1);

        JButton b2 = new JButton("Delete");
        b2.addActionListener(this);

        b2.setForeground(new Color(199, 21, 133));
        b2.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        b2.setBorder(new LineBorder(new Color(255, 20, 147), 2, true));
        b2.setBounds(712, 89, 138, 33);
        contentPane.add(b2);


        JLabel l1 = new JLabel("Product Details");
        l1.setForeground(new Color(107, 142, 35));
        l1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 30));
        l1.setBounds(300, 15, 400, 47);
        contentPane.add(l1);


        search = new JTextField();
        search.setBackground(new Color(255, 240, 245));
        search.setBorder(new LineBorder(new Color(255, 105, 180), 2, true));
        search.setForeground(new Color(47, 79, 79));
        search.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 17));
        search.setBounds(189, 89, 357, 33);
        contentPane.add(search);
        search.setColumns(10);

        b3 = new JButton("Back");
        b3.addActionListener(this);
        b3.setForeground(new Color(199, 21, 133));
        b3.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        b3.setBorder(new LineBorder(new Color(255, 20, 147), 2, true));
        b3.setBounds(752, 20, 80, 33);
        add(b3);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 128, 128), 3, true), "Product-Details",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
        panel.setBounds(67, 54, 793, 368);
        contentPane.add(panel);
        panel.setBackground(Color.WHITE);
        Book();
    }

    public void actionPerformed(ActionEvent ae){

        try{

            connections con = new connections();
            if(ae.getSource() == b1){

                String sql = "select * from book where concat(name, book_id) like ?";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1, "%" + search.getText() + "%");
                ResultSet rs = st.executeQuery();

                table.setModel(DbUtils.resultSetToTableModel(rs));
                rs.close();
                st.close();

            }
            if(ae.getSource() == b2){
                String sql = "delete from book where name = '" + search.getText() + "'";
                PreparedStatement st = con.c.prepareStatement(sql);

                JDialog.setDefaultLookAndFeelDecorated(true);
                int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.NO_OPTION) {

                } else if (response == JOptionPane.YES_OPTION) {
                    int rs = st.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Deleted !!");
                } else if (response == JOptionPane.CLOSED_OPTION) {

                }
                st.close();
                con.c.close();
            }
            if(ae.getSource() == b3){
                this.setVisible(false);
                new Products_user().setVisible(true);
            }
        }catch(Exception e){

        }

    }
}
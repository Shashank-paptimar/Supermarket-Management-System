import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JButton b1, b2;

    public static void main(String[] args) {

        new Home().setVisible(true);
    }

    public Home() {
        super("SuperMarket Management System (Home)");
        setBounds(400, 150, 1000, 700);
        setBackground(new Color(255, 255, 204));
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 204));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 128, 0), new Color(128, 128, 128)));
        menuBar.setBackground(Color.CYAN);
        menuBar.setBounds(0, 10, 1000, 35);
        contentPane.add(menuBar);

        JMenu mnExit = new JMenu("Exit");
        mnExit.setFont(new Font("Trebuchet MS", Font.BOLD, 17));


        JMenuItem mntmLogout = new JMenuItem("Logout");
        mntmLogout.setBackground(new Color(211, 211, 211));
        mntmLogout.setForeground(new Color(105, 105, 105));
        mntmLogout.addActionListener(this);
        mnExit.add(mntmLogout);

        JMenuItem mntmExit = new JMenuItem("Exit");
        mntmExit.setForeground(new Color(105, 105, 105));
        mntmExit.setBackground(new Color(211, 211, 211));
        mntmExit.addActionListener(this);
        mnExit.add(mntmExit);


        JMenu mnHelp = new JMenu("Help");
        mnHelp.setFont(new Font("Trebuchet MS", Font.BOLD, 17));


        JMenuItem mntmReadme = new JMenuItem("Read Me");
        mntmReadme.setBackground(new Color(211, 211, 211));
        mntmReadme.setForeground(new Color(105, 105, 105));
        mntmReadme.addActionListener(this);
        mnHelp.add(mntmReadme);


        menuBar.add(mnHelp);
        menuBar.add(mnExit);

        JLabel l1 = new JLabel("SuperMarket Management System");
        l1.setForeground(new Color(204, 51, 102));
        l1.setFont(new Font("Segoe UI Semilight", Font.BOLD, 30));
        l1.setBounds(250, 30, 701, 80);
        contentPane.add(l1);

        JLabel l2 = new JLabel("");
        l2.setVerticalAlignment(SwingConstants.TOP);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/img_3.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l2 = new JLabel(i3);
        l2.setBounds(60, 130, 200, 200);
        contentPane.add(l2);

        JLabel l3 = new JLabel("");
        ImageIcon i4  = new ImageIcon(ClassLoader.getSystemResource("Images/img_1.png"));
        Image i5 = i4.getImage().getScaledInstance(150, 200,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        l3 = new JLabel(i6);
        l3.setBounds(350, 412, 200, 200);
        contentPane.add(l3);

        b1 = new JButton("User Login");
        b1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(450, 200, 159, 44);
        contentPane.add(b1);

        b2 = new JButton("Admin Login");
        b2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(750, 500, 139, 44);
        contentPane.add(b2);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255), 3), "", TitledBorder.RIGHT,
                TitledBorder.TOP, null, new Color(255, 0, 0)));
        panel.setBounds(20, 120, 700, 220);
        panel.setBackground(Color.lightGray);
        contentPane.add(panel);

        JPanel panel2 = new JPanel();
        panel2.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255), 3), "", TitledBorder.RIGHT,
                TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel2.setBounds(270, 400, 700, 220);
        panel2.setBackground(Color.pink);
        contentPane.add(panel2);

        getContentPane().setBackground(Color.WHITE);
        contentPane.setBackground(Color.WHITE);
    }


    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();

        if(msg.equals("Logout")){
            setVisible(false);
            new Login_user().setVisible(true);
        }else if(msg.equals("Exit")){
            System.exit(ABORT);

        }else if(msg.equals("Read Me")){
            setVisible(false);
            new Help().setVisible(true);
        }

        if(ae.getSource() == b1){
            this.setVisible(false);
            new Login_user().setVisible(true);
        }
        if(ae.getSource() == b2){
            this.setVisible(false);
            new Login_admin().setVisible(true);
        }
    }

}
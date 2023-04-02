import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class LoginRegWindow  {
    DataBaseConnection dbc = new DataBaseConnection();
    static JFrame mainFrame;
    JPanel login;
    JPanel reg;
    JLabel uid, upassword, bgimg, usertype, name, password, mobileno, mailid, regusertype, reguid;
    JTextField uidtxt, regnametxt, regunametxt, regmobilenotxt, regemailtxt, regPersonIDTxt;
    JPasswordField passwordField, regpasswordField;
    JButton clearbtn, loginbtn, registerbtn, backbtn, regclearbtn, regsubmitbtn, forgotUID_Pass;
    String []usertypes = {"Teacher", "Student"};
    public LoginRegWindow()
    {
        DataBaseConnection.getConnection();
        ImageIcon img = new ImageIcon("D:\\DBMS COURSE PROJECT\\.idea\\Background2.jpg");
        GridBagConstraints gbg = new GridBagConstraints();
        mainFrame = new JFrame("ID Card Generation System");
        //Login panel form(line 19 -100)
        login = new JPanel();
        reg = new JPanel();
        uid = new JLabel("User ID:");
        uid.setFont(new Font("Georgia", Font.BOLD, 24));
        uid.setForeground(new Color(255,255, 255));
        uidtxt = new JTextField(15);
        upassword = new JLabel("Password:");
        upassword.setForeground(new Color(255, 255, 255));
        bgimg = new JLabel(img);
        usertype = new JLabel("Login as:");
        usertype.setFont(new Font("Georgia", Font.BOLD, 24));
        usertype.setForeground(new Color(255, 255, 255));
        passwordField = new JPasswordField(15);
        clearbtn = new JButton("Clear");
        clearbtn.setBackground(new Color(176, 224, 230));
        clearbtn.setFont(new Font("Georgia", Font.BOLD, 18));
        loginbtn = new JButton("Login");
        loginbtn.setBackground(new Color(176, 224, 230));
        loginbtn.setFont(new Font("Georgia", Font.BOLD, 18));
        registerbtn = new JButton("Register");
        registerbtn.setFont(new Font("Georgia", Font.BOLD, 18));
        registerbtn.setBackground(new Color(176, 224, 230));
        upassword.setFont(new Font("Georgia", Font.BOLD, 24));
        login.setSize(400, 500);
        login.setLocation(580, 50);
        login.setBackground(new Color(33, 33, 33, 60));
        login.setLayout(new GridBagLayout());
        reg.setSize(400, 600);
        reg.setLocation(580, 50);
        reg.setBackground(new Color(33, 33, 33, 60));
        reg.setLayout(new GridBagLayout());
        gbg.gridx = 0;
        gbg.gridy = 0;
        gbg.ipadx = 10;
        gbg.ipady = 20;
        login.add(uid, gbg);
        gbg.gridx = 0;
        gbg.gridy = 1;
        gbg.ipadx = 10;
        gbg.ipady = 20;
        login.add(upassword, gbg);
        gbg.gridx = 1;
        gbg.gridy = 0;
        gbg.ipadx = 20;
        gbg.insets = new Insets(0, 20, 0, 0);
        login.add(uidtxt, gbg);
        gbg.gridx = 1;
        gbg.gridy = 1;
        gbg.ipadx = 20;
        gbg.insets = new Insets(20, 20, 0, 0);
        login.add(passwordField, gbg);
        gbg.gridx = 0;
        gbg.gridy = 4;
        gbg.ipady = 10;
        gbg.insets = new Insets(20, 20, 0, 0);
        JButton lPassViewBtn = new JButton("View password");
        lPassViewBtn.setFont(new Font("Georgia", Font.BOLD, 16));
        lPassViewBtn.setBackground(new Color(176, 224, 230));
        gbg.gridx = 1;
        gbg.gridy = 5;
        login.add(lPassViewBtn, gbg);
        gbg.gridx = 0;
        gbg.gridy = 6;
        login.add(clearbtn, gbg);
        gbg.gridx = 1;
        gbg.gridy = 6;
        gbg.ipady = 10;
        gbg.insets = new Insets(20, 20, 0, 0);
        login.add(loginbtn, gbg);
        gbg.gridx = 0;
        gbg.gridy = 7;
        gbg.ipadx = 10;
        gbg.ipady = 10;
        gbg.insets = new Insets(20, 20, 0, 0);
        login.add(registerbtn, gbg);
        forgotUID_Pass = new JButton("Forgot UID or pass");
        forgotUID_Pass.setFont(new Font("Georgia", Font.BOLD, 16));
        forgotUID_Pass.setBackground(new Color(176, 224, 230));
        forgotUID_Pass.addActionListener(e ->
        {
            String input = JOptionPane.showInputDialog(mainFrame, "Enter your mobile number");
            try
            {
                ResultSet resultSet = dbc.getUIDAndPassword(input);
                resultSet.next();
                JOptionPane.showMessageDialog(mainFrame, "UID:" + resultSet.getString("username") + ", password:" + resultSet.getString("password"));
            }
            catch (Exception exp){System.out.println(exp.getMessage());}
        });
        gbg.gridx = 1;
        gbg.gridy = 7;
        login.add(forgotUID_Pass, gbg);
        //Register panel
        name = new JLabel("Name:");
        name.setFont(new Font("Georgia", Font.BOLD, 24));
        name.setForeground(new Color(255, 255, 255));
        reguid = new JLabel("Username:");
        reguid.setFont(new Font("Georgia", Font.BOLD, 24));
        reguid.setForeground(new Color(255, 255, 255));
        mobileno = new JLabel("Mobile Number:");
        mobileno.setFont(new Font("Georgia", Font.BOLD, 24));
        mobileno.setForeground(new Color(255, 255, 255));
        password = new JLabel("Password:");
        password.setFont(new Font("Georgia", Font.BOLD, 24));
        password.setForeground(new Color(255, 255, 255));
        mailid = new JLabel("Email ID:");
        mailid.setFont(new Font("Georgia", Font.BOLD, 24));
        mailid.setForeground(new Color(255, 255, 255));
        gbg.gridx = 0;
        gbg.gridy = 0;
        gbg.insets = new Insets(10, 0, 10,10);
        reg.add(name, gbg);
        gbg.gridx = 0;
        gbg.gridy = 1;
        gbg.insets = new Insets(10, 0, 10, 10);
        reg.add(mobileno, gbg);
        gbg.gridx = 0;
        gbg.gridy = 2;
        gbg.insets = new Insets(10, 0, 10, 10);
        reg.add(reguid, gbg);
        gbg.gridx = 0;
        gbg.gridy = 3;
        gbg.insets = new Insets(10, 0, 10, 10);
        reg.add(password, gbg);
        gbg.gridx = 0;
        gbg.gridy = 5;
        gbg.insets = new Insets(10, 0, 10, 10);
        reg.add(mailid, gbg);
        regclearbtn = new JButton("Clear");
        regclearbtn.setBackground(new Color(176, 224, 230));
        regclearbtn.setFont(new Font("Georgia", Font.BOLD, 18));
        regsubmitbtn = new JButton("Submit");
        regsubmitbtn.setBackground(new Color(176, 224, 230));
        regsubmitbtn.setFont(new Font("Georgia", Font.BOLD, 18));
        backbtn = new JButton("<- Back");
        backbtn.setBackground(new Color(176, 224, 230));
        backbtn.setFont(new Font("Georgia", Font.BOLD, 18));
        gbg.gridx = 0;
        gbg.gridy = 7;
        gbg.insets = new Insets(10, 0, 10,1);
        reg.add(regclearbtn, gbg);
        gbg.gridx = 1;
        gbg.gridy = 7;
        gbg.insets = new Insets(10, 0, 10,1);
        reg.add(regsubmitbtn, gbg);
        gbg.gridx = 1;
        gbg.gridy = 8;
        gbg.insets = new Insets(10, 0, 10,1);
        reg.add(backbtn, gbg);
        regunametxt = new JTextField(15);
        regnametxt = new JTextField(15);
        regmobilenotxt = new JTextField(15);
        regemailtxt = new JTextField(15);
        regpasswordField = new JPasswordField(15);
        gbg.gridx = 1;
        gbg.gridy = 0;
        reg.add(regnametxt, gbg);
        gbg.gridx = 1;
        gbg.gridy = 1;
        reg.add(regmobilenotxt, gbg);
        gbg.gridx = 1;
        gbg.gridy = 2;
        reg.add(regunametxt, gbg);
        gbg.gridx = 1;
        gbg.gridy = 3;
        reg.add(regpasswordField, gbg);
        JButton viewBtn = new JButton("View password");
        viewBtn.setBackground(new Color(176, 224, 230));
        viewBtn.setFont(new Font("Georgia", Font.BOLD, 16));
        gbg.gridx = 1;
        gbg.gridy = 4;
        reg.add(viewBtn, gbg);
        gbg.gridx = 1;
        gbg.gridy = 5;
        reg.add(regemailtxt, gbg);
        regclearbtn.addActionListener(e -> {
            regnametxt.setText("");
            regmobilenotxt.setText("");
            regunametxt.setText("");
            regpasswordField.setText("");
            regemailtxt.setText("");
        });
        clearbtn.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent e)
            {
                clearbtn.setBackground(new Color(135, 206, 235));
            }
        });
        clearbtn.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseExited(MouseEvent e)
            {
                clearbtn.setBackground(new Color(176, 224, 230));
            }
        });
        clearbtn.addActionListener(e -> {
            if(e.getSource() == clearbtn)
            {
                uidtxt.setText("");
                passwordField.setText("");
            }
        });
        loginbtn.addActionListener(e -> {
            //login for JDBC
            try
            {
                if(dbc.login(uidtxt.getText(), String.valueOf(passwordField.getPassword())))
                {
                    mainFrame.dispose();
                    new IDCardFromFrame();
                }
                else JOptionPane.showMessageDialog(mainFrame, "Invalid username or password!");
            }
            catch (Exception exception)
            {
                System.out.println(exception.getMessage());
            }

        });
        loginbtn.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent e)
            {
                loginbtn.setBackground(new Color(135, 206, 235));
            }
        });
        loginbtn.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseExited(MouseEvent e)
            {
                loginbtn.setBackground(new Color(176,224, 230));
            }
        });
        registerbtn.addActionListener(e -> {
            login.setVisible(false);
            reg.setVisible(true);
        });
        registerbtn.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent e)
            {
                registerbtn.setBackground(new Color(135, 206, 235));
            }
        });
        registerbtn.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseExited(MouseEvent e)
            {
                registerbtn.setBackground(new Color(176, 224, 230));
            }
        });
        regclearbtn.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent e)
            {
                regclearbtn.setBackground(new Color(135, 206, 235));
            }
        });
        regclearbtn.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseExited(MouseEvent e)
            {
                regclearbtn.setBackground(new Color(176, 224, 230));
            }
        });
        regsubmitbtn.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent e)
            {
                regsubmitbtn.setBackground(new Color(135, 206, 235));
            }
        });
        regsubmitbtn.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseExited(MouseEvent e)
            {
                regsubmitbtn.setBackground(new Color(176, 224, 230));
            }
        });
        regsubmitbtn.addActionListener(e -> {
            try
            {
                if(dbc.registration(regnametxt.getText(), regunametxt.getText(), String.valueOf(regpasswordField.getPassword()), regmobilenotxt.getText(), regemailtxt.getText())
                )
                {
                    JOptionPane.showMessageDialog(mainFrame, "Registration Successful!");
                }
                else JOptionPane.showMessageDialog(mainFrame, "Username and Password already exists!");
            }
            catch (Exception exception) {System.out.println(exception.getMessage());};
        });
        backbtn.addActionListener(e -> {
            reg.setVisible(false);
            login.setVisible(true);
        });
        backbtn.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent e)
            {
                backbtn.setBackground(new Color(135, 206, 235));
            }
        });
        backbtn.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseExited(MouseEvent e)
            {
                backbtn.setBackground(new Color(176, 224, 230));
            }
        });
        viewBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                viewBtn.setBackground(new Color(135, 206, 235));
            }
    });
        viewBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                viewBtn.setBackground(new Color(176, 224, 230));
            }
        });
        lPassViewBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lPassViewBtn.setBackground(new Color(135, 206, 235));
            }
        });
        lPassViewBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                lPassViewBtn.setBackground(new Color(176, 224, 230));
            }
        });
        char echoChar = regpasswordField.getEchoChar();
        viewBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                regpasswordField.setEchoChar((char)0);
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                regpasswordField.setEchoChar(echoChar);
            }
        });
        lPassViewBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                passwordField.setEchoChar((char)0);
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                passwordField.setEchoChar(echoChar);
            }
        });
        forgotUID_Pass.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                forgotUID_Pass.setBackground(new Color(135, 206, 235));
            }
        });
        forgotUID_Pass.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                forgotUID_Pass.setBackground(new Color(176, 224, 230));
            }
        });
        reg.setVisible(false);
        mainFrame.setLayout(null);
        mainFrame.setContentPane(bgimg);
        mainFrame.setSize(1000, 720);
        mainFrame.add(login);
        mainFrame.add(reg);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String []args)
    {
        new LoginRegWindow();
    }
}
import javax.swing.*;

public class IDcard {
    private JPanel IDcardpanel;
    private JLabel collegelogo;
    private JLabel Studentname;
    private JLabel mobile;
    private JLabel Address;
    private JLabel branch;
    private JLabel studentid;
    private JPanel uprpanel;
    private JPanel mpanel1;
    private JPanel mpanel2;
    private JPanel mpanel3;
    private JPanel lwrpanel1;
    private JPanel lwrpanel2;

    public IDcard()
    {
        JFrame frame = new JFrame("ID card");
        frame.setContentPane(IDcardpanel);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        IDcardpanel.setVisible(true);
        uprpanel.setVisible(true);
        frame.add(IDcardpanel);
        frame.add(uprpanel);
        frame.add(mpanel1);
        frame.add(mpanel2);
        frame.add(mpanel3);
        frame.add(lwrpanel1);
        frame.add(lwrpanel2);
    }
    public static void main(String []args)
    {
        IDcard id = new IDcard();
        TestPrintJob tpj = new TestPrintJob();
        tpj.print(id.IDcardpanel);
    }
}

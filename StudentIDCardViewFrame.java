import javax.swing.*;
import java.awt.*;

public class StudentIDCardViewFrame
{
    JFrame mainFrame;
    JPanel panel;
    IDCardFromFrame ID = new IDCardFromFrame();
    public StudentIDCardViewFrame()
    {
        GridBagConstraints gbc = new GridBagConstraints();
        mainFrame = new JFrame();
        mainFrame.setSize(1028, 720);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
        mainFrame.setLayout(null);
        panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(ID.IDCardPanel.getPreferredSize());
        mainFrame.add(panel);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public ImageIcon resize(String imgPath, JLabel label)
    {
        ImageIcon icon = null;
        try
        {
            icon = new ImageIcon(imgPath);
        }catch (Exception e){JOptionPane.showMessageDialog(mainFrame, "Invalid Image path!");}
        Image myImage = icon.getImage();
        Image scaledImage = myImage.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }
    public static void main(String []args)
    {new StudentIDCardViewFrame();}
}

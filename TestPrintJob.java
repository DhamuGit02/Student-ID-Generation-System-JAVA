import javax.swing.*;
import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class TestPrintJob extends JFrame
{
    static JPanel panel;
    static JFrame frame;
    public TestPrintJob()
    {
        frame = new JFrame("Print Test Frame");
        panel = new JPanel();
        JLabel greet = new JLabel("Hello Dharmesh");
        greet.setFont(new Font("Georgia", Font.ITALIC, 24));
        greet.setForeground(new Color(255, 255, 255));
        panel.setBackground(new Color(100));
        panel.setLayout(new GridBagLayout());
        frame.add(panel);
        panel.add(greet);
        frame.setSize(1280, 720);
        panel.setSize(new Dimension(frame.getPreferredSize()));
        frame.setVisible(true);
        panel.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void print(JPanel panel)
    {
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setJobName("Test Print");
        printerJob.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException
            {
                if(pageIndex > 0)
                {
                    return Printable.NO_SUCH_PAGE;
                }
                Graphics2D graphics2D = (Graphics2D) graphics;
                graphics2D.translate(pageFormat.getImageableX() * 2, pageFormat.getImageableY() * 2);
                graphics2D.scale(0.5, 0.5);
                panel.print(graphics2D);
                return Printable.PAGE_EXISTS;
            }
        });
        boolean returningresult = printerJob.printDialog();
        if(returningresult)
        {
            try
            {
                printerJob.print();
            }catch (PrinterException pe)
            {
                JOptionPane.showMessageDialog(this, "Print Error: " +  pe.getMessage());
            }
            finally {
                printerJob.cancel();
            }
        }
    }
    public static void main(String []args)
    {
        TestPrintJob tpj = new TestPrintJob();
        LoginRegWindow lrw = new LoginRegWindow();
        tpj.print(lrw.login);
    }
}

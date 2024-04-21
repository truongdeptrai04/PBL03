package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JSplitPane;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.JLayeredPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Component;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import java.awt.Canvas;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;

public class loginView extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;
    private JLabel imageLabel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    loginView frame = new loginView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

//    private void loadImage(String imagePath) {
//        try {
//            // Đọc ảnh từ tệp tin
//            BufferedImage img = ImageIO.read(new File(imagePath));
//            if (img == null) {
//                System.out.println("Không thể đọc tệp tin ảnh.");
//                return;
//            }
//            // Thay đổi kích thước ảnh nếu cần
//            Image scaledImage = img.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
//            // Đặt ảnh vào JLabel
//            imageLabel.setIcon(new ImageIcon(scaledImage));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public loginView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1400, 800);
        contentPane = new JPanel();
        contentPane.setAutoscrolls(true);
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(19, 125, 21), 3, true));
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(200, 100, 1000, 600);
        contentPane.add(panel);
        panel.setLayout(null);

        textField = new JTextField();
        textField.setBorder(new LineBorder(new Color(0, 128, 0), 5, true));
        textField.setFont(new Font("Tahoma", Font.PLAIN, 30));
        textField.setBounds(60, 140, 400, 70);
        panel.add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBorder(new LineBorder(new Color(0, 128, 0), 5, true));
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 30));
        passwordField.setBounds(60, 250, 400, 70);
        panel.add(passwordField);

        JLabel lblNewLabel = new JLabel("Login");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
        lblNewLabel.setBounds(190, 50, 120, 55);
        panel.add(lblNewLabel);

        imageLabel = new JLabel("");
        imageLabel.setIcon(new ImageIcon("C:\\Users\\truong\\Desktop\\OIP.jpg"));
        imageLabel.setBounds(513, 151, 376, 351);
        panel.add(imageLabel);
        
        JButton btnNewButton = new JButton("L O G I N");
        btnNewButton.setBackground(new Color(47, 138, 86));
        btnNewButton.setBorder(UIManager.getBorder("DesktopIcon.border"));
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
        btnNewButton.setBounds(60, 402, 400, 70);
        panel.add(btnNewButton);
//        loadImage("C:/Users/truong/git/repository/image/IMG_2812.HEIC");

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(19, 125, 21));
        panel_1.setBounds(0, 0, 1390, 390);
        contentPane.add(panel_1);
    }
}
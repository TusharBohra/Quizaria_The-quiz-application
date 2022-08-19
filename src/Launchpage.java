import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Launchpage implements ActionListener {
    JFrame frame = new JFrame();
    JLabel label = new JLabel();
    JLabel label1 = new JLabel();
    JButton myButton = new JButton();

    Launchpage(){
        label.setText("Quizaria");
        label.setBounds(250,10,500,60);
        label.setForeground(new Color(247,202,101,255));
        label.setFont(new Font("Cambria",Font.PLAIN,50));

        label1.setText("<html> A short introduction about the quiz goal and any information that might be important to the visitors</html> ");
        label1.setBounds(50,80 ,600,60);
        label1.setForeground(Color.white);
        label1.setFont(new Font("Cambria",Font.PLAIN,18));


        myButton.setBounds(250,200,200,40);
        myButton.setFocusable(false);
        myButton.setText("Start Quiz");
        myButton.setSize(200,40);
        myButton.setFont(new Font("Cambria",Font.PLAIN,15));
        myButton.addActionListener(this);
        myButton.setForeground(new Color(35,51,59));
        myButton.setBackground(new Color(247,202,101,255));

        frame.getContentPane().setBackground(new Color(35,51,59));
        frame.add(label);
        frame.add(label1);
        frame.add(myButton);
        frame.setLocation(450,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==myButton){
            frame.dispose();
                new onlineTest("Online Test app");
        }
    }
}

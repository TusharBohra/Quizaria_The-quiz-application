import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class onlineTest extends JFrame implements ActionListener {

    JLabel label;
    JRadioButton radioButton[] = new JRadioButton[5];
    JButton btnNext, btnBookmark;
    ButtonGroup bg;
    int count = 0, current = 0, x = 1, y = 1, now = 0;
    int m[] = new int[8];

    onlineTest(String message) {
        super(message);
        label = new JLabel();
        add(label);

        bg = new ButtonGroup();
        for (int i = 0; i < 5; i++) {
            radioButton[i] = new JRadioButton();
            add(radioButton[i]);
            bg.add(radioButton[i]);
            radioButton[i].setForeground(Color.WHITE);
            radioButton[i].setBackground(new Color(35,51,59));
        }
        label.setForeground(Color.WHITE);
        btnNext = new JButton("Next");
        btnBookmark = new JButton("Bookmark");

        btnNext.setForeground(new Color(35,51,59));
        btnNext.setBackground(new Color(247,202,101,255));
        btnBookmark.setForeground(new Color(35,51,59));
        btnBookmark.setBackground(new Color(247,202,101,255));

        btnNext.addActionListener(this);
        btnBookmark.addActionListener(this);
        add(btnNext);
        add(btnBookmark);
        set_Method();
        label.setBounds(30, 40, 450, 20);
        radioButton[0].setBounds(50, 80, 100, 20);
        radioButton[1].setBounds(50, 110, 100, 20);
        radioButton[2].setBounds(50, 140, 100, 20);
        radioButton[3].setBounds(50, 170, 100, 20);
        btnNext.setBounds(100, 240, 100, 30);
        btnBookmark.setBounds(270, 240, 100, 30);
        getContentPane().setBackground(new Color(35,51,59));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(500, 200);
        setVisible(true);
        setSize(600, 350);

    }

    void set_Method() {

        radioButton[4].setSelected(true);
        if (current == 0) {
            label.setText("Ques 1. \t" +
                    "World Ranger Day is being celebrated on which date?");
            radioButton[0].setText("A.\tJuly 28");
            radioButton[1].setText("B.\tJuly 30");
            radioButton[2].setText("C.\tJuly 29");
            radioButton[3].setText("D.\tJuly 31");
        }
        if (current == 1) {
            label.setText("Ques 2. \t" +
                    "Prime Minister Narendra Modi has launched the IIBX in which state?");
            radioButton[0].setText("A.\tRajasthan");
            radioButton[1].setText("B.\tUttarakhand");
            radioButton[2].setText("C.\tUttar Pradesh");
            radioButton[3].setText("D.\tGujarat");
        }
        if (current == 2) {
            label.setText("Ques 3. \t" +
                    "The Agricultural Census is conducted in the interval of how many years in India?");
            radioButton[0].setText("A.\t10");
            radioButton[1].setText("B.\t5");
            radioButton[2].setText("C.\t2");
            radioButton[3].setText("D.\t3");
        }
        if (current == 3) {
            label.setText("Ques 4. \t" +
                    "In which country, the largest pink diamond in 300 years named 'Lulo Rose', has been found?");
            radioButton[0].setText("A.\tAngola");
            radioButton[1].setText("B.\tOman");
            radioButton[2].setText("C.\tSudan");
            radioButton[3].setText("D.\tGhana");
        }
        if (current == 4) {
            label.setText("Ques 5. \t" +
                    "England's Leicester Cricket Ground has been named after which legendary cricketer?");
            radioButton[0].setText("A.\tRahul Dravid");
            radioButton[1].setText("B.\tSunil Gavaskar");
            radioButton[2].setText("C.\tVVS Laxman");
            radioButton[3].setText("D.\tSachin Tendulkar");
        }
        if (current == 5) {
            label.setText("Ques 6. \t" +
                    "Which state hosted the FIDE Chess Olympiad for the first time in India?");
            radioButton[0].setText("A.\tOdisha");
            radioButton[1].setText("B.\tMaharashtra");
            radioButton[2].setText("C.\tTamil Nadu");
            radioButton[3].setText("D.\tTelangana");
        }
        if (current == 6) {
            label.setText("Ques 7. \t" +
                    "Tadoba Tiger Reserve, which hosted the Global Tiger Day Celebrations, is located in which Indian state?");
            radioButton[0].setText("A.\tAndhra Pradesh");
            radioButton[1].setText("B.\tMaharashtra");
            radioButton[2].setText("C.\tSikkim");
            radioButton[3].setText("D.\tGujarat");
        }
        if (current == 7) {
            label.setText("Ques 8. \t" +
                    "The 'Dinesh Shahra Lifetime Award' is associated with which fields?");
            radioButton[0].setText("A.\tActing");
            radioButton[1].setText("B.\tMusic");
            radioButton[2].setText("C.\tPhilanthropy");
            radioButton[3].setText("D.\tSports");
        }
        label.setBounds(30, 40, 450, 20);
        for (int i = 0, j = 0; i <= 90; i += 30, j++) {
            radioButton[j].setBounds(50, 80 + i, 200, 20);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if((e.getSource()) == btnNext){
            if(check())
                count = count +1;
            current++;
            set_Method();
            if(current == 7){
                btnNext.setEnabled(false);
                btnBookmark.setText("Result");
            }
        }
        if(e.getActionCommand().equals("Bookmark")){
            JButton bk =new JButton("Bookmark" + x);
            bk.setBounds(480 ,20 +40 * x,100,30);
            add(bk);
            bk.addActionListener(this);
            m[x] = current;
            x++;
            current++;
            set_Method();
            if(current==9){
                btnBookmark.setText("Result");
            }
            setVisible(false);
            setVisible(true);
        }

        for(int i=0 ,y = 1; i<x; i++, y++){
            if(e.getActionCommand().equals("Bookmark" + y)){
                if(check())
                    count += 1;
                now = current;
                current = m[y];
                set_Method();
                ((JButton)e.getSource()).setEnabled(false);
                current = now;
            }
        }
        if(e.getActionCommand().equals("Result")){
            if(check())
                count += count;
            current++;
            JOptionPane.showMessageDialog(this,"correct answers= "+count);
            System.exit(0);
        }
    }

    private boolean check() {
        if(current == 0)
            return (radioButton[3].isSelected());
        if(current == 1)
            return (radioButton[3].isSelected());
        if(current == 2)
            return (radioButton[1].isSelected());
        if(current == 3)
            return (radioButton[0].isSelected());
        if(current == 4)
            return (radioButton[1].isSelected());
        if(current == 5)
            return (radioButton[2].isSelected());
        if(current == 6)
            return (radioButton[3].isSelected());
        if(current == 7)
            return (radioButton[1].isSelected());
        return false;
    }
}

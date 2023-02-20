import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;


public class FastCash  extends JFrame implements ActionListener {

    JButton A, B, C, D, E, F, back;

    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 880);
        add(image);

        JLabel text  = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        A = new JButton("Rs 100");
        A.setBounds(170, 410, 150, 30);
        A.addActionListener(this);
        image.add(A);

        B = new JButton("Rs 500");
        B.setBounds(355, 410, 150, 30);
        B.addActionListener(this);
        image.add(B);

        C = new JButton("Rs 1000");
        C.setBounds(170, 445, 150, 30);
        C.addActionListener(this);
        image.add(C);

        D  = new JButton("Rs 2000");
        D.setBounds(355, 445, 150, 30);
        D.addActionListener(this);
        image.add(D);

        E = new JButton("Rs 5,000");
        E.setBounds(170, 480, 150, 30);
        E.addActionListener(this);
        image.add(E);

        F  = new JButton("Rs 10000");
        F.setBounds(355, 480, 150, 30);
        F.addActionListener(this);
        image.add(F);

        back  = new JButton("Back");
        back.setBounds(355, 515, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){

        if (ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else {
           String amount = ((JButton)ae.getSource()).getText().substring(3);  //
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while (rs.next()){
                    if (rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (ae.getSource() != back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance" );
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+ amount +" Debited Successfully" );

                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            } catch (Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String[] args) {

        new FastCash("");
    }
}

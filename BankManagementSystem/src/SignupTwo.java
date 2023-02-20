import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{


    JTextField pan, aadhar;
    JButton next;

    JRadioButton  syes, sno, eyes, eno;


    JComboBox religion, category, income, eduction, occupation;
    String formno;



    SignupTwo(String formno){
        this.formno = formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");


        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD,20));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        JLabel name = new JLabel("Religion: ");
        name.setFont(new Font("Raleway", Font.BOLD,22));
        name.setBounds(100, 140, 150, 30);
        add(name);

        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other" };
        religion = new JComboBox(valReligion);
        religion.setBounds(320, 140, 400, 30);
        religion.setBackground(Color.white);
        add(religion);


        JLabel Fname = new JLabel("Category: ");
        Fname.setFont(new Font("Raleway", Font.BOLD,22));
        Fname.setBounds(100, 190, 200, 30);
        add(Fname);
        String valCategory[] = {"General", "OBC", "ST", "SC", "Other" };
        category = new JComboBox(valCategory);
        category.setBounds(320, 190, 400, 30);
        category.setBackground(Color.white);
        add(category);

        JLabel dob = new JLabel("Income: ");
        dob.setFont(new Font("Raleway", Font.BOLD,22));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        String incomecategory[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000" };
        income = new JComboBox(incomecategory);
        income.setBounds(320, 240, 400, 30);
        income.setBackground(Color.white);
        add(income);

        JLabel gender = new JLabel("Educational ");
        gender.setFont(new Font("Raleway", Font.BOLD,22));
        gender.setBounds(100, 290, 200, 30);
        add(gender);


        JLabel email = new JLabel("Qualification: ");
        email.setFont(new Font("Raleway", Font.BOLD,22));
        email.setBounds(100, 315, 200, 30);
        add(email);
        String eductionValues[] = {"Non-Graduation", "Graduate", "Post-Graduate", "Doctrate", "Others" };
        eduction = new JComboBox(eductionValues);
        eduction.setBounds(320, 300, 400, 30);
        eduction.setBackground(Color.white);
        add(eduction);


        JLabel Marital = new JLabel("Occupation: ");
        Marital.setFont(new Font("Raleway", Font.BOLD,22));
        Marital.setBounds(100, 390, 200, 30);
        add(Marital);

        String occupationValues[] = {"Salaried", "Self-Employed", "Bussiness", "Student", "Retired" , "Others"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(320, 390, 400, 30);
        occupation.setBackground(Color.white);
        add(occupation);


        JLabel address = new JLabel("PAN Number: ");
        address.setFont(new Font("Raleway", Font.BOLD,22));
        address.setBounds(100, 440, 200, 30);
        add(address);

        pan= new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(320, 440, 400, 30);
        add(pan);

        JLabel city = new JLabel("Aadhar Number: ");
        city.setFont(new Font("Raleway", Font.BOLD,22));
        city.setBounds(100, 490, 200, 30);
        add(city);

        aadhar= new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhar.setBounds(320, 490, 400, 30);
        add(aadhar);

        JLabel state = new JLabel("Senior Citizen: ");
        state.setFont(new Font("Raleway", Font.BOLD,22));
        state.setBounds(100, 540, 200, 30);
        add(state);

        syes = new JRadioButton("YES");
        syes.setBounds(320,540,100,30);
        syes.setBackground(Color.white);
        add(syes);

        sno = new JRadioButton("NO");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.white);
        add(sno);

        ButtonGroup sbuttonGroup = new ButtonGroup();
        sbuttonGroup.add(syes);
        sbuttonGroup.add(sno);

        JLabel pincode = new JLabel("Exisiting Account: ");
        pincode.setFont(new Font("Raleway", Font.BOLD,22));
        pincode.setBounds(100, 590, 250, 30);
        add(pincode);

        eyes = new JRadioButton("YES");
        eyes.setBounds(320,590,100,30);
        eyes.setBackground(Color.white);
        add(eyes);

        eno = new JRadioButton("NO");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.white);
        add(eno);

        ButtonGroup ebuttonGroup = new ButtonGroup();
        ebuttonGroup.add(eyes);
        ebuttonGroup.add(eno);

        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(Color.white);

        setSize(850,800);
        setLocation(350,10);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seduction = (String) eduction.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();


        String seniorcitizen = null;
        if (syes.isSelected()){
            seniorcitizen = "YES";
        } else if (sno.isSelected()){
            seniorcitizen = "NO";
        }

        String exisitingaccount = null;
        if (eyes.isSelected()){
            exisitingaccount = "YES";
        } else if (eno.isSelected()) {
            exisitingaccount = "NO";
        }

        String span = pan.getText();
        String saadhar = aadhar.getText();

        try {
            Conn c = new Conn();
            String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seduction+"', '"+soccupation+"', '"+span+"', '"+saadhar+"', '"+seniorcitizen+"', '"+exisitingaccount+"')";
            c.s.executeUpdate(query);

            //signup3 Object
            setVisible(false);
            new SignupThree(formno).setVisible(true);
        } catch (Exception e){
            System.out.println(e);
        }

    }


    public static void main(String[] args) {
        new SignupTwo("");
    }
}

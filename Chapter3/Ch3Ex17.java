import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;
import javax.swing.*;

class HealthRecords{
    private String name;
    private String surname;
    private String gender;
    private int day;
    private int month;
    private int year;
    private double height;
    private double weight;

    public HealthRecords() {}

    public HealthRecords(String name, String surname, String gender, int day, int month, int year, double height, double weight) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.day = day;
        this.month = month;
        this.year = year;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getAge(int day, int month, int year){
        LocalDate birthdate = LocalDate.of(year, month, day);
        LocalDate now = LocalDate.of(LocalDate.now().getYear(),
                LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth());
        return (int) ChronoUnit.YEARS.between(birthdate, now);
    }

    public int maxHeartRate(int day, int month, int year){
        return 220 - getAge(day, month, year);
    }

    public int minTargetHeartRate(){
        return (int) (maxHeartRate(day, month, year) * 0.5);
    }

    public int maxTargetHeartRate(){
        return (int) (maxHeartRate(day, month, year) * 0.85);
    }

    public double findBMI(double height, double weight){
        return (weight) / (height * height);
    }
}
class Result extends JFrame{
    JPanel resultPanel = new JPanel();
    JLabel resultLabel = new JLabel();
    JButton OK = new JButton("OK");
    Result(){
        super("Result");
        setSize(300, 230);
        setLayout(new FlowLayout());
        resultPanel.setLayout(new FlowLayout());
        resultPanel.setSize(195,180);
        OK.addActionListener(e -> dispose());
        resultPanel.add(resultLabel);
        add(resultPanel);
        add(OK);
        setVisible(false);
        setResizable(false);
        setLocationRelativeTo(null);
    }
}
public class Ch3Ex17 extends JFrame{
    String[] genders = {"Male", "Female"};
    ArrayList<String> years = new ArrayList<>();
    ArrayList<String> months = new ArrayList<>();
    ArrayList<String> days = new ArrayList<>();
    JLabel nameL = new JLabel("Name: ");
    JLabel surnameL = new JLabel("Surname: ");
    JLabel genderL = new JLabel("Gender: ");
    JLabel birthdayL = new JLabel("Birthday: ");
    JLabel heightL = new JLabel("Height: ");
    JLabel weightL = new JLabel("Weight: ");
    JTextField nameText, surnameText;
    JTextField heightText;
    JTextField weightText;
    JComboBox<String> genderCombo;
    JComboBox<String> dayCombo = new JComboBox<>();
    JComboBox<String> monthCombo = new JComboBox<>();
    JComboBox<String> yearCombo = new JComboBox<>();
    JPanel birthDate = new JPanel();
    JPanel buttonPrint = new JPanel();
    JButton Print = new JButton("Print");
    JPanel StatusPanel = new JPanel();
    JLabel StatusLabel = new JLabel("<html>BMI VALUES<br>" +
            "Underweight: less than 18.5<br>" +
            "Normal: between 18.5 and 24.9<br>" +
            "Overweight: between 25 and 29.9<br>" +
            "Obese: 30 or greater</html>", SwingConstants.CENTER);
    Ch3Ex17(){
        super("Health Records");
        setSize(300, 430);
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(new GridBagLayout());
        nameText = new JTextField("Insert your name");
        surnameText = new JTextField("Insert your surname");
        heightText = new JTextField("Insert height in Meters");
        weightText = new JTextField("Insert weight in Kg");
        for(int y = 1950; y <= Calendar.getInstance().get(Calendar.YEAR); y++)
            years.add(y + "");
        for(int m = 1; m <= 12; m++)
            months.add(m + "");
        for(int d = 1; d <= 31; d++)
            days.add(d + "");
        genderCombo = new JComboBox<>(genders);
        dayCombo.setModel(new DefaultComboBoxModel<>(days.toArray(new String[0])));
        monthCombo.setModel(new DefaultComboBoxModel<>(months.toArray(new String[0])));
        yearCombo.setModel(new DefaultComboBoxModel<>(years.toArray(new String[0])));
        nameText.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                nameText.setText("");
            }
        });
        surnameText.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                surnameText.setText("");
            }
        });
        heightText.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                heightText.setText("");
            }
        });
        weightText.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                weightText.setText("");
            }
        });
        Print.addActionListener(e -> {
            Result rs = new Result();
            HealthRecords hr = new HealthRecords();
            hr.setName(nameText.getText());
            hr.setSurname(surnameText.getText());
            hr.setGender((String) genderCombo.getSelectedItem());
            hr.setDay(Integer.parseInt(Objects.requireNonNull(dayCombo.getSelectedItem()).toString()));
            hr.setMonth(Integer.parseInt(Objects.requireNonNull(monthCombo.getSelectedItem()).toString()));
            hr.setYear(Integer.parseInt(Objects.requireNonNull(yearCombo.getSelectedItem()).toString()));
            try{
                hr.setHeight(Double.parseDouble(heightText.getText()));
                hr.setWeight(Double.parseDouble(weightText.getText()));
                rs.resultLabel.setText("<html>" +
                        hr.getName() + " " + hr.getSurname() + "<br>" +
                        "Gender: " + hr.getGender() + "<br>" +
                        "Date of birth: " + hr.getDay() + "/" + hr.getMonth() + "/" + hr.getYear() + "<br>" +
                        "Height: " + hr.getHeight() + " meters<br>" + "Weight: " + hr.getWeight() + " kg<br>" +
                        "Is " + hr.getAge(hr.getDay(), hr.getMonth(), hr.getYear()) + " years old<br>" +
                        "BMI: " + String.format("%.2f", hr.findBMI(hr.getHeight(), hr.getWeight())) + "<br>" +
                        "Maximum heart rate: " + hr.maxHeartRate(hr.getDay(), hr.getMonth(), hr.getYear()) + "<br>" +
                        "Target heart rate range: Between " + hr.minTargetHeartRate() + " and " +
                        hr.maxTargetHeartRate() + "</html>");
                rs.setVisible(true);
            }
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(this, "Insert correct data!",
                        "Height or Weight input", JOptionPane.WARNING_MESSAGE);
            }
        });
        StatusPanel.setLayout(new FlowLayout());
        buttonPrint.setLayout(new FlowLayout());
        buttonPrint.add(Print);
        birthDate.setLayout(new GridLayout(1,3));
        birthDate.add(dayCombo);
        birthDate.add(monthCombo);
        birthDate.add(yearCombo);
        StatusPanel.add(StatusLabel);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 20;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(nameL, gbc);
        gbc.ipady = 0;
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(nameText, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 20;
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(surnameL, gbc);
        gbc.ipady = 0;
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(surnameText, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 20;
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(genderL, gbc);
        gbc.ipady = 0;
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(genderCombo, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 20;
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(birthdayL, gbc);
        gbc.ipady = 0;
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(birthDate, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 20;
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(heightL, gbc);
        gbc.ipady = 0;
        gbc.gridx = 1;
        gbc.gridy = 4;
        add(heightText, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 20;
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(weightL, gbc);
        gbc.ipady = 0;
        gbc.gridx = 1;
        gbc.gridy = 5;
        add(weightText, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 20;
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        add(buttonPrint, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        add(StatusPanel, gbc);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Ch3Ex17::new);
    }
}

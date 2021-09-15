package Chapter3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
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

    public int maxHeartRate(){
        return 220 - getAge(day, month, year);
    }

    public int minTargetHeartRate(){
        return (int) (maxHeartRate() * 0.5);
    }

    public int maxTargetHeartRate(){
        return (int) (maxHeartRate() * 0.85);
    }

    public double findBMI(double height, double weight){
        return (weight * 703) / (height * height);
    }
}

class Actions implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

public class Ex17 extends JFrame{
    String[] genders = {"Male", "Female"};
    ArrayList<String> years = new ArrayList<>();
    ArrayList<String> months = new ArrayList<>();
    ArrayList<String> days = new ArrayList<>();
    ArrayList<String> heights = new ArrayList<>();
    ArrayList<String> weights = new ArrayList<>();
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
    JComboBox dayCombo;
    JComboBox monthCombo;
    JComboBox yearCombo;
    JPanel birthDate = new JPanel();
    JPanel buttonPrint = new JPanel();
    JButton Print = new JButton("Print");
    Ex17(){
        super("Health Records");
        setSize(300, 350);
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(new GridBagLayout());
        nameText = new JTextField("Insert your name");
        surnameText = new JTextField("Insert your surname");
        for(int y = 1950; y <= Calendar.getInstance().get(Calendar.YEAR); y++)
            years.add(y + "");
        for(int m = 1; m <= 12; m++)
            months.add(m + "");
        for(int d = 1; d <= 31; d++)
            days.add(d + "");
        for(int h = 140; h <= 220; h++)
            heights.add(h + "");
        for(int w = 40; w <= 150; w++)
            weights.add(w + "");
        genderCombo = new JComboBox<>(genders);
        dayCombo = new JComboBox(days.toArray());
        monthCombo = new JComboBox(months.toArray());
        yearCombo = new JComboBox(years.toArray());
        heightText = new JTextField();
        weightText = new JTextField();
        buttonPrint.setLayout(new FlowLayout());
        buttonPrint.add(Print);
        birthDate.setLayout(new GridLayout(1,3));
        birthDate.add(dayCombo);
        birthDate.add(monthCombo);
        birthDate.add(yearCombo);
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
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ex17();
    }
}

/*
* PROJECT: STUDENT MANAGEMENT SYSTEM
* Internship:CODSOFT
* Task: 5
* Description: 

*Manages student records with add, remove, 
search, and display features. Data is stored safely,
input is validated, and access is via console or GUI.

* Author: DEV KUMAR CHAUBEY
* Date : 11 Sep 2025
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class Student {
    String name;
    int roll;
    String grade;

    Student(String n, int r, String g) {
        name = n;
        roll = r;
        grade = g;
    }

    public String toString() {
        return name + " - " + roll + " - " + grade;
    }
}

public class StudentMangSys {
    ArrayList<Student> list = new ArrayList<>();

    public static void main(String args[]) {
        new StudentMangSys();
    }

    StudentMangSys() {
        JFrame f = new JFrame("Student Management");

        JTextField t1 = new JTextField(10); // name
        JTextField t2 = new JTextField(10); // roll
        JTextField t3 = new JTextField(10); // grade
        JTextArea area = new JTextArea();

        JButton b1 = new JButton("Add");
        JButton b2 = new JButton("Search");
        JButton b3 = new JButton("Remove");
        JButton b4 = new JButton("Show All");

        JPanel p = new JPanel();
        p.add(new JLabel("Name:"));
        p.add(t1);
        p.add(new JLabel("Roll:"));
        p.add(t2);
        p.add(new JLabel("Grade:"));
        p.add(t3);

        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(b4);

        f.add(p, BorderLayout.NORTH);
        f.add(new JScrollPane(area), BorderLayout.CENTER);

        // add student
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (t1.getText().equals("") || t2.getText().equals("") || t3.getText().equals("")) {
                    JOptionPane.showMessageDialog(f, "Fill all fields");
                } else {
                    try {
                        int r = Integer.parseInt(t2.getText());
                        list.add(new Student(t1.getText(), r, t3.getText()));
                        JOptionPane.showMessageDialog(f, "Student Added!");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(f, "Roll must be number");
                    }
                }
            }
        });

        // search student
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int r = Integer.parseInt(t2.getText());
                    for (Student s : list) {
                        if (s.roll == r) {
                            area.setText(s.toString());
                            return;
                        }
                    }
                    area.setText("Not Found");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(f, "Enter valid roll");
                }
            }
        });

        // remove student
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int r = Integer.parseInt(t2.getText());
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).roll == r) {
                            list.remove(i);
                            JOptionPane.showMessageDialog(f, "Removed!");
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(f, "Not Found");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(f, "Enter valid roll");
                }
            }
        });

        // show all students
        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (list.isEmpty()) {
                    area.setText("No students");
                } else {
                    String str = "";
                    for (Student s : list) {
                        str += s.toString() + "\n";
                    }
                    area.setText(str);
                }
            }
        });

        f.setSize(800, 800);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class StudentGradeCalculatorGUI extends JFrame implements ActionListener {


    private JTextField idField;
    private JTextField nameField;

    private JTextField[] marksFields;

    private JTextArea reportArea;

    private JButton calculateButton;
    private JButton clearButton;
    private JButton exitButton;


    private String[] subjects = {

            "Object Oriented Programming",
            "Database Systems",
            "Operating Systems",
            "Computer Networks",
            "Information Security"

    };




    public StudentGradeCalculatorGUI(){


        setTitle("Student GPA Calculator");

        setSize(1100,750);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );


        setLocationRelativeTo(null);



        Color background =
                new Color(240,245,250);


        getContentPane().setBackground(
                background
        );



        setLayout(
                new BorderLayout(15,15)
        );





        JLabel title = new JLabel(
                "STUDENT GPA CALCULATOR",
                SwingConstants.CENTER
        );


        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        30
                )
        );


        title.setForeground(
                new Color(30,70,120)
        );


        title.setBorder(
                BorderFactory.createEmptyBorder(
                        15,0,10,0
                )
        );


        add(
                title,
                BorderLayout.NORTH
        );


        JPanel leftPanel = new JPanel();


        leftPanel.setLayout(
                new BoxLayout(
                        leftPanel,
                        BoxLayout.Y_AXIS
                )
        );


        leftPanel.setBackground(
                background
        );

        // Student Information

        JPanel studentPanel =
                new JPanel(
                        new GridBagLayout()
                );


        studentPanel.setBackground(
                Color.WHITE
        );


        studentPanel.setBorder(
                BorderFactory.createTitledBorder(
                        "Student Information"
                )
        );



        GridBagConstraints gbc =
                new GridBagConstraints();


        gbc.insets =
                new Insets(
                        8,8,8,8
                );


        gbc.anchor =
                GridBagConstraints.WEST;

        gbc.gridx=0;
        gbc.gridy=0;


        studentPanel.add(
                new JLabel("Student ID:"),
                gbc
        );


        gbc.gridx=1;


        idField =
                new JTextField(10);


        studentPanel.add(
                idField,
                gbc
        );


        gbc.gridx=0;
        gbc.gridy=1;


        studentPanel.add(
                new JLabel("Student Name:"),
                gbc
        );



        gbc.gridx=1;


        nameField =
                new JTextField(14);


        studentPanel.add(
                nameField,
                gbc
        );





        studentPanel.setMaximumSize(
                new Dimension(320,90)
        );

        leftPanel.add(studentPanel);


        leftPanel.add(
                Box.createVerticalStrut(20)
        );

 // Marks Panel

        JPanel marksPanel =
                new JPanel(
                        new GridLayout(
                                5,
                                2,
                                12,
                                25
                        )
                );

        marksPanel.setBackground(
                Color.WHITE
        );


        marksPanel.setBorder(
                BorderFactory.createTitledBorder(
                        "Enter Subject Marks"
                )
        );


          marksFields =
                new JTextField[5];

        for(int i=0;i<subjects.length;i++){


            JLabel label =
                    new JLabel(
                            subjects[i]
                    );


            label.setFont(
                    new Font(
                            "Segoe UI",
                            Font.PLAIN,
                            14
                    )
            );


            marksPanel.add(label);



            marksFields[i] =
                    new JTextField();


            marksPanel.add(
                    marksFields[i]
            );


        }



        leftPanel.add(
                marksPanel
        );
        marksPanel.setPreferredSize(
                new Dimension(350,300)
        );



        add(
                leftPanel,
                BorderLayout.WEST
        );
        // Report Area

        reportArea = new JTextArea();


        reportArea.setFont(
                new Font(
                        "Monospaced",
                        Font.PLAIN,
                        15
                )
        );


        reportArea.setEditable(false);


        reportArea.setBackground(
                Color.WHITE
        );


        reportArea.setBorder(
                BorderFactory.createTitledBorder(
                        "Generated Report"
                )
        );



        add(
                new JScrollPane(reportArea),
                BorderLayout.CENTER
        );

    // Button Panel

        JPanel buttonPanel =
                new JPanel();



        buttonPanel.setBackground(
                new Color(240,245,250)
        );



        calculateButton =
                new JButton("Generate Result");


        clearButton =
                new JButton("Clear");


        exitButton =
                new JButton("Exit");


        JButton[] buttons =
                {
                        calculateButton,
                        clearButton,
                        exitButton
                };



        for(JButton button : buttons){


            button.setFont(
                    new Font(
                            "Segoe UI",
                            Font.BOLD,
                            14
                    )
            );


            button.setPreferredSize(
                    new Dimension(
                            150,
                            35
                    )
            );


        }




        buttonPanel.add(calculateButton);

        buttonPanel.add(clearButton);

        buttonPanel.add(exitButton);



        add(
                buttonPanel,
                BorderLayout.SOUTH
        );




        calculateButton.addActionListener(this);

        clearButton.addActionListener(this);

        exitButton.addActionListener(this);




        setVisible(true);

    }







    public void actionPerformed(ActionEvent e){


        if(e.getSource()==calculateButton){


            generateReport();

        }




        else if(e.getSource()==clearButton){


            idField.setText("");

            nameField.setText("");



            for(JTextField field:marksFields){

                field.setText("");

            }


            reportArea.setText("");

        }




        else if(e.getSource()==exitButton){


            System.exit(0);

        }

    }

 private void generateReport(){


        try{


            if(idField.getText().isEmpty()
                    ||
                    nameField.getText().isEmpty()){


                throw new Exception();

            }

            ArrayList<Integer> marks =
                    new ArrayList<>();



            for(JTextField field:marksFields){


                int mark =
                        Integer.parseInt(
                                field.getText()
                        );



                if(mark<0 || mark>100)

                    throw new Exception();



                marks.add(mark);

            }


            Student student =
                    new Student(
                            idField.getText(),
                            nameField.getText(),
                            marks
                    );

            int total =
                    GradeCalculator.calculateTotal(marks);



            double percentage =
                    GradeCalculator.calculatePercentage(marks);



            double gpa =
                    GradeCalculator.calculateGPA(marks);



            String grade =
                    GradeCalculator.calculateOverallGrade(
                            percentage
                    );



            String status =
                    GradeCalculator.calculateStatus(
                            percentage
                    );

          StringBuilder report =
                    new StringBuilder();

        report.append(
                    "============================================\n"
            );


            report.append(
                    "              STUDENT REPORT CARD\n"
            );


            report.append(
                    "============================================\n\n"
            );

            report.append(
                    "Student ID   : "
            )
            .append(student.getStudentId())
            .append("\n");


            report.append(
                    "Student Name : "
            )
            .append(student.getName())
            .append("\n\n");

       report.append(
                    "--------------------------------------------\n"
            );

            report.append(
                    String.format(
                            "%-27s %-6s %-7s %-5s\n",
                            "Subject",
                            "Marks",
                            "Grade",
                            "GP"
                    )
            );

        report.append(
                    "--------------------------------------------\n"
            );


        for(int i=0;i<subjects.length;i++){


                report.append(
                        String.format(
                                "%-27s %-6d %-7s %-5.1f\n",
                                subjects[i],
                                marks.get(i),
                                GradeCalculator.calculateSubjectGrade(
                                        marks.get(i)
                                ),
                                GradeCalculator.calculateGradePoint(
                                        marks.get(i)
                                )
                        )
                );

            }

     report.append(
                    "--------------------------------------------\n"
            );

      report.append(
                    "Total Marks : "
            )
            .append(total)
            .append("/500\n");

       report.append(
                    "Percentage  : "
            )
            .append(
                    String.format("%.2f",percentage)
            )
            .append("%\n");



            report.append(
                    "GPA         : "
            )
            .append(
                    String.format("%.2f",gpa)
            )
            .append("\n");



            report.append(
                    "Grade       : "
            )
            .append(grade)
            .append("\n");



            report.append(
                    "Status      : "
            )
            .append(status);


            reportArea.setText(
                    report.toString()
            );



        }


        catch(Exception e){


            JOptionPane.showMessageDialog(
                    this,
                    "Enter valid student information and marks (0-100)"
            );


        }


    }

 public static void main(String[] args){


        new StudentGradeCalculatorGUI();

    }


}
package online_examination;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

public class Quiz implements ActionListener{

String[] questions={

                        "Java is a ___",
                        " What is the size of byte variable ? ",
                        "What is an immutable object ?",
                        "Java is designed by ?",
                        "Java first appeared in ?",
                        "Java influenced by ?",
                        " What is the default value of data type boolean in Java ?",
                        " If a = -5, then +a means ?",
                        "What is the value of the expression 9/9 ?",
                        "System.out.print is user for ?"

                   };

 String [][] options={

                        {"High-level programming language","Object-oriented (class-based) programming language","functional, imperative and reflective programming language","All the above"},
                        {"1","2","4","8"},
                        {"Object can be changed after it's created","Object can't be changed after it's created","Both A & B", "None"},
                        {"Dennis Ritchie","James Gosling","Charles Babbage","Guido van Rossum"},
                        
                        {"May 23, 1995",
                       "23 July, 1994",
                        "18 August, 2001",
                        "13 September, 1983"
                        },


                        {"C++",
                        "Objective-C",
                        "Ada",
                        "All the above"
                        },

                        {"0",
                        "1",
                        "true",
                        "false"
                        },

                        {"-5",
                        "5",
                        "0",
                        "none of the above"},

                        {"0",
                        "1",
                        "10",
                        "none of the above"},

                        {"Display output", "Display Input","Take output","Take Input"}
                        

                     };   
                     
              
char[] answers=  {
                        'D',
                        'A',
                        'B',
                        'B',
                        'A',
                        'D',
                        'D',
                        'A',
                        'B',
                        'A'
                };

                char guess;
                char answer;
                int index;
                int correct_guesses=0;
                int total_questions=questions.length;
                int result;
                int seconds=10;



        JFrame frame= new JFrame();
        JTextField textfield= new JTextField();
        JTextArea textarea= new JTextArea();
        JButton buttonA= new JButton();
        JButton buttonB= new JButton();
        JButton buttonC= new JButton();
        JButton buttonD= new JButton();

        JLabel answer_labelA= new JLabel();
        JLabel answer_labelB= new JLabel();
        JLabel answer_labelC= new JLabel();
        JLabel answer_labelD= new JLabel();

        JLabel time_label= new JLabel();
        JLabel seconds_left= new JLabel();
        JTextField number_right=new JTextField();
        JTextField percentage = new JTextField();

        Timer start=new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                seconds--;
                seconds_left.setText(String.valueOf(seconds));
                if(seconds<=0){
                    displayAnswer();
                }

            }
        });




   public  Quiz(){
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(1100,650);

        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(null);
        frame.setResizable(false);


        textfield.setBounds(0,0,1100,50);
        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font("Ink Free",Font.BOLD,30));
        textfield.setBorder(BorderFactory.createBevelBorder(1));
        textfield.setHorizontalAlignment(JTextField.CENTER);
        textfield.setEditable(false);

        textarea.setBounds(0,50,1100,50);
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setBackground(new Color(25,25,25));
        textarea.setForeground(new Color(25,255,0));
        textarea.setFont(new Font("MV Boli",Font.BOLD,30));
        textarea.setBorder(BorderFactory.createBevelBorder(1));
        textarea.setEditable(false);

        buttonA.setBounds(0,100,100,100);
        buttonA.setFont(new Font("MV Boli",Font.BOLD,30));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        buttonB.setBounds(0,200,100,100);
        buttonB.setFont(new Font("MV Boli",Font.BOLD,35));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");


        buttonC.setBounds(0,300,100,100);
        buttonC.setFont(new Font("MV Boli",Font.BOLD,35));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        buttonD.setBounds(0,400,100,100);
        buttonD.setFont(new Font("MV Boli",Font.BOLD,35));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");

        answer_labelA.setBounds(125,100,1200,100);
        answer_labelA.setBackground(new Color(50,50,50));
        answer_labelA.setForeground(new Color(25,255,0));
        answer_labelA.setFont(new Font("MV Boli",Font.BOLD,30));

        answer_labelB.setBounds(125,200,1200,100);
        answer_labelB.setBackground(new Color(50,50,50));
        answer_labelB.setForeground(new Color(25,255,0));
        answer_labelB.setFont(new Font("MV Boli",Font.BOLD,30));

        answer_labelC.setBounds(125,300,900,100);
        answer_labelC.setBackground(new Color(50,50,50));
        answer_labelC.setForeground(new Color(25,255,0));
        answer_labelC.setFont(new Font("MV Boli",Font.BOLD,30));

        answer_labelD.setBounds(125,400,900,100);
        answer_labelD.setBackground(new Color(50,50,50));
        answer_labelD.setForeground(new Color(25,255,0));
        answer_labelD.setFont(new Font("MV Boli",Font.BOLD,30));


        seconds_left.setBounds(950,510,100,100);
        seconds_left.setBackground(new Color(25,25,25));
        seconds_left.setForeground(new Color(25,255,0));
        seconds_left.setFont(new Font("MV Boli",Font.BOLD,30));
        seconds_left.setBorder(BorderFactory.createBevelBorder(1));
        seconds_left.setOpaque(true);
        seconds_left.setHorizontalAlignment(JTextField.CENTER);
        seconds_left.setText(String.valueOf(seconds));



        time_label.setBounds(950,475,100,25);
        time_label.setBackground(new Color(50,50,50));
        time_label.setForeground(new Color(255,0,0));
        time_label.setFont(new Font("MV Boli",Font.BOLD,20));
        time_label.setHorizontalAlignment(JTextField.CENTER);
        time_label.setText("time >: D");



        number_right.setBounds(355,255,200,100);
        number_right.setBackground(new Color(25,25,25));
        number_right.setForeground(new Color(25,255,0));
        number_right.setFont(new Font("Ink Free",Font.BOLD,50));
        number_right.setBorder(BorderFactory.createBevelBorder(1));
        number_right.setHorizontalAlignment(JTextField.CENTER);
        number_right.setEditable(false);

        percentage.setBounds(325,425,200,100);
        percentage.setBackground(new Color(25,25,25));
        percentage.setForeground(new Color(25,255,0));
        percentage.setFont(new Font("MV Boli",Font.BOLD,50));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);


        frame.add(time_label);
        frame.add(seconds_left);
        frame.add(answer_labelA);
        frame.add(answer_labelB);
        frame.add(answer_labelC);
        frame.add(answer_labelD);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(textarea); 
        frame.add(textfield);
        frame.setVisible(true);

        nextQuestion();
    }


    public void nextQuestion(){
        if(index>=total_questions){
            result();
        }
        else{
            textfield.setText("Question "+(index+1));
            textarea.setText(questions[index]);
            answer_labelA.setText(options[index][0]);
            answer_labelB.setText(options[index][1]);
            answer_labelC.setText(options[index][2]);
            answer_labelD.setText(options[index][3]);
            start.start();
        }

    }


    public void actionPerformed(ActionEvent e){
            buttonA.setEnabled(false);
            buttonB.setEnabled(false);
            buttonC.setEnabled(false);
            buttonD.setEnabled(false);

            if(e.getSource()==buttonA){
                answer='A';
                if(answer==answers[index]){
                    correct_guesses++;
                }
            }
            if(e.getSource()==buttonC){
                answer='C';
                if(answer==answers[index]){
                    correct_guesses++;
                }
            }
            if(e.getSource()==buttonB){
                answer='B';
                if(answer==answers[index]){
                    correct_guesses++;
                }
            }
            if(e.getSource()==buttonD){
                answer='D';
                if(answer==answers[index]){
                    correct_guesses++;
                }
            }
            displayAnswer();
    }


    public void displayAnswer(){
        start.stop();
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if(answers[index]!='A'){
            answer_labelA.setForeground(new Color(255,0,0));
        }
        if(answers[index]!='B'){
            answer_labelB.setForeground(new Color(255,0,0));
        }
        if(answers[index]!='C'){
            answer_labelC.setForeground(new Color(255,0,0));
        }
        if(answers[index]!='D'){
            answer_labelD.setForeground(new Color(255,0,0));
        }


        Timer pause=new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                answer_labelA.setForeground(new Color(25,255,0));
                answer_labelB.setForeground(new Color(25,255,0));
                answer_labelC.setForeground(new Color(25,255,0));
                answer_labelD.setForeground(new Color(25,255,0));

                answer=' ';
                seconds=10;
                seconds_left.setText(String.valueOf(seconds));
                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);
                index++;
                nextQuestion();

            }
        });


        pause.setRepeats(false);
        pause.start();


    }


    public void result(){
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        result=(int)((correct_guesses/(double)total_questions)*100);
        textfield.setText(("RESULTS !!"));
        textarea.setText("");
        answer_labelA.setText("");
        answer_labelB.setText("");
        answer_labelC.setText("");
        answer_labelD.setText("");

        number_right.setText("("+correct_guesses+"/"+total_questions+")");
        percentage.setText(result+"%");

        frame.add(percentage);
        frame.add(number_right);

    }
}

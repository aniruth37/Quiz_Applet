import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
class  Quiz extends JFrame implements ActionListener{
            JPanel panel;
            JPanel panelresult;
            JRadioButton choice1;
            JRadioButton choice2;
            JRadioButton choice3;
            JRadioButton choice4;
            ButtonGroup bg;
            JLabel lblmess;
            JButton btnext;
            String[][] qpa;
            String[][] qca;
            int qaid;
            HashMap<Integer, String> map;

            Quiz(){
             initializedata();
                      setTitle("Quiz Program");
                      setDefaultCloseOperation(EXIT_ON_CLOSE);
                      setSize(500,400);
                      setLocation(400,200);
                      setResizable(false);
                      Container cont=getContentPane();
                      cont.setLayout(null);          
                      cont.setBackground(Color.GRAY);
                    bg=new ButtonGroup();     
                    choice1=new JRadioButton("Choice1",true);
                    choice2=new JRadioButton("Choice2",false);
                    choice3=new JRadioButton("Choice3",false);
                   choice4=new JRadioButton("Choice4",false);
                    bg.add(choice1);
                    bg.add(choice2);
                    bg.add(choice3);
                    bg.add(choice4);
                    lblmess=new JLabel("Choose a correct anwswer");
                   lblmess.setForeground(Color.BLUE);
                    lblmess.setFont(new Font("Arial", Font.BOLD, 11));
                    btnext=new JButton("Next");
                    btnext.setForeground(Color.GREEN);                
                    btnext.addActionListener(this);
                    panel=new JPanel();
                    panel.setBackground(Color.LIGHT_GRAY);
                    panel.setLocation(10,10);
                    panel.setSize(400,300);
                    panel.setLayout(new GridLayout(6,2));
                    panel.add(lblmess);
                    panel.add(choice1);
                    panel.add(choice2);
                    panel.add(choice3);
                    panel.add(choice4);
                  panel.add(btnext);
                    cont.add(panel);
                    setVisible(true);
                    qaid=0;
                    readqa(qaid);
         
            }
           
        public void actionPerformed(ActionEvent e){
           
                        if(btnext.getText().equals("Next")){
                                    if(qaid<9){
                                               
                                                map.put(qaid,getSelection());
                                                qaid++;
                                                readqa(qaid);
                                                }
                                    else {
                                                map.put(qaid,getSelection());
                                                btnext.setText("Show answers");
                                               
                                             }
                                    }
                        else if(btnext.getText().equals("Show answers"))
                                    new Report();
                       
                       
            }
           

           
        public void initializedata(){
                        //qpa stores pairs of question and its possible answers
                        qpa=new String[10][5];

                        qpa[0][0]="What is the number of states in India?";
                        qpa[0][1]="14";
                        qpa[0][2]="16";
                        qpa[0][3]="25";
                        qpa[0][4]="29";

                        qpa[1][0]="Which is the first state to be formed on the basis of language";
                        qpa[1][1]="Andhra Pradesh";
                        qpa[1][2]="Maharashtra";
                        qpa[1][3]="UP";
                        qpa[1][4]="Punjab";
                       
                        qpa[2][0]="Which is the smallest state in terms of area?";
                        qpa[2][1]="Goa";
                        qpa[2][2]="Punjab";
                        qpa[2][3]="Sikkim";
                        qpa[2][4]="Tripura";

                        qpa[3][0]="When was Burma was separated from India?";
                        qpa[3][1]="1948";
                        qpa[3][2]="1937";
                        qpa[3][3]="1901";
                        qpa[3][4]="1929";

                        qpa[4][0]="When did India become a republic?";
                        qpa[4][1]="1947";
                        qpa[4][2]="1948";
                        qpa[4][3]="1950";
                        qpa[4][4]="1951";

                        qpa[5][0]="Which state was divided into Maharashtra and Gujarat in 1960?";
                        qpa[5][1]="Bombay";
                        qpa[5][2]="Madras";
                        qpa[5][3]="Mysore";
                        qpa[5][4]="Hyderabad";

                        qpa[6][0]="Who was the Speaker of the Lok Sabha before he became the President of India?";
                        qpa[6][1]="APJ Abdul Kalam";
                        qpa[6][2]="Pranab Mulherjee";
                        qpa[6][3]="N Sanjeeva Reddy";
                        qpa[6][4]="Prathibha Patil";

                        qpa[7][0]="What was the age of Morarji Desai when he became the Prime Minister?";
                        qpa[7][1]="45";
                        qpa[7][2]="56";
                        qpa[7][3]="81";
                        qpa[7][4]="73";

                        qpa[8][0]="How was Tamil Nadu known?";
                        qpa[8][1]="Madras";
                        qpa[8][2]="Hyderabad";
                        qpa[8][3]="Mysore";
                        qpa[8][4]="Bombay";

                        qpa[9][0]="Nagaland was separated from which state?";
                        qpa[9][1]="Arunachal Pradesh";
                        qpa[9][2]="Assam";
                        qpa[9][3]="W Bengal";
                        qpa[9][4]="Meghalaya";

                       
                        //qca stores pairs of question and its correct answer
                        qca=new String[10][2];
                       
                        qca[0][0]="What is the number of states in India?";
                        qca[0][1]="29";

                        qca[1][0]="Which is the first state to be formed on the basis of language";
                        qca[1][1]="Andhra Pradesh";

                        qca[2][0]="Which is the smallest state in terms of area?";
                        qca[2][1]="Goa";

                        qca[3][0]="When was Burma was separated from India?";
                        qca[3][1]="1937";

                        qca[4][0]="When did India become a republic?";
                        qca[4][1]="1950";

                        qca[5][0]="Which state was divided into Maharashtra and Gujarat in 1960?";
                        qca[5][1]="Bombay";

                        qca[6][0]="Who was the Speaker of the Lok Sabha before he became the President of India?";
                        qca[6][1]="N Sanjeeva Reddy";
                       
                        qca[7][0]="What was the age of Morarji Desai when he became the Prime Minister?";
                        qca[7][1]="81";
                       
                        qca[8][0]="How was Tamil Nadu known?";
                        qca[8][1]="Madras";

                        qca[9][0]="Nagaland was separated from which state?";
                        qca[9][1]="Assam";
                       
                       
                        //create a map object to store pairs of question and selected answer
                        map=new HashMap<Integer, String>();
                       
                        }
        public String getSelection(){
                        String selectedChoice=null;
                        Enumeration<AbstractButton> buttons=bg.getElements(); 
                        while(buttons.hasMoreElements()) 
                        { 
                        JRadioButton temp=(JRadioButton)buttons.nextElement(); 
                        if(temp.isSelected()) 
                                    { 
                                                selectedChoice=temp.getText();
                                    } 
                         }  
                        return(selectedChoice);
            }


        public void readqa(int qid){
                        lblmess.setText("  "+qpa[qid][0]);
                        choice1.setText(qpa[qid][1]);
                        choice2.setText(qpa[qid][2]);
                        choice3.setText(qpa[qid][3]);
                        choice4.setText(qpa[qid][4]);
                        choice1.setSelected(true);
            }
        public void reset(){
                        qaid=0;
                        map.clear();
                        readqa(qaid);
                        btnext.setText("Next");
                        }
        public int calCorrectAnswer(){
                        int qnum=10;
                        int count=0;
                        for(int qid=0;qid<qnum;qid++)
                                    if(qca[qid][1].equals(map.get(qid))) count++;
                        return count;
            }

        public class Report extends JFrame{
                        Report(){
                                    setTitle("Answers");
                                    setSize(850,550);
                                    setBackground(Color.WHITE);
                                    addWindowListener(new WindowAdapter(){
                                                            public void windowClosing(WindowEvent e){
                                                                        dispose();
                                                                        reset();
                                                            }
                                                });
                                    Draw d=new Draw();                                  
                                    add(d);
                                    setVisible(true);
                                    }
                       
                       
                    class Draw extends Canvas{
                                    public void paint(Graphics g){
                                                int qnum=10;
                                                int x=10;
                                                int y=20;
                                                for(int i=0;i<qnum;i++){
                                                            //print the 1st column
                                                            g.setFont(new Font("Arial",Font.BOLD,12));                                         
                                                            g.drawString(i+1+". "+qca[i][0], x,y);
                                                            y+=30;           
                                                            g.setFont(new Font("Arial",Font.PLAIN,12));                             
                                                            g.drawString("      Correct answer:"+qca[i][1], x,y);
                                                            y+=30;
                                                            g.drawString("      Your answer:"+map.get(i), x,y);
                                                            y+=30;
                                                            //print the 2nd column
                                                            if(y>400)
                                                            {y=20;
                                                              x=450;
                                                            }
                                                           
                                                }
                                                //Show number of correct answers
                                                int numc=calCorrectAnswer();
                                                g.setColor(Color.BLUE);
                                                g.setFont(new Font("Arial",Font.BOLD,14));
                                                g.drawString("Number of correct answers:"+numc,300,500);
                       
                                               
                                    }
                        }
                                   
            }
           

           

}


 public class QuizProgram{
 
            public static void main(String args[]){
                         new Quiz();
  
            }


}
/* <applet code = "QuizProgram" width = 300 height = 300> </applet> */

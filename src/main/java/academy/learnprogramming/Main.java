package academy.learnprogramming;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner readFileStudents = null;
        //FileReader readFileStudents = null;
        FileWriter writeFileFailedStudents = null;
        FileWriter writeFilePassedStudents = null;
        Student tempStudent = new Student();

        try{

            readFileStudents = new Scanner(new FileReader("students.txt"));
            writeFilePassedStudents = new FileWriter("passedStudents.txt");
            writeFileFailedStudents = new FileWriter("failedStudents.txt");


            readFileStudents.useDelimiter(",");
            while(readFileStudents.hasNextLine()){

             String lineRead = readFileStudents.nextLine();
             String[] lineFields = lineRead.split(",",2);
             tempStudent.setStudentName(lineFields[0]);
             tempStudent.setTotalMarks(Double.parseDouble(lineFields[1]));
             if (tempStudent.getTotalMarks()>100){
                 System.out.println("valid student lines read from input file : "+lineRead);
                 writeFilePassedStudents.write(lineRead+"\n");
             }else{
                 System.out.println("invalid student lines read from input file : "+lineRead);
                 writeFileFailedStudents.write(lineRead+"\n");
             }

            }

//            readMarks();
//            writeMarks();

        }
        catch (IOException e){
            System.out.println("printing stack trace from catch block");
            e.printStackTrace();
        }
        finally{
            if(readFileStudents != null){
                readFileStudents.close();
            }
            if(writeFilePassedStudents != null){
                writeFilePassedStudents.close();
            }
            if(writeFileFailedStudents != null){
                writeFileFailedStudents.close();
            }
        }

    }

//    public static Student readMarks() throws IOException
//    {
//        Student student = new Student();
//        return student;
//    }
//
//    public static void writeMarks() throws IOException
//    {
//        return;
//    }

}

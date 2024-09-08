package StudentGradeTracker;
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int[] Marks = new int[5];
    Scanner sc = new Scanner(System.in);
    ArrayList<Float> Averagestd = new ArrayList<>();
    Student(){}
    Student(String name, int[] Marks) {
        this.name = name;
        this.Marks = Marks;
    }


    public void addStud(ArrayList<Student> studentsRecords) {
        System.out.print("\t-> Enter Number of Students to add Records = ");
        int numStd = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < numStd; i++) {
            System.out.println("\n==========Student " + (i + 1) + "==========");
            System.out.print("Name = ");
            name = sc.nextLine();
            
            System.out.println("Enter Marks in order (Phy Maths English PST Islamiat):");
            for (int j = 0; j < Marks.length; j++) { 
                System.out.print("-> ");
                Marks[j] = sc.nextInt();
            }
            sc.nextLine(); 
            studentsRecords.add(new Student(name, Marks.clone()));
        }
    }

    public void display(ArrayList<Student> studentsRecords) {
        if (studentsRecords.isEmpty()) {
            System.out.println("No records to Display.");
            return;
        }
        int count = 0;
        for (Student std : studentsRecords) {
            System.out.println("\n\t\t------------STUDENT " + (count= count+1) + "------------");
            System.out.println("\t\t\tName: " + std.name);
            System.out.print("\t\t\tMarks: ");
            for (int mark : std.Marks) {
                System.out.print(mark + " ");
            }
            System.out.println();
            System.out.println("\t\t---------------------------------");
            System.out.println();
            
        }
    
}
    public void avgCal(ArrayList<Student> studentsRecords){
        if (studentsRecords.isEmpty()) {
            System.out.println("No records to calculate average.");
            return;
        }
        
        
        System.out.println("\n-----Average of each Student-----\n");
        for(Student std : studentsRecords){ 
            int sum =0;
            float avgstd = 0;
            for(int stdavg : std.Marks){
                sum=sum+stdavg;
            }
           avgstd = (float)((avgstd+sum)/Marks.length);
           Averagestd.add(avgstd);
           System.out.println("Avg of "+ std.name+" = "+avgstd);
        }
        System.out.println("\n-----Average marks of Whole class Students-----\n");
        float avgClass = 0; 
        float sum =0;
        for(float classavg : Averagestd){
                sum=sum+classavg;
        }
        avgClass = (avgClass+sum)/Averagestd.size();
        System.out.println("Avg numbers obtained by whole class = "+ avgClass);
        System.out.println();
    }
    public void highestGrade(){
        if (Averagestd.isEmpty()) {
            System.out.println("No records available to determine the highest grade.");
            return;
        }
        float max = Averagestd.get(0);
        for(float value : Averagestd){
            if(value > max){
                max=value;
            }
        }
        System.out.println("\n->Highest Grade of among all student is = "+max);
    }
    public void lowestGrade(){
        if (Averagestd.isEmpty()) {
        System.out.println("No records available to determine the lowest grade.");
        return;
    }
        float low = Averagestd.get(0);
        for(float value : Averagestd){
            if(value < low){
                low = value;
            }
        }
        System.out.println("\n->Lowest Grade of among all student is = "+low);
    }
    int index;
    public void remove(ArrayList<Student> studentsRecords){
        System.out.print("\n->Enter index number to remove = ");
        index = sc.nextInt();
        sc.nextLine();

        studentsRecords.remove(index);
        System.out.println("\n \t Record Removed successfully!");
    }
    
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> studentsRecords = new ArrayList<>();
        int choice;
        Scanner sc1 = new Scanner(System.in);
        Student student = new Student();
        System.out.println("\n_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_STUDENT GRADE TRACKER_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-\n");
        while (true) {
            System.out.println("\n.............................................................\n");
            System.out.println("1: Add Student Record");
            System.out.println("2: Calculate Average");
            System.out.println("3: Find Highest Grade");
            System.out.println("4: Find Lowest Grade Student");
            System.out.println("5: Remove Students Record");
            System.out.println("6: Display Record of all Students");
            System.out.println("7: Exit");
            System.out.println("\n.............................................................\n");

            System.out.print("Enter Your Choice: ");
            choice = sc1.nextInt();
            sc1.nextLine();

            switch (choice) {
                case 1:
                    student.addStud(studentsRecords);
                    break;
                case 2:
                    student.avgCal(studentsRecords);
                    break;
                case 3:
                    student.highestGrade();
                    break;
                case 4:
                    student.lowestGrade();
                    break;
                case 5:
                    student.remove(studentsRecords);
                case 6:
                    student.display(studentsRecords);
                    break;

                case 7:
                    System.out.println("\n Good Bye!\n");
                    sc1.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }
    }
}

import java.util.Scanner;
import java.io.*;

public class SchoolProblems
{
    // initialises gradYear int
    private int gradYear;
    // initialises scanner for user input
    static Scanner input = new Scanner(System.in);

    //Retrieves saved count number used last time code was run
    int countFaculty = getCountNumFac();
    int countStudents = getCountNumStu();

    // Getters setters and an update method for gradYear
    public void setGradYear(int gradYear) 
    {
        this.gradYear = gradYear;
    }

    public int getGradYear() 
    {
        return this.gradYear;
    }

    public void updateGradYear(int newGradYear) 
    {
        this.gradYear = newGradYear;
    }

    public void main (String[] args)
    {

        // welcomes user to QU parking lot
        System.out.println("Hello and welcome to the Quinnipiac parking system. Are you a student or are you faculty?.");
        String studentOrFaculty = input.nextLine();
        // Checks for special circumstances
        if (studentOrFaculty.equals("faculty"))
        {
            // checks for president judy and if not welcomes regular faculty
            System.out.println("Are you by any chance Judy Olian? yes / no");
            String judy = input.nextLine();
            if (judy.equals("yes"))
            {
                System.out.println("Welcome Mrs president your special spot number 1 is available");
                //assignFacultyParkingSpot();
                countFaculty++;

            }
            else
            {
                System.out.println("Welcome faculty");
                //assignFacultyParkingSpot();
                countFaculty++;
            }
        } 
        // if student, it checks for grad year and if permitted to park
        else
        {
            System.out.println("Your expected year of graduation?");
            SchoolProblems schoolProblems = new SchoolProblems();
            schoolProblems.setGradYear(input.nextInt());

            if (schoolProblems.getGradYear() == 2026)
            {
                System.out.println("Sorry, freshman are not allowed to park on campus.");
            }
            else
            {
                System.out.println("Welcome to the wonderful QU parking lot");
                //assignStudentParkingSpot();
                countStudents++;
            }
        }
    }

    // This assigns faculty name to their parking spot
    public static void assignFacultyParkingSpot(String[] parkingSpots, String judy, int count)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your full name. This is permanent entry and cannot be changed later on. ");
        

        if (judy.equals("yes"))
        {
            parkingSpots[0] = "Judy Olian";
        }

        else
        {
            parkingSpots[count] = scan.nextLine();
        }

        

    }

    // This assigns student name to their parking spot
    public static void assignStudentParkingSpot(String[] parkingSpots, int gradYear, int count)
    {
        Scanner scan = new Scanner(System.in);
        int numYearsLeft = gradYear - 2023;

        if (numYearsLeft == 0)
        {
            System.out.println("Congrats for making it this far! Good luck with your final year at Quinnipiac University");
            
            System.out.println("Please enter your full name. This is permanent entry and cannot be changed later on. ");
            parkingSpots[count] = scan.nextLine();
            
        }

        else
        {
            System.out.println("Please enter your full name. This is permanent entry and cannot be changed later on. ");
            parkingSpots[count] = scan.nextLine();
        }
    }

    // retrieves student count number
    public static int getCountNumStu()
    {
        File file = new File ("countNumbers.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return sc.nextInt();
        
    }

    // retrieves faculty count number
    public static int getCountNumFac()
    {
        File file = new File ("countNumbers.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        sc.nextInt();
        return sc.nextInt();
        
    }


    // Saves count numbers for faculty and students
    public static void saveCountNum(int countNum, int countNum2)
    {
        try {
            FileWriter myWriter = new FileWriter("countNumbers.txt");
            myWriter.write(countNum);
            myWriter.write(countNum2);
            myWriter.close();
            System.out.println("Successfully saved countNumbers");
        } catch(IOException e) {
            System.out.println("An error occured");
        }
        
    }
}
import java.util.Scanner;

public class SchoolProblems
{
    // initialises gradYear int
    private int gradYear;
    // initialises scanner for user input
    static Scanner input = new Scanner(System.in);

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

    public static void main (String[] args)
    {


        // welcomes user to QU parking lot
        System.out.println("Hello and welcome to the Quinnipiac parking system. Are you a student or are you faculty?.");
        String studentOrFaculty = input.nextLine();
        // Checks for special circumstances
        if (studentOrFaculty.equals("faculty"))
        {
            // checks for president judy and if not welcomes regular faculty
            System.out.println("Are you by any chance Judy Olian?");
            String judy = input.nextLine();
            if (judy.equals("yes"))
            {
                System.out.println("Welcome Mrs president your special spot number 1 is available");
            }
            else
            {
                System.out.println("Welcome faculty");
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
            }
        }
    }
}
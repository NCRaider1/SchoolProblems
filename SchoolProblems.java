import java.util.Random;
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

    public static void main(String[] args) 
    {
        int[] spots = new int[25];
        Random rnd = new Random();
        int numRemoved = 0;

        // welcomes user to QU parking lot
        System.out.println("Hello and welcome to the Quinnipiac parking system. Are you a student or are you faculty?.");
        String studentOrFaculty = input.nextLine();
        // Checks for special circumstances
        if (studentOrFaculty.equals("faculty")) 
        {
            // checks for president judy and if not welcomes regular faculty
            System.out.println("Are you by any chance Judy Olian?");
            String judy = input.nextLine();
            if (judy.equals("yes")) {
                System.out.println("Welcome Mrs president your special spot number 1 is available");
                spots[0] = 1;
            } else {
                System.out.println("Welcome faculty");
                while (true) {
                    int spot = rnd.nextInt(25) + 1;
                    if (spots[spot - 1] == 0) 
                    {
                        spots[spot - 1] = 1;
                        System.out.println("Your assigned spot is: " + spot);
                        break;
                    }
                }
            }
        } else {
            System.out.println("Your expected year of graduation?");
            SchoolProblems schoolProblems = new SchoolProblems();
            schoolProblems.setGradYear(input.nextInt());

            if (schoolProblems.getGradYear() >= 2026) {
                System.out.println("Sorry, freshman are not allowed to park on campus.");
            } else {
                System.out.println("Welcome to the wonderful QU parking lot");
                while (true) 
                {
                    int spot = rnd.nextInt(25) + 1;
                    if (spots[spot - 1] == 0) 
                    {
                        spots[spot - 1] = 1;
                        System.out.println("Your assigned spot is: " + spot);
                        break;
                    }
                }
            }
        }
    }
}

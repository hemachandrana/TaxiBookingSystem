import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TaxiBook {
    char[] pickupLocation = new char[10];
    char[] dropLocation = new char[10];
    int plCount;
    int dlCount;
    int[] pickupTime=new int[10];
    int pTArray;
    int[] amount=new int[10];
    int amountArray;
    int numberTaxi;
    Scanner in = new Scanner(System.in);
    public void showMenu()
    {
        System.out.println("Please Choose One");
        System.out.println("1.Book Taxi");
        System.out.println("2.Display Previous History");
        System.out.println("3.Exit");
       int input;
       try {
           input = in.nextInt();



        switch(input)
        {
            case 1:
                bookingProcess();
                break;

            case 2:
                displayTaxiDetails();
                break;

            case 3:
                exit();
                break;

            default:
                System.out.println("Enter Proper Input");
        }
       }

       catch (Exception e)
       {
           e.getMessage();
       }
    }
    public void bookingProcess()
    {
        System.out.println("Note:\nThe Avaliable Locations Are A,B,C,D,E,F.\nEach Two Location between Distance is 15Km,\nOur Billing Process is Below,\nFirst 5km -> 100Rs and After Every 1km -> 10Rs ");
        System.out.println("Enter the PickUp Location");
        try {
            pickupLocation[plCount] = in.next().charAt(0);
            System.out.println("Enter the Drop Location");
            dropLocation[dlCount] = in.next().charAt(0);
            System.out.println("Enter Pickup Time");
            pickupTime[pTArray] = in.nextInt();
            pTArray++;
            amount[amountArray] = ((((Math.abs(dropLocation[dlCount] - pickupLocation[plCount]) * 15) - 5) * 10) + 100);
            System.out.println("Your Total Amount is " + amount[amountArray]);
            amountArray++;
            plCount++;
            dlCount++;
            int customerId = (int) (Math.random() * 9999);
            System.out.println("Customer OTP is: " + customerId);
        }

        catch (Exception e)
        {
            System.out.println("Please Enter Proper Input");
            e.printStackTrace();
        }
        checkTaxiAvailable();
    }
    public void checkTaxiAvailable()
    {
        if(numberTaxi<=3)
        {
            numberTaxi++;
        }
        else
        {
            numberTaxi=(int)((Math.random()*2)+1);
        }
        System.out.println("Taxi "+numberTaxi+ " is Booked\n");
        showMenu();
    }
    public void displayTaxiDetails()
    {
        System.out.println("\nHistory Of Your Trips Today");
        for(int i=0;i<=amountArray-1;i++)
        {
            System.out.println("Trip "+(i+1)+ "\nPickup Time : " + pickupTime[i]);
            System.out.println("Pickup Location : " + pickupLocation[i]);
            System.out.println("Drop Location : " + dropLocation[i]);
            System.out.println("Amount you Paid for the Trip: " + amount[i]+"\n");
        }
        showMenu();
    }
    public void exit()
    {
        System.out.println("Byeee...");
    }
}

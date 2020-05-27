import java.util.Random;
import java.util.Scanner;
public class Problem1{

   final int LOW = 1;
   final int HIGH = 100;
   Scanner in = new Scanner(System.in);
   
   private int getInt() {
       Scanner in = new Scanner(System.in);
       int integer = -1;
       
       try {
           integer = in.nextInt();
       } 
       catch (Exception e) {
           System.out.println("Not an integer! Try again");
           return -1;
       }
       return integer;
   }

   private void initRand(int arr[], int size) {
       Random rand = new Random();
       
       for (int i = 0; i < size; i++) {
           arr[i] = rand.nextInt(HIGH - LOW) + LOW;
       }
   }

   private void print(int arr[], int size) {
       for (int i = 0; i < size; i++) {
           System.out.print(arr[i] + " ");
       }
       System.out.println();
   }

   private boolean isAllEven(int arr[], int size) {
       boolean isEven = true;
       for (int i = 0; i < size; i++) {
           if (arr[i] % 2 != 0) {
               isEven = false;
               break;
           }
       }
       return isEven;
   }

   private boolean isUnique(int arr[], int size) {
       boolean unique = true;
       
       for (int i = 0; i < size; i++) {
           for (int j = i + 1; j < size; j++) {
               if (arr[i] == arr[j]) {
                   unique = false;
                   break;
               }
           }
       }
       return unique;
   }

   private int minGap(int arr[], int size) {
       int gap = arr[1] - arr[0];

       for (int i = 1; i < size - 1; i++) {
           int currentGap = arr[i + 1] - arr[i];
           if (currentGap < gap) {
               gap = currentGap;
           }
       }
       return gap;
   }

   private int menu() {
       int option;
       System.out.println("Your options are:\n----------------------");
       System.out.println("1) All even values?");
       System.out.println("2) All unique values?");
       System.out.println("3) Print min gap between values");
       System.out.println("4) Statistics");
       System.out.println("5) Print 80% percentile");
       System.out.println("0) EXIT");
       
       do {
           System.out.println("Please enter your option: ");
           option = getInt();
       } while (option == -1);
       return option;
   }

   private void bubbleSort(int arr[], int size) {
       for (int i = 0; i < size - 1; i++) {
           for (int j = 0; j < (size - i - 1); j++) {
               if (arr[j] > arr[j + 1]) {
                   int temp = arr[j];
                   arr[j] = arr[j + 1];
                   arr[j + 1] = temp;
               }
           }
       }
   }

   private void copy(int arr1[], int arr2[], int size) {

       for (int i = 0; i < size; i++) {
           arr2[i] = arr1[i];
       }
   }

   private void top_20(int arr[], int size) {
       int arr1[] = new int[size];
       copy(arr, arr1, size);
       bubbleSort(arr1, size);
       System.out.println("The list sorted:");
       for (int i = 0; i < size; i++) {
           System.out.print(arr1[i] + " ");
       }
       
       System.out.println();
       System.out.println("80%-percentile from this list:");
       int twentyPercent = size * 20 / 100;
       int count = 0;
       
       for (int i = size - 1; i >= 0; i--) {
           if (count < twentyPercent) {
               System.out.print(arr1[i] + " ");
               count++;
           } else
               break;
       }
       System.out.println();
   }

   private double getMean(int arr[], int size) {
       double total = 0;
       
       for (int i = 0; i < size; i++) {
           total += arr[i];
       }
       return total / size;
   }

   private double getMean(double arr[], int size) {
       double total = 0;

       for (int i = 0; i < size; i++) {
           total += arr[i];
       }
       return total / size;
   }

   private double getVariance(int list[], int size) {
       double list2[] = new double[size];
       double mean = getMean(list, size);
       double total = 0;

       for (int i = 0; i < size; i++) {
           list2[i] = Math.pow((list[i] - mean), 2);
           total += list2[i];
       }
       return total / size;
   }

   public static void main(String args[]) {
       Problem1 task = new Problem1();
       int size;

       do {
           System.out.print("How many elements/list: ");
           size = task.getInt();
       } while (size == -1);
       
       int list[] = new int[size];
       task.initRand(list, size);
       task.print(list, size);
       while (true) {
           int option = task.menu();
           
           do {
               switch (option) {
               case 1:
                   boolean isEven = task.isAllEven(list, size);
                   if (!isEven)
                       System.out.println("Some values/list are odd");
                   else
                       System.out.println("All values are even");
                   break;

               case 2:
                   boolean unique = task.isUnique(list, size);
                   if (!unique)
                       System.out
                               .println("Some values/list appear multiple times");
                   else
                       System.out.println("All values are unique");
                   break;
                   
               case 3:
                   System.out
                           .println("The minimum gap between 2 adjacent values is "
                                   + task.minGap(list, size));
                   break;
                   
               case 4:
                   task.print(list, size);
                   System.out.println("The mean for this list is: "
                           + task.getMean(list, size));
                   System.out.println("The variance for this list is: "
                           + task.getVariance(list, size));
                   System.out
                           .println("The standard deviation for this list is: "
                                   + Math.sqrt(task.getVariance(list, size)));
                   break;
                   
               case 5:
                   task.top_20(list, size);
                   break;
                   
               case 0:

System.out.println("Testing completed");
                   System.exit(0);
                   break;
               default:
                   System.out.println("Wrong choice!");
               }
           } while (option == -1);
       }
   }
}
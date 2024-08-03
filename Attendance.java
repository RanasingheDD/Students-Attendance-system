import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Attendance {
    static ArrayList<String> stu_numList1  = new ArrayList<>();
    static ArrayList<String> stu_numList2  = new ArrayList<>();
    static String number;
    static int attendance_count;
    public static void setCourse(){
        System.out.println("1.BECS");
        System.out.println("2.PE");
        System.out.println("3.PS");
        System.out.println("4.MIT");
        System.out.println("5.BS");
        System.out.println("6.ENCM");

    }
    public static void BECS() throws IOException {
        FileWriter TimeWriter = new FileWriter("Students2.txt", true);
        PrintWriter printWriter0 = new PrintWriter(TimeWriter);
        printWriter0.println(controller.getTime());
        printWriter0.println();
        printWriter0.close();
        TimeWriter.close();
        int count1 = 0;
        if (count1<=controller.getNameCount()) {
            for (int i = count1; i <= count1; count1++) {

                System.out.println("Enter your Last 03 digiit of Student Number");
                Scanner scr = new Scanner(System.in);
                number = scr.nextLine();
                String fileRead;
                if(Integer.parseInt(number) ==0) {
                    break;
                }


                try (BufferedReader student_Scanner1 = new BufferedReader(new FileReader("Students.txt"))) {
                    while ((fileRead = student_Scanner1.readLine()) != null) {
                        String[] names_nums = fileRead.split(",", 2);

                        for (int j = 1; j < names_nums.length; j += 2) {
                            stu_numList1.add(names_nums[j]);

                        }
                    }
                    FileWriter StudentWriter = new FileWriter("Students2.txt", true);
                    PrintWriter printWriter1 = new PrintWriter(StudentWriter);
                   for (String s : stu_numList1) {
                        if (s.contains(number)) {
                            printWriter1.println(s);
                        }

                    }

                    printWriter1.close();
                    StudentWriter.close();

                }
                stu_numList1.clear();

            }
        }
        else {
            System.out.println("compleated");
        }

    }
    public static void readAttendance(){

        String attendance;
        Scanner scr2 = new Scanner(System.in);
        System.out.println("Enter Student number");
        String stunum = scr2.nextLine();

        try (BufferedReader Attendance_Reader = new BufferedReader(new FileReader("Students2.txt"))) {
            while ((attendance = Attendance_Reader.readLine()) != null) {
                stu_numList2.add(attendance);
                System.out.println(stu_numList2);
            }
                if (stu_numList2.contains(stunum)) {
                    HashMap<String, Integer> countMap = new HashMap<>();

                    // Count occurrences of each element in the array
                    for (String element : stu_numList2) {
                        countMap.put(element, countMap.getOrDefault(element, 0) + 1);
                    }

                    // Print element counts
                    for (String element : countMap.keySet()) {
                        attendance_count = countMap.get(element);
                        // System.out.println(attendance_count + " times.");

                    }

                    System.out.println("Marks is " + (attendance_count) + "%");

                }



    } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    }




import java.util.Scanner;

public class Initialization {

    // Student-DB--------------

    static String[] studentNames = new String[100];  // for stores student's names
    static int[] studentAges = new int[100];  // sotores student's age
    static String[] studentEmails = new String[100];  // stores student's own email
    static int studentCounter = -1;  // point of current save student
    // Student-DB--------------


    // Course DB--------------

    static String[] courseNames = new String[100]; // for stores course's names
    static int[] courseDuration = new int[100]; // stores course's duration of time
    static double[] courseFee = new double[100]; // store course's course fee
    static int courseCounter = -1; // point of currently save course

    // Course DB--------------


    static Scanner input = new Scanner(System.in);


    public static void printPrimaryQ() {

        System.out.println("=============================================================");
        System.out.println("Hello,Welocme to STUDENT MANAGMENT SYSTEM");
        System.out.println("=============================================================");

    }

    public static void printQ() {
        System.out.println("============================");
        System.out.println("Choose an Option (Enter the Number :)");
        System.out.println("============================");
        System.out.println("1)Student Managment");
        System.out.println("2)Course Managment");
        System.out.println("3)Enroll Managment");
        System.out.println("4)Exit");
        System.out.println("============================");

    }

    public static void clearNewLine() {

        input.nextLine();
    }


    // =======studentQ==================

    static String[] studentQ = {

            "1)Save Student",
            "2)Update Student",
            "3)Delete Student",
            "4)Search Student",
            "5)View All",
            "6)Back",
            "7)Exit"
    };

    // =======studentQ==================


    // ==========================Student management==========================

    public static void loadAllStudents() {

        for (String name : studentNames) {
            System.out.print(name + ", ");
        }
        System.out.println();


        for (int age : studentAges) {
            System.out.print(age + ", ");
        }
        System.out.println();


        for (String email : studentEmails) {
            System.out.print(email + ", ");
        }
        System.out.println();


    }


//check student array full============

    public static boolean isFull() {

        return studentNames.length - 1 <= studentCounter;
    }

    public static boolean isEmpty() {

        return studentCounter == -1;
    }


//check student array full============


    public static void saveStudent() {

        if (isFull()) {
            System.out.println("Oops Cannot be add more student!");
            return;

        }

        loadAllStudents(); // print all info of students

        System.out.println("Please Enter Student (" + (studentCounter + 1 + 1) + ")" + "name:");
        String sName = input.nextLine();


        boolean isValid = false;
        int age = 0;

        while (!isValid) {

            System.out.println("Enter Student (" + (studentCounter + 1 + 1) + ")" + "Age: ");
            String inputString = input.nextLine();

            try {
                age = Integer.parseInt(inputString);

                if (age > 0 && age < 120) {

                    isValid = true;
                } else {

                    System.out.println("Please enter valid age!");
                }
            } catch (NumberFormatException e) {

                System.out.println("Error! Please Enter Numbers  only!");

            }
        }


        System.out.println("Enter Student(" + (studentCounter + 1 + 1) + ")" + "Email:");
        String email = input.nextLine();

        for (int i = 0; i <= studentCounter; i++) {

            if (studentNames[i] == sName || studentEmails[i] == email) {

                System.out.println("Studnet already exit!");
                return;
            }

        }
        ++studentCounter;
        studentNames[studentCounter] = sName;
        studentAges[studentCounter] = age;
        studentEmails[studentCounter] = email;

        System.out.println("Student saved! ✔\uFE0F");
        String saveStudent = String.format("Name: %s | Age: %d | Email: %s ", sName, age, email);
        System.out.println(saveStudent);


    }

    public static void UpdateStudent() {

        if (isEmpty()) {

            System.out.println("Cannot allowcate to do this operation!");
            return;
        }


        loadAllStudents();

        System.out.println("Please Enter Student Id: ");
        int indexsId = input.nextInt(); // do not use 0
        clearNewLine();
        indexsId--;

        String sName = studentNames[indexsId];
        String email = studentEmails[indexsId];

        if (sName != null && email != null) {

            System.out.println("Student found and name is :" + sName);
            System.out.println("Insert new Name: ");
            String tName = input.nextLine();

            System.out.println("Insert new Age:");
            int tAge = input.nextInt();
            clearNewLine();

            System.out.println("Insert new Email: ");
            String tEmail = input.nextLine();

            studentNames[indexsId] = tName;
            studentAges[indexsId] = tAge;
            studentEmails[indexsId] = tEmail;

            System.out.println("Student Updaed!");
            String saveStudent = String.format("Name: %s | Age: %d | Email: %s ", sName, tAge, tEmail);
            System.out.println(saveStudent);


        } else {

            System.out.println("Student Not found!");
        }


    }

    public static void deleteStudent() {

        if (isEmpty()) {
            System.out.println("Cannot allowcate to do this operation!");
            return;

        }

        loadAllStudents();

        System.out.println("Please enter student Id: ");
        int indexId = input.nextInt(); // please only enter starting 1
        clearNewLine();
        indexId--;

        String sName = studentNames[indexId];
        String sEmail = studentEmails[indexId];

        if (sName != null && sEmail != null) {

            studentNames[indexId] = null;
            studentAges[indexId] = 0;
            studentEmails[indexId] = null;
            System.out.println("Student Removed Sucess!");
            studentCounter--;
        } else {

            System.out.println("Student not found!");
        }


    }

    public static void searchStudent() {

        System.out.println("Enter Search Text: ");
        String searchText = input.nextLine();

        // search is exit or not provide student name

        for (int i = 0; i <= studentCounter; i++) {

            if (searchText != null && studentNames[i].contains(searchText)) {

                System.out.println(studentNames[i]);

            }
        }
        System.out.println("Student not found!");
    }

    public static void viewAllStudent() {

        if (isEmpty()) {
            System.out.println("Cannot allowcate to do this operation!");
            return;

        }

        boolean isValid = false;
        for (int i = 0; i < studentCounter; i++) {

            if (studentNames[i] != null && studentAges[i] != 0 && studentEmails[i] != null) {
                String saveStudent = String.format("Name: %s | Age: %d | Email: %s ", studentNames[i], studentAges[i], studentEmails[i]);
                isValid = true;
            }


        }
        if (!isValid) {
            System.out.println("Student not found");
        }


    }


    private static void manageStudent() {

        System.out.println("Manage Student,");
        printDevider();

        while (true) {

            for (String question : studentQ) {

                System.out.println(question);
            }
            System.out.println();

            int num = input.nextInt();
            clearNewLine();

            switch (num) {

                case 1:
                    saveStudent();//saveStudent
                    break;
                case 2:
                    UpdateStudent(); //updateStudent
                    break;
                case 3:
                    deleteStudent();
                    break;//deleteStudent
                case 4:
                    searchStudent();
                    break; //searchStudent
                case 5:
                    viewAllStudent();
                    break;
                case 6:
                    return;
                case 7:
                    goodBye();
                    break;

                default:
                    System.out.println("Idiot,Wrong Input,Please Try Again! \uD83D\uDE14");


            }


        }


    }


    //print devider============================
    public static void printDevider() {
        System.out.println("=========================================");
    }

    //print devider============================

    public static void goodBye() {
        System.out.println("Good bye...\uD83D\uDC4B\uD83D\uDE0A");
        System.exit(0);


    }


    // ==========================Student management==========================

    // ---------Course Question

    static String[] printC = {

            "1)Save Course",
            "2)Update  Course",
            "3)Delete Course",
            "4)Search Course",
            "5)VewAll Course",
            "6)Back",
            "7)Exit"

    };

    // ---------Course Question


    public static void loadAllCourses() {


    }

    // ========================Course management========================

    public static void saveCourse() {


    }


















    public static void manageCourse() {

        System.out.println("Manages Courses,");
        printDevider();

        while (true) {


            for (String courseQ : printC) {

                System.out.println(courseQ);

            }
            System.out.println();

            int num = input.nextInt();
            clearNewLine();

            switch (num) {

                case 1: saveCourse();// saveCourse
                case 2: // updateCourse
                case 3: // deleteCourse
                case 4: // searchCourse
                case 5: // viewAll
                case 6: //back
                    return;
                case 7: // exit
                    goodBye();
                default:
                    System.out.println("Idiot,Wrong Input,Please Try Again! \uD83D\uDE14");
                    return;

            }


        }


    }



    // ========================Course management========================





    public static void manageEnrollment() {
    }


    public static void main(String[] args) {


        while (true) {

            printPrimaryQ();
            printQ();


            int num = input.nextInt();
            clearNewLine();

            switch (num) {

                case 1:
                    manageStudent();
                    break;
                case 2:
                    manageCourse();
                    break;
                case 3:
                    manageEnrollment();
                    break;
                case 4:
                    goodBye();
                default:
                    System.out.println("Idiot,Wrong Input,Please Try Again! \uD83D\uDE14");
                    return;
            }


        }


    }


}

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

        if (indexId <= 0 || indexId > 100) {

            System.out.println("Student not found!");
            return;
        }

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

        for (String course : courseNames) {

            System.out.print(course + ", ");
        }
        System.out.println();

    }


    public static void loadAllCoursesFee() {

        for (double cFees : courseFee) {

            System.out.print(cFees + ", ");
        }
        System.out.println();
    }

    public static void loadAllCourseTimers() {

        for (int cTimer : courseDuration) {

            System.out.print(cTimer + ", ");
        }
        System.out.println();
    }


    // ========================Course management========================

    public static void saveCourse() {

        loadAllCourses();

        // store course name
        System.out.println("Please Enter course (" + (courseCounter + 1) + ")" + "name :");
        String cname = input.nextLine();
        String covrtedText = cname.toLowerCase();

        // store provide course's duration
        boolean isValid = false;
        int durC = 0;
        while (!isValid) {


            loadAllCourseTimers();

            System.out.println("Please Enter Course Duration: ");
            String duration = input.nextLine();

            try {
                durC = Integer.parseInt(duration);

                if (durC > 0) {

                    isValid = true;
                } else {

                    System.out.println("Not valid time duration!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please Provide only Numbers!");
            }

        }
        System.out.println("Course duration saved!");

        // store provide course's fees

        loadAllCoursesFee();

        boolean isChecker = false;
        double cFee = 0.0;

        while (!isChecker) {

            System.out.println("Please Enter Course fee (LKR):");
            cFee = input.nextDouble();

            if (cFee < 0) {
                System.out.println("Not valid! Try Again!");
            } else {

                isChecker = true;
            }

        }
        System.out.println("Course Payment Successfully!");

        courseCounter++;
        courseNames[courseCounter] = covrtedText;
        courseDuration[courseCounter] = durC;
        courseFee[courseCounter] = cFee;
        String cSummery = String.format("Name: %s | Duration: %dh | Fee: LKR%.2f", cname, durC, cFee);
        System.out.println(cSummery);


    }

    public static void updateCourse() {

        System.out.println("Please Enter course Id: ");
        int cIndex = input.nextInt(); // not use 0
        cIndex--;
        clearNewLine();

        String cName = courseNames[cIndex];

        if (cName != null) {

            System.out.println("Course found and name is-" + cName);
            System.out.println("Insert New course Name :");
            String nCname = input.nextLine();
            courseNames[cIndex] = cName;

            System.out.println("Do you want change Course Duration and Fees?(Y/N) :");
            String option = input.nextLine();
            String lConfirm = option.toLowerCase(); // convert to lowerCase


            if (lConfirm.equals("y")) {

                System.out.println("Insert new course fee(LKR) :");
                double newFee = input.nextDouble();
                clearNewLine();
                courseFee[cIndex] = newFee;

                System.out.println("Insert new course Duratione(hrs) :");
                int nDur = input.nextInt();
                clearNewLine();
                courseDuration[cIndex] = nDur;
                System.out.println("Course details updated!");

            } else if (lConfirm.equals("no")) {

                System.out.println("Confirming...");
            } else {

                System.out.println("Invalid!");
            }


        }


    }

    public static void deleteCourse() {

        System.out.println("Please Enter Course Id: ");
        int cIndex = input.nextInt(); // dont use 0
        cIndex--;

        String cName = input.nextLine();

        if (cName != null) {

            courseNames[cIndex] = null;
            courseDuration[cIndex] = 0;
            courseFee[cIndex] = 0.0;
            courseCounter--;
            System.out.println("Course deleted!" + cName);
        } else {

            System.out.println("Course not found!");
        }


    }

    public static void searchCourse() {

        System.out.println("Enter SearchText:");
        String searchTxt = input.nextLine();

        String lowerCname = searchTxt.toLowerCase();


        for (int i = 0; i <= courseCounter; i++) {

            if (courseNames[i].contains(lowerCname)) {

                System.out.println(courseNames[i]);

            }

        }
        System.out.println("course not found!");


    }

    public static void viewAll() {


        for (int i = 0; i <= courseCounter; i++) {

            if (courseNames[i] != null && courseDuration[i] != 0 && courseFee[i] != 0) {

                String cSummery = String.format("Name: %s | Duration: %dh | Fee: LKR%.2f", courseNames[i], courseDuration[i], courseFee[i]);
                System.out.println(cSummery);
            }

        }

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

                case 1:
                    saveCourse();// saveCourse
                    break;
                case 2:
                    updateCourse();// updateCourse
                    break;
                case 3:
                    deleteCourse(); // deleteCourse
                    break;
                case 4:
                    searchCourse(); // searchCourse
                    break;
                case 5:
                    viewAll();  // viewAll
                    break;
                case 6: //back
                    return;
                case 7: // exit
                    goodBye();
                    break;
                default:
                    System.out.println("Idiot,Wrong Input,Please Try Again! \uD83D\uDE14");
                    return;

            }


        }


    }


    // ========================Course management========================


    //  ========================Enrolment Management ========================


    static String[] printRegister = {

            "1)Enroll Student",
            "2)View All Enrolments",
            "3)Delete Enrolment",
            "4)Back",
            "5)Exit"

    };


    //  ========================Enrolment Management ========================


    public static void manageEnrollment() {

        System.out.println("Manage Enroll Process,");
        printDevider();


        for (String registerQ : printRegister) {

            System.out.print(registerQ);

        }
        System.out.println();

        int num=input.nextInt();

        switch (num){

            case 1: // enrollStudent
            case 2:// view allEnrollment
            case 3: //cancelEnrollment
            case 4:
            case 5:
            default:
        }


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

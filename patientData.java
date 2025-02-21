import java.util.*;
class Hospital {
    void display() {
        System.out.println("--------------------------------");
        System.out.println("1. 16/2/25 , Time: 9:00 AM IST");
        System.out.println("2. 16/2/25 , Time: 15:00 IST");
        System.out.println("3. 17/2/25 , Time: 9:00 AM IST");
        System.out.println("4. 17/2/25 , Time: 15:00 IST");
        System.out.println("5. 18/2/25 , Time: 9:00 AM IST");
        System.out.println("6. 18/2/25 , Time: 15:00 IST");
        System.out.println("7. 19/2/25 , Time: 9:00 AM IST");
        System.out.println("8. 19/2/25 , Time: 15:00 IST");
        System.out.println("9. 20/2/25 , Time: 9:00 AM IST");
        System.out.println("10. 20/2/25 , Time: 15:00 IST");
        System.out.println("--------------------------------");
    }
    void displayCharges(){
        System.out.println("------------------------------");
        System.out.println("Normal Checkup - Rs500/-");
        System.out.println("Blood/Urine Checkup - Rs350/-");
        System.out.println("Bowl Test - Rs 100");
        System.out.println("Sugar Level Checkup - Rs50/-");
        System.out.println("Bp level Checkup - Rs50/-");
        System.out.println("--------------------------------");
    }
}
class PatientData extends Hospital {Scanner sc = new Scanner(System.in);
    static int counter = 0;
    int defaultBalance = 1000;
    String name ,pass;
    String feedback = "";
    static  int choice;
    int id, medicalBills;
    String appointmentDate = "";
    String[] medical_record = new String[20];

    void generateId() {
        id = ++counter;
    }
}
class Patient extends PatientData {
    Patient() {
        generateId();
    }

    boolean login(Patient obj, String name1, String pass1) {
        if (obj.name.equalsIgnoreCase(name1) && obj.pass.equals(pass1)) {
            System.out.println("Login Successful");
            return true;
        } else {
            System.out.println("Enter proper credentials");
            return false;
        }
    }
    void MedicalHistoryInput(Patient obj){
        System.out.println("Do You have any Past Disease History?Type 1 For yes and 2 otherwise");
         choice = sc.nextInt();
        if(choice==1){
            System.out.println("Please Enter Your Past Sickness Details, Type Exit when you are finished");
            int h =0;
            while(true){
                obj.medical_record[h] = sc.nextLine();
                if(obj.medical_record[h].equalsIgnoreCase("Exit"))
                    break;
                else{h++;}

            }
        }}
    void bookAppointment() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter The date and Time from the below given slots");
        display();
        boolean k = true;
        while(k){
        int appointDate = sc.nextInt();
        k=false;
        switch (appointDate) {
            case 1:
                appointmentDate = "16/2/25 , Time: 9:00 AM IST";
                break;
            case 2:
                appointmentDate = "16/2/25 , Time: 15:00 PM IST";
                break;
            case 3:
                appointmentDate = "17/2/25 , Time: 9:00 AM IST";
                break;
            case 4:
                appointmentDate = "17/2/25 , Time: 15:00 PM IST";
                break;
            case 5:
                appointmentDate = "18/2/25 , Time: 9:00 AM IST";
                break;
            case 6:
                appointmentDate = "18/2/25 , Time: 15:00 PM IST";
                break;
            case 7:
                appointmentDate = "19/2/25 , Time: 9:00 AM IST";
                break;
            case 8:
                appointmentDate = "19/2/25 , Time: 15:00 PM IST";
                break;
            case 9:
                appointmentDate = "20/2/25 , Time: 9:00 AM IST";
                break;
            case 10:
                appointmentDate = "20/2/25 , Time: 15:00 PM IST";
                break;
            default:
                System.out.println("No proper date selected");k=true;
                break;
        }}
        System.out.println(appointmentStatus());
    }
    String appointmentStatus() {
        System.out.println();
        return ("---Successfully Booked your appointment on " + appointmentDate+"------");
    }
    void medicalHistory(Patient[] array, int id) {
        if(choice==1){
        for (int k = 0; k < array[id - 1].medical_record.length; k++) {
            if(array[id-1].medical_record[k].equalsIgnoreCase("exit"))break;
            System.out.println(array[id - 1].medical_record[k]);
        }}
        else
            System.out.println("You do not have any medical History");
    }
    void calculateBill(int array[]){
        displayCharges();
         for(int i =0;i<array.length;i++){
             switch(array[i]){
                 case 1:medicalBills+=500;break;
                 case 2:medicalBills+=350;break;
                 case 3:medicalBills+=100;break;
                 case 4:medicalBills+=50;break;
                 case 5:medicalBills+=50;break;
                 default: continue;
             }
         }
        System.out.println("Your Total Payable amount is : Rs"+medicalBills+"/-");
    }
    void payment(){
        System.out.println("Kindly Enter The amount To pay From Your account");
        int payment = sc.nextInt();
        while(true){
        if(payment==medicalBills){
            if(medicalBills>defaultBalance){
                System.out.println("Insufficient Balance. Kindly add balance in your account ");
                addMoney();
            }
            else {
            defaultBalance-=medicalBills;medicalBills=0;
            System.out.println("Your Account Balance is "+"Rs"+defaultBalance+"/-");break;}
        }
        else{
            System.out.println("Kindly Enter Proper Amount");
             payment = sc.nextInt();}}
    }
    void addMoney(){
        System.out.println("Enter The Amount You want to add in your wallet");
        int amount = sc.nextInt();
        System.out.println("Enter your Password");sc.nextLine();
        String password = sc.nextLine();
        if(pass.equals(password))
            defaultBalance+=amount;
        else {System.out.println("-----WRONG PASSWORD---Follow procedure again");}
    }
}
class Run {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Patient[] record = new Patient[20];
        for (int i = 0; i < record.length; i++) {
            record[i] = new Patient();
        }
        String[] patientNames = {"John", "Hailey", "George", "Max", "Matt"};
        Patient calling = new Patient();
        for (int i = 0; i < patientNames.length; i++) {
            record[i].name = patientNames[i];
            record[i].pass=record[i].name+"123";
        }
        System.out.println("Welcome to Patient login Interface");
        System.out.println("Kindly enter Your id");
        int id1 = sc.nextInt();
        sc.nextLine();
        System.out.println("Kindly enter Your Name");
        String name = sc.nextLine();
        System.out.println("Kindly enter Your Password");
        String pass = sc.nextLine();
        boolean k = true;
        while (k) {
            if (calling.login(record[id1 - 1], name, pass)) {
                k = false;
            } else {
                name = sc.nextLine();
                pass = sc.nextLine();
            }
        }
        calling.MedicalHistoryInput(record[id1 - 1]);
        System.out.println("Select the Service You wish:");
        boolean b = true;
        while (b) {
            System.out.println("1.Book Appointment\n2.See Appointment Details\n3.See Medical History\n4.Add Money In e-wallet\n5.See E-wallet Balance\n6.Exit");
            int service = sc.nextInt();
            switch (service) {
                case 1:
                    record[id1 - 1].bookAppointment();
                    System.out.println("Please Enter whatever service You need :");
                    System.out.println("1.Normal Checkup\n2.Blood/Urine Test\n3.Bowl Test\n4.Sugar Level Check\n5.Bp level Check\n6.exit");
                    int checkUpChoice[] = new int[5];
                    boolean c = true;
                    while(c){
                    for (int i = 0; i < checkUpChoice.length; i++) {
                        checkUpChoice[i] = sc.nextInt();
                        if (checkUpChoice[i] == 6) {
                            c = false;
                            break;
                        }
                        else if (checkUpChoice[i] > 6 || checkUpChoice[i] < 1) {
                            System.out.println("Invalid Choice");
                            System.out.println("Enter all your choices Once again");
                        }
                    }
                    }
                    record[id1 - 1].calculateBill(checkUpChoice);
                    record[id1 - 1].payment();

                    break;
                case 2:
                    if (record[id1 - 1].appointmentDate.equals("")) {
                        System.out.println("Kindly Book Appointment First");
                    } else {
                        System.out.println(record[id1 - 1].appointmentStatus());
                    }
                    break;
                case 3:
                    record[id1 - 1].medicalHistory(record, id1);
                    break;
                case 4:record[id1-1].addMoney();
                  break;
                case 5:
                    System.out.println("Balance: "+"Rs"+record[id1-1].defaultBalance+"/-");break;
                case 6:
                    System.out.println("Thanks for visiting us.");b= false;break;
                default:
                    System.out.println("Select from available services");break;
            }
        }
    }
}


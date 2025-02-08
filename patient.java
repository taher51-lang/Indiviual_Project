import java.util.*;
class hospital{
    void display(){
        System.out.println("1. 16/2/25 , Time: 9:00 AM IST\n2. 16/2/25 , Time: 15:00 IST ");
        System.out.println("3. 17/2/25 , Time: 9:00 AM IST\n4. 17/2/25 , Time: 15:00 IST ");
        System.out.println("5. 18/2/25 , Time: 9:00 AM IST\n6. 18/2/25 , Time: 15:00 IST ");
        System.out.println("7. 19/2/25 , Time: 9:00 AM IST\n8. 19/2/25 , Time: 15:00 IST ");
        System.out.println("9. 20/2/25 , Time: 9:00 AM IST\n10. 20/2/25 , Time: 15:00 IST ");
    }
}
public class patient extends hospital{
    static  int counter =0;
    String name,Feedback,pass;
    int id,medicalBills;
    String appointmentDate;
    String medical_record[] = new String[10];
    void generateId(){
        id=++counter;
    }
}
class patientFunctions extends patient{
    boolean login(patient obj,String name,String pass){
        if(obj.name.equalsIgnoreCase(name)&&obj.pass.equals(pass)){
            System.out.println("Login Successful");
            return true;
        }
        else {
            System.out.println("Enter proper credentials");
            return false;
        }
    }
    void bookAppointment(){Scanner sc= new Scanner(System.in);
        System.out.println("Enter The date and Time from the below given slots");
        display();
        int appointDate = sc.nextInt();
        switch (appointDate){
            case  1:appointmentDate+="16/2/25 , Time: 9:00 AM IST";break;
            case 2:appointmentDate+="16/2/25 , Time: 15:00 PM IST";break;
            case 3:appointmentDate+="17/2/25 , Time: 9:00 AM IST";break;
            case 4:appointmentDate+="17/2/25 , Time: 15:00 PM IST";break;
            case 5:appointmentDate+="18/2/25 , Time: 9:00 AM IST";break;
            case 6:appointmentDate+="18/2/25 , Time: 15:00 PM IST";break;
            case 7:appointmentDate+="19/2/25 , Time: 9:00 AM IST";break;
            case 8:appointmentDate+="19/2/25 , Time: 15:00 PM IST";break;
            case 9:appointmentDate+="20/2/25 , Time: 9:00 AM IST";break;
            case 10:appointmentDate+="20/2/25 , Time: 15:00 PM IST";break;
            default:
                System.out.println("No proper date selected");break;
        }
        appointmentStatus();
    }
    void appointmentStatus(){
        System.out.println("Successfully Booked your appointment on "+appointmentDate);
    }
}
class run {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        patient record[] = new patient[20];
        for(int i =0;i<record.length;i++){
            record[i] = new patient();
        }
        patientFunctions calling = new patientFunctions();
        System.out.println("Welcome to Patient login Interface");
        System.out.println("Kindly enter Your name,pass and id");
        int id = sc.nextInt();sc.nextLine();
        String name = sc.nextLine();
        String pass = sc.nextLine();
        boolean k = true;
        while(k){
            if(calling.login(record[id-1],name,pass)){k=false;}
            else{name = sc.nextLine();
                 pass = sc.nextLine();}
        }
        System.out.println("Select the Service You wish:");
        System.out.println("1.BookAppointment\n2.See Appointment Details\3.See Medical History");
    }
}
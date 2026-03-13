import java.util.Scanner;

//Ye UI ke liye hai user ese hi dekhega
class AtmMenu {
    void displayMenu() {
        System.out.println("+++++++++++++++++ATM MENU+++++++++++++++++");
        System.out.println("            1 ->> Check Balance");
        System.out.println("            2 ->> Withdraw");
        System.out.println("            3 ->> Deposit");
        System.out.println("            4 ->> Exit");
        System.out.println("            5 ->> Mini Statement");
    }
}

// Data Hidding ko 100% hide karne ke liye
// Ye interface banaya hai jise child class me implements ki sahayata se
// implment kiya jayega
interface ATMoperations {
    void checkBalance();

    void withdraw();

    void deposit();

    void exit();
}

// ye abstract class hai constructor,variables define kiya gaya hai aur
// inisilive kiya gaya haii
// aur ek abstract method bhi hai without body esko bhi child class me
// inheritence se kiya jayega
abstract class setForInterface {
    Scanner sc = new Scanner(System.in);
    long balance;
    long userPin;

    setForInterface(long balance, long userPin) {
        this.balance = balance;
        this.userPin = userPin;
    }

    abstract void operations();

}

// esme sare operations ko implement kiya jayega interface aur inheritece ki
// madad se
// method overriding kiya bhi gaya hai
class ATMoperationsImplementation extends setForInterface implements ATMoperations {

    ATMoperationsImplementation(long balance, long userPin) {
        super(balance, userPin);
        // superkey se va
    }

    public void checkBalance() {
        System.out.println("Enter your 4 DigitPIN");
        long pin = sc.nextLong();
        if (pin != userPin) {
            System.out.println("Invalid PIN! Please try again.");
            return;
        } else {
            System.out.println("PIN verified successfully.");
            System.out.println("Your current balance is: " + balance);
        }
    }

    @Override
    public void withdraw() {
        System.out.println("Enter your 4 DigitPIN");
        long pin = sc.nextLong();
        if (pin != userPin) {
            System.out.println("Invalid PIN! Please try again.");
            return;
        } else {
            System.out.println("PIN verified successfully.");
        }
        System.out.println("Enter the amount to withdraw:");
        long amount = sc.nextLong();
        if (amount > balance) {
            System.out.println("Insufficient balance! Your current balance is: " + balance);
        } else {
            balance = balance - amount;
            System.out.println("Please collect your cash. Your new balance is: " + balance);
        }
    }

    @Override
    public void deposit() {
        System.out.println("Enter your 4 DigitPIN");
        long pin = sc.nextLong();
        if (pin != userPin) {
            System.out.println("Invalid PIN! Please try again.");
            return;
        } else {
            System.out.println("PIN verified successfully.");
        }
        System.out.println("Enter the amount to deposit:");
        // Scanner sc = new Scanner(System.in);
        long amount = sc.nextLong();
        balance = balance + amount;
        System.out.println("Amount deposited successfully. Your new balance is: " + balance);
    }

    @Override
    public void exit() {
        System.out.println("Thank you for using our ATM. Goodbye!");
    }

    @Override
    void operations() {
        System.out.println("Enter your choice to perfrom operations");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                checkBalance();
                break;
            case 2:
                withdraw();
                break;
            case 3:
                deposit();
                break;
            case 4:
                exit();
                break;
            case 5:
                System.out.println("#####        Mini Statement          ######");
                System.out.println("Your current balance is: " + balance);
                System.out.println("Your Last transaction was Amount deposited successfully");
                System.out.println("Your pin is xxxx");
                System.out.println("Your card is valid till 12/25");
                System.out.println("Thank you for using our ATM. Goodbye!");
                break;
            default:
                System.out.println("Invalid choice! Please select a valid operation.");
        }

    }
}

class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Basic Details");
        System.out.println("Enter your last remaining balance");
        long userBalance = sc.nextLong();
        System.out.println("Enter your 4 DigitPIN");
        long userPin = sc.nextLong();
        if (userPin != 0) {
            System.out.println("Please wait while we are processing your card");
        }
        System.out.println("#********** Welcome to my ATM ***********#");
        System.out.println("Please insert your card");
        System.out.println("Select your language");
        System.out.println("1 ->> English");
        System.out.println("2 ->> Hindi");
        System.out.println("3 ->> Bhojpuri"); // e hamara bihar khatir
        System.out.println("Enter your choice");
        int lan1 = sc.nextInt();
        switch (lan1) {
            case 1:
                System.out.println("Bilkul");
                break;
            case 2:
                System.out.println("Mera man hai English me");
                break;
            case 3:
                System.out.println("MAJAK KARAT RAHANI HIE");
                System.out.println("FER SE CHALU KARA");
                return;
            default:
                System.out.println("Invalid choice! please select sufficient language");
        }
        // if(lan1==3){

        System.out.println("Thank you for choosing language");
        System.out.println("Thank you");

        AtmMenu menu = new AtmMenu();
        menu.displayMenu();

        ATMoperationsImplementation operations = new ATMoperationsImplementation(userBalance, userPin);
        while (true) {
            operations.operations();
        }
    }
}
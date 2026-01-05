package hospitalmanagementsystem;

public class Bill {

    double consultationFee;
    double medicineCost;
    double taxRate =0.05;  
    double discount =0.10;  

    Bill(double consultationFee, double medicineCost) {
        this.consultationFee=consultationFee;
        this.medicineCost = medicineCost;
    }

    double calculatePayment() {
        double total = consultationFee+medicineCost;
        double tax =total*taxRate;
        double discountAmount=total*discount;
        return total+tax-discountAmount;
    }
}
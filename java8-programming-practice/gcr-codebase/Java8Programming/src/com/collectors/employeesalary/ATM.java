import java.util.*;

class ATM {
    public static void main(String[] args){
        double minBalance = 5000;
        double dailyTransaction = 50000;
        double initialBalance = 20000;
        
        List<Double> withdrawn = Arrays.asList(2500.0, 1500.0, 4000.0);
        double[] totalWithdrawn = {0}; 

        double finalBalance = withdrawn.stream()       
                .filter(amount -> {
                    if(amount <= 0){
                        System.out.println("Invalid amount" + amount);
                        return false;
                    }
                    return true;
                })

               
                .filter(amount -> {
                    if(amount >= dailyTransaction){
                        System.out.println("Exceed daily limit: " + amount);
                        return false;
                    }
                    return true;
                })
             
                .filter(amount -> {
                    if(initialBalance - amount < minBalance){
                        System.out.println("Cannot withdraw " + amount +
                                " minimum balance must be maintained");
                        return false;
                    }
                    return true;
                })            
                .peek(amount -> {
                    System.out.println("Withdrawn successful: " + amount);
                    totalWithdrawn[0] += amount;
                })          
                .reduce(initialBalance,(balance, amount) -> balance - amount);

        System.out.println("Final balance: " + finalBalance);
        System.out.println("Total withdrawn: " + totalWithdrawn[0]);
    }
}

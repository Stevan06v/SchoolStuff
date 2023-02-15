import java.util.Comparator;

public class AccountBookAmountComparator implements Comparator<Account>{

    @Override
    public int compare(Account o1, Account o2) {
        if(o1 == null || o2 ==  null){
            throw new NullPointerException("One account is null");
        }


        if(o1.getBalance() < o1.getBalance()){
            return -1;
        }else if(o1.getBalance() > o1.getBalance()){
            return -1;
        }else{
            return 0;
        }

        // oder return Integer.compare(o1.getBalance, o2.getBalance)
    }
}

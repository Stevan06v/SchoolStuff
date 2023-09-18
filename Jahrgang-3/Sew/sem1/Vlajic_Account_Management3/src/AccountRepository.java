import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;

public class AccountRepository {

    private static AccountRepository instance;
    List<Account> accounts = new LinkedList();
    String dataPath = "/accounts_original.csv";
    
    private AccountRepository(){

    }

    public static AccountRepository getInstance() {
        if(instance == null){
            instance = new AccountRepository();
        }
        return instance;
    }



    public void writeAccounts(String pathFileWritten) {
        List<String> lines = new LinkedList<>();
        for (Account iterator : this.accounts) {
           lines.add(iterator.toString());
        }

        try{
            Files.write(Paths.get(pathFileWritten), lines);

        }catch (Exception ex){
            throw new AccountPersistenceException("Could not write from accounts.",ex);
        }
    }

    public Account getAccount(int accNumber){
        Account acc = new Account(accNumber);
           for (Account iterator : this.accounts) {
               if(iterator.getAccountNumber() == acc.getAccountNumber()){
                   return iterator;
               }
           }
        return null;
        }

    public void loadAccounts(String filePathCorrupt) {
        List<String> lines;
        try {
            Path path = Paths.get(filePathCorrupt);
            lines = Files.readAllLines(path);
        }catch(Exception ex){
            throw new AccountPersistenceException("Could not read from accounts file.",ex);
        }


            for (String iterator : lines) {
                try{
                    Account acc = Account.createFromString(iterator);
                    addAccount(acc);
                }catch (Exception ex){
                    throw new AccountPersistenceException("Account specification is invalid.",ex);
                }
            }

    }

    public boolean addAccount(Account account) {
            if (accounts.contains(account)) {
                return false;
            }else{
                accounts.add(account);
                return true;
            }
        }


}

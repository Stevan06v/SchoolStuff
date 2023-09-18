public class YouthAccount extends Account {

    private int age;
    public static double DEFAULT_MAX_OVERDRAFT = 0.0;


    public YouthAccount(int nr, int age) {
        super(nr);
        this.setBalance(20);
        if(age < 14 || age > 18){
            throw new IllegalArgumentException("wrong age");
        }else {
            this.age = age;
        }
    }


    public void depositAmount(double value) {
        setBalance(value+this.getBalance());

    }

    /*
    public void withdrawAmount(double value) {
        if(value < 0){
            throw new IllegalArgumentException("not < 0");
        }
        if(balance - value < this.getMaxOverdraft()){
            throw new IllegalArgumentException("Too much");
        }else{
            balance -= value;
        }
    }
    */


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age <= 13 || age >= 19){
            throw new IllegalArgumentException("too young");
        }else {
            this.age = age;
        }
    }

    public  double getMaxOverdraft() {
        return DEFAULT_MAX_OVERDRAFT;
    }

    public void setMaxOverdraft(double defaultMaxOverdraft) {
        if(defaultMaxOverdraft < 0.0){
            throw new IllegalArgumentException("no overdraft");
        }else {
            DEFAULT_MAX_OVERDRAFT = defaultMaxOverdraft;
        }
    }


}

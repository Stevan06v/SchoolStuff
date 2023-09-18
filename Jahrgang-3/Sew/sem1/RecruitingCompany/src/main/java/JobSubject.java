import java.util.HashSet;

public class JobSubject {
    private int id;
    private String description;
    private String company;
    private double minPay;
    private double maxPay;
    private HashSet<Skill> requiredSkills;
    private boolean isPremium;


    public JobSubject(int id, String description, String company, double minPay, double maxPay, HashSet<Skill> requiredSkills, boolean isPremium) {
        setId(id);
        setDescription(description);
        setCompany(company);
        setCompany(company);
        setMinPay(minPay);
        setMaxPay(maxPay);
        setRequiredSkills(requiredSkills);
        setPremium(isPremium);
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getCompany() {
        return company;
    }

    public HashSet<Skill> getRequiredSkills() {
        return requiredSkills;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public double getMinPay() {
        return minPay;
    }

    private void setMinPay(double minPay) {
        this.minPay = minPay;
    }

    public double getMaxPay() {
        return maxPay;
    }

    public void setMaxPay(double maxPay) {
        this.maxPay = maxPay;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setDescription(String descrioption) {
        this.description = descrioption;
    }

    private void setCompany(String company) {
        this.company = company;
    }

    private void setRequiredSkills(HashSet<Skill> requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    private void setPremium(boolean premium) {
        isPremium = premium;
    }


}

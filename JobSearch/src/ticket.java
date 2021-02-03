public class ticket {
    private String company;
    private String title;
    private String contract;
    private int min_wage;
    private int max_wage;
    private String town;
    private String description;


    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public int getMin_wage() {
        return min_wage;
    }

    public void setMin_wage(int min_wage) {
        this.min_wage = min_wage;
    }

    public int getMax_wage() {
        return max_wage;
    }

    public void setMax_wage(int max_wage) {
        this.max_wage = max_wage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public ticket(String company, String title, String contract, int min_wage, int max_wage, String town, String description) {
        this.company = company;
        this.title = title;
        this.contract = contract;
        this.min_wage = min_wage;
        this.max_wage = max_wage;
        this.town = town;
        this.description = description;
    }



}

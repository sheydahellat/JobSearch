import java.io.Serializable;

public class company implements Serializable {

    private String name;
    private String town;
    private String field;
    private int employees;
    private String address;
    private String description;

    public company(String name, String town, String field, int employees, String address, String description) {
        this.name = name;
        this.town = town;
        this.field = field;
        this.employees = employees;
        this.address = address;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getTown() {
        return town;
    }

    public String getField() {
        return field;
    }

    public int getEmployees() {
        return employees;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }
}

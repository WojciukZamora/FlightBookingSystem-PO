public class Firm extends Client {
    private String companyName;
    private int companyId;
    public Firm(String companyName, int companyId) {
        this.companyName = companyName;
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getCompanyId() {
        return companyId;
    }
}

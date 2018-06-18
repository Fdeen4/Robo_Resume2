import java.util.ArrayList;

public class Experience {
    //static variable
    static int numberOfExperiences = 0;

    //instance variables
    private String jobTitle;
    private String company;
    private String startDate;
    private String endDate;
    private ArrayList<String> Duties;

    //constructor
    public Experience() {
        numberOfExperiences++;
    }

    //instance methods
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public ArrayList<String> getDuties() {
        return Duties;
    }

    public void setDuties(ArrayList<String> duties) {
        Duties = duties;
    }

    @Override
    public String toString () {
        StringBuffer out = new StringBuffer();
        out.append(getJobTitle() + "\n" + getCompany() + ", " + getStartDate() + "-" + getEndDate() + "\n" );
        for (String duty : getDuties()) {
            out.append(" -");
            out.append(duty);
            out.append("\n");
        }
        return out.toString();
    }
}

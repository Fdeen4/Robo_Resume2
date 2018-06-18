public class Education {
    // static variable
    static int numberOfAchievements = 0;

    //instance variables
    private String degreeName;
    private String schoolName;
    private int year;

    //constructor
    public Education() {
        numberOfAchievements++;
    }

    //instance methods
    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString () {
        return  getDegreeName() + ",\n" + getSchoolName() + ", " + getYear();
    }

}

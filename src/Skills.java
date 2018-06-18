
import java.util.ArrayList;

public class Skills {

    //static variables
    public static int numberOfSkills = 0;

    //instance variables
    private String skill;
    private String proficiency;

    //constructor


    public Skills () {
        numberOfSkills++;
    }

    //instance methods
    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getProficiency() {
        return proficiency;
    }

    public void setProficiency(String proficiency) {
        this.proficiency = proficiency;
    }

    @Override
    public String toString () {
        return "" + getSkill() + ", " + getProficiency();

    }
}

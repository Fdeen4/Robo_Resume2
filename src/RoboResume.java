import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class RoboResume {

    public static void main(String[] args) {

        //the array list will store all of the output
        ArrayList<String> storage = new ArrayList();

        //variables
        String name;
        String email;

        //create a scanner object
        Scanner in = new Scanner (System.in);

        //prompt for and read in name
        System.out.print("Name:");
        name = in.nextLine();
        if (name.equals(" ") || name.equals("\n")){
            name = "none";
        }

        //validate name
        while(name.contains("0") ||
                name.contains("1") ||
                name.contains("2") ||
                name.contains("3") ||
                name.contains("5") ||
                name.contains("6") ||
                name.contains("7") ||
                name.contains("8") ||
                name.contains("9")) {
            System.out.println("This is not a valid input. Please enter your name in words");
            System.out.print("Please enter your name:");
            name = in.nextLine();
            if (name.equals(" ") || name.equals("\n")){
                name = "none";
            }
        }

        //add the name to storage
        storage.add(name);

        //prompt for e-mail
        System.out.print("Email: ");
        email = in.nextLine();
        if (email.equals(" ") || email.equals("\n")){
            email = "none";
        }

        //validate input
        while (!email.contains("@")){
            System.out.println("This is not a valid e-mail");
            System.out.print("Enter your e-mail");
            email = in.nextLine();
            if (email.equals(" ") || email.equals("\n")){
                email = "none";
            }
        }

        //add the e-mail to storage
        storage.add ("\n");
        storage.add(email);
        storage.add("\n");
        storage.add("\n");

        //add section name to the storage array
        storage.add ("Education");
        storage.add ("\n");

        //create the first educational achievement
        Education ed1 = new Education();
        System.out.print("Major: ");
        ed1.setDegreeName(in.nextLine());
        if (ed1.getDegreeName().equals(" ") || ed1.getDegreeName().equals("\n")){
            ed1.setDegreeName("none");
        }
        while  (ed1.getDegreeName ().contains("0") ||
                name.contains("1") ||
                name.contains("2") ||
                name.contains("3") ||
                name.contains("5") ||
                name.contains("6") ||
                name.contains("7") ||
                name.contains("8") ||
                name.contains("9")) {
            System.out.println("This is not a valid degree name. Please enter the degree name in words");
            System.out.print("Please enter your degree: ");
            ed1.setDegreeName(in.nextLine());
            if (ed1.getDegreeName().equals(" ") || ed1.getDegreeName().equals("\n")){
                ed1.setDegreeName("none");
            }
        }

        System.out.print("School: ");
        ed1.setSchoolName(in.nextLine());
        if (ed1.getSchoolName().equals(" ") || ed1.getSchoolName().equals("\n")){
            ed1.setSchoolName("none");
        }


        System.out.print("Year of graduation: " );
        boolean correctYear = false;
        while (!correctYear) {
            try {
                ed1.setYear(Integer.valueOf(in.nextLine()));
                correctYear = true;
            } catch (InputMismatchException e) {
                System.out.print("Please enter a year in numeric digits: ");
            }
        }

        // add the first educational achievement to the storage array
        storage.add(ed1.toString());
        //create a boolean to see if there are more educational achievement fields to enter
        boolean moreEducation = false;
        //prompt to see if there are more educational achievements to enter
        System.out.print("Would you like to add more education?(yes or no) ");
        String response = in.nextLine();
        if (response.equalsIgnoreCase("yes")){
            moreEducation = true;
        }
        // create a loop to ask for additional educational achievements up to 10
        while (moreEducation && Education.numberOfAchievements <=10 ){
            Education ed = new Education();
            System.out.print("Major: ");
            ed.setDegreeName(in.nextLine());
            while   (ed.getDegreeName ().contains("0") ||
                    name.contains("1") ||
                    name.contains("2") ||
                    name.contains("3") ||
                    name.contains("5") ||
                    name.contains("6") ||
                    name.contains("7") ||
                    name.contains("8") ||
                    name.contains("9")) {
                System.out.println("This is not a valid degree name. Please enter the degree name in words");
                System.out.print("Please enter your degree: ");
                ed.setDegreeName(in.nextLine());
            }

            System.out.print("School: ");
            ed.setSchoolName(in.nextLine());
            if (ed1.getSchoolName().equals(" ") || ed1.getSchoolName().equals("\n")){
                ed1.setSchoolName("none");
            }

            System.out.print("Year of graduation: " );
            correctYear = false;
            while (!correctYear) {
                try {
                    ed.setYear(Integer.valueOf(in.nextLine()));
                    correctYear = true;
                } catch (InputMismatchException e) {
                    System.out.print("Please enter a year in numeric digits: ");
                }
            }
            //add the educational achievement to the storage array
            storage.add(ed.toString());
            //prompt to see if there are more educational achievements to enter
            System.out.print("Would you like to add more education?(yes or no) ");
            response = in.nextLine();
            if (!response.equalsIgnoreCase("yes")){
                moreEducation = false;
            }
        }
        if (Education.numberOfAchievements > 10) {
            System.out.println("MAX: 10 educational achievements");
        }
        //add a space after the section to the storage array
        storage.add("\n");
        storage.add("\n");


        //use a boolean value to test if they have any work experiences
        boolean hasWorkExperience = false;
        System.out.print("Would you like to add work experience? (yes or no)");
        response = in.nextLine();
        if (response.equalsIgnoreCase("yes")){
            hasWorkExperience = true;
        }
        if (hasWorkExperience) {
            //add work experience section to the storage array list
            storage.add("Experience");
            storage.add ("\n");
            //create a boolean to see if there are more work experience fields to enter
            boolean moreExperience = true;
            while (moreExperience && Experience.numberOfExperiences <= 10) {
                //create a new work experience
                Experience w = new Experience();
                //prompt for the job title
                System.out.print("Job title: ");
                //assume that job title can contain numbers, so no validation here
                w.setJobTitle(in.nextLine());
                if (w.getJobTitle().equals(" ") || w.getJobTitle().equals("\n")){
                    w.setJobTitle("none");
                }
                //prompt for the company name
                System.out.print("Company name: ");
                //name of the company may also include numbers
                w.setCompany(in.nextLine());
                if (w.getCompany().equals(" ") || w.getCompany().equals("\n")){
                    w.setCompany("none");
                }
                //prompt for the start date
                System.out.print("Job Start date: ");
                //the start date may contain words, but needs to contain at least some numbers
                w.setStartDate(in.nextLine());
                if (w.getStartDate().equals(" ") || w.getStartDate().equals("\n")){
                    w.setStartDate("none");
                }
                while (!(w.getStartDate().contains("0") ||
                        w.getStartDate().contains("1") ||
                        w.getStartDate().contains("2") ||
                        w.getStartDate().contains("3") ||
                        w.getStartDate().contains("5") ||
                        w.getStartDate().contains("6") ||
                        w.getStartDate().contains("7") ||
                        w.getStartDate().contains("8") ||
                        w.getStartDate().contains("9"))) {
                    System.out.println("This is not a valid start date. Please enter the start date with digits");
                    System.out.print("Job start date: ");
                    w.setStartDate(in.nextLine());
                    if (w.getStartDate().equals(" ") || w.getStartDate().equals("\n")){
                        w.setStartDate("none");
                    }
                }
                //prompt for the end date
                System.out.print("Job end date: ");
                //the end date need to either contain a number or the word present
                w.setEndDate(in.nextLine());
                if (w.getEndDate().equals(" ") || w.getEndDate().equals("\n")){
                    w.setEndDate("none");
                }
                while (!(w.getEndDate().contains("0") ||
                        w.getEndDate().contains("1") ||
                        w.getEndDate().contains("2") ||
                        w.getEndDate().contains("3") ||
                        w.getEndDate().contains("5") ||
                        w.getEndDate().contains("6") ||
                        w.getEndDate().contains("7") ||
                        w.getEndDate().contains("8") ||
                        w.getEndDate().contains("9")) ||
                        (w.getEndDate().trim().equalsIgnoreCase("present"))) {
                    System.out.println("This is not a valid end date. Please enter the end date with digits or the word \"present\"");
                    System.out.print("Job end date: ");
                    w.setEndDate(in.nextLine());
                    if (w.getEndDate().equals(" ") || w.getEndDate().equals("\n")){
                        w.setEndDate("none");
                    }
                }
                //prompt for the number of duties performed
                int numberOfDuties;
                System.out.print("How many duties for this job? ");
                numberOfDuties = Integer.valueOf(in.nextLine());
                ArrayList<String> duties = new ArrayList<>();
                for (int i = 1; i <=numberOfDuties; i++) {
                    System.out.print("Duty " + i + ": ");
                    duties.add(in.nextLine());
                }
                //pass the duties list to the set function of the work experience
                w.setDuties(duties);

                //add the work experience to the storage array list
                storage.add(w.toString());
                //prompt to see if there are more work experience to enter
                System.out.print("Would you like to add more job experience? (yes or no) ");
                response = in.nextLine();
                if (!response.equalsIgnoreCase("yes")) {
                    moreExperience = false;
                }
            }
            if (Experience.numberOfExperiences > 10) {
                System.out.println("Max 10 work experiences.");
            }
        }
        //add a space and a new section name to the storage array
        storage.add("\n");
        storage.add ("Skills");
        storage.add("\n");

        //create and gather information for the first skill
        Skills s1 = new Skills ();
        System.out.print("Skills: ");
        //skill names should not contain numbers;
        s1.setSkill(in.nextLine());
        if (s1.getSkill().equals(" ") || s1.getSkill().equals("\n")){
            s1.setSkill("none");
        }
        while (s1.getSkill().contains("0") ||
                s1.getSkill().contains("1") ||
                s1.getSkill().contains("2") ||
                s1.getSkill().contains("3") ||
                s1.getSkill().contains("4") ||
                s1.getSkill().contains("5") ||
                s1.getSkill().contains("5") ||
                s1.getSkill().contains("6") ||
                s1.getSkill().contains("7") ||
                s1.getSkill().contains("8") ||
                s1.getSkill().contains("9")) {
            System.out.println("The skill name should not contain any digits.");
            System.out.println("Enter the first skill: ");
            s1.setSkill(in.nextLine());
            if (s1.getSkill().equals(" ") || s1.getSkill().equals("\n")){
                s1.setSkill("none");
            }
        }

        //prompt for the proficiency level for the first skill
        System.out.print("Level of skill: ");
        //proficiency level
        s1.setProficiency(in.nextLine());
        if (s1.getProficiency().equals(" ") || s1.getProficiency().equals("\n")){
            s1.setProficiency("none");
        }
        //add the first skill to the storage array list
        storage.add(s1.toString());
        //create a boolean to test if the user has more skills to enter
        boolean moreSkills = false;
        //ask the user if they have more skills to enter
        System.out.print("Do you have more skills to enter(y or n)?  ");
        response = in.nextLine();
        if (response.equalsIgnoreCase("y")){
            moreSkills = true;
        }
        //create a loop to ask for skills up to 20
        while (moreSkills && Skills.numberOfSkills <= 20){
            //create and gather information for the first skill
            Skills s = new Skills ();
            System.out.print("Enter the first skill: ");
            //skill names should not contain numbers;
            s.setSkill(in.nextLine());
            if (s.getSkill().equals(" ") || s.getSkill().equals("\n")){
                s.setSkill("none");
            }
            while  (s.getSkill().contains("0") ||
                    s.getSkill().contains("1") ||
                    s.getSkill().contains("2") ||
                    s.getSkill().contains("3") ||
                    s.getSkill().contains("4") ||
                    s.getSkill().contains("5") ||
                    s.getSkill().contains("5") ||
                    s.getSkill().contains("6") ||
                    s.getSkill().contains("7") ||
                    s.getSkill().contains("8") ||
                    s.getSkill().contains("9")) {
                System.out.println("The skill name should not contain any digits.");
                System.out.println("Enter skills: ");
                s.setSkill(in.nextLine());
                if (s.getSkill().equals(" ") || s.getSkill().equals("\n")){
                    s.setSkill("none");
                }
            }

            //prompt for the proficiency level for the skill
            System.out.print("Enter the proficiency level for the skill: ");
            //proficiency level
            s.setProficiency(in.nextLine());
            if (s.getProficiency().equals(" ") || s.getProficiency().equals("\n")){
                s.setProficiency("none");
            }
            //add the skill to the storage array
            storage.add(s.toString());
            //ask the user if they have more skills to enter
            System.out.print("Would you like to add more skills (y or n)?  ");
            response=in.nextLine ();
            if (response.equalsIgnoreCase("y")){
                moreSkills = true;
            }
        }
        if (Skills.numberOfSkills > 20) {
            System.out.println("MAX: 20 skills.");
        }

        //output all of the information to the screen
        System.out.println("=======================================================");
        for (String item: storage){
            System.out.print(item);
        }

        //create a new file
        File file = new File ("resume.txt");
        PrintWriter out = null;
        try {
            out = new PrintWriter(file);
            out.println("=======================================================");
            for (String item: storage){
                out.print(item);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            if (out != null) {
                out.close();
            }
        }



    }
}

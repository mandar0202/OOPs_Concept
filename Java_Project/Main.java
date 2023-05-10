abstract class Candidate {
    private String name;
    private String dateOfBirth;
    private double hscMarks;
    private double averageMarks;
    private double ugCGPA;
    private double pgCGPA;
    private int numProjects;
    private double interviewScore;
    private String citizenship;

    public Candidate(String name, String dateOfBirth, double hscMarks, double averageMarks, double ugCGPA, double pgCGPA, int numProjects, double interviewScore, String citizenship) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.hscMarks = hscMarks;
        this.averageMarks = averageMarks;
        this.ugCGPA = ugCGPA;
        this.pgCGPA = pgCGPA;
        this.numProjects = numProjects;
        this.interviewScore = interviewScore;
        this.citizenship = citizenship;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public double getHscMarks() {
        return hscMarks;
    }

    public double getAverageMarks() {
        return averageMarks;
    }

    public double getUgCGPA() {
        return ugCGPA;
    }

    public double getPgCGPA() {
        return pgCGPA;
    }

    public int getNumProjects() {
        return numProjects;
    }

    public double getInterviewScore() {
        return interviewScore;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public abstract boolean isEligible();

    public void displayResult() {
        if (isEligible()) {
            System.out.println("Congratulations, " + name + "! You have been selected.");
        } else {
            System.out.println("Sorry, " + name + ". You did not meet the eligibility criteria.");
        }
    }
}

class GeneralCandidate extends Candidate {
    public GeneralCandidate(String name, String dateOfBirth, double hscMarks, double averageMarks, double ugCGPA, double pgCGPA, int numProjects, double interviewScore, String citizenship) {
        super(name, dateOfBirth, hscMarks, averageMarks, ugCGPA, pgCGPA, numProjects, interviewScore, citizenship);
    }

    @Override
    public boolean isEligible() {
        return getDateOfBirth().compareTo("1999-07-01") >= 0 && getHscMarks() >= 60 && getAverageMarks() >= 50 && getUgCGPA() >= 8 && getPgCGPA() >= 8 && getNumProjects() >= 2 && getInterviewScore() >= 35 && getCitizenship().equals("India");
    }
}

class SCSTCandidate extends Candidate {
    public SCSTCandidate(String name, String dateOfBirth, double hscMarks, double averageMarks, double ugCGPA, double pgCGPA, int numProjects, double interviewScore, String citizenship) {
        super(name, dateOfBirth, hscMarks, averageMarks, ugCGPA, pgCGPA, numProjects, interviewScore, citizenship);
    }

    @Override
    public boolean isEligible() {
        return getDateOfBirth().compareTo("1999-07-01") >= 0 && getHscMarks() >= 60 && getAverageMarks() >= 35 && getUgCGPA() >= 8 && getPgCGPA() >= 8 && getNumProjects() >= 2 && getInterviewScore() >= 35 && getCitizenship().equals("India");
    }
}

class RecruitingTeam {
    public static double calculateInterviewScore() {
        double interviewScore = 42.0; 
        return interviewScore;
    }
}

class HRTeam {
    public static void informResult(Candidate candidate) {
        candidate.displayResult();
    }
}

public class Main {
    public static void main(String[] args) {
        Candidate candidate1 = new GeneralCandidate("Mandar Patil", "1999-08-01", 85.0, 75.0, 8.5, 8.2, 3, RecruitingTeam.calculateInterviewScore(), "India");
        Candidate candidate2 = new SCSTCandidate("Yogesh Khedkar", "2000-01-15", 65.0, 55.0, 7.8, 7.6, 2, RecruitingTeam.calculateInterviewScore(), "India");
        Candidate candidate3 = new GeneralCandidate("Abhishek Rathod", "2001-02-03", 95.0, 77.0, 8.6, 8.4, 4, RecruitingTeam.calculateInterviewScore(), "India");
        Candidate candidate4 = new SCSTCandidate("Swaraj Gaikwad", "2000-02-12", 67.0, 56.0, 7.9, 7.5, 2, RecruitingTeam.calculateInterviewScore(), "India");

        HRTeam.informResult(candidate1);
        HRTeam.informResult(candidate2);
        HRTeam.informResult(candidate3);
        HRTeam.informResult(candidate4);
    }
}


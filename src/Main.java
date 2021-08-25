import exceptions.NoFacultyException;
import model.Faculty;
import model.FacultyName;
import model.University;

public class Main {
    public static void main(String[] args) {
        University university = new University("BGU");
        Faculty eff = new Faculty(FacultyName.EFF);
        Faculty hf = new Faculty(FacultyName.HF);
        Faculty irf = new Faculty(FacultyName.IRF);
        Faculty mmf = new Faculty(FacultyName.MMF);
        university.addFaculty(eff, hf, irf, mmf);
        try {
            university.printFaculties();
        } catch (NoFacultyException e) {
            e.printStackTrace();
        }
    }
}

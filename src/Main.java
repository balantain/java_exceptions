import exceptions.*;
import model.*;
import service.FacultyService;
import service.GroupService;
import service.StudentService;
import service.UniversityService;

public class Main {
    public static void main(String[] args) throws NoGroupException, NoFacultyException, NoStudentException, NoDisciplineException, MarkValueException {
//------------------------------------------- Create university --------------------------------------------------------

        University bguUniversity = new University("BGU");

//--------------------------------------------- Add faculties ----------------------------------------------------------
//                                        For convenience created enum

        Faculty effFaculty = new Faculty(FacultyName.EFF);
        Faculty hfFaculty = new Faculty(FacultyName.HF);
        Faculty irfFaculty = new Faculty(FacultyName.IRF);
        Faculty mmfFaculty = new Faculty(FacultyName.MMF);
        UniversityService.addUniversityFaculties(bguUniversity, effFaculty, hfFaculty, irfFaculty, mmfFaculty);

//-------------- Add disciplines to each faculty, because they are common for all groups in faculty --------------------
//                                             For convenience created enum

        FacultyService.addDisciplinesToFaculty(effFaculty, Discipline.ENGLISH, Discipline.FRENCH, Discipline.EFF_BANK_ANALYSIS, Discipline.EFF_FINANCE_ANALYSIS, Discipline.EFF_MACROECONOMICS, Discipline.EFF_MICROECONOMICS);
        FacultyService.addDisciplinesToFaculty(hfFaculty, Discipline.ENGLISH, Discipline.FRENCH, Discipline.HF_HISTORY_OF_BELARUS, Discipline.HF_HISTORY_OF_SCIENCE_AND_TECHNICS, Discipline.HF_LATIN_LANGUAGE, Discipline.HF_WORLD_HISTORY);
        FacultyService.addDisciplinesToFaculty(irfFaculty, Discipline.ENGLISH, Discipline.GERMAN, Discipline.IRF_BELARUS_FOREIGN_POLICY, Discipline.IRF_HISTORY_OF_FOREIGN_POLICY, Discipline.IRF_HISTORY_OF_INTERNATIONAL_RELATIONS, Discipline.IRF_REGIONAL_CONFLICTS);
        FacultyService.addDisciplinesToFaculty(mmfFaculty, Discipline.ENGLISH, Discipline.GERMAN, Discipline.MMF_ALGEBRA, Discipline.MMF_GEOMETRY, Discipline.MMF_MATHS_ANALYSIS, Discipline.MMF_PHYSICS, Discipline.MMF_PROGRAMMING);

//-------------------------------------- Add groups to each faculty ----------------------------------------------------

        Group eff1Group = new Group("EFF-1");
        Group eff2Group = new Group("EFF-2");
        Group hf1Group = new Group("HF-1");
        Group hf2Group = new Group("HF-2");
        Group irf1Group = new Group("IRF-1");
        Group irf2Group = new Group("IRF-2");
        Group mmf1Group = new Group("MMF-1");
        Group mmf2Group = new Group("MMF-2");

        FacultyService.addFacultyGroups(effFaculty, eff1Group, eff2Group);
        FacultyService.addFacultyGroups(hfFaculty, hf1Group, hf2Group);
        FacultyService.addFacultyGroups(irfFaculty, irf1Group, irf2Group);
        FacultyService.addFacultyGroups(mmfFaculty, mmf1Group, mmf2Group);

//---------------------------------------------- Add students to each group --------------------------------------------

        GroupService.addStudentsToGroup(eff1Group, new Student("Фадеев О.С."), new Student("Дубров Д.В."), new Student("Прохоров И.И."), new Student("Чигирь В.С."));
        GroupService.addStudentsToGroup(eff2Group, new Student("Чернышов О.А."), new Student("Дегтярев Д.С"), new Student("Савицын О.И."), new Student("Панин А.С."));

        GroupService.addStudentsToGroup(hf1Group, new Student("Дуров И.И."), new Student("Павлов К.М."), new Student("Тищенко В.В."), new Student("Вазов П.П."));
        GroupService.addStudentsToGroup(hf2Group, new Student("Дубовик К.И."), new Student("Прилуков Д.Д."), new Student("Автушов А.А."), new Student("Северин В.И."));

        GroupService.addStudentsToGroup(irf1Group, new Student("Туров Ф.Е."), new Student("Кудин А.В"), new Student("Березин В.В."), new Student("Торцов В.В."));
        GroupService.addStudentsToGroup(irf2Group, new Student("Шевцов Н.В."), new Student("Павлов О.В."), new Student("Дебров Н.С"), new Student("Хрущев Н.С."));

        GroupService.addStudentsToGroup(mmf1Group, new Student("Иванов И.И."), new Student("Петров П.П."), new Student("Сидоров С.С"), new Student("Сергеев С.С."));
        GroupService.addStudentsToGroup(mmf2Group, new Student("Мамехин М.М."), new Student("Мамонов Д.С."), new Student("Егоров Е.А."), new Student("Хомченко С.С."));

//--------------------------------------------- Realizing tasks --------------------------------------------------------
//                           Count average mark value for all disciplines for student
        StudentService.printAvrMarkForStudentDairy(UniversityService.getStudentByName(bguUniversity, "Хомченко С.С."));
        StudentService.printAvrMarkForStudentDairy(UniversityService.getStudentByName(bguUniversity, "Мамехин М.М."));

//                 Count average mark for concrete discipline at concrete faculty and concrete group
//---------------------- Counting average mark for discipline for concrete group ---------------------------------------
        GroupService.printAvrMarkForDiscipline(mmf1Group, Discipline.MMF_GEOMETRY);

//---------------------- Counting average mark for discipline for concrete faculty -------------------------------------
        FacultyService.printAvrMarkForDiscipline(mmfFaculty, Discipline.MMF_ALGEBRA);
        FacultyService.printAvrMarkForDiscipline(mmfFaculty, Discipline.ENGLISH);
        FacultyService.printAvrMarkForDiscipline(irfFaculty, Discipline.ENGLISH);

//--------------------------- Count average mark for discipline for whole university -----------------------------------
        UniversityService.printAvrMarkValueForDiscipline(bguUniversity, Discipline.ENGLISH);
        UniversityService.printAvrMarkValueForDiscipline(bguUniversity, Discipline.GERMAN);
    }
}

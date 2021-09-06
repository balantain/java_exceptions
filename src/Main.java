import exceptions.*;
import model.*;
import service.FacultyService;
import service.GroupService;
import service.StudentService;
import service.UniversityService;

public class Main {
    public static void main(String[] args) throws NoGroupException, NoFacultyException, NoStudentException, NoDisciplineException, MarkValueException {
//------------------------------------------- Create university --------------------------------------------------------

        University bgu = new University("BGU");

//--------------------------------------------- Add faculties ----------------------------------------------------------
//                                        For convenience created enum

        Faculty eff = new Faculty(FacultyName.EFF);
        Faculty hf = new Faculty(FacultyName.HF);
        Faculty irf = new Faculty(FacultyName.IRF);
        Faculty mmf = new Faculty(FacultyName.MMF);
        UniversityService.addUniversityFaculties(bgu, eff, hf, irf, mmf);

//--------------------------------- Print list of students to check (successfully) -------------------------------------

        UniversityService.printUniversityFaculties(bgu);
        System.out.println();

//-------------- Add disciplines to each faculty, because they are common for all groups in faculty --------------------
//                                             For convenience created enum

        FacultyService.addDisciplinesToFaculty(eff, Discipline.ENGLISH, Discipline.FRENCH, Discipline.EFF_BANK_ANALYSIS, Discipline.EFF_FINANCE_ANALYSIS, Discipline.EFF_MACROECONOMICS, Discipline.EFF_MICROECONOMICS);
        FacultyService.addDisciplinesToFaculty(hf, Discipline.ENGLISH, Discipline.FRENCH, Discipline.HF_HISTORY_OF_BELARUS, Discipline.HF_HISTORY_OF_SCIENCE_AND_TECHNICS, Discipline.HF_LATIN_LANGUAGE, Discipline.HF_WORLD_HISTORY);
        FacultyService.addDisciplinesToFaculty(irf, Discipline.ENGLISH, Discipline.GERMAN, Discipline.IRF_BELARUS_FOREIGN_POLICY, Discipline.IRF_HISTORY_OF_FOREIGN_POLICY, Discipline.IRF_HISTORY_OF_INTERNATIONAL_RELATIONS, Discipline.IRF_REGIONAL_CONFLICTS);
        FacultyService.addDisciplinesToFaculty(mmf, Discipline.ENGLISH, Discipline.GERMAN, Discipline.MMF_ALGEBRA, Discipline.MMF_GEOMETRY, Discipline.MMF_MATHS_ANALYSIS, Discipline.MMF_PHYSICS, Discipline.MMF_PROGRAMMING);

//--------------------------------- Print list of disciplines to check (successfully) ----------------------------------

        FacultyService.printFacultyDisciplines(eff);
        FacultyService.printFacultyDisciplines(hf);
        FacultyService.printFacultyDisciplines(irf);
        FacultyService.printFacultyDisciplines(mmf);


//-------------------------------------- Add groups to each faculty ----------------------------------------------------

        Group eff1 = new Group("EFF-1");
        Group eff2 = new Group("EFF-2");
        Group hf1 = new Group("HF-1");
        Group hf2 = new Group("HF-2");
        Group irf1 = new Group("IRF-1");
        Group irf2 = new Group("IRF-2");
        Group mmf1 = new Group("MMF-1");
        Group mmf2 = new Group("MMF-2");

        FacultyService.addFacultyGroups(eff, eff1, eff2);
        FacultyService.addFacultyGroups(hf, hf1, hf2);
        FacultyService.addFacultyGroups(irf, irf1, irf2);
        FacultyService.addFacultyGroups(mmf, mmf1, mmf2);

//---------------------------- Print list of groups for each faculty to check (successfully) ---------------------------

        FacultyService.printFacultyGroups(eff);
        FacultyService.printFacultyGroups(hf);
        FacultyService.printFacultyGroups(irf);
        FacultyService.printFacultyGroups(mmf);

//---------------------------------------------- Add students to each group --------------------------------------------

        GroupService.addStudentsToGroup(eff1, new Student("Фадеев О.С."), new Student("Дубров Д.В."), new Student("Прохоров И.И."), new Student("Чигирь В.С."));
        GroupService.addStudentsToGroup(eff2, new Student("Чернышов О.А."), new Student("Дегтярев Д.С"), new Student("Савицын О.И."), new Student("Панин А.С."));

        GroupService.addStudentsToGroup(hf1, new Student("Дуров И.И."), new Student("Павлов К.М."), new Student("Тищенко В.В."), new Student("Вазов П.П."));
        GroupService.addStudentsToGroup(hf2, new Student("Дубовик К.И."), new Student("Прилуков Д.Д."), new Student("Автушов А.А."), new Student("Северин В.И."));

        GroupService.addStudentsToGroup(irf1, new Student("Туров Ф.Е."), new Student("Кудин А.В"), new Student("Березин В.В."), new Student("Торцов В.В."));
        GroupService.addStudentsToGroup(irf2, new Student("Шевцов Н.В."), new Student("Павлов О.В."), new Student("Дебров Н.С"), new Student("Хрущев Н.С."));

        GroupService.addStudentsToGroup(mmf1, new Student("Иванов И.И."), new Student("Петров П.П."), new Student("Сидоров С.С"), new Student("Сергеев С.С."));
        GroupService.addStudentsToGroup(mmf2, new Student("Мамехин М.М."), new Student("Мамонов Д.С."), new Student("Егоров Е.А."), new Student("Хомченко С.С."));

//---------------------------- Print list of all students with dairy in university to check (successfully) -------------

        UniversityService.printListOfAllStudentsWithDairy(bgu);

//---------------------------- Print list of all students with dairy in each group to check (successfully)------------
        GroupService.printGroupStudentList(eff1);
        GroupService.printGroupStudentList(eff2);
        GroupService.printGroupStudentList(hf1);
        GroupService.printGroupStudentList(hf2);
        GroupService.printGroupStudentList(irf1);
        GroupService.printGroupStudentList(irf2);
        GroupService.printGroupStudentList(mmf1);
        GroupService.printGroupStudentList(mmf2);

//--------------------------------------------- Realizing tasks --------------------------------------------------------
//                           Count average mark value for all disciplines for student
        StudentService.printAvrMarkForStudentDairy(UniversityService.getStudentByName(bgu, "Хомченко С.С."));
        StudentService.printAvrMarkForStudentDairy(UniversityService.getStudentByName(bgu, "Мамехин М.М."));

//                 Count average mark for concrete discipline at concrete faculty and concrete group
//---------------------- Printing list of students with dairy in faculty to check (successfully) -----------------------

        System.out.println("List of all students with dairy in " + mmf.getFacultyName());
        for (Student student : FacultyService.getFacultyStudentList(mmf)) {
            StudentService.printStudentInfo(student);
        }
//---------------------- Counting average mark for discipline for concrete group ---------------------------------------
        GroupService.printAvrMarkForDiscipline(mmf1, Discipline.MMF_GEOMETRY);

//---------------------- Counting average mark for discipline for concrete faculty -------------------------------------
        FacultyService.printAvrMarkForDiscipline(mmf, Discipline.MMF_ALGEBRA);
        FacultyService.printAvrMarkForDiscipline(mmf, Discipline.ENGLISH);
        FacultyService.printAvrMarkForDiscipline(irf, Discipline.ENGLISH);

//--------------------------- Count average mark for discipline for whole university -----------------------------------
        UniversityService.printAvrMarkValueForDiscipline(bgu, Discipline.ENGLISH);
        UniversityService.printAvrMarkValueForDiscipline(bgu, Discipline.GERMAN);



    }
}

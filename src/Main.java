import exceptions.*;
import model.*;

public class Main {
    public static void main(String[] args) throws NoGroupException, NoFacultyException, NoStudentException, NoDisciplineException, MarkValueException {
//------------------------------------------- Create university --------------------------------------------------------

        University university = new University("BGU");

//--------------------------------------------- Add faculties ----------------------------------------------------------
//                                        For convenience created enum

        Faculty eff = new Faculty(FacultyName.EFF);
        Faculty hf = new Faculty(FacultyName.HF);
        Faculty irf = new Faculty(FacultyName.IRF);
        Faculty mmf = new Faculty(FacultyName.MMF);
        university.addFaculty(eff, hf, irf, mmf);

//--------------------------------- Print list of students to check (successfully) -------------------------------------

        university.printFaculties();
        System.out.println();

//-------------- Add disciplines to each faculty, because they are common for all groups in faculty --------------------
//                                             For convenience created enum

        eff.addDisciplines(Discipline.EFF_BANK_ANALYSIS, Discipline.EFF_FINANCE_ANALYSIS, Discipline.EFF_MACROECONOMICS, Discipline.EFF_MICROECONOMICS);
        hf.addDisciplines(Discipline.HF_HISTORY_OF_BELARUS, Discipline.HF_HISTORY_OF_SCIENCE_AND_TECHNICS, Discipline.HF_LATIN_LANGUAGE, Discipline.HF_WORLD_HISTORY);
        irf.addDisciplines(Discipline.ENGLISH, Discipline.IRF_BELARUS_FOREIGN_POLICY,Discipline.IRF_HISTORY_OF_FOREIGN_POLICY, Discipline.IRF_HISTORY_OF_INTERNATIONAL_RELATIONS, Discipline.IRF_REGIONAL_CONFLICTS);
        mmf.addDisciplines(Discipline.ENGLISH, Discipline.MMF_ALGEBRA, Discipline.MMF_GEOMETRY, Discipline.MMF_MATHS_ANALYSIS, Discipline.MMF_PHYSICS, Discipline.MMF_PROGRAMMING);

//--------------------------------- Print list of disciplines to check (successfully) ----------------------------------

        eff.printSchedule();
        System.out.println();
        hf.printSchedule();
        System.out.println();
        irf.printSchedule();
        System.out.println();
        mmf.printSchedule();
        System.out.println();

//-------------------------------------- Add groups to each faculty ----------------------------------------------------

        Group eff1 = new Group("EFF-1");
        Group eff2 = new Group("EFF-2");

        Group hf1 = new Group("HF-1");
        Group hf2 = new Group("HF-2");

        Group irf1 = new Group("IRF-1");
        Group irf2 = new Group("IRF-2");

        Group mmf1 = new Group("MMF-1");
        Group mmf2 = new Group("MMF-2");

        eff.addGroup(eff1, eff2);
        hf.addGroup(hf1, hf2);
        irf.addGroup(irf1, irf2);
        mmf.addGroup(mmf1, mmf2);

//---------------------------- Print list of groups for each faculty to check (successfully) ---------------------------

        eff.printGroups();
        hf.printGroups();
        irf.printGroups();
        mmf.printGroups();

//---------------------------------------------- Add students to each group --------------------------------------------

        eff1.addStudent(new Student("Фадеев О.С."), new Student("Дубров Д.В."), new Student("Прохоров И.И."), new Student("Чигирь В.С."));
        eff2.addStudent(new Student("Чернышов О.А."), new Student("Дегтярев Д.С"), new Student("Савицын О.И."), new Student("Панин А.С."));

        hf1.addStudent(new Student("Дуров И.И."), new Student("Павлов К.М."), new Student("Тищенко В.В."), new Student("Вазов П.П."));
        hf2.addStudent(new Student("Дубовик К.И."), new Student("Прилуков Д.Д."), new Student("Автушов А.А."), new Student("Северин В.И."));

        irf1.addStudent(new Student("Туров Ф.Е."), new Student("Кудин А.В"), new Student("Березин В.В."), new Student("Торцов В.В."));
        irf2.addStudent(new Student("Шевцов Н.В."), new Student("Павлов О.В."), new Student("Дебров Н.С"), new Student("Хрущев Н.С."));

        mmf1.addStudent(new Student("Иванов И.И."), new Student("Петров П.П."), new Student("Сидоров С.С"), new Student("Сергеев С.С."));
        mmf2.addStudent(new Student("Мамехин М.М"), new Student("Мамонов Д.С."), new Student("Егоров Е.А."), new Student("Хомченко С.С."));

//---------------------------- Print list of all students in university to check (successfully) ------------------------

        System.out.println("List of all students in " + university.getUniversityName() + ":");
        for (Student student : university.getStudents()){
                System.out.println(student.toString());
        }

//-------------------- Print list of all students in university with schedule to check (successfully) ------------------

        System.out.println("List of all students in " + university.getUniversityName() + " with schedule:");
        for (Student student : university.getStudents()){
            System.out.println(student.toStringWithSchedule());
        }

//---------------------------- Set random marks for each student in university -----------------------------------------

        university.setRandomMarksForStudents(university.getStudents());

//------------------- Print list of all students in university with dairy to check (successfully) ----------------------

        System.out.println("List of all students in " + university.getUniversityName() + " with dairy:");
        for (Student student : university.getStudents()){
            System.out.println(student.toStringWithDairy());
        }

//--------------------------------------------- Realizing tasks --------------------------------------------------------
//                           Count average mark value for all disciplines fo student

        university.countAvrMarkValueForStudentDairy(university.getStudentByName("Хомченко С.С."));

//----------------------------------------------------------------------------------------------------------------------
//                 Count average mark for concrete discipline at concrete faculty and concrete group
//---------------------- Printing list of students with dairy in faculty to check (successfully) -----------------------

        System.out.println("List of all students with dairy in " + mmf.getFacultyName());
        for (Student student : mmf.getStudents()){
            System.out.println(student.toStringWithDairy());
        }

        mmf1.printAvrMarkForDiscipline(Discipline.MMF_GEOMETRY);

        mmf.printAvrMarkForDiscipline(Discipline.MMF_ALGEBRA);

        mmf.printAvrMarkForDiscipline(Discipline.ENGLISH);
        irf.printAvrMarkForDiscipline(Discipline.ENGLISH);

        university.printAvrMarkValueForDiscipline(Discipline.ENGLISH);
    }
}

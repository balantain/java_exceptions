import exceptions.NoFacultiesException;
import exceptions.NoGroupsException;
import exceptions.NoStudentsException;
import model.*;

// нужно добавить несколько вариантов добавления студентов в университет.
// 1. с указанием факультета и группы при помощи конструктора
// 2. непосредственно в группу через метод

public class Main {
    public static void main(String[] args) {
        //----------------------------------- создаем университет ----------------------------------------------------
        University university = new University("BGU");

        //----------------------------------- добавляем в него факультеты --------------------------------------------
        Faculty eff = new Faculty(FacultyName.EFF); // возможно нужно доработать нейминг enum FacultyName
        Faculty hf = new Faculty(FacultyName.HF);
        Faculty irf = new Faculty(FacultyName.IRF);
        Faculty mmf = new Faculty(FacultyName.MMF);
        university.addFaculty(eff, hf, irf, mmf);

//--------------------------------- вывод списка факультетов для университета (для себя) (работает)---------------------
//        try {
//            university.printFaculties();
//        } catch (NoFacultiesException e) {
//            e.printStackTrace();
//        }
//        System.out.println();

//--------------------- добавляем в каждый факультет дисциплины т.к. они общие для всего факультета --------------------
        eff.addDisciplines(Discipline.EFF_BANK_ANALYSIS, Discipline.EFF_FINANCE_ANALYSIS, Discipline.EFF_MACROECONOMICS, Discipline.EFF_MICROECONOMICS);
        hf.addDisciplines(Discipline.HF_HISTORY_OF_BELARUS, Discipline.HF_HISTORY_OF_SCIENCE_AND_TECHNICS, Discipline.HF_LATIN_LANGUAGE, Discipline.HF_WORLD_HISTORY);
        irf.addDisciplines(Discipline.IRF_BELARUS_FOREIGN_POLICY,Discipline.IRF_HISTORY_OF_FOREIGN_POLICY, Discipline.IRF_HISTORY_OF_INTERNATIONAL_RELATIONS, Discipline.IRF_REGIONAL_CONFLICTS);
        mmf.addDisciplines(Discipline.MMF_ALGEBRA, Discipline.MMF_GEOMETRY, Discipline.MMF_MATHS_ANALYSIS, Discipline.MMF_PHYSICS, Discipline.MMF_PROGRAMMING);

//--------------------------------------------- Вывод списка дисциплин (для себя) (работает) ---------------------------
//        eff.printSchedule();
//        System.out.println();
//        hf.printSchedule();
//        System.out.println();
//        irf.printSchedule();
//        System.out.println();
//        mmf.printSchedule();
//        System.out.println();
//------------------------------------ добавляем группы в факультет ----------------------------------------------------
// возможно тоже нужно поработать над неймингом, а также рассмотреть возможность добавления групп без предварительной инициализации
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
//---------------------------- выводим список групп для каждого факультета (для себя) (работает) -----------------------
//        try {
//            eff.printGroups();
//            hf.printGroups();
//            irf.printGroups();
//            mmf.printGroups();
//        } catch (NoGroupsException e) {
//            e.printStackTrace();
//        }
        //-------------------------------------- добавляем студентов в группу ------------------------------------------
        eff1.addStudent(new Student("Фадеев О.С."), new Student("Дубров Д.В."), new Student("Прохоров И.И."), new Student("Чигирь В.С."));
        eff2.addStudent(new Student("Чернышов О.А."), new Student("Дегтярев Д.С"), new Student("Савицын О.И."), new Student("Панин А.С."));

        hf1.addStudent(new Student("Дуров И.И."), new Student("Павлов К.М."), new Student("Тищенко В.В."), new Student("Вазов П.П."));
        hf2.addStudent(new Student("Дубовик К.И."), new Student("Прилуков Д.Д."), new Student("Автушов А.А."), new Student("Северин В.И."));

        irf1.addStudent(new Student("Туров Ф.Е."), new Student("Кудин А.В"), new Student("Березин В.В."), new Student("Торцов В.В."));
        irf2.addStudent(new Student("Шевцов Н.В."), new Student("Павлов О.В."), new Student("Дебров Н.С"), new Student("Хрущев Н.С."));

        mmf1.addStudent(new Student("Иванов И.И."), new Student("Петров П.П."), new Student("Сидоров С.С"), new Student("Сергеев С.С."));
        mmf2.addStudent(new Student("Мамехин М.М"), new Student("Мамонов Д.С."), new Student("Егоров Е.А."), new Student("Хомченко С.С."));

//---------------------------- Выводим список всех студентов университета (для себя) (работает)-------------------------
//        try {
//            System.out.println(university.getStudents());
//        } catch (NoStudentsException | NoGroupsException | NoFacultiesException e) {
//            e.printStackTrace();
//        }
//                                                        или
//        try {
//            university.printStudents();
//        } catch (NoStudentsException | NoGroupsException | NoFacultiesException e) {
//            e.printStackTrace();
//        }

//-------- После добавления студента в группу он должен добавляться в список студентов университета-------------
        try {
            System.out.println(university.getStudentByName("Фадеев О.С."));
        } catch (NoStudentsException | NoGroupsException | NoFacultiesException e) {
            e.printStackTrace();
        }
        //-- Если начинать процесс создания студента с самого студента и передавать в него параметры группа и факультет, то в параметре факультет можно сохранить список предметов
        // но тогда будет вероятность
    }
}

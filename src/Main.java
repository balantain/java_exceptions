import exceptions.NoFacultyException;
import exceptions.NoGroupException;
import model.*;

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
        //----------------------------------- вывод списка факультетов для университета (для себя) ---------------------
        try {
            university.printFaculties();
        } catch (NoFacultyException e) {
            e.printStackTrace();
        }
        //----------------------------------- добавляем в каждый факультет дисциплины ----------------------------------
        eff.addDisciplines(Discipline.EFF_BANK_ANALYSIS, Discipline.EFF_FINANCE_ANALYSIS, Discipline.EFF_MACROECONOMICS, Discipline.EFF_MICROECONOMICS);
        hf.addDisciplines(Discipline.HF_HISTORY_OF_BELARUS, Discipline.HF_HISTORY_OF_SCIENCE_AND_TECHNICS, Discipline.HF_LATIN_LANGUAGE, Discipline.HF_WORLD_HISTORY);
        irf.addDisciplines(Discipline.IRF_BELARUS_FOREIGN_POLICY,Discipline.IRF_HISTORY_OF_FOREIGN_POLICY, Discipline.IRF_HISTORY_OF_INTERNATIONAL_RELATIONS, Discipline.IRF_REGIONAL_CONFLICTS);
        mmf.addDisciplines(Discipline.MMF_ALGEBRA, Discipline.MMF_GEOMETRY, Discipline.MMF_MATHS_ANALYSIS, Discipline.MMF_PHYSICS, Discipline.MMF_PROGRAMMING);
        //------------------------------------ добавляем группы в факультет --------------------------------------------
        Group eff1 = new Group("EFF-1"); // возможно тоже нужно поработать над неймингом
        Group eff2 = new Group("EFF-2");
        Group eff3 = new Group("EFF-3");
        Group hf1 = new Group("HF-1");
        Group hf2 = new Group("HF-2");
        Group hf3 = new Group("HF-3");
        Group irf1 = new Group("IRF-1");
        Group irf2 = new Group("IRF-2");
        Group irf3 = new Group("IRF-3");
        Group mmf1 = new Group("MMF-1");
        Group mmf2 = new Group("MMF-2");
        Group mmf3 = new Group("MMF-3");
        eff.addGroup(eff1, eff2, eff3);
        hf.addGroup(hf1, hf2, hf3);
        irf.addGroup(irf1, irf2, irf3);
        mmf.addGroup(mmf1, mmf2, mmf3);
        //------------------------------------- выводим список групп для каждого факультета (для себя) -----------------
        try {
            eff.printGroups();
            hf.printGroups();
            irf.printGroups();
            mmf.printGroups();
        } catch (NoGroupException e) {
            e.printStackTrace();
        }
    }
}

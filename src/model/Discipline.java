package model;

public enum Discipline {
    MMF_ALGEBRA("Algebra"),
    MMF_GEOMETRY("Analytic Geometry"),
    MMF_MATHS_ANALYSIS("Maths Analysis"),
    MMF_PHYSICS("Physics"),
    MMF_PROGRAMMING("Computer Programming"),

    IRF_HISTORY_OF_FOREIGN_POLICY("History Of Foreign Policy"),
    IRF_HISTORY_OF_INTERNATIONAL_RELATIONS("History Of International Relations"),
    IRF_BELARUS_FOREIGN_POLICY("Foreign Policy Of Belarus"),
    IRF_REGIONAL_CONFLICTS("Regional Conflicts"),

    EFF_BANK_ANALYSIS("Bank Analysis"),
    EFF_MICROECONOMICS("Microeconomics"),
    EFF_MACROECONOMICS("Macroeconomic Analysis"),
    EFF_FINANCE_ANALYSIS("Finance Analysis"),

    HF_WORLD_HISTORY("World History"),
    HF_LATIN_LANGUAGE("Latin Language"),
    HF_HISTORY_OF_BELARUS("History Of Belarus"),
    HF_HISTORY_OF_SCIENCE_AND_TECHNICS("History Of Science And Technics"),

    ENGLISH("\"English language\"");

    private String title;

    Discipline(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

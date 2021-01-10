package ru.skillbench.tasks.text.regex;

public class Main {
    public static void main(String[] args) {
        CurriculumVitaeImpl curriculumVitae = new CurriculumVitaeImpl();
        curriculumVitae.setText("ghjk, nm, hjk(916)125-4171 lkmdrgkvg 800 250 0890 hjkm");
        System.out.println(curriculumVitae.getText());
        curriculumVitae.getPhones();

    }
}

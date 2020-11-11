package ru.skillbench.tasks.text.regex;

public class Main {
    public static void main(String[] args) {
        CurriculumVitaeImpl curriculumVitae = new CurriculumVitaeImpl();
        curriculumVitae.setText("ghjk, nm, hjk vghjkm");
        System.out.println(curriculumVitae.getText());

    }
}

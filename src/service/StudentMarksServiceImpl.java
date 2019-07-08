package service;

import entity.StudentProgress;

public class StudentMarksServiceImpl implements StudentMarksService {
    @Override
    public double averageStudentMark(StudentProgress studentProgress) {
        double sumOfMarks = 0;
        sumOfMarks += studentProgress.getArtMark();
        sumOfMarks += studentProgress.getBiologyMark();
        sumOfMarks += studentProgress.getChemistryMark();
        sumOfMarks += studentProgress.getEconomicsMark();
        sumOfMarks += studentProgress.getMathematicsMark();
        sumOfMarks += studentProgress.getPhysicsMark();
        sumOfMarks += studentProgress.getPsychologyMark();
        return sumOfMarks / 7;
    }

    @Override
    public boolean isExcellentProgress(StudentProgress studentProgress) {
        return studentProgress.getArtMark() == 5 && studentProgress.getBiologyMark() == 5
                && studentProgress.getChemistryMark() == 5 && studentProgress.getEconomicsMark() == 5
                && studentProgress.getMathematicsMark() == 5 && studentProgress.getPhysicsMark() == 5
                && studentProgress.getPsychologyMark() == 5;
    }

    @Override
    public boolean hasUnsuccessfulMarks(StudentProgress studentProgress) {
        return studentProgress.getArtMark() == 2 || studentProgress.getBiologyMark() == 2
                || studentProgress.getChemistryMark() == 2 || studentProgress.getEconomicsMark() == 2
                || studentProgress.getMathematicsMark() == 2 || studentProgress.getPhysicsMark() == 2
                || studentProgress.getPsychologyMark() == 2;
    }
}

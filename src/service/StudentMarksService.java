package service;

import entity.StudentProgress;

public interface StudentMarksService {

    double averageStudentMark(StudentProgress studentProgress);

    boolean isExcellentProgress(StudentProgress studentProgress);

    boolean hasUnsuccessfulMarks(StudentProgress studentProgress);
}

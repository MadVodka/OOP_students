package service;

import repository.Group;

public interface GroupService {
    int groupSize(Group group);

    double averageGroupMark(Group group, StudentMarksService studentMarksService);

    int amountStudentsWithAllExcellentMarks(Group group, StudentMarksService studentMarksService);

    int amountStudentsHavingUnsuccessfulMarks(Group group, StudentMarksService studentMarksService);
}

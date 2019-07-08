package service;

import repository.Group;

public interface GroupService {
    int groupSize(Group group);

    double averageGroupMark(Group group);

    int amountStudentsWithAllExcellentMarks(Group group);

    int amountStudentsHavingUnsuccessfulMarks(Group group);
}

import java.util.ArrayList;

public class GroupSystem {
    public static Student[] check(Student[] students, Group[] groups)
    {
        // elements in isValid[] record the correspond student is valid or not
        // they are all invalid initially
        int[] isValid = new int[students.length];
        for (int i = 0; i < groups.length; i++)
        {
            if(groups[i].checkSameLab())
            {
                // find the index of the successfully grouped students
                int index1 = indexOf(students, groups[i].getStudent1());
                int index2 = indexOf(students,groups[i].getStudent2());
                // check before validate the students: if they are in invalid groups
                if (isInvalidGroup(groups, students[index1]) || isInvalidGroup(groups, students[index2]))
                {
                    isValid[index1] = 2;
                    isValid[index2] = 2;
                }
                isValid[index1]++;
                isValid[index2]++;
                // omit a situation: the partner of the overlapped student is also invalid
                // the following cannot check out students in both valid group and invalid group
                if (isValid[index1] > 1 || isValid[index2] > 1) // students[index1] or students[index2] is the overlapped students
                {
                    isValid[index1] = 2;
                    isValid[index2] = 2; // make the two students present group with the overlapped student invalid
                    // my error: omit another student partnered with the overlapped student
                    for (int k = 0;k < groups.length;k++)
                    {
                        if ((groups[k].getStudent1() == students[index1] || groups[k].getStudent1() == students[index2]) && groups[k].checkSameLab())
                        {
                            // if groups[k].oneOfItsTwoStudents is in the overlapped group, then the group[k].thOtherStudent will be the other student partnered with the overlapped students
                            //but the overlapped_shared student may have failed the checkSameLab and have a isValid of 0
                            int index3 = indexOf(students, groups[k].getStudent2());
                            if (isValid[index3] != 0)
                            {
                                isValid[index3] = 2; // make the previous partner invalid
                            }
                        }
                        if ((groups[k].getStudent2() == students[index1] || groups[k].getStudent2() == students[index2]) && groups[k].checkSameLab())
                        {
                            int index3 = indexOf(students, groups[k].getStudent1());
                            if (isValid[index3] != 0)
                            {
                                isValid[index3]++;
                            }
                        }
                    }
                }
            }
        }
        // now only the valid students have their corresponded isValid value 0

        // count how many invalid students
        int count = 0;
        for(int i = 0;i < isValid.length; i++)
        {
            if (isValid[i] != 1)
            {
                count++;
            }
        }

        if (count == 0)
        {
            return null;
        }
        else
        {
            // build an array of invalid students
            Student[] studentsWithProblem = new Student[count];
            int indexOfStudentWithProblem = 0;
            for(int i = 0;i < isValid.length; i++)
            {
                if (isValid[i] != 1)
                {
                    studentsWithProblem[indexOfStudentWithProblem] = students[i];
                    indexOfStudentWithProblem++;
                }
            }

            return studentsWithProblem;
        }
    }

    public static int indexOf(Student[] students, Student student)
    {
        for (int i = 0; i < students.length; i++)
        {
            if (students[i] == student)
            {
                return i;
            }
        }
        return -1;
    }


    public static boolean isInvalidGroup(Group[] groups, Student student)
    {
        for (int i = 0; i < groups.length; i++)
        {
            if (!groups[i].checkSameLab() && (groups[i].getStudent1() == student || groups[i].getStudent2() == student))
            {
                return true;
            }
        }
        return false;
    }

    public static Group[] group(Student[] students)
    {
        // sort students[] according to the grades of students
        //bubble sort
        for (int i = 0; i < students.length - 1; i++) // loop length - 1 times
        {
            for (int j = 0; j < students.length - 1; j++) // loop the entire array every time, taking length - 1 steps each time
            {
                if (students[j].getGrade() < students[j + 1].getGrade())
                {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }

        // from top grade to low grade, find students from the same lab
        ArrayList<Group> Groups = new ArrayList<>();
        int[] havePartner = new int[students.length]; // record if the students having partner or not
        for (int i = 0; i < students.length; i++) // check every student
        {
            for (int j = i + 1; j < students.length; j++) // check if students[j] can be a partner
            {
                if (students[i].getLab() == students[j].getLab() && havePartner[i] == 0 && havePartner[j] == 0) {
                    Group group = new Group(students[i], students[j], students[i].getLab());
                    Groups.add(group);
                    havePartner[i]++;
                    havePartner[j]++;
                    break; // check next student if this student successfully find a partner
                }
            }
            if (havePartner[i] == 0) {
                // no students can be students[i]'s partner
                Group group1 = new Group(students[i], students[i].getLab());
                Groups.add(group1);
                havePartner[i]++;
            }
        }
            //turn ArrayList groups into array groups
            Group[] groups = new Group[Groups.size()];
            for (int k = 0; k < Groups.size(); k++)
            {
                groups[k] = Groups.get(k);
            }
            return groups;



    }
}

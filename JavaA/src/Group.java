public class Group {
    private Student student1;
    private Student student2;
    private char lab;

    public Group (Student student1, Student student2, char lab)
    {
        this.student1 = student1;
        this.student2 = student2;
        this.lab = lab;
    }

    public Group (Student student1, char lab)
    {
        this.student1 = student1;
        this.student2 = null;
        this.lab = lab;
    }

    public Student getStudent1()
    {
        return student1;
    }

    public Student getStudent2()
    {
        return student2;
    }

    public char getLab() {
        return lab;
    }

    public void setStudent1(Student student1)
    {
        this.student1 = student1;
    }

    public void setStudent2(Student student2)
    {
        this.student2 = student2;
    }

    public void setLab(char lab) {
        this.lab = lab;
    }

    public boolean checkSameLab()
    {
        if (getStudent2() != null && getStudent1().getLab() == getLab() && getStudent2().getLab() == getLab())
        {
            return true;
        }
        else {
            return false;
        }
    }

    public String toString()
    {
        if(getStudent2() == null)
        {
            return String.format("%c_%s_null", getLab(), getStudent1().getStudentNumber());
        }
        else
        {
            if (getStudent1().getStudentNumber().length() > getStudent2().getStudentNumber().length())
            {
                return String.format("%c_%s_%s", getLab(),getStudent2().getStudentNumber(), getStudent1().getStudentNumber());
            }
            else if (getStudent1().getStudentNumber().length() < getStudent2().getStudentNumber().length())
            {
                return String.format("%c_%s_%s", getLab(),getStudent1().getStudentNumber(), getStudent2().getStudentNumber());
            }
            else
            {
                for (int i = 0; i < getStudent2().getStudentNumber().length(); i++)
                {
                    if (getStudent1().getStudentNumber().charAt(i) > getStudent2().getStudentNumber().charAt(i))
                    {
                        return String.format("%c_%s_%s", getLab(),getStudent2().getStudentNumber(), getStudent1().getStudentNumber());
                    }
                }
                return String.format("%c_%s_%s", getLab(),getStudent1().getStudentNumber(), getStudent2().getStudentNumber());
            }
        }
    }
}

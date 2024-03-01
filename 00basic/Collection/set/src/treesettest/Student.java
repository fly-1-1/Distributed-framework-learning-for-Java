package treesettest;

public class Student implements Comparable<Student>{
    private String name;
    private int chinese;
    private int math;
    private int english;

    public Student() {
    }

    public Student(String name, int chinese, int math, int english) {
        this.name = name;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChinese() {
        return chinese;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", chinese=" + chinese +
                ", math=" + math +
                ", english=" + english +
                '}' + "总分为" + getSum();
    }

    public int getSum(){
        return chinese + math + english;
    }

    @Override
    public int compareTo(Student o) {
        //按照总分进行排序
        //int result = this.getChinese() + this.getMath() + this.getEnglish()
        int result = o.getSum() - this.getSum();
        //次要条件
        //总分一样，就比较语文成绩
        result = result == 0 ? o.getChinese() - this.getChinese() : result;
        //语文成绩一样，就比较数学成绩
        result = result == 0 ? o.getMath() - this.getMath() : result;
        //如果数学成绩一样，就比较英文成绩
        result = result == 0 ? o.getEnglish() - this.getEnglish() : result;
        //如果成绩都一样，则按照姓名进行排序
        result = result == 0 ? o.getName().compareTo(this.getName()) : result;
        return result;
    }
}

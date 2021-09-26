public class Student01 {
    private String name;
    private  int age;

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void  ent(String c){
        System.out.println(name+age+"岁学习"+ c);
    }
}

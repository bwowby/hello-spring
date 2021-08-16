package hello.hellospring.controller;

//얘가 json key값이 들어오는 do 같은 애인가봄.. -> name이 html id랑 같지 않아도 되나본데...?
public class MemberForm {
    private String age;
    private String nameee;


    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getNameeee() {
        return nameee;
    }

    public void setName(String name) {
        this.nameee = name;
    }
}

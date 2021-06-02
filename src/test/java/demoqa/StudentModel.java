package demoqa;

public class StudentModel {
    String firstName;
    String lastName;
    String email;
    String gendermale;
    String mobile;
    String dateOfbirth;
    String hobbies;
    String state;
    String city;
    String subjects;
    String currentaddress;

    public StudentModel() {
    }

    public StudentModel(String firstName, String lastName, String email,String gendermale,String mobile,
                        String hobbies, String state, String city,String subjects, String currentaddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gendermale = gendermale;
        this.mobile = mobile;
        this.hobbies = hobbies;
        this.state = state;
        this.city = city;
        this.subjects = subjects;
        this.currentaddress = currentaddress;

    }
}

public class Sub_program {

    String name = "kayal";     // Instance variable
    static int rollno = 11;    // Static variable

    void sample() {
        int mark = 99;         // Local variable
        System.out.println(mark);
    }

    public static void main(String[] args) {

        Sub_program obj = new Sub_program();

        System.out.println(obj.name);
        System.out.println(rollno);

        obj.sample();
    }
}

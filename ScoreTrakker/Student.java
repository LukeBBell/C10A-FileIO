public class Student {
    private String name;
    private int score;

    public Student(String name, int score){
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString(){
        //System.out.println(name + " " + score);
        return name + " " + score;

    }



    
}
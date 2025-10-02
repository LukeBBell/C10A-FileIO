public class Student {
    //initializing the name and score
    private String name;
    private int score;
// constructor for the name and score
    public Student(String name, int score){
        this.name = name;
        this.score = score;
    }
//to string to print out  the name and score
    @Override
    public String toString(){
        //System.out.println(name + " " + score);
        return name + " " + score;

    }



    
}
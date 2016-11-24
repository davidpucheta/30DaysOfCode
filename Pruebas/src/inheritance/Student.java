package inheritance;

class Student extends Person{
	private int[] testScores;
    private String firstName;
    private String lastName;
    private int id;
    
    public Student(String firstName, String lastName, int id, int[] scores){
        super(firstName, lastName, id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.testScores = scores;
    }
    
    public char calculate() {
        int sum = 0;
        int avg = 0;
        char grade = 'X';
        
        for (int i=0; i<testScores.length;i++){
            sum += testScores[i];
        }
        
        avg = sum / testScores.length;
        
        if (avg >= 90 && avg <= 100){
            grade = 'O';
        }
        if (avg >= 80 && avg < 90){
            grade = 'E';
        }
        if (avg >= 70 && avg < 80){
            grade = 'A';
        }
        if (avg >= 55 && avg < 70){
            grade = 'P';
        }
        if (avg >= 40 && avg < 55){
            grade = 'D';
        }
        if (avg < 40){
            grade = 'T';
        }
        
        return grade;
        
    }
   
}
package animal;

public class Dog extends Animal {
    public Dog () {
        super(15);
        System.out.println("A dog has been created!");
    }
    
    public void ruff() {
        System.out.println("the dog says ruff!");
    }
    
    public void run() {
        System.out.println("the dog is running!");
    }
    
    public void eat(){
        System.out.println("A dog is eating");
    }
    
    public void sleep(){
       System.out.println("A dog is sleeping");
    }
}

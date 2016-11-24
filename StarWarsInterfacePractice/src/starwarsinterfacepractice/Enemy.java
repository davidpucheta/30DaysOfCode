package starwarsinterfacepractice;

public class Enemy implements Character {

    public String weapon = "lightsaber";
    
    @Override
    public void attack() {
        System.out.println("The enemy attacks you!");
    }

    @Override
    public void heal() {
        System.out.println("The enemy heals himself");
    }
    
    public void weaponDraw(){
       System.out.println("Draw out weapon"); 
    }
    
    
}

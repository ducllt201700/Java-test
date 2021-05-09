package Java;

public abstract class Cattle{
    public String codeName;
    public int age;
    public float weight;

}
class Cow extends Cattle{

    public Cow(String codeName, int age, float weight){
        this.weight = weight;
        this.codeName = codeName;
        this.age = age;
    }


    public void printInfo(){
        System.out.println("Cow's code name is:" + this.codeName);
        System.out.println("Cow's age is:" + this.age);
        System.out.println("Cow's weight is:" + this.weight);
    }

    public float dailyMilk () {
        if ((this.age >= 2) && (this.age <= 5)) {
            return Math.max(0, (this.weight - this.age) / 10);
        }
        else return 0;
    }

}

class Goat extends Cattle {

    public Goat(String codeName, int age, float weight){
        this.weight = weight;
        this.codeName = codeName;
        this.age = age;
    }

    public void printInfo(){
        System.out.println(this.codeName);
        System.out.println(this.age);
        System.out.println(this.weight);
    }

    //daily amount of milk produced
    public float dailyMilk (){
        if ((this.age >= 1) && (this.age <= 2)) {
            return (this.weight / 10);
        }
        else if ((this.age > 2) && (this.age <= 4)){
            return (this.weight /15);
        }
        else return 0;
    }
}
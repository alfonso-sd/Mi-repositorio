import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Damageable> objs = new ArrayList<>();

        objs.add(new Wall(400));
        objs.add(new Character(300));
        objs.add(new Knight(400));

        for(Damageable obj: objs){
            obj.applyDamage(100);
        }

        for(Damageable obj: objs){
            if(obj instanceof Wall){
                Wall wall = (Wall) obj;
                System.out.println("La pared tiene: "+wall.getDurability());
            }else if(obj instanceof Character){
                Character character = (Character) obj;
                System.out.println("El personaje tiene "+character.getHealth());            
            }


        }   




        }
}

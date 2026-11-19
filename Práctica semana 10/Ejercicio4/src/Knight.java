public class Knight extends Character{

    public Knight(int health){
        super(health);
    }

    @Override
    public void applyDamage (int points){
        int tmPoints = (int) (points*0.9);
        /*setHealth(getHealth()-tmPoints);
        if(getHealth()<=0){
            setHealth(0);
            System.out.println("Ha muerto el personaje ha muerto.");
        }    */
       //Mejor:
       super.applyDamage(tmPoints);
    }

}

public class Character implements Damageable{
    private int health;

    public Character(int health){
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health){
        this.health=health;
    }

    @Override
    public void applyDamage(int points){
        health = health - points;
        if(health<=0){
            health=0;
            System.out.println("El personaje ha muerto");
        }
    }

}

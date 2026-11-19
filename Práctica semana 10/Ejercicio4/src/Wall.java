public class Wall implements Damageable{
    private int durability;

    public Wall (int durability){
        this.durability = durability;
    }

    public int getDurability() {
        return durability;
    }

    @Override
    public void applyDamage(int points){
        durability = durability - points;
        if(durability<=0){
            durability = 0;
            System.out.println("Se ha roto la pared");
        }
    }

}

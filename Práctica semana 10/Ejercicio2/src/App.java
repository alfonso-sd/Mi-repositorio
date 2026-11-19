import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<DatabaseService> conexiones = new ArrayList<>();

        System.out.println("1");
        conexiones.add(new DatabaseService());
        System.out.println("2");
        conexiones.add(new MySQLDatabaseService());
        System.out.println("3");
        conexiones.add(new SQLiteDatabaseService());
        System.out.println("4");
        conexiones.add(new FakeDatabaseService());

        for(DatabaseService conexion: conexiones){
            System.out.println("----------");
            conexion.connect();
        }







    }
}

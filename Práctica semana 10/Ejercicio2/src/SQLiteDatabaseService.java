public class SQLiteDatabaseService extends DatabaseService{

    public SQLiteDatabaseService(){
        super();
        System.out.println("Constructor: SQLiteDatabaseService");

    }

    @Override
    public void connect(){
        super.connect();//usamos el método de la clase padre
        System.out.println("Base de datos: SQLite");
    }

}

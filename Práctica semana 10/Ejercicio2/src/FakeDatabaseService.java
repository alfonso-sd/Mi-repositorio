public class FakeDatabaseService extends DatabaseService{

    @Override
    public void connect(){
        System.out.println("Base de datos: FAKE");
    }

}

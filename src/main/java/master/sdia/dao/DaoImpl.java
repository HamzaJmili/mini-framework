package master.sdia.dao;




public class DaoImpl implements IDao {

    @Override
    public double getData() {
        System.out.println("DaoImpl appelé");
        return 40;
    }
}
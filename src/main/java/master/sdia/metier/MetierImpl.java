package master.sdia.metier;

import master.sdia.dao.IDao;

public class MetierImpl implements IMetier {
    private IDao dao;

    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    @Override
    public void calcul() {
        System.out.println("MetierImpl appelé");
        double data = dao.getData();
        System.out.println(data);
    }
}

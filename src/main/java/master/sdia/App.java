package master.sdia;


import master.sdia.container.BeanContainer;
import master.sdia.dao.IDao;
import master.sdia.metier.IMetier;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        // Avec XML
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IMetier metier = (IMetier) context.getBean("metier");
        metier.calcul();
        context.close();
    }
}

package hibernate_driud;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class DruidTest {

	public static void main(String[] args) {
		try {

			SessionFactory sf = new Configuration().configure()
					.buildSessionFactory();

			Session session = sf.openSession();

			List catlist = null;

			catlist = session.createSQLQuery("select *from t_user").list();

			Transaction tx = session.beginTransaction();

			if (catlist != null) {

				Iterator it = catlist.iterator();

				while (it.hasNext()) {

//					User user = (User) it.next();
					Object[] ob=(Object[])it.next();
					System.out.println(ob[0]+"--name="+ob[1]+"pass="+ob[2]+"\n");

				}

			}

			tx.commit();

			session.clear();

		} catch (HibernateException e) {

			// TODO: handle exception

			e.printStackTrace();

		}

	}

}

package org.hibernate.tutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tutorial.dto.AddressDTO;
import org.hibernate.tutorial.dto.UserDetailsDTO;

public class ServiceMain {

	public ServiceMain() {
	}

	public static void main(String args[]) {
		UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
		// userDetailsDTO.setUserId(4);
		userDetailsDTO.setUserName("Mani");
		AddressDTO addDTO1 = new AddressDTO();
		addDTO1.setCity("Jaipur");
		addDTO1.setHouseNo("8/30");

		AddressDTO addDTO2 = new AddressDTO();
		addDTO2.setCity("Ajmer");
		addDTO2.setHouseNo("8/34");

		userDetailsDTO.getListOfAddresses().add(addDTO1);
		userDetailsDTO.getListOfAddresses().add(addDTO2);

		// addDTO.setColonyName("Bank Colony");
		// addDTO.setState("Rajasthan");
		// userDetailsDTO.setAddressDTO(addDTO);

		// SessionFactory and other relevant works.
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(userDetailsDTO);
		// No Value will be saved in the database until
		// we don't do commit, Spring transaction @Transaction do commit in the
		// end of the method and it also closes the session.
		session.getTransaction().commit();
		session.close();

/*		session = sessionFactory.openSession();
		session.beginTransaction();
		UserDetailsDTO dto = session.get(UserDetailsDTO.class, 1L);
		session.close();
		System.out.println(dto.getListOfAddresses());
		sessionFactory.close();*/
	}
}

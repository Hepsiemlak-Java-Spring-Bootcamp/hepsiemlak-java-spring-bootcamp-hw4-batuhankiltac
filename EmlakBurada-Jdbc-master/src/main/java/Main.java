import com.emlakburada.entity.Advert;
import com.emlakburada.entity.User;
import com.emlakburada.repository.AdvertRepoImpl;
import com.emlakburada.repository.UserRepoImpl;

import java.math.BigDecimal;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		UserRepoImpl userRepoImpl = new UserRepoImpl();

		// insert user
		userRepoImpl.save(prepareUser());
		userRepoImpl.save(new User("INDIVIDUAL", "Mehmet", "ahmet@gmail.com"));

		// select all users
		userRepoImpl.findAll();

		// select user by id
		userRepoImpl.findOne(1);

		// update user by id
		userRepoImpl.update(6);

		// delete user by name
		userRepoImpl.delete(1);

		// --------------------------------------------------

		AdvertRepoImpl advertRepoImpl = new AdvertRepoImpl();

		// insert advert
		advertRepoImpl.save(prepareAdvert());
		advertRepoImpl.save(new Advert(2, 435345, "ACIL", "DENEME"));

		// select all adverts
		advertRepoImpl.findAll();

		// select advert by id
		advertRepoImpl.findOne(2);

		// update user by id
		advertRepoImpl.update(2);

		// delete user by name
		advertRepoImpl.delete(1);
	}

	private static User prepareUser() {
		User user = new User();
		user.setId(6);
		user.setName("Batu");
		user.setEmail("emlakburada@patika.dev");
		user.setBio("");
		return user;
	}

	private static Advert prepareAdvert() {
		Advert advert = new Advert();
		advert.setId(1);
		advert.setAdvertNo(3424324);
		advert.setTitle("Ornek Ilan");
		advert.setDescription("Deneme 1");
		advert.setPrice(new BigDecimal(785000));
		return advert;
	}
}
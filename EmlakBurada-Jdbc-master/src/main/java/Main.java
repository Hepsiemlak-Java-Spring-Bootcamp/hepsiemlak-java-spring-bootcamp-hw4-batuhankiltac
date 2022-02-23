import com.emlakburada.entity.Advert;
import com.emlakburada.entity.User;
import com.emlakburada.service.AdvertService;
import com.emlakburada.service.UserService;

import java.math.BigDecimal;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		UserService userService = new UserService();

		// insert user
		userService.save(prepareUser());
		userService.save(new User("INDIVIDUAL", "Mehmet", "ahmet@gmail.com"));

		// select all users
		userService.findAll();

		// select user by id
		userService.findOne(1);

		// update user by id
		userService.update(6);

		// delete user by name
		userService.delete(1);

		// --------------------------------------------------

		AdvertService advertService = new AdvertService();

		// insert advert
		advertService.save(prepareAdvert());
		advertService.save(new Advert(2, 435345, "ACIL", "DENEME"));

		// select all adverts
		advertService.findAll();

		// select advert by id
		advertService.findOne(2);

		// update user by id
		advertService.update(2);

		// delete user by name
		advertService.delete(1);
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
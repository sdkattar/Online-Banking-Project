package com.app.controller;

import java.util.List;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.HttpStatus.*;
import com.app.dao.IUsersDao;
import com.app.pojos.Account;
import com.app.pojos.AccountTransfer;
import com.app.pojos.News;
import com.app.pojos.Role;
//import com.app.pojos.User;
import com.app.pojos.UserAccount;
import com.app.pojos.Users;
import com.app.service.UserService;

@CrossOrigin(allowedHeaders = "*")
@RestController
@RequestMapping("/user")

public class SignInController {
	int otp;
	@Autowired
	IUsersDao iuserDao;

	@Autowired
	JavaMailSender mailSender;

	Users user;

	@Autowired
	private UserService serv;

	public SignInController() {
		System.out.println("in sigin controller");

	}

	@GetMapping
	public ResponseEntity<?> getAllUsers() {
		System.out.println("in get all users test");
		List<Users> list = serv.getAllUsers();
		System.out.println(list);
		for (Users user : list)
			System.out.println(user);

		System.out.println("test data");
		if (list.isEmpty())
			return new ResponseEntity<String>("No users", HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Users>>(list, HttpStatus.OK);
	}
	
	
	@GetMapping("/news")
	public ResponseEntity<?> getAllNews() {
		System.out.println("in get all News controller");
		List<News> list = serv.getAllNews();
		System.out.println(list);
		for (News user : list)
			System.out.println(user);

		System.out.println("test data");
		if (list.isEmpty())
			return new ResponseEntity<String>("No users", HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<News>>(list, HttpStatus.OK);
	}
	
	
	
	
	

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody UserAccount us) {
//		Users user= new Users(userrcvd.getName(), userrcvd.getMobileno(), userrcvd.getEmail(), userrcvd.getPassword(), userrcvd.getConfirmpassword(), userrcvd.getAddress());
//		Users user= new Users(userrcvd.getName(),userrcvd.getMobileno(),
//				userrcvd.getEmail(),userrcvd.getRole(),userrcvd.getPassword(),
//			userrcvd.getPan(),userrcvd.getAddress());
		Users user = new Users(us.getName(), us.getMobileno(), us.getEmail(), us.getRole(), us.getPassword(),
				us.getConfirmpassword(), us.getPan(), us.getAddress());

		Account acc = new Account(us.getAcc_type(), us.getOpening_date(), us.getBalance());
		System.out.println("in register");

		System.out.println(acc);
		Integer id = serv.registerUser(user, acc);
		if (id != null)
			return new ResponseEntity<Integer>(id, HttpStatus.OK);
		return new ResponseEntity<String>("registration failed plz try again", HttpStatus.FAILED_DEPENDENCY);
	}

	
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody Users users) 
	{
		Users userfound = serv.loginUser(users);
		if (userfound != null)
			return new ResponseEntity<Users>(userfound, HttpStatus.OK);
		return new ResponseEntity<String>("login failed try again", HttpStatus.FAILED_DEPENDENCY);
	}
	
	

	
	@PostMapping("/forgot/{em:.+}")
	public ResponseEntity<?> processForgotPassword(@PathVariable String em, HttpSession hs) {
		System.out.println("email " + em);
		user = serv.findByEmail(em);
		System.out.println(user);
		try {
			user = serv.findByEmail(em);
			System.out.println(user);
			if (user != null) {

				otp = serv.generateOtp();
				System.out.println(otp);
				String msg = "Your one time password(OTP) is = " + otp;
				SimpleMailMessage mailMessage = new SimpleMailMessage();
				mailMessage.setTo(user.getEmail());
				mailMessage.setSubject("One Time Password");
				mailMessage.setText(msg);
				try {
					mailSender.send(mailMessage);

					return new ResponseEntity<String>("success", HttpStatus.OK);
				} catch (MailException e) {
					System.out.println("inside mail exception");
					e.printStackTrace();
				}
			}
			
		} catch (NoResultException e) {
			System.out.println("in other exception");
			e.printStackTrace();
		}
		return new ResponseEntity<String>("error", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@PostMapping("/setpass")
	public ResponseEntity<?> setpassword(@RequestBody Users u, HttpSession hs) {
		System.out.println("reached till /setpass");
		System.out.println(u.getPassword());
		System.out.println(u.getOtp());
		// System.out.println("mail "+user.getEmail()+" otp "+otp);
		if (otp == u.getOtp()) {
			System.out.println("in set pass");
			iuserDao.setPass(u.getPassword(), user.getEmail());
			return new ResponseEntity<Integer>(1, OK);
		}

		else {
			return new ResponseEntity<Integer>(0, OK);
		}
	}

	@GetMapping("/account/{uid}")
	public ResponseEntity<?> checkBalance(@PathVariable int uid) {
		System.out.println("in get account dtls " + uid);
		Account accDetails = serv.checkBalance(uid);
		if (accDetails == null)
			return new ResponseEntity<String>("Account not found...", NOT_FOUND);
		return new ResponseEntity<Account>(accDetails, OK);
	}

	@GetMapping("/specific") // if we use ? use @RequestParam & if we use / then use @pathvariable
	public ResponseEntity<?> getSpecificUser(@PathVariable String uid) {

		return new ResponseEntity<Users>(serv.getSpecificUser(Integer.parseInt(uid)), HttpStatus.OK);
	}

//
//@GetMapping("/details/{uid}") // URI template variable
//// eg : http://host:port/test_web/employees/123
//public ResponseEntity<?> getUserDtls(@PathVariable int uid) {
//	System.out.println("in get users dtls " + uid);
//	Users empDetails = serv.getUserDetails(uid);
//	if (empDetails == null)
//		return new ResponseEntity<String>("User not found...", NOT_FOUND);
//	return new ResponseEntity<Users>(empDetails, OK);
//
//}

//@PutMapping("/details")
//public ResponseEntity<String> updateCustomerDetails(@PathVariable int uid, @RequestBody Users u) {
//	System.out.println("in update " + uid+ " " + u);
//	// invoke service's method
//	try {
//
//		return new ResponseEntity<String>(serv.updateCustomerDetails(uid, u), OK);
//	} catch (RuntimeException e1) {
//		e1.printStackTrace();
//		return new ResponseEntity<String>(e1.getMessage(), INTERNAL_SERVER_ERROR);
//	}
//}

//@PostMapping("/profile")
//public Users profile(@RequestBody Users user)
//{
//	System.out.println("user");
//	return iuserDao.profile(user);
//	
//}

	@PutMapping("/update")
	public ResponseEntity<?> updateprofile(@RequestParam Integer id, @RequestBody Users user) {
		System.out.println("in update profile controller");
		serv.updateuserprofile(id, user);
		return null;
	}

	@GetMapping("/getdatabyid")
	public ResponseEntity<?> getDataById(@RequestParam Integer id) {
		System.out.println("in getdatabyid controller");

		return new ResponseEntity<Users>(serv.getData(id), HttpStatus.OK);
	}

	
	@PostMapping("/signup")
	public Integer register(@RequestBody Users user) {
		System.out.println(user);
		return iuserDao.signupUser(user);
	}

	@PutMapping("/createaccount")
	public Integer createAccount(@RequestBody Account acc, @RequestParam int id) {
		System.out.println(acc);
		iuserDao.addAcc(id, acc);
//	return iuserDao.createAccount(acc);
		return null;
	}

	@GetMapping("/allaccounts")
	public ResponseEntity<?> getUserAccountDetailsList(@RequestParam int uid) {
		System.out.println("in getuseraaccountdetailslist test");
		Users user = serv.getUserAccountDetailsList(uid);
//	System.out.println(list);
//	for(Users user : list)
//		System.out.println(user);
//	
//	System.out.println("test data");
//	if (list.isEmpty())
//		return new ResponseEntity<String>("No Account list found", HttpStatus.NO_CONTENT);
		return new ResponseEntity<Users>(user, HttpStatus.OK);
	}

	@GetMapping("/managers")
	public ResponseEntity<?> findByRole(Role r) {
		System.out.println("in get all managers controller");
		List<Users> list = serv.findByRole(r);
		System.out.println(list);
		for (Users user : list)
			System.out.println(user);

		System.out.println("test data");
		if (list.isEmpty())
			return new ResponseEntity<String>("No managers found", HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Users>>(list, HttpStatus.OK);
	}

	@DeleteMapping("/uid")
	public ResponseEntity<String> delUserDetails(@RequestParam int uid) {
		System.out.println("in delete user " + uid);
		try {
			return new ResponseEntity<String>(serv.deleteUsers(uid), OK);
		} catch (RuntimeException e1) {
			e1.printStackTrace();
			return new ResponseEntity<String>(e1.getMessage(), NOT_FOUND);
		}
	}

	@PutMapping("/editbyadmin")
	public ResponseEntity<?> editByAdmin(@RequestParam Integer id, @RequestBody Users user) {
		System.out.println("in edit by admin controller");
		serv.editByAdmin(id, user);
		return null;
	}
	
	@PostMapping("/accountTransfer")
	public ResponseEntity<?> accountTransfer(@RequestBody AccountTransfer acc)
	{
		System.out.println(acc);
		serv.tranfertoAccount(acc);
		return null;
	}

	
	@GetMapping("/showManagers")
	public ResponseEntity<?> geManager()
	{
		System.out.println("in get all managers test");
		List<Users> list = serv.getManager();
		System.out.println(list);
		for (Users user : list)
			System.out.println(user);

		if (list.isEmpty())
			return new ResponseEntity<String>("No Managers", HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Users>>(list, HttpStatus.OK);
	}
}

package domain;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {

	private String userId;
	private String password;
	private String salt;
	private String firstName;
	private String lastName;
	private String geslacht;
	private int leeftijd;
	private Role role;
	private String status;
	private ArrayList<String> friendlist;

	public Person(String userId, String password, String firstName,
			String lastName,Role role, String geslacht, int leeftijd) {
		setUserId(userId);
		setHashedPassword(password);
		setFirstName(firstName);
		setLastName(lastName);
		setRole(role);
		status = "Online";
		friendlist = new ArrayList<>();
		setLeeftijd(leeftijd);
		setGelslacht(geslacht);
	}

	public Person(String userId, String password, String salt,
			String firstName, String lastName,Role role, String geslacht, int leeftijd) {
		setUserId(userId);
		setPassword(password);
		setSalt(salt);
		setFirstName(firstName);
		setLastName(lastName);
		setRole(role);
		status = "Online";
		friendlist = new ArrayList<>();
		setLeeftijd(leeftijd);
		setGelslacht(geslacht);
	}

	public Person() {
	}

	public void addFriend(String s){
		if(!friendlist.contains(s)){
			friendlist.add(s);
		}

	}

	public String getGelslacht() {
		return geslacht;
	}

	public void setGelslacht(String g) {
		if(g == null || g.trim().isEmpty() ){
			throw new IllegalArgumentException
							("geslacht is leeg");
		}
		this.geslacht = g;
	}

	public int getLeeftijd() {
		return leeftijd;
	}

	public void setLeeftijd(int leeftijd) {
		if(leeftijd < 13 || leeftijd > 103){
			throw new IllegalArgumentException
							("leeftijd tussen 13 en 103");
		}
		this.leeftijd = leeftijd;
	}

	public ArrayList<String> getFriendList(){
		return this.friendlist;
	}
	public String getStatus(){
		return this.status;
	}
	public void setStatus(String s){
		this.status = s;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role=role;
	}
	

	public void setUserId(String userId) {
		if (userId.isEmpty()) {
			throw new IllegalArgumentException("No id given");
		}
		String USERID_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern p = Pattern.compile(USERID_PATTERN);
		Matcher m = p.matcher(userId);
		if (!m.matches()) {
			throw new IllegalArgumentException("Email not valid");
		}
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public boolean isCorrectPassword(String password) {
		if (password.isEmpty()) {
			throw new IllegalArgumentException("No password given");
		}
		return getPassword().equals(hashPassword(password, getSalt()));
	}

	public void setPassword(String password) {
		if (password.isEmpty()) {
			throw new IllegalArgumentException("No password given");
		}
		this.password = password;
	}

	public void setHashedPassword(String password) {
		if (password.isEmpty()) {
			throw new IllegalArgumentException("No password given");
		}
		this.password = hashPassword(password);
	}

	private String hashPassword(String password) {
		SecureRandom random = new SecureRandom();
		byte[] seed = random.generateSeed(20);

		String salt = new BigInteger(1, seed).toString(16);
		this.setSalt(salt);

		return hashPassword(password, salt);
	}

	private String hashPassword(String password, String seed) {
		String hashedPassword = null;
		try {
			MessageDigest crypt = MessageDigest.getInstance("SHA-1");
			crypt.reset();
			crypt.update(salt.getBytes("UTF-8"));
			crypt.update(password.getBytes("UTF-8"));
			hashedPassword = new BigInteger(1, crypt.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			throw new DomainException(e.getMessage(), e);
		} catch (UnsupportedEncodingException e) {
			throw new DomainException(e.getMessage(), e);
		}
		return hashedPassword;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getSalt() {
		return salt;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName.isEmpty()) {
			throw new IllegalArgumentException("No firstname given");
		}
		this.firstName = firstName;// firstName;

	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (lastName.isEmpty()) {
			throw new IllegalArgumentException("No last name given");
		}
		this.lastName = lastName;
	}

}

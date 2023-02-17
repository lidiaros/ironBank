package com.example.ironBank;
import com.example.ironBank.models.account.CheckingAccount;
import com.example.ironBank.models.account.CreditCard;
import com.example.ironBank.models.account.SavingsAccount;
import com.example.ironBank.models.account.StudentChecking;
import com.example.ironBank.models.user.AccountHolders;
import com.example.ironBank.models.user.Address;
import com.example.ironBank.models.user.Admins;
import com.example.ironBank.models.user.ThirdParty;
import com.example.ironBank.repositories.account.*;
import com.example.ironBank.repositories.user.AccountHoldersRepository;
import com.example.ironBank.repositories.user.AdminsRepository;
import com.example.ironBank.repositories.user.ThirdPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class IronBankApplication implements CommandLineRunner {

	@Autowired
	ThirdPartyRepository thirdPartyRepository;

	@Autowired
	AccountHoldersRepository accountHoldersRepository;

	@Autowired
	CheckingAccountRepository checkingAccountRepository;

	@Autowired
	StudentCheckingRepository studentCheckingRepository;

	@Autowired
	SavingsAccountRepository savingsAccountRepository;

	@Autowired
	CreditCardRepository creditCardRepository;

	@Autowired
	AdminsRepository adminsRepository;


	public static void main(String[] args) {
		SpringApplication.run(IronBankApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		AccountHolders accountHolders1 = accountHoldersRepository.save(new AccountHolders("Alejandro", LocalDate.of(1956, 12, 8), new Address(), "ale@es.com"));
		AccountHolders accountHolders2 = accountHoldersRepository.save(new AccountHolders("Sebi", LocalDate.of(1960, 9, 03), null, "sebi@es.com"));
		AccountHolders accountHolders3 = accountHoldersRepository.save(new AccountHolders("Alex", LocalDate.of(1997, 9, 2), null, "alex@es.com"));
		AccountHolders accountHolders4 = accountHoldersRepository.save(new AccountHolders("Carla", LocalDate.of(1972, 2, 1), null, "carla@es.com"));
		AccountHolders accountHolders5 = accountHoldersRepository.save(new AccountHolders("Ana", LocalDate.of(1962, 6, 18), null, "ana@es.com"));

		CheckingAccount account1 = checkingAccountRepository.save(new CheckingAccount(new BigDecimal(4420.10), 1234, accountHolders1, null, new BigDecimal(1.10), new BigDecimal(10.09), new BigDecimal(12.0)));
		CheckingAccount account2 = checkingAccountRepository.save(new CheckingAccount(new BigDecimal(3909.10), 4321, accountHolders2, null, new BigDecimal(1.11), new BigDecimal(10.0), new BigDecimal(12.0)));
		StudentChecking account3 = studentCheckingRepository.save(new StudentChecking(new BigDecimal(120.00), 1111, accountHolders3, null, new BigDecimal(0)));
		SavingsAccount account4 = savingsAccountRepository.save(new SavingsAccount(new BigDecimal(9293.19), 9328, accountHolders4, null, new BigDecimal(0.8), new BigDecimal(4.0), new BigDecimal(12.0)));
		CreditCard account5 = creditCardRepository.save(new CreditCard(new BigDecimal(4349.00), 8371, accountHolders5, null, new BigDecimal(0.6), new BigDecimal(10000), new BigDecimal(6.1)));

		Admins admin1 = adminsRepository.save(new Admins());

		ThirdParty thirdParty1 = thirdPartyRepository.save(new ThirdParty());
	}
}
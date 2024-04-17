package com.mruruc;

import com.mruruc.client.model.Address;
import com.mruruc.client.model.Client;
import com.mruruc.client.model.Gender;
import com.mruruc.client.service.AddressService;
import com.mruruc.client.service.ClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
// @PropertySource("classpath:application-postgres.properties")
public class LoveBankRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoveBankRestApplication.class, args);
	}

	//@Bean
	public CommandLineRunner commandLineRunner(ClientService service, AddressService addressService){
		return args -> {
			var client=new Client("John","Doe", LocalDate.of(1999,4,7),
					  Gender.MALE,"+48456123789","mr_john@gmail.com");
			service.newClient(client);
			addressService.addAddress(new Address("Poland","Warsaw","Lukowska12","04-456",12,client));
			addressService.addAddress(new Address("Poland","Krakow","Center","45-234",54,client));
		};
	}
}

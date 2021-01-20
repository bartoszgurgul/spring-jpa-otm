package pl.javastart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.javastart.dao.ClientDao;
import pl.javastart.model.Client;
import pl.javastart.model.Order;

import java.util.Arrays;

@SpringBootApplication
public class SpringJpaOtmApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringJpaOtmApplication.class, args);
        ClientDao clientDao = context.getBean(ClientDao.class);

        Client client =
                new Client("Johny",
                        "Cash",
                        "Sezamowa ulica",
                        Arrays.asList(
                                    new Order("Wodka","Zimna"),
                                new Order("Chleb","Swiezy"),
                                new Order("tyton","duzo")));
        clientDao.create(client);

        context.close();
    }

}

package br.uff.dw;

import br.uff.dw.Constant;
import br.uff.dw.model.Event;
import br.uff.dw.model.Purchase;
import br.uff.dw.model.User;
import br.uff.dw.persistence.EventDAO;
import br.uff.dw.persistence.PurchaseDAO;
import br.uff.dw.persistence.UserDAO;
import java.util.Calendar;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TicketsApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext config = SpringApplication.run(TicketsApplication.class, args);
//**********************populando o banco em memória *****************************
        User fabio = new User("fabio", "123", "f@gmail.com");
        User manuel = new User("manuel", "234", "m@gmail.com");
        UserDAO userDAO = config.getBean("userDAO", UserDAO.class);
        userDAO.save(fabio);
        userDAO.save(manuel);
        EventDAO eventDAO = config.getBean("eventDAO", EventDAO.class);
        Event e11 = new Event("procurando dolly", "dolly sumiu", "fabio.jpg", Constant.MOVIE, 12.0, "Rio de Janeiro", 30);
        eventDAO.save(e11);

        Event e12 = new Event("quarteto fantastico", "4 herois", "fabio.jpg", Constant.MOVIE, 8.0, "Rio de Janeiro", 40);
        eventDAO.save(e12);

        Event e13 = new Event("efeito borboleta 10", "viagem no tempo", "fabio.jpg", Constant.MOVIE, 10.0, "Rio de Janeiro", 20);
        eventDAO.save(e13);

        Event e2 = new Event("fantastico mundo de dolly", "menina em um universo paralelo", "fabio.jpg", Constant.THEATER, 12.0, "Rio de Janeiro", 20);
        eventDAO.save(e2);

        Event e3 = new Event("system of down", "venha ver o show do system", "fabio.jpg", Constant.SHOW, 42.0, "Rio de Janeiro", 20);
        eventDAO.save(e3);
        
        Event e14 = new Event("procurando dolly", "dolly sumiu", "fabio.jpg", Constant.MOVIE, 12.0, "Niteroi", 30);
        eventDAO.save(e14);

        Calendar c15 = Calendar.getInstance();
        c15.set(2016, 6, 25);
        Event e15 = new Event("quarteto fantastico", "4 herois", "fabio.jpg", Constant.MOVIE, 8.0, "Rio de Janeiro", 40);
        eventDAO.save(e15);

//        Calendar c4 = Calendar.getInstance();
//        c4.set(2016, 5, 14);
//        Event e4 = new Event("copa do mundo", "melhores times", "2.jpeg", Constant.SPORT, 6.0, "Rio de Janeiro", 20, c4);
//        eventDAO.save(e4);

        PurchaseDAO purchaseDAO = config.getBean("purchaseDAO", PurchaseDAO.class);
        Purchase purchase = new Purchase(1, manuel, e11);
        purchaseDAO.save(purchase);
        Purchase purchase2 = new Purchase(2, manuel, e12);
        purchaseDAO.save(purchase2);
        Purchase purchase3 = new Purchase(3, manuel, e3);
        purchaseDAO.save(purchase3);
        Purchase purchase4 = new Purchase(1, fabio, e13);
        purchaseDAO.save(purchase4);
//        Purchase purchase5 = new Purchase(2, fabio, e4);
//        purchaseDAO.save(purchase5);
        Purchase purchase6 = new Purchase(3, fabio, e3);
        purchaseDAO.save(purchase6);
//    //*****************************************************************************
//        
//    //******** Testes da seleção de eventos que serão exibidos no site*********************
//        //teste da barra de busca por descrição do evento
//        Iterable<Event> eventos;
//        eventos = eventDAO.findByDescriptionContainingAndLocalAndType("dolly", "Rio de Janeiro", Constant.MOVIE);
//        for (Event evento : eventos) {
//            System.out.println(evento.getTitle());
//        }
//        // test exibir eventos ordenados por quantidade de ingressos
//        eventos = eventDAO.findByLocalAndTypeOrderByAmountAsc("Rio de Janeiro", Constant.MOVIE);
//        for (Event evento : eventos) {
//            System.out.println(evento.getTitle() + " amount: " + evento.getAmount());
//        }
//        //teste exibir eventos ordenados por preço
//        eventos = eventDAO.findByLocalAndTypeOrderByPriceAsc("Rio de Janeiro", Constant.MOVIE);
//        for (Event evento : eventos) {
//            System.out.println(evento.getTitle() + " price: " + evento.getPrice());
//        }
//        //teste exibir eventos ordenados por data 
//        eventos = eventDAO.findByLocalAndTypeOrderByDateAsc("Rio de Janeiro", Constant.MOVIE);
//        for (Event evento : eventos) {
//            System.out.println(evento.getTitle() + " data: " + evento.getDate().getTime());
//        }
//
//        //**********Teste de seleção de compras *******************************
//        List<Purchase> compras;
//        compras = purchaseDAO.findByUser(manuel);
//        for (Purchase compra : compras) {
//            System.out.println(compra.getUser().getNome() +" comprou ingresso para: "+ compra.getEvent().getTitle());
//        }
        
    }
}

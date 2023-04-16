package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class AviaSoulsTest {

    @Test
    public void testByPrice() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("Moscow", "London", 100, 7, 12);
        Ticket ticket2 = new Ticket("Moscow", "London", 900, 10, 13);
        Ticket ticket3 = new Ticket("Milan", "Dubai", 300, 13, 16);
        Ticket ticket4 = new Ticket("Roma", "Tokio", 400, 11, 14);
        Ticket ticket5 = new Ticket("Tokio", "London", 500, 15, 20);
        Ticket ticket6 = new Ticket("Moscow", "London", 600, 20, 23);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] expected = {ticket1, ticket6, ticket2};
        Ticket[] actual = manager.search("Moscow", "London");

        Assertions.assertArrayEquals(expected,actual);


    }

    @Test
    public void testFindOne() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("Moscow", "London", 600, 7, 12);
        Ticket ticket2 = new Ticket("Moscow", "Milan", 200, 10, 13);
        Ticket ticket3 = new Ticket("Milan", "Dubai", 300, 13, 16);
        Ticket ticket4 = new Ticket("Roma", "Tokio", 400, 11, 14);
        Ticket ticket5 = new Ticket("Tokio", "London", 500, 15, 20);
        Ticket ticket6 = new Ticket("Moscow", "London", 100, 20, 23);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] expected = {ticket3};
        Ticket[] actual = manager.search("Milan", "Dubai");

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void testFindNull() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("Moscow", "London", 600, 7, 12);
        Ticket ticket2 = new Ticket("Moscow", "Milan", 200, 10, 13);
        Ticket ticket3 = new Ticket("Milan", "Dubai", 300, 13, 16);
        Ticket ticket4 = new Ticket("Roma", "Tokio", 400, 11, 14);
        Ticket ticket5 = new Ticket("Tokio", "London", 500, 15, 20);
        Ticket ticket6 = new Ticket("Moscow", "London", 100, 20, 23);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] expected = { };
        Ticket[] actual = manager.search("Tokio", "Dubai");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ticketComparator() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("Moscow", "London", 600, 7, 12); //5
        Ticket ticket2 = new Ticket("Moscow", "London", 200, 10, 13); //3
        Ticket ticket3 = new Ticket("Milan", "Dubai", 300, 13, 16);
        Ticket ticket4 = new Ticket("Moscow", "London", 400, 8, 14); //6
        Ticket ticket5 = new Ticket("Tokio", "London", 500, 15, 20);
        Ticket ticket6 = new Ticket("Moscow", "London", 100, 19, 23); //4

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket2, ticket6, ticket1, ticket4};
        Ticket[] actual = manager.searchAndSortBy("Moscow", "London", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ticketComparatorFindOne() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("Moscow", "London", 600, 7, 12); //5
        Ticket ticket2 = new Ticket("Moscow", "London", 200, 10, 13); //3
        Ticket ticket3 = new Ticket("Milan", "Dubai", 300, 13, 16);
        Ticket ticket4 = new Ticket("Moscow", "London", 400, 8, 14); //6
        Ticket ticket5 = new Ticket("Tokio", "London", 500, 15, 20);
        Ticket ticket6 = new Ticket("Moscow", "London", 100, 19, 23); //4

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket3};
        Ticket[] actual = manager.searchAndSortBy("Milan", "Dubai", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ticketComparatorFindNull() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("Moscow", "London", 600, 7, 12); //5
        Ticket ticket2 = new Ticket("Moscow", "London", 200, 10, 13); //3
        Ticket ticket3 = new Ticket("Milan", "Dubai", 300, 13, 16);
        Ticket ticket4 = new Ticket("Moscow", "London", 400, 8, 14); //6
        Ticket ticket5 = new Ticket("Tokio", "London", 500, 15, 20);
        Ticket ticket6 = new Ticket("Moscow", "London", 100, 19, 23); //4

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = { };
        Ticket[] actual = manager.searchAndSortBy("Tokio", "Dubai", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }





}
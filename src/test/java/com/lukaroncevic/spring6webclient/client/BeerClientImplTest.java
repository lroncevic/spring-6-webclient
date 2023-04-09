package com.lukaroncevic.spring6webclient.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BeerClientImplTest {

    @Autowired
    BeerClient client;

    @Test
    void listBeer() throws InterruptedException {

        AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        client.listBeer().subscribe(System.out::println);
        atomicBoolean.set(true);
        await().untilTrue(atomicBoolean);
    }

    @Test
    void getMap() throws InterruptedException {

        AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        client.listBeerMap().subscribe(System.out::println);
        atomicBoolean.set(true);
        await().untilTrue(atomicBoolean);
    }

    @Test
    void getBeerJson() {

        AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        client.listBeersJsonNode().subscribe(System.out::println);
        atomicBoolean.set(true);
        await().untilTrue(atomicBoolean);
    }
}
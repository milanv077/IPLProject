package com.mountblue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Main m;
    Util u;
    @BeforeEach
    void initialize()
    {
        m=new Main();
        u=new Util();
    }

    @Test
    void testEconomicalBowler() throws Exception
    {
        Map<String,Double> topEconomicalBowler=m.findEconomicalBowler(u.getDeliveriesDatabase(),u.getMatchesDatabase());

        assertAll(
                ()->assertEquals(1,topEconomicalBowler.size())
        );
    }




}
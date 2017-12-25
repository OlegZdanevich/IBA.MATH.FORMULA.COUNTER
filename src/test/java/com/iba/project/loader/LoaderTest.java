package com.iba.project.loader;

import org.junit.Test;

import static org.junit.Assert.*;

public class LoaderTest {

    @Test
    public void loadData() {
        assertEquals("qwerty\nasdfgh\n",Loader.loadData("test1.txt").toString());
    }
}
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;

public class HashTableTest {

    @Test
    public void makeEmpty() {
        HashTable ht = new HashTable(5);
        HashEntry[] testTable = new HashEntry[5];
        ht.insert("gg",1234);
        ht.insert("hf",13);
        ht.insert("gl",47);
        //Assert.assertEquals(testTable, ht.makeEmpty());
        Assert.assertNull(ht.makeEmpty());
    }

    @Test
    public void get() {
        HashTable ht = new HashTable(5);
        ht.insert("gg",1234);
        ht.insert("hf",13);

        Assert.assertEquals(13, ht.get("hf"));
    }

    @Test
    public void insert() {

        HashTable ht = new HashTable(5);
        Assert.assertEquals(0, ht.insert("gg",1234));
        Assert.assertEquals(0, ht.insert("hf",13));
        Assert.assertEquals(0, ht.insert("gl",47));
        ht = null;
    }

    @Test
    public void remove() {
        HashTable ht = new HashTable(5);
        ht.insert("gg",1234);
        ht.insert("hf",13);
        ht.insert("gl",47);
        Assert.assertEquals(0, ht.remove("gg"));
        Assert.assertEquals(0, ht.remove("hf"));
        Assert.assertEquals(0, ht.remove("gl"));
        ht = null;
    }

    @Test
    public void printHashTable() {
        HashTable ht = new HashTable(5);
        ht.insert("gg",1234);
        ht.insert("hf",13);
        ht.insert("gl",47);
        ArrayList<String> hC = new ArrayList<String>();
        hC.add("gg 1234");
        hC.add("hf 13");
        hC.add("gl 47");
        Assert.assertEquals(hC, ht.printHashTable());
        ht = null;
        hC = null;
    }
}
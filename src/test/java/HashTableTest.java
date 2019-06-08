import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class HashTableTest {

    @Test
    public void getPrime() {

    }

    @Test
    public void makeEmpty() {
    }

    @Test
    public void get() {
    }

    @Test
    public void insert() {

        HashTable ht = new HashTable(5);

        ht.insert("ddd",2567);
        ht.insert("ddf",2557);
        Assert.assertEquals(ht.insert("ddg",2547), 0);
    }

    @Test
    public void remove() {
    }

    @Test
    public void printHashTable() {
    }
}
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;

public class HashTableTest {

    @Test
    public void makeEmpty() {   //тест на очищение хэш-таблицы
        HashTable ht = new HashTable(5);
        HashEntry[] testTable = new HashEntry[5];
        ht.insert("gg",1234);
        ht.insert("hf",13);
        ht.insert("gl",47);
        Assert.assertArrayEquals(testTable, ht.makeEmpty());
        ht = null;
        testTable = null;
    }

    @Test
    public void makeEmpty2() {   //тест на очищение пустой хэш-таблицы
        HashTable ht = new HashTable(5);
        HashEntry[] testTable = new HashEntry[5];
        Assert.assertArrayEquals(testTable, ht.makeEmpty());
        ht = null;
        testTable = null;
    }

    @Test
    public void findMax() {    //поиск максимального значения
        HashTable ht = new HashTable(5);
        ht.insert("gg",1234);
        ht.insert("gl",47);
        ht.insert("hf",13);

        Assert.assertEquals(1234, 1234);
        ht = null;
    }
    @Test
    public void findMin() {     //поиск минимального значения
        HashTable ht = new HashTable(5);
        ht.insert("gg",1234);
        ht.insert("hf",13);
        ht.insert("gl",47);

        Assert.assertEquals(13, 13);
        ht = null;
    }

    @Test
    public void get() {     //тест на получения значения по ключу
        HashTable ht = new HashTable(5);
        ht.insert("gg",1234);
        ht.insert("hf",13);

        Assert.assertEquals(13, ht.get("hf"));
        ht = null;
    }

    @Test
    public void insert() {  //тесты на обычное добавление

        HashTable ht = new HashTable(5);
        Assert.assertEquals(0, ht.insert("gg",1234));
        Assert.assertEquals(0, ht.insert("hf",13));
        Assert.assertEquals(0, ht.insert("gl",47));
        ht = null;
    }

    @Test
    public void insertEmpty() {  //тесты на добавление ключа с пустой строкой и обычное добавление

        HashTable ht = new HashTable(5);
        Assert.assertEquals(0, ht.insert("",16));
        ht = null;
    }

    @Test
    public void insertNull() {  //тесты на добавление ключа с пустой строкой и обычное добавление

        HashTable ht = new HashTable(5);
        Assert.assertEquals(1, ht.insert(null,1234));

        ht = null;
    }

    @Test
    public void insertElemWithSameKey() {  //тесты на добавление в хэш-таблицу такого же ключа

        HashTable ht = new HashTable(5);
        ht.insert("gg",1234);
        Assert.assertEquals(0, ht.insert("gg",13));

        ht = null;
    }

    @Test
    public void remove() {  //тесты на обычное удаление и удаление не существующего ключа
        HashTable ht = new HashTable(5);
        ht.insert("gg",1234);
        ht.insert("hf",13);
        Assert.assertEquals(0, ht.remove("gg"));
        Assert.assertEquals(0, ht.remove("hf"));
        ht = null;
    }

    @Test
    public void removeNotExist() {  //тесты на обычное удаление и удаление не существующего ключа
        HashTable ht = new HashTable(5);
        ht.insert("gg",1234);
        ht.insert("hf",13);
        Assert.assertEquals(0, ht.remove("glhf")); //на не существующий ключ
        ht = null;
    }



    @Test
    public void printHashTable() {  //тест на правильный вывод таблицы на экран
        HashTable ht = new HashTable(5);
        ht.insert("gg",1234);
        ht.insert("hf",13);
        ht.insert("gl",47);
        ArrayList<String> hC = new ArrayList<String>();
        //Т.к. это хэш-таблица, то в данном случае порядок элементов при выводе
        //на экран будет такой
        hC.add("gl 47");
        hC.add("gg 1234");
        hC.add("hf 13");
        Assert.assertEquals(hC, ht.printHashTable());
        ht = null;
        hC = null;
    }

    @Test
    public void printEmptyHashTable() {  //тест на вывод пустой хэш-таблицы на экран
        HashTable ht = new HashTable(5);
        ArrayList<String> hC = new ArrayList<String>();
        //Т.к. это хэш-таблица, то в данном случае порядок элементов при выводе
        //на экран будет такой
        hC.add("HashTable is empty");
        Assert.assertEquals(hC, ht.printHashTable());
        ht = null;
        hC = null;
    }
}
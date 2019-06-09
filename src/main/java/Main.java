import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.math.*;


class HashEntry
{
    String key;
    int value;

    HashEntry(String key, int value)
    {
        this.key = key;
        this.value = value;
    }
}


class HashTable
{
    private int TABLE_SIZE;
    private int size;
    private HashEntry[] table;
    private int primeSize;

    public HashTable(int ts)
    {
        size = 0;
        TABLE_SIZE = ts;
        table = new HashEntry[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++)
            table[i] = null;
        primeSize = getPrime();
    }
    // Функция для получения числа меньше размера таблицы для функции myhash2
    public int getPrime()
    {
        for (int i = TABLE_SIZE - 1; i >= 1; i--)
        {
            int fact = 0;
            for (int j = 2; j <= (int) Math.sqrt(i); j++)
                if (i % j == 0)
                    fact++;
            if (fact == 0)
                return i;
        }

        return 3;
    }

    public HashEntry[] makeEmpty()
    {
        size = 0;
        HashEntry[] testTable;
        for (int i = 0; i < TABLE_SIZE; i++)
            table[i] = null;
        testTable = table;
        return testTable;
    }

    public int get(String key)
    {
        int hash1 = myhash1( key );
        int hash2 = myhash2( key );

        while (table[hash1] != null && !table[hash1].key.equals(key))
        {
            hash1 += hash2;
            hash1 %= TABLE_SIZE;
        }
        return table[hash1].value;
    }

    public int insert(String key, int value)
    {
        if (key == null)
            return 1;
        if (size == TABLE_SIZE)
        {
            System.out.println("Table full");
            return 1;
        }
        int hash1 = myhash1( key );
        int hash2 = myhash2( key );
        while (table[hash1] != null)
        {
            hash1 += hash2;
            hash1 %= TABLE_SIZE;
        }
        table[hash1] = new HashEntry(key, value);
        size++;
        return 0;
    }

    public int remove(String key)
    {
        int hash1 = myhash1( key );
        int hash2 = myhash2( key );
        while (table[hash1] != null && !table[hash1].key.equals(key))
        {
            hash1 += hash2;
            hash1 %= TABLE_SIZE;
        }
        table[hash1] = null;
        size--;
        return 0;
    }

    private int myhash1(String x )
    {
        int hashVal = x.hashCode( );
        hashVal %= TABLE_SIZE;
        if (hashVal < 0)
            hashVal += TABLE_SIZE;
        return hashVal;
    }

    private int myhash2(String x )
    {
        int hashVal = x.hashCode( );
        hashVal %= TABLE_SIZE;
        if (hashVal < 0)
            hashVal += TABLE_SIZE;
        return primeSize - hashVal % primeSize;
    }

    public ArrayList<String> printHashTable()
    {
        boolean b = false;
        ArrayList<String> hashC = new ArrayList<String>();
        System.out.println("\nHash Table");
        for (int i = 0; i < TABLE_SIZE; i++)
            if (table[i] != null)
            {
                System.out.println(table[i].key + " " + table[i].value);
                hashC.add(table[i].key + " " + table[i].value);
                b = true;
            }
        if(!b)
            {
                System.out.println("HashTable is empty");
                hashC.add("HashTable is empty");
                return hashC;
            }
        return hashC;
    }
}


public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Hash Table Test\n\n");
        System.out.println("Enter size");

        HashTable ht = new HashTable(scan.nextInt() );

        char ch;

        do
        {
            System.out.println("\nHash Table Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. remove");
            System.out.println("3. get");
            System.out.println("4. clear");

            int choice = scan.nextInt();
            switch (choice)
            {
                case 1 :
                    System.out.println("Enter key and value");
                    ht.insert(scan.next(), scan.nextInt() );
                    break;
                case 2 :
                    System.out.println("Enter key");
                    ht.remove( scan.next() );
                    break;
                case 3 :
                    System.out.println("Enter key");
                    System.out.println("Value = "+ ht.get( scan.next() ));
                    break;
                case 4 :
                    ht.makeEmpty();
                    System.out.println("Hash Table Cleared\n");
                    break;
                default :
                    System.out.println("Wrong Entry \n ");
                    break;
            }

            ht.printHashTable();

            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y'|| ch == 'y');

    }
}


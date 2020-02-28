package toptal;

import java.util.ArrayList;

public class HashTables {
    public static void main(String[] args) {
        LPHashTable t = new LPHashTable();
        t.add("Hello", "Yoyo");
        t.add(134, 'h');
        t.add(true, false);
        t.add(false, true);
        t.remove(true);
        t.remove(false);
        t.remove("Hello");
        t.remove(134);
        t.add("Empt", 45);
    }
}

class LPHashTable {
    private ArrayList[] table;
    private int size;
    public LPHashTable () {
        table = new ArrayList[100];
    }

    private int hash(Object key, int m) {
        return key.hashCode() % m;
    }

    public void add(Object key, Object val) {

        int hash = hash(key, table.length);
        if(table[hash] == null) table[hash] = new ArrayList();
        for(Object entry : table[hash]) {
            HashEntry hashEntry = (HashEntry) entry;
            if(hashEntry.getKey().equals(key)) {
                hashEntry.setValue(val);
                return;
            }
        }
        table[hash].add(new HashEntry(key, val));
    }

    public boolean exists(Object key) {
        int hash = hash(key, table.length);
        if(table[hash] == null) return false;

        for(Object entry : table[hash]) {
            HashEntry hashEntry = (HashEntry) entry;
            if(hashEntry.getKey().equals(key)) return true;
        }

        return false;
    }

    public Object get(Object key) {
        int hash = hash(key, table.length);
        if(table[hash] == null) return null;

        for(Object entry : table[hash]) {
            HashEntry hashEntry = (HashEntry) entry;
            if(hashEntry.getKey().equals(key)) return hashEntry.getValue();
        }

        return null;
    }

    public void remove(Object key) {
        int hash = hash(key, table.length);
        if(table[hash] == null) return;

        int size = table[hash].size();
        for(int i = 0; i < size; i++) {
            HashEntry hashEntry = (HashEntry) table[hash].get(i);
            if(hashEntry.getKey().equals(key)) {
                table[hash].remove(i);
                return;
            }
        }
    }

}

class HashEntry {
    private Object key;
    private Object val;
    private boolean recycle = false;
    public HashEntry(Object key, Object val) {
        this.key = key;
        this.val = val;
    }

    public Object getKey() {
        return key;
    }

    public Object getValue() {
        return val;
    }

    public void setValue(Object newVal) {
        this.val = newVal;
    }

    public void markForRecycle() {
        this.recycle = true;
    }
}

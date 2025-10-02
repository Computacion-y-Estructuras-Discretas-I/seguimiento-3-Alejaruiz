package structures;

import java.util.LinkedList;

public class TablasHash {
    private LinkedList<Integer>[] tabla;
    private int size;

    public TablasHash(int n) throws Exception {
        this.tabla = new LinkedList[n];
        this.size = n;
    }

    public int getSize() {
        return size;
    }

    public boolean search(int k, int value) throws Exception {
        int pos = this.hashFunction(k);
        LinkedList<Integer> found = this.tabla[pos];
        if (found != null) {
            for (Integer ci : found) {
                if (ci == value) {
                    return true;
                }
            }
        }
        return false;
    }

    public void insert(int k, int value) throws Exception {
        int pos = this.hashFunction(k);
        LinkedList<Integer> found = this.tabla[pos];
        if (found == null) {
            found = new LinkedList<Integer>();
        }
        found.add(value);
        this.tabla[pos] = found;
    }

    public void delete(int k, int v) throws Exception {
        int pos = this.hashFunction(k);
        LinkedList<Integer> found = this.tabla[pos];
        if (found != null) {
            found.remove((Integer) v);
        }
        this.tabla[pos] = found;
    }

    private int hashFunction(int k) throws Exception {
        return Math.floorMod(k, this.size);
    }
}

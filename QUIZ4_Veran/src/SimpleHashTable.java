public class SimpleHashTable {
    private StoredPlayer[] hashtable;

    public SimpleHashTable() {
        hashtable = new StoredPlayer[10];
    }

    private int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    public void put(String key, Player value) {
        int hashedKey = hashKey(key);

        if (isOccupied(hashedKey)) {
            // do linear probing
            int stoppingIndex = hashedKey;

            if (hashedKey == hashtable.length - 1) {
                hashedKey = 0;
            } else {
                hashedKey++;
            }

            while (isOccupied(hashedKey) && hashedKey != stoppingIndex) {
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }

        if (isOccupied(hashedKey)) {
            System.out.println("Sorry, there is already an element at position " + hashedKey);
        } else {
            hashtable[hashedKey] = new StoredPlayer(key, value);
        }
    }

    public Player get(String key) {
        int hashedKey = findKey(key);

        if (hashedKey == -1) {
            return null;
        }
        return hashtable[hashedKey].value;
    }

    // ✅ NEW: remove() using linear probing
    public Player remove(String key) {
        int hashedKey = findKey(key);

        if (hashedKey == -1) {
            // key not found
            return null;
        }

        Player removedPlayer = hashtable[hashedKey].value;
        hashtable[hashedKey] = null;

        // rehash the entire table so linear probing still works
        StoredPlayer[] oldHashtable = hashtable;
        hashtable = new StoredPlayer[oldHashtable.length];

        for (int i = 0; i < oldHashtable.length; i++) {
            if (oldHashtable[i] != null) {
                put(oldHashtable[i].key, oldHashtable[i].value);
            }
        }

        return removedPlayer;
    }

    private int findKey(String key) {
        int hashedKey = hashKey(key);

        // found the right key immediately?
        if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        }

        // do linear probing
        int stoppingIndex = hashedKey;

        if (hashedKey == hashtable.length - 1) {
            hashedKey = 0;
        } else {
            hashedKey++;
        }

        // 🔧 NOTE: condition should be "while NOT equal to key"
        while (hashedKey != stoppingIndex &&
                hashtable[hashedKey] != null &&
                !hashtable[hashedKey].key.equals(key)) {

            hashedKey = (hashedKey + 1) % hashtable.length;
        }

        if (hashtable[hashedKey] != null &&
                hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        }

        return -1;
    }

    private boolean isOccupied(int index) {
        return hashtable[index] != null;
    }

    public void printHastable() {
        for (int i = 0; i < hashtable.length; i++) {
            if (hashtable[i] == null) {
                System.out.println("element " + i + " = null");
            } else {
                System.out.println("element " + i + " = " + hashtable[i].value);
            }
        }
    }
}

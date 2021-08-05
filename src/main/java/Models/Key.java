package Models;

import java.util.Objects;

public class Key {

   private long id;
   private String sizeKey;
   private String nameKey;
   private String statusKey;

    public Key() {
    }

    public Key(String sizeKey, String nameKey, String statusKey) {
        this.sizeKey = sizeKey;
        this.nameKey = nameKey;
        this.statusKey = statusKey;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSizeKey() {
        return sizeKey;
    }

    public void setSizeKey(String sizeKey) {
        this.sizeKey = sizeKey;
    }

    public String getNameKey() {
        return nameKey;
    }

    public void setNameKey(String nameKey) {
        this.nameKey = nameKey;
    }

    public String getStatusKey() {
        return statusKey;
    }

    public void setStatusKey(String statusKey) {
        this.statusKey = statusKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Key key = (Key) o;
        return id == key.id &&
                statusKey == key.statusKey &&
                sizeKey.equals(key.sizeKey) &&
                nameKey.equals(key.nameKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sizeKey, nameKey, statusKey);
    }

    @Override
    public String toString() {
        return "Key{" +
                "id=" + id +
                ", sizeKey='" + sizeKey + '\'' +
                ", nameKey='" + nameKey + '\'' +
                ", statusKey=" + statusKey +
                '}';
    }
}

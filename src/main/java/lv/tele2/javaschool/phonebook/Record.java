package lv.tele2.javaschool.phonebook;

import com.sun.prism.impl.Disposer;
import sun.plugin2.message.Serializer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by krisosip on 07/03/2017.
 */
public class Record implements Serializable {
    private static final long serailVersionUID = 1L;
    private static int nextId = 1; //static - belongs to all objects of the class, i.e. is only one among all objects

    private int id;
    private String name;
    private String[] phone;
    //private List<String> phone = new ArrayList<>();
    private String email;

    public Record() { //constructor
        this.id = nextId;
        nextId++;
    }

    public Record(String name, String email, String[] phone) {
        this();
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getPhone() {
        return phone;
    }

    public void setPhone(String[] phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone=" + Arrays.toString(phone) +
                ", email='" + email + '\'' +
                '}';
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        nextId = Math.max(id + 1, nextId);
    }
}

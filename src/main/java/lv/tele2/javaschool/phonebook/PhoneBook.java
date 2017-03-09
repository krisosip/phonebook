package lv.tele2.javaschool.phonebook;

import asg.cliche.Command;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by krisosip on 07/03/2017.
 */
public class PhoneBook implements Serializable{ //i.e. can be stored somewhere
    private static final long serialVersionUID = 1L;

    private List<Record> list = new ArrayList<>();

    @Command
    public void create(String name, String email, String... phone){
        Record r = new Record(name, email, phone);
        //r.setEmail(email);
        list.add(r);
    }

    @Command
    public List<Record> show() {
        return list;
    }
}

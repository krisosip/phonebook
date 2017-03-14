package lv.tele2.javaschool.phonebook;

import asg.cliche.Command;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;
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

    @Command
    public void remove (int id, String name){
        for (Record r : list) {
            if (r.getId() == id && r.getName().equals(name)) {
                list.remove(r);
                System.out.println(r);
                break;
            }
        }
    }

    @Command
    public void generate (){
        JSONObject obj = callNameFake();
        String name = obj.getString ("name");
        String phone = obj.getString("phone_h");
        String email = obj.getString("email_u")+"@"+obj.get("email_d");
        System.out.println(name);
        System.out.println(phone);
        System.out.println(email);
        create(name, email, phone);
    }

    private JSONObject callNameFake() {
        try {
            URL url = new URL("http://api.namefake.com/latvian-latvia/random");
            try(InputStream is = url.openStream()){
            JSONTokener t = new JSONTokener(is);
            JSONObject obj = new JSONObject(t); //we have created JSON object from URL, InputStream will close automatically
            return obj;
            }
        } catch (IOException e){
            return null;
        }
    }
}

import java.util.ArrayList;
import java.util.List;

public class MediatorApp {
    public static void main(String[] args){
        TextChat textChat = new TextChat();

        Uuser admin = new Admin(textChat, "admin adminovich");
        Uuser u1 = new SimpleUser(textChat, "Ivan");
        Uuser u2 = new SimpleUser(textChat, "Oleg");
        Uuser u3 = new SimpleUser(textChat, "Sasha");
        u2.setEnable(false);

        textChat.setAdmin(admin);
        textChat.addUser(u1);
        textChat.addUser(u2);
        textChat.addUser(u3);

        //u1.sendMessage("hi");
        admin.sendMessage("hi, I'm an admin");
    }
}

abstract class Uuser{
    Chat chat;
    String name;
    boolean isEnable = true;

    public boolean isEnable(){
        return isEnable;
    }

    public void setEnable(boolean isEnable){
        this.isEnable = isEnable;
    }

    public Uuser(Chat chat, String name){
        this.chat = chat;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void sendMessage(String message){
        chat.sendMessage(message, this);
    }

    abstract void getMessage(String message);
}

interface Chat{
    void sendMessage(String message, Uuser uuser);
}

class Admin extends Uuser{
    public Admin(Chat chat, String name){
        super(chat, name);
    }

    public void getMessage(String message) {
        System.out.println("Admin is recieving a message: '" + message + "'");
    }

    public String toString(){
        return "User [name = " + name + "]";
    }
}

class SimpleUser extends Uuser{
    public SimpleUser(Chat chat, String name){
        super(chat, name);
    }

    public void getMessage(String message) {
        System.out.println("User " + name+ " is recieving a message: '" + message + "'");
    }
}

class TextChat implements Chat{
    Uuser admin;
    List<Uuser> users = new ArrayList<>();

    public void setAdmin(Uuser admin){
        if (admin!=null && admin instanceof Admin){
            this.admin = admin;
        }
        else {
            throw new RuntimeException("Denied");
        }
    }

    public void addUser(Uuser uuser){
        if (admin==null){
            throw new RuntimeException("No admin for this chat!");
        }

        if (uuser instanceof SimpleUser){
            users.add(uuser);
        }
        else {
            throw new RuntimeException("Admin can not enter another chat.");
        }
    }

    @Override
    public void sendMessage(String message, Uuser uuser) {
        if (uuser instanceof Admin){
            for (Uuser u: users){
                u.getMessage(uuser.getName()+": "+message);
            }
        }
        if (uuser instanceof SimpleUser){
            for (Uuser u: users){
                if(u!=uuser && u.isEnable()){
                    u.getMessage(uuser.getName()+": "+message);
                }
            }
            if(admin.isEnable()){
                admin.getMessage(uuser.getName()+": "+message);
            }
        }
    }
}

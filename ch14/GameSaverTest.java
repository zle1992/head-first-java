

import java.io.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class GameSaverTest{
     public static void main (String[] args) {
        GameCharacter one = new GameCharacter(50, "Elf", new String[] {"bow", "sword", "dust"});
        GameCharacter two = new GameCharacter(200, "Troll", new String[] {"bare hands", "big axe"});
        GameCharacter three = new GameCharacter(120, "Magician", new String[] {"spells", "invisibility"});
        try{
            FileOutputStream fileStream = new FileOutputStream("MyGame.ser");
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(one);
            os.writeObject(two);
            os.writeObject(three);
            os.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        //free the object on the heap
        one = null;
        two = null;
        three = null;
        //read object from MyGame.ser
        try{
            FileInputStream fileStream2 = new FileInputStream("MyGame.ser");
            ObjectInputStream os2 = new ObjectInputStream(fileStream2);
            GameCharacter one2 = (GameCharacter) (os2.readObject());
            GameCharacter two2 = (GameCharacter) (os2.readObject());
            GameCharacter three2 = (GameCharacter) (os2.readObject());

            System.out.println("one's type:"+one2.getType());
            System.out.println("two's type:"+two2.getType());
            System.out.println("three's type:"+three2.getType());
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}

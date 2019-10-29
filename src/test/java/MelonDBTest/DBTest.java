package MelonDBTest;

import java.io.File;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import MelonDB.DB;
import MelonDB.MelonDB;

public class DBTest {
    String s1 = "{\"name\":\"tangdh\",\"age\":13}";
    String s2 = "{\"male\":true}";
    String s3 = "{\"tall\":18.189,\"age\":16}";
    String s4 = "{\"age\":124,\"tall\":1.189,\"male\":true}";
    @Test
    public void CreatingTable(){
        DB db = new MelonDB();
        db.creatingMelon("User");
        File file = new File("./MelonDB/User");
        Assertions.assertTrue(file.exists());
    }

    @Test
    public void UsingTable(){
        DB db = new MelonDB();
        db.creatingMelon("Item");

        Assertions.assertTrue(db.usingMelon("Item"));
        db.add(s1);
        Assertions.assertTrue(db.usingMelon("User"));
        Assertions.assertEquals(0,db.search("\"name\"","\"tangdh\"").size());
        db.usingMelon("Item");
        Assertions.assertEquals(1,db.search("\"name\"","\"tangdh\"").size());
    }

    @Test
    public void DeleteTable(){
        DB db = new MelonDB();
        db.usingMelon("Item");
        Assertions.assertFalse(db.deleteMelon("Item"));
        db.usingMelon("User");
        Assertions.assertTrue(db.deleteMelon("Item"));
    }


    @Test
    public void add(){
        DB db = new MelonDB();
        Assertions.assertTrue(db.creatingMelon("Item"));
        db.usingMelon("Item");
        db.add(s1);
        db.add(s4);
        db.add(s1);
        Assertions.assertEquals(1,db.search("\"name\"","\"tangdh\"").size());

    }
    @Test
    public void search(){
        DB db = new MelonDB();
        //Assertions.assertTrue(db.creatingMelon("Item"));
        db.usingMelon("Item");
        db.add(s1);
        db.add(s4);
        db.add(s1);
        Assertions.assertEquals(1,db.search("\"name\"","\"tangdh\"").size());
        Assertions.assertEquals(1,db.search("\"age\"","124").size());
        db.usingMelon("User");
        Assertions.assertEquals(0,db.search("\"name\"","\"tangdh\"").size());
        Assertions.assertEquals(0,db.search("\"age\"","124").size());
    }
    @Test
    public void delete(){
        DB db = new MelonDB();
        //Assertions.assertTrue(db.creatingMelon("Item"));
        db.usingMelon("Item");
        Assertions.assertEquals(1,db.search("\"name\"","\"tangdh\"").size());
        db.delete("\"name\"","\"tangdh\"","\"age\"","13");
        Assertions.assertEquals(0,db.search("\"name\"","\"tangdh\"").size());

    }
    @Test
    public void change(){
        DB db = new MelonDB();
        db.usingMelon("Item");
        db.add(s1);
        Assertions.assertEquals(1,db.search("\"name\"","\"tangdh\"").size());
        db.change(s1,"\"name\"","\"gzy\"");
        Assertions.assertEquals(0,db.search("\"name\"","\"tangdh\"").size());
        Assertions.assertEquals(1,db.search("\"name\"","\"gzy\"").size());

    }
}

package MelonJsonTest.util;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.omg.CORBA.OBJ_ADAPTER;

import MelonJson.entity.BooleanValue;
import MelonJson.entity.DoubleValue;
import MelonJson.entity.IntegerValue;
import MelonJson.entity.JsonValue;
import MelonJson.entity.StringValue;

public class JPairGeneratorTest {
    private static final boolean[][] true_ans = {{true,false,false,false},{false,true,false,false},{false,false,true,false}
            ,{false,false,false,true}};
    private static boolean[] result;
    static  class TypeGenerator{
        //private static final Class[] clazz = {BooleanValue.class, DoubleValue.class, IntegerValue.class, StringValue.class};
        static Random random = new Random(47);
        public static String next(){
          if(random.nextInt(40)<=5){
              BooleanValue booleanValue = new BooleanValue(true);
              result = true_ans[0];
              return booleanValue.toString();
          }else if(random.nextInt(40)<=10){
              BooleanValue booleanValue = new BooleanValue(false);
              result = true_ans[0];
              return booleanValue.toString();
          }else if(random.nextInt(40)<=20){
              DoubleValue doubleValue = new DoubleValue(random.nextDouble());
              result = true_ans[3];
              return doubleValue.toString();
          }else if(random.nextInt(40)<=30){
              IntegerValue integerValue = new IntegerValue(random.nextInt(10000000));
              result = true_ans[2];
              return integerValue.toString();
          }else {
              StringBuilder sb = new StringBuilder();
              while (random.nextInt(200)>=10)
                  sb.append(String.valueOf((char) (random.nextInt(71)+48)));
              StringValue stringValue = new StringValue(sb.toString());
              result = true_ans[1];
              return stringValue.toString();
          }
        }
    }

    @Test void KetTest(){
        final String Key =  "\"[^\\s]+\"";
        Pattern pattern = Pattern.compile(Key);
        String s1 = "\"2efsd212rre\"";
        String s2 = "\"wef3ef87ih j9f3f\"";
        String s3 = "\"fvdff32    fefww\"";
        Assertions.assertTrue(pattern.matcher(s1).matches());
        Assertions.assertFalse(pattern.matcher(s2).matches());
        Assertions.assertFalse(pattern.matcher(s3).matches());
    }
    @Test void JsonTest(){
        final  String bValue = "true|false";
        final  String sValue = "\".*?\"";
        final  String iValue = "-?\\d+";
        final  String dValue = "[\\\\+\\\\-]{0,1}[0-9]+[\\\\.\\\\,][0-9]+";
        final  String Key = "\"[^\\s]+?\"";
        final String KV = Key+":"+"("+"("+sValue+")"+"|"+"("+bValue+")"+"|"+"("+dValue+")"+"|"+"("+iValue+")" +")";
        final String JsonValue1 = "^\\{"+KV+"("+","+KV+")"+"*"+"\\}$";

        String s1 = "{\"name\":\"tangdh\",\"age\":13}";
        String s2 = "{\"male\":true}";
        String s3 = "{\"tall\":18.189,\"age\":13}";
        String s4 = "{\"age\":124,\"tall\":1.189,\"male\":true}";
        String s5 = "{\"name\":\"tangdj\",}";
        //String temp = "qdqw ef we fwe";
        Assertions.assertTrue(Pattern.matches(JsonValue1,s1));
        Assertions.assertTrue(Pattern.matches(JsonValue1,s2));
        Assertions.assertTrue(Pattern.matches(JsonValue1,s3));
        Assertions.assertTrue(Pattern.matches(JsonValue1,s4));
        Assertions.assertFalse(Pattern.matches(JsonValue1,s5));
        Pattern pattern = Pattern.compile(KV);
        Matcher matcher = pattern.matcher(s3);
        while (matcher.find()){
            System.out.println(matcher.group()+"  ");
        }

    }
    @Test
    public void RegTest() throws InstantiationException, IllegalAccessException {

         final  String bValue = "true|false";
         final  String sValue = "\".*\"";
         final  String iValue = "^-?\\d+$";
         final  String dValue = "^[\\\\+\\\\-]{0,1}[0-9]+[\\\\.\\\\,][0-9]+$";
         final  String Key = "\"[^\\s]+\"";
         final  String JsonValue = "\\\\{"+Key+":"+sValue+"|"+iValue+"|"+dValue+"|"+"\\\\}";


         Pattern bpattern = Pattern.compile(bValue);
         Pattern spattern = Pattern.compile(sValue);
         Pattern ipattern = Pattern.compile(iValue);
         Pattern dpattern = Pattern.compile(dValue);
         //System.out.println(ipattern.matcher("498410").matches());
         boolean[] vali = new boolean[4];
         for(int i=0;i<300;i++) {
             String s = TypeGenerator.next();
             System.out.println("Now is"+s);
             vali[0] = bpattern.matcher(s).matches();
             vali[1] = spattern.matcher(s).matches();
             vali[2] = ipattern.matcher(s).matches();
             vali[3] = dpattern.matcher(s).matches();
             System.out.println(vali);
             System.out.println(result);
             Assertions.assertArrayEquals(vali,result);
         }



    }
}

package utilities;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import tipeandocodigo.com.overview.pageclasses.AllCourses;

public class GeneralUtils {
    private static final Log log = LogFactory.getLog(AllCourses.class);
    public static int randomNumber(int min,int max){
        int dif = max - min;
        return  (int)(Math.random() * dif);
    }
    public static int randomNumber(int max){
        return randomNumber(1,max);
    }
    public static String randomString(int length){
        String baseString = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ1234567890*$%&#_-";
        String ram = "";
        for(int i=0;i < length;i++){
            ram+= baseString.charAt(randomNumber(baseString.length()));
        }
        return ram;
    }
    public static String randomString(){
        return randomString(10);
    }

    /**
     * Method to sleep for the 'time' in miliseconds
     * @param time long
     */
    public static void Sleep(long time) {
        try {
            Thread.sleep(time);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method to sleep 5 seconds
     */
    public static void Sleep() {
        Sleep(5000);
    }

    /***
     * //send message to the log
     * @param message "message to send in the log"
     * @param type "type for the message currenttype: info , warning, error"
     */
    public static void logMessage(String message,String type){
        switch (type){
            case "info":{
                log.info(message);
                break;
            }
            case "warning": {
                log.warn(message);
                break;
            }
            case "error":{
                log.error(message);
                break;
            }
        }
    }

}

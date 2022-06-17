package utilities;

import pojos.RegisterPojo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class WriteToTxt {

    public static void saveRegistrantData(RegisterPojo registerPojo) {
        try {

            //src/resources/testdata/Registrantdata.txt
            FileWriter fileWriter = new FileWriter(ConfigurationReader.getProperty("registration_data"), true);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            writer.append(registerPojo+"\n");
            writer.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

//    public static void saveAppointData(Appointment appointment){
//        try{
//            //src/resources/testdata/Registrantdata.txt
//            FileWriter fileWriter = new FileWriter(ConfigurationReader.getProperty("appointment_records"), true);
//            BufferedWriter writer = new BufferedWriter(fileWriter);
//            writer.append(appointment+"\n");
//            writer.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
    public static void saveRegistrantData(List<Object> SSNIds){
        try{
            //src/resources/testdata/Registrantdata.txt
            FileWriter fileWriter = new FileWriter(ConfigurationReader.getProperty("database_registrant_data"), false);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for(Object eachSSN: SSNIds) {
                writer.append(eachSSN + ",\n");
            }
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

//    public static void saveAppointData(AppointmentGet appointment) {
//        try {
//            //src/resources/testdata/Registrantdata.txt
//            FileWriter fileWriter = new FileWriter(ConfigurationReader.getProperty("appointment_records"), true);
//            BufferedWriter writer = new BufferedWriter(fileWriter);
//            writer.append(appointment + "\n");
//            writer.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//    public static void saveApiAppointmentData(AppointmentGet appointment) {
//        try {
//            //src/resources/testdata/Registrantdata.txt
//            FileWriter fileWriter = new FileWriter(ConfigurationReader.getProperty("api_appointment_data"), true);
//            BufferedWriter writer = new BufferedWriter(fileWriter);
//            writer.append(appointment + "\n");
//            writer.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//    public static void saveAppointmentCreation(AppointmentGet appointmentGet) {
//        try {
//            FileWriter fileWriter = new FileWriter(ConfigurationReader.getProperty("api_appointment_data"), true);
//            BufferedWriter writer = new BufferedWriter(fileWriter);
//            writer.append(appointmentGet + "\n");
//            writer.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
}
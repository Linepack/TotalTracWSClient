package org.linepack.totaltracwsclient.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Leandro
 */
public class Log {

    public static void write(String msg) throws FileNotFoundException, IOException {
        Date date = new Date();
        String maskData = "dd/MM/yyyy";
        String maskDataHora = "dd/MM/yyyy HH:mm:ss";
        SimpleDateFormat dataFormatada = new SimpleDateFormat(maskData);
        SimpleDateFormat dataHoraFormatada = new SimpleDateFormat(maskDataHora);
        String stringData = dataFormatada.format(date).replace("/", "");
        String stringDataHora = dataHoraFormatada.format(date);

        File file = new File(stringData + ".log");
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(stringDataHora + " -> " + msg);
        bufferedWriter.newLine();
        if (!file.exists()) {
            file.createNewFile();
        }
        bufferedWriter.close();
        fileWriter.close();
    }
}

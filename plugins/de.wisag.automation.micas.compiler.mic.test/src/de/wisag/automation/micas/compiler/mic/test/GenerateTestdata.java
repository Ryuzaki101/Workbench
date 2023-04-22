package de.wisag.automation.micas.compiler.mic.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

public class GenerateTestdata {

    public static void main(String[] args) throws IOException {
        File dir = new File("src/de/wisag/automation/micas/compiler/mic/test");
        BufferedReader br = new BufferedReader(new FileReader(new File(dir, "hwtypes.txt")));
        String type = null;
        // List<?> bigLines = IOUtils.readLines(new FileInputStream(new
        // File(dir,"big-template.mic")), "CP850");
        List<?> miniLines = IOUtils.readLines(new FileInputStream(new File(dir, "mini-template.mic")), "CP850");
        File typDir = new File(dir, "types");
        PrintWriter pw = new PrintWriter(new File(typDir, "compile.cmd"));

        typDir.mkdir();
        while ((type = br.readLine()) != null) {
            type = StringUtils.trim(type);
            int pos = -1;
            if ((pos = type.indexOf(',')) > -1) {
                type = StringUtils.left(type, pos);
            }

            // String bigFname = "29"+type+"03";
            // String bigFName = bigFname + ".mic";
            // PrintWriter pwBig = new PrintWriter(new File(typDir,bigFName));
            // new File(typDir,bigFname).mkdir();
            // for (Iterator<?> it = bigLines.iterator(); it.hasNext();) {
            // String s = (String) it.next();
            // int pos=-1;
            // if ((pos=s.indexOf(','))>-1) {
            // s=StringUtils.left(s, pos);
            // }
            // s=StringUtils.replace(
            // StringUtils.replace(s, "@TYPE@", type),"@FILEDBUS@","3");
            // pwBig.println(s);
            // }
            // pwBig.close();
            // pw.println("mic.exe " + bigFName+ " -lis -od");
            String string = "29" + type + "05";
            String miniFName = string + ".mic";
            PrintWriter pwMini = new PrintWriter(new File(typDir, miniFName));
            new File(typDir, string).mkdir();
            for (Iterator<?> it = miniLines.iterator(); it.hasNext();) {
                String s = (String) it.next();
                s = StringUtils.replace(StringUtils.replace(s, "@TYPE@", type), "@FILEDBUS@", "5");
                pwMini.println(s);
            }
            pw.println("mic.exe " + miniFName + " -lis -od");
            pwMini.close();

        }
        pw.close();
        IOUtils.closeQuietly(br);
    }
}

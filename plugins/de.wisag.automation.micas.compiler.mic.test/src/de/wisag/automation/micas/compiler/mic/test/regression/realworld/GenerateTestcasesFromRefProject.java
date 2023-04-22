package de.wisag.automation.micas.compiler.mic.test.regression.realworld;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

public class GenerateTestcasesFromRefProject {
    class MicMeta {
        private String srcFileName;
        private String projectName;
        private String projectNumber;
        private int lineNumber;
        private int userNumber;
        private String moduleType;
        private int fieldbusNumber;

        public String getSrcFileName() {
            return this.srcFileName;
        }

        public void setSrcFileName(String srcFileName) {
            this.srcFileName = srcFileName;
        }

        public String getProjectName() {
            return this.projectName;
        }

        public void setProjectName(String projectName) {
            this.projectName = projectName;
        }

        public int getLineNumber() {
            return this.lineNumber;
        }

        public void setLineNumber(int lineNumber) {
            this.lineNumber = lineNumber;
        }

        public int getUserNumber() {
            return this.userNumber;
        }

        public void setUserNumber(int userNumber) {
            this.userNumber = userNumber;
        }

        public String getModuleType() {
            return this.moduleType;
        }

        public void setModuleType(String moduleType) {
            this.moduleType = moduleType;
        }

        public int getFieldbusNumber() {
            return this.fieldbusNumber;
        }

        public void setFieldbusNumber(int fieldbusNumber) {
            this.fieldbusNumber = fieldbusNumber;
        }

        @Override
        public String toString() {
            return "MicMeta [srcFileName=" + this.srcFileName + ", projectName=" + this.projectName + ", projectNumber="
                    + this.projectNumber + ", lineNumber=" + this.lineNumber + ", userNumber=" + this.userNumber
                    + ", moduleType=" + this.moduleType + ", fieldbusNumber=" + this.fieldbusNumber + "]";
        }

        public String getProjectNumber() {
            return this.projectNumber;
        }

        public void setProjectNumber(String projectNumber) {
            this.projectNumber = projectNumber;
        }
    }

    @Test
    public void collectAllMics() throws Exception {
        File[] baseDirs = new File[] { //
                //
                new File("../de.wisag.automation.micas.refprj/Messe_Duesseldorf"),
                new File("../de.wisag.automation.micas.refprj/MPI"),
                new File("../de.wisag.automation.micas.refprj/Wolfgang_Donner") };
        List<File> all = new ArrayList<>();

        for (File dir : baseDirs) {
            Collection<?> files = FileUtils.listFiles(dir, new String[] { "mic", "MIC" }, true);
            for (Object object : files) {
                all.add((File) object);
            }
        }
        /*
         * ;*** Projekt Beginn \s*;.+Dateiname\s+:\s*(\S+) ;*** Dateiname :
         * AR04_03.GPS \s*;.+Projektname\s+:\s*(\S+) ;*** Projektname :
         * NOWEA-MSC \s*;.+Projektnummer\s+:\s*(\S+) ;*** Projektnummer :
         * 33101664 ;*** Bearbeiter : Fließgarten ;*** Prüfer : \s*;.+Line
         * Nummer\s+:\s*(\d+) ;*** Line Nummer : 7 \s*;.+User
         * Number\s+:\s*(\d+)? ;*** User Number : 4 \s*;.+Modul
         * Typ\s+:\s*([A-Z]{2}[0-9]{2}) ;*** Modul Typ : AR20 \s*;.+Feldbus
         * Nummer\s+:\s*(\d+) ;*** Feldbus Nummer : 3
         */
        Pattern p1 = Pattern.compile("^\\s*;.+Dateiname\\s+:\\s*(\\S+).*$", Pattern.CASE_INSENSITIVE);
        Pattern p2 = Pattern.compile("^\\s*;.+Projektname\\s+:\\s*(\\S+).*$", Pattern.CASE_INSENSITIVE);
        Pattern p3 = Pattern.compile("^\\s*;.+Projektnummer\\s+:\\s*(\\S+).*$", Pattern.CASE_INSENSITIVE);
        Pattern p4 = Pattern.compile("^\\s*;.+Line Nummer\\s+:\\s*(\\d+).*$", Pattern.CASE_INSENSITIVE);
        Pattern p5 = Pattern.compile("^\\s*;.+User Number\\s+:\\s*(\\d+).*$", Pattern.CASE_INSENSITIVE);
        Pattern p6 = Pattern.compile("^\\s*;.+Modul Typ\\s+:\\s*([A-Z]{2}[0-9]{2}).*$", Pattern.CASE_INSENSITIVE);
        Pattern p7 = Pattern.compile("^\\s*;.+Feldbus Nummer\\s+:\\s*(\\d+).*$", Pattern.CASE_INSENSITIVE);
        // MODUL (AC40,3)
        Pattern p8 = Pattern.compile("^\\s*MODUL\\s*\\(\\s*(\\S+)\\s*,\\s*(\\d)+\\s*\\).*$");
        System.out.println(String.format("Have %d files", all.size()));
        int i = 0;
        List<String> cl = new ArrayList<>();

        for (File file : all) {
            StringBuilder sb = new StringBuilder();
            MicMeta meta = new MicMeta();
            LineIterator lines = IOUtils.lineIterator(new FileInputStream(file), "CP850");
            while (lines.hasNext()) {
                String line = lines.nextLine();
                Matcher m = null;
                if ((m = p1.matcher(line)).matches()) {
                    String srcFileName = StringUtils.trimToEmpty(m.group(1));
                    meta.setSrcFileName(srcFileName);
                } else if ((m = p2.matcher(line)).matches()) {
                    String projectName = StringUtils.trimToEmpty(m.group(1));
                    meta.setProjectName(projectName);
                } else if ((m = p3.matcher(line)).matches()) {
                    String sProjectNumber = StringUtils.trimToEmpty(m.group(1));
                    meta.setProjectNumber(sProjectNumber);
                } else if ((m = p4.matcher(line)).matches()) {
                    String sLineNumber = StringUtils.trimToEmpty(m.group(1));
                    meta.setLineNumber(Integer.parseInt(sLineNumber));
                } else if ((m = p5.matcher(line)).matches()) {
                    String sUserNumber = StringUtils.trimToEmpty(m.group(1));
                    meta.setUserNumber(Integer.parseInt(sUserNumber));
                } else if ((m = p6.matcher(line)).matches()) {
                    String moduleType = StringUtils.trimToEmpty(m.group(1));
                    meta.setModuleType(moduleType);
                } else if ((m = p7.matcher(line)).matches()) {
                    String fieldbusNumber = StringUtils.trimToEmpty(m.group(1));
                    meta.setFieldbusNumber(Integer.parseInt(fieldbusNumber));
                } else if ((m = p8.matcher(line)).matches()) {
                    line = "  MODUL (@TYPE@, @FILEDBUS@)";
                    // line = " MODUL (AC40, 2)";
                }
                sb.append(line);
                sb.append("\r\n");
            }
            String name = String.format("%03d_testcase.mic", i);
            File file2 = new File("testdata/realworld/" + name);
            IOUtils.copy(new ByteArrayInputStream(sb.toString().getBytes("UTF-8")), new FileOutputStream(file2));
            StringBuilder src = new StringBuilder();
            String x = String.format("Testcase_%03d", i++);
            src.append("package de.wisag.automation.micas.compiler.mic.test.regression.realworld;");
            src.append("		");
            src.append("import de.wisag.automation.micas.compiler.mic.test.TestForSupportedHardware;");
            src.append("		");
            src.append(String.format("public class %s extends TestForSupportedHardware{", x));
            src.append("		");
            src.append("	public String getTestPath() {");
            src.append(String.format("		return \"/testdata/realworld/%s\";", name));
            src.append("	}");
            src.append("public String getEncoding() {");
            src.append("	return \"UTF-8\";");
            src.append("	}");
            src.append("");
            src.append("}");
            File file3 = new File("src/de/wisag/automation/micas/compiler/mic/test/regression/realworld");
            File genFile = new File(file3, x + ".java");
            cl.add(x + ".class,");
            IOUtils.write(src.toString(), new FileOutputStream(genFile));
            System.out.println(file);
            System.out.println(meta);
        }
        for (String string : cl) {
            System.out.println(string);
        }
    }
}

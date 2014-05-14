package tools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class TestLogger {

    public void writeToLogFile(String text, String type){
        try(BufferedWriter bufferedWriter = getWriter()) {
            if(type.equals("log")){
                bufferedWriter.write("<li><div>" + text + "</div></li>\n");
            } else if(type.equals("fail")) {
                bufferedWriter.write("<li><div style='color: red'>" + text + "</div></li>\n");
            }
            System.out.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setLogFileBeginning() {
        try(BufferedWriter bufferedWriter = getWriter()) {
            bufferedWriter.write("<html>\n<head>\n<title>Test log</title>\n</head>\n<body>\n");
            bufferedWriter.write("<div>" + new Date().toString() + "</div>\n<ul>");
            System.out.println("Beginning - Ok");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setLogFileEnding(){
        try(BufferedWriter bufferedWriter = getWriter()) {
            bufferedWriter.write("</ul>\n</body>\n</html>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private BufferedWriter getWriter() throws IOException {
       return new BufferedWriter(new FileWriter(new File("TestLogFile.html"), true));
    }
}

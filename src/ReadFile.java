import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {

    private String fileName;
    private String fileContent;

    public ReadFile(String fileName){
        this.fileName = fileName;
        this.fileContent = "";
    }

    public String getFileContent() throws IOException {

        FileReader fr = new FileReader(this.fileName);
        Scanner scanner = new Scanner(fr);

        while(scanner.hasNextLine()){
            this.fileContent = this.fileContent+scanner.nextLine()+"\n";
        }

        return this.fileContent;
    }
}

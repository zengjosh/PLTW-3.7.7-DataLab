import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Cereal {

  private int highestsugar;
  private int lowestsugar;
  
  public Cereal(int lowestsugar, int highestsugar) {
      this.highestsugar = highestsugar;
      this.lowestsugar = lowestsugar;
  }

  public int gethighestsugar() {
    return highestsugar;
  }

  public int getlowestsugar() {
    return lowestsugar;
  }

  public void sethighestsugar(int newhighestsugar) {
    highestsugar = newhighestsugar;
  }

  public void setlowestsugar(int newlowestsugar) {
    lowestsugar = newlowestsugar;
  } 

  public String toString() {
    return("Lowest Sugar: " + lowestsugar + "\n" + "Highest Sugar: " + highestsugar);
  }
  public static void main(String[] args) {

    ArrayList<Integer> sugarcontent = new ArrayList<Integer>();

    String path = "Copy of Cereal.csv";
    String line = "";
    try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            if (br.ready()) {
              br.readLine();
            }

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                sugarcontent.add(Integer.parseInt(values[8]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    
    Cereal cereal = new Cereal(sugarcontent.get(0), sugarcontent.get(0));
    for (int i = 0; i < sugarcontent.size(); i++) {
      if (sugarcontent.get(i) > cereal.gethighestsugar() && sugarcontent.get(i) >= 0) {
        cereal.sethighestsugar(sugarcontent.get(i));
      }
      if (sugarcontent.get(i) < cereal.getlowestsugar() && sugarcontent.get(i) >= 0) {
        cereal.setlowestsugar(sugarcontent.get(i));
      }
    } 
    System.out.println(cereal);
  }
} 
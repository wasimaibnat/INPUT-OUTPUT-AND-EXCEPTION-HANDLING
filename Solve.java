
Filename:“Test.java”

//import the header files

import java.io.File;

import java.io.FileNotFoundException;

import java.io.PrintWriter;

import java.util.Scanner;

//definition of "Test" class

public class Test

{

    //definition of main method

    public static void main(String[] args)

    {

        //open a file name hello.txt

        try (Scanner in = new Scanner(new File("hello.txt")))

        {

            //read message in string variable

            String message = in.nextLine();

            //display the message

            System.out.println(message);

        }

        //catch block

        catch (FileNotFoundException e)

        {

            //throw an exception

            e.printStackTrace();

        }
        //file auto close at the end by try and catch block

        //try block

        try (PrintWriter out = new PrintWriter("hello.txt"))

        {

            //store the message Hello, World! in the file

            out.println("Hello, World!");

        }

        //catch block

        catch (FileNotFoundException e)

        {

            //throw an exception

            e.printStackTrace();

        }

    }

}
// expected output:: hello world

#########2

Filename:“BlankLinesRemover.java”
// import the header files
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

// definition of "BlankLinesRemover" class
public class BlankLinesRemover
{
    //objective 1 remove definition of "removeLines" class
    public static void removeLines(String fileName)
    {
        //create an object for "ArrayList" class
        ArrayList<String> lines = new ArrayList<>();
        //get the filename in try block
        try (Scanner in = new Scanner(new File(fileName)))
        {
            //check the condition
            while (in.hasNextLine())
            {
                //get the input
                String line = in.nextLine();
                //check the "line" is empty
                if (!line.trim().isEmpty())
                {
                    //add the values
                    lines.add(line);
                }
            }
        }
        //catch block
        catch (FileNotFoundException e)
        {
            //throw an error message
            e.printStackTrace();
        }
        //objective 2 write non blank in the same file again get the filename in try block
        try (PrintWriter out = new PrintWriter(fileName))
        {
            //check the condition
            for (String line: lines)
            {
                //print the output
                out.println(line);
            }
        }
        //catch block
        catch (FileNotFoundException e)
        {
            //throw an error message
            e.printStackTrace();
        }
    }
}Filename:“Test.java”
// import the header files
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

// definition of "Test" class
public class Test {
    // definition of main method
    public static void main(String[] args) {
        // objective 1 remove :call the method with a filename
        BlankLinesRemover.removeLines("lines.txt");
        // declare the variable
        int count = 0;
        // get the file name in try block
        try (Scanner in = new Scanner(new File("lines.txt"))) {
            // check the condition
            while (in.hasNextLine()) {
                // get the input
                in.nextLine();
                // increment the value
                count++;
            }
        }
        // catch block
        catch (FileNotFoundException e) {
            // throw exception
            e.printStackTrace();
        }
        // display the outputs
        System.out.println("Number of non-blank lines: " + count);
        System.out.println("Expected: 10");
    }
}

Sample Output Output:
Input file:“lines.txt”

################3

Filename:“FileTrimmer.java”

// import the header files

import java.io.File;

import java.io.FileNotFoundException;

import java.io.PrintWriter;

import java.util.Scanner;

import java.util.ArrayList;

import java.util.ListIterator;

// definition of "FileTrimmer" class

public class FileTrimmer

{

    //definition of "trimBlankLines" class

    public static void trimBlankLines(String fileName)

    {

        //create an object for "ArrayList" class

        ArrayList<String> lines = new ArrayList<>();

        boolean nonBlankFound = false;

        //get the filename in try block

        try (Scanner in = new Scanner(new File(fileName)))

        {

            //check the condition

            while (in.hasNextLine())

            {

                //get the input

                String line = in.nextLine();

                /*Skip lines until non blank found*/

                if (!line.trim().isEmpty() || nonBlankFound)

                {

                    //set the value

                    nonBlankFound = true;

                    //add the values

                    lines.add(line);

                }

            }

        }

        //catch block

        catch (FileNotFoundException e)

        {

            //throw an error message

            e.printStackTrace();

        }

        //create an object for "ListIterator" class

        ListIterator<String> it = lines.listIterator(lines.size());

        //check the condition

        while (it.hasPrevious() && it.previous().trim().isEmpty())

        {

            /*objective 1 :: remove blank lines at the end of the file*/

            it.remove();

        }

        //objective 1 :: write the remaining line back to the same file get the filename in try block

        try (PrintWriter out = new PrintWriter(fileName))

        {

            //check the condition

            for (String line: lines)

            {

                //print the output

                out.println(line);

            }

        }

        //catch block

        catch (FileNotFoundException e)

        {

            //throw an error message

            e.printStackTrace();

        }

    }

}

Filename:“Test.java”

// import the header files

import java.io.File;

import java.io.FileNotFoundException;

import java.io.PrintWriter;

import java.util.Scanner;

// definition of "Test" class

public class Test

{

    // definition of main method

    public static void main(String[] args)

    {

        // call the method with a filename

        FileTrimmer.trimBlankLines("lines.txt");

        // declare the variable

        int count = 0;

        // get the file name in try block

        try (Scanner in = new Scanner(new File("lines.txt")))

        {

            // check the condition

            while (in.hasNextLine())

            {

                // get the input

                in.nextLine();

                // increment the value

                count++;

            }

        }

        // catch block

        catch (FileNotFoundException e)

        {

            // throw exception

            e.printStackTrace();

        }

        // display the outputs

        System.out.println("Number of non-blank lines: " + count);

        System.out.println("Expected: 12");

    }

}

Number of non-blank lines:10 Expected:10

#############4

Filename:“LineNumbers.java”
// import the header files
import java.io.*;import java.util.Scanner;

// definition of "LineNumbers" class
public class LineNumbers {
    // definition of main method
    public static void main(String[] args) {
        // create an object for "Scanner" class
        Scanner in = new Scanner(System.in);
        // get the input file name
        System.out.print("Please enter the file name for input: ");
        String filename1 = in.next();
        // get the output file name
        System.out.print("Please enter the file name for output: ");
        String filename2 = in.next();
        // objective 1 :: read text file and send it to out file and also line number
        // try block
        try (Scanner inFile = new Scanner(new File(filename1)); PrintWriter out = new PrintWriter(filename2)) {
            // declare the variable and set the value
            int count = 1;
            // check the condition
            while (inFile.hasNext()) {
                // add the "/* */" to the line
                out.println("/* " + count + " */ " + inFile.nextLine());
                // increment the value
                count++;
            }
        }
        // catch block
        catch (FileNotFoundException e) {
            // display an error message
            System.out.println("File not found!");
        }
    }
}

Sample Output Output:
Please enter
the file name for input:
input.txt Please
enter the
file name for output:
output.txt
        Input file:“input.txt”

Input file:“output.txt”

##########5

Filename:“Test.java”

// import the header files

import java.io.*;

import java.util.Scanner;

// definition of "LineNumbers" class

public class LineNumbers

{

    // definition of main method

    public static void main(String[] args)

    {

        // create an object for "Scanner" class

        Scanner in = new Scanner(System.in);

        // objective 1 if user specify fileneme in command line declare the variable and
        // set the value

        String filename1 = null;

        // check "args" length is 1

        if (args.length == 1)

        {

            // set the value

            filename1 = args[0];

        }

        // objective 2 otherwise prompt the user for name

        else

        {

            // get the input file name from the user

            System.out.print("Please enter the file name for input: ");

            filename1 = in.next();

        }

        // get the output file name

        System.out.print("Please enter the file name for output: ");

        String filename2 = in.next();

        // try block

        try (Scanner inFile = new Scanner(new File(filename1)); PrintWriter out = new PrintWriter(filename2))

        {

            // declare the variable and set the value

            int count = 1;

            // check the condition

            while (inFile.hasNext())

            {

                // add the "/* */" to the line

                out.println("/* " + count + " */ " + inFile.nextLine());

                // increment the value

                count++;

            }

        }

        // catch block

        catch (FileNotFoundException e)

        {

            // display an error message

            System.out.println("File not found!");

        }

    }

}

#############6

Filename:“AverageColumns.java”
// import the header files
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// definition of "AverageColumns" class
public class AverageColumns {
    // definition of main method
    public static void main(String[] args) {
        // create an object for "Scanner" class
        Scanner in = new Scanner(System.in);
        // objective ask user for file name get the input file name
        System.out.print("Please enter the file name: ");
        String filename = in.next();
        // objective read file having 2 columns try block
        try (Scanner inFile = new Scanner(new File(filename))) {
            /* declare the variables and set the values */
            double sum1 = 0.0;
            double sum2 = 0.0;
            int count = 0;
            // check the condition
            while (inFile.hasNextDouble()) {
                // calculate the "sum1" and "sum2"
                sum1 += inFile.nextDouble();
                sum2 += inFile.nextDouble();
                // increment the value
                count++;
            }
            // objective 3 print average of each columns display the outputs
            System.out.println("Average of column 1: " + sum1 / count);
            System.out.println("Average of column 2: " + sum2 / count);
        }
        // catch block
        catch (FileNotFoundException e) {
            // display an error message
            System.out.println("File not found!");
        }
    }
}Step 4>

Sample Output Output:
Please enter
the file name:
input.txt
        Average
of column 1:4.787999999999999
Average of column 2:5.247999999999999
Input file:“input.txt”

#################
7

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// Class
class GFG { // Fundamental driver technique
    public static void main(String[] args) //
    {
        attempt
        {
            FileReader fr = new FileReader("gfgInput.txt");
            // Creating a FileWriter object
            FileWriter fw = new FileWriter("gfgOutput.txt");
            String str = "";
            int i;
            while ((i = fr.read()) != -1)
            {     // Storing every character in the string
                str += (char)i;
            }
            // Print and show the string that    // contains record information
            System.out.println(str);    // Writing above string data to    // FileWriter object
            fw.write(str); // Shutting the record utilizing close() strategy
            fr.close();
            fw.close();    // Display message
            System.out.println(  "File reading and writing both done");
        }
        // Catch block to handle the exception
    catch (IOException e)
        {    // If there is no file in specified path
            System.out.println(     "There are some IOException");
        }

    }
}

#######

programming projects

########1

// include the required header files
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

// definition of "BabyNames" class
public class BabyNames {
    // definition of "processName" method
    public static String processName(Scanner in) {
        // get the inputs
        String name = in.next();
        int count = in.nextInt();
        double percent = in.nextDouble();
        // return the names
        return name;
    }

    // definition of main method
    public static void main(String[] args) {
        // objective 1 read baynames.txt try block
        try (Scanner in = new Scanner(new File("babynames.txt"));
                PrintWriter boyOut = new PrintWriter("boynames.txt");
                PrintWriter girlOut = new PrintWriter("girlnames.txt")) {
            // check the condition
            while (in.hasNextInt()) {
                // get the input
                int rank = in.nextInt();
                // objective 2create 2 sepearate boy nad girl names.txt try block
                /* call the "processName" method and write the boy names */
                boyOut.println(processName(in));
                /* call the "processName" method and write the girl names */
                girlOut.println(processName(in));
            }
            // display the message
            System.out.println("The program runs successfully");
        }
        // catch block
        catch (IOException e) {
            // exception
            e.printStackTrace();
        }
    }
}

Sample Output
Input filename:“babynames.txt”

Output:
The program
runs successfully
Output filename:“boynames.txt”

Output filename:“girlnames.txt”

#######2

// include the required header files

import java.io.File;

import java.io.IOException;

import java.util.ArrayList;

import java.util.Scanner;

// definition of "DualGenderNames" class

public class DualGenderNames

{

    //definition of "processName" method

    public static String processName(Scanner in)

    {

        //get the inputs

        String name = in.next();

        int count = in.nextInt();

        double percent = in.nextDouble();

        return name;

    }

    //definition of "printSameNames" method

    public static void printSameNames(ArrayList<String> boyNames, ArrayList<String> girlNames)

    {

        //iterate for boy names

        for (String name : boyNames)

        {

            //iterate for girl names

            if (girlNames.contains(name))

            {

                //display the names

                System.out.println(name);

            }

        }

    }

    //definition of main method

    public static void main(String[] args)

    {

        //try block

        try (Scanner in = new Scanner(new File("babynames.txt")))

        {

            //create the objects for boy and girl names

            ArrayList<String> boyNames = new ArrayList<String>();

            ArrayList<String> girlNames = new ArrayList<String>();

            //check the condition

            while (in.hasNextInt())

            {

                //get the input

                int rank = in.nextInt();

                /*call the "processName" method and write the boy names */

                boyNames.add(processName(in));

                /*call the "processName" method and write the girl names */

                girlNames.add(processName(in));

            }

            ////objective 1 print  names that are both boy and girls name call the method

            printSameNames(boyNames, girlNames);

        }

        //catch block

        catch (IOException e)

        {

            //exception

            e.printStackTrace();

        }

    }

}

############3

Program:
// import the required header files
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

// definition of "WebGet" class
public class WebGet {
    // definition of "dumpScannerToFile" method
    public static void dumpScannerToFile(Scanner in, String filename) {
        // objective 2 write all data from url web page to a file try block
        try (PrintWriter outfile = new PrintWriter(filename)) {
            // check the condition
            while (in.hasNextLine()) {
                // get the file name from the user
                String line = in.nextLine();
                // write the content to the file
                outfile.println(line);
            }
        }
        // catch block
        catch (FileNotFoundException e) {
            // display an error message
            System.out.println("Cannot write to file " + filename);
        }
    }

    // definition of main method
    public static void main(String[] args) {
        // create an object for "Scanner" class
        Scanner console = new Scanner(System.in);
        // get the url from the user
        System.out.println("Enter the url to scan: ");

        String url = console.nextLine();
        // get the file name from the user
        System.out.println("Enter the file to write to: ");
        String fileName = console.nextLine();
        // create an object for "URL"
        URL locator;

        // try block
        try {
            // create an object for "URL"
            locator = new URL(url);
            // objective1 read all data from url web page try block
            try (Scanner in = new Scanner(locator.openStream())) {
                // call the method
                dumpScannerToFile(in, fileName);
            }
            // catch block
            catch (IOException e) {
                // display an error message
                System.out.println("IO Exception!");
            }
        }
        // catch block
        catch (MalformedURLException e) {
            // display an error message
            System.out.println("Invalid URL.");
        }
    }
}

Sample Output Output:
Enter the
url to scan:http:// horstmann.com/index.html
Enter the
file to
write to:
output.txt
        Output filename:“output.txt”

##########4

Filename:“CSVReader.java”
// import the header files
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

// definition of "CSVReader" class
public class CSVReader
{
    //declare the private variable
    private ArrayList<String> rows;
    //definition of constructor
    public CSVReader(String fileName)
    {
        //create an object
        rows = new ArrayList<>();
        // objective 1 read csv file try block
        try (Scanner inFile = new Scanner(new File(fileName)))
        {
            //check the condition
            while (inFile.hasNext())
            {
                //add the lines in the "rows"
                rows.add(inFile.nextLine());
            }
        }
        //catch block
        catch (FileNotFoundException e)
        {
            //display the statement
            System.out.println("File not found!");
        }
    }
    // objective 2 provide methods numberOfRows() numberOfFields()  public String field()
    //definition of "numberOfRows" method
    public int numberOfRows()
    {
        //return the value
        return rows.size();
    }
    //definition of "numberOfFields" method
    public int numberOfFields(int row)
    {
        //check the condition
        if (row < 0 || row >= rows.size())
        {
            //throw an exception
            throw new IllegalArgumentException("Row: " + row);
        }
        //return the value
        return getFields(row).size();
    }
    //definition of "getFields" method
    private ArrayList<String> getFields(int row)
    {
        //create an object for "ArrayList"
        ArrayList<String> fields = new ArrayList<>();
        //create an object for "Scanner" class
        Scanner line = new Scanner(rows.get(row));
        //use "," to separate the words
        line.useDelimiter(",");
        //check the condition
        while (line.hasNext())
        {
            //trim the string
            String field = line.next().trim();
            //check the condition
            if (field.startsWith("\""))
            {
                //check the condition
                while (!field.endsWith("\""))
                {
                    // append comma-separated fields
                    field = field + "," + line.next();
                }
                // remove quotes
                field = field.substring(1,field.length() - 1);
            }
            //replace all the "\\" by "\"
            field = field.replaceAll("\"\"","\"");
            //add the "field" to the "fields"
            fields.add(field);
        }
        //return the value
        return fields;
    }
    //definition of "field" method
    public String field(int row, int column)
    {
        //check the condition
        if (row < 0 || row >= rows.size())
        {
            //throw an "IllegalArgumentException"
            throw new IllegalArgumentException("Row: " + row);
        }
        //check the condition
        if (column < 0 || column >= numberOfFields(row))
        {
            //throw an "IllegalArgumentException"
            throw new IllegalArgumentException("Column: " + column);
        }
        //return the value
        return getFields(row).get(column);
    }
}Filename:“CSVReaderTester.java”

// definition of "CSVReaderTester" class
public class CSVReaderTester {
    // definition of main method
    public static void main(String[] args) {
        // create the objects for the "CSVReader" class
        CSVReader reader1 = new CSVReader("att2007.csv");
        CSVReader reader2 = new CSVReader("quotes.csv");
        // display the number of rows
        System.out.println("Number of rows: " + reader1.numberOfRows());
        // display the expected number of rows
        System.out.println("Expected: 214");
        // display the number of fields in row 10
        System.out.println("Number of fields in row 10: " + reader1.numberOfFields(10));
        // display the expected number of fields in row 10
        System.out.println("Expected: 7");
        // display the row 10 and column 2
        System.out.println("Row 10, Col 2: " + reader1.field(10, 2));
        // display the expected row 10 and column 2
        System.out.println("Expected: 24.95");
        // display the number of rows
        System.out.println("Number of rows: " + reader2.numberOfRows());
        // display the expected number of rows
        System.out.println("Expected: 2");
        // display the number of fields in row1
        System.out.println("Number of fields in row 1: " + reader2.numberOfFields(1));
        // display the expected number of fields in row1
        System.out.println("Expected: 4");
        // display the rows 1 and column 2
        System.out.println("Row 1, Col 2: " + reader2.field(1, 2));
        // display the expected rows 1 and column 2
        System.out.println("Expected: Hello, World");
        // display the rows 1 and column 3
        System.out.println("Row 1, Col 3: " + reader2.field(1, 3));
        // display the expected rows 1 and column 3
        System.out.println("Expected: He asked: \"Quo vadis?\"");
        // display the rows 0 and column 3
        System.out.println("Row 0, Col 3: " + reader2.field(0, 3));
        // display the statement
        System.out.println("Expected: \"..., that all men are created equal, ...\"");
    }
}

Sample Output
Input files:“att2007.xlsx”

“quotes.xlsx”

Output:
Number of rows:214 Expected:214
Number of
fields in row 10:7 Expected:7 Row 10,Col 2:24.95 Expected:24.95
Number of rows:2 Expected:2
Number of
fields in row 1:4 Expected:4 Row 1,Col 2:Hello,
World
        Expected:Hello,
World
        Row 1,Col 3:
He asked:"Quo vadis?"Expected:
He asked:"Quo vadis?"Row 0,Col 3:"..., that all men are created equal, ..."Expected:"..., that all men are created equal, ..."

############5

Filename:“CSVReader.java”

// import the header files

import java.util.ArrayList;

import java.util.Scanner;

import java.io.*;

// definition of "CSVReader" class

public class CSVReader

{

    //declare the private variable

    private ArrayList<String> rows;

    //definition of constructor

    public CSVReader(String fileName)

    {

        //create an object

        rows = new ArrayList<>();

        //try block

        try (Scanner inFile = new Scanner(new File(fileName)))

        {

            //check the condition

            while (inFile.hasNext())

            {

                //add the lines in the "rows"

                rows.add(inFile.nextLine());

            }

        }

        //catch block

        catch (FileNotFoundException e)

        {

            //display the statement

            System.out.println("File not found!");

        }

    }

    //definition of "numberOfRows" method

    public int numberOfRows()

    {

        //return the value

        return rows.size();

    }

    //definition of "numberOfFields" method

    public int numberOfFields(int row)

    {

        //check the condition

        if (row < 0 || row >= rows.size())

        {

            //throw an exception

            throw new IllegalArgumentException("Row: " + row);

        }

        //return the value

        return getFields(row).size();

    }

    //definition of "getFields" method

    private ArrayList<String> getFields(int row)

    {

        //create an object for "ArrayList"

        ArrayList<String> fields = new ArrayList<>();

        //create an object for "Scanner" class

        Scanner line = new Scanner(rows.get(row));

        //use "," to separate the words

        line.useDelimiter(",");

        //check the condition

        while (line.hasNext())

        {

            //trim the string

            String field = line.next().trim();

            //check the condition

            if (field.startsWith("\""))

            {

                //check the condition

                while (!field.endsWith("\""))

                {

                    // append comma-separated fields

                    field = field + "," + line.next();

                }

                // remove quotes

                field = field.substring(1,field.length() - 1);

            }

            //replace all the "\\" by "\"

            field = field.replaceAll("\"\"","\"");

            //add the "field" to the "fields"

            fields.add(field);

        }

        //return the value

        return fields;

    }

    //definition of "field" method

    public String field(int row, int column)

    {

        //check the condition

        if (row < 0 || row >= rows.size())

        {

            //throw an "IllegalArgumentException"

            throw new IllegalArgumentException("Row: " + row);

        }

        //check the condition

        if (column < 0 || column >= numberOfFields(row))

        {

            //throw an "IllegalArgumentException"

            throw new IllegalArgumentException("Column: " + column);

        }

        //return the value

        return getFields(row).get(column);

    }

}

Filename:“CSVcolumnSummary.java”

// definition of "CSVcolumnSummary" class

public class CSVcolumnSummary

{

    // declare the private variable

    private CSVReader reader;

    // definition of constructor

    public CSVcolumnSummary(String fileName)

    {

        // create an object for "CSVReader" class

        reader = new CSVReader(fileName);

    }

    // definition of "columnAvg" method

    public double columnAvg(int col)

    {

        // declare the variable

        double sum = 0;

        // iterate "row" until it reaches the declared value

        for (int row = 0; row < reader.numberOfRows(); ++row)

        {

            // calculate the sum

            sum += Double.parseDouble(reader.field(row, col));

        }

        // return the average

        return sum / reader.numberOfRows();

    }

    // definition of "columnMin" method

    public double columnMin(int col)

    {

        // declare the variable

        doublemin = Double.parseDouble(reader.field(0, col));

        // iterate "row" until it reaches the declared value

        for (int row = 1; row < reader.numberOfRows(); ++row)

        {

            // declare the variable

            double value = Double.parseDouble(reader.field(row, col));

            // check "value" is less than "min"

            if (value < min)

            {

                // set the value

                min = value;

            }

        }

        // return the value

        return min;

    }

    // definition of "columnMax" method

    public double columnMax(int col)

    {

        // declare the variable

        double max = Double.parseDouble(reader.field(0, col));

        // iterate "row" until it reaches the declared value

        for (int row = 1; row < reader.numberOfRows(); ++row)

        {

            // declare the variable

            double value = Double.parseDouble(reader.field(row, col));

            // check "value" is greater than "min"

            if (value > max)

            {

                // set the value

                max = value;

            }

        }

        // return the value

        return max;

    }

}

Filename:“CSVcolumnSummaryTester.java”

// definition of "CSVcolumnSummaryTester" class

public class CSVcolumnSummaryTester

{

    //definition of main method

    public static void main(String[] args)

    {

        //create an object for the "CSVcolumnSummary" class

        CSVcolumnSummary summary = new CSVcolumnSummary("att2007.csv");

        //display an average volume

        System.out.printf("The avg volume is: %.2f\n", summary.columnAvg(5));

        //display an expected average volume

        System.out.println("Expected: 166560.75");

        //display the minimum price

        System.out.printf("The min volume is: %.2f\n", summary.columnMin(5));

        //display an expected minimum price

        System.out.println("Expected: 22100.00");

        //display the maximum price

        System.out.printf("The max volume is: %.2f\n", summary.columnMax(5));

        //display an expected maximum price

        System.out.println("Expected: 8841040.00");

        //display an average price

        System.out.printf("The avg price is: %.2f\n", summary.columnAvg(6));

        //display an expected average price

        System.out.println("Expected: 22.63");

        //display the minimum price

        System.out.printf("The min price is: %.2f\n", summary.columnMin(6));

        //display an expected minimum price

        System.out.println("Expected: 20.77");

        //display the maximum price

        System.out.printf("The max price is: %.2f\n", summary.columnMax(6));

        //display an expected maximum price

        System.out.println("Expected: 23.73");

    }

}


package parser.test_case;

import java.io.IOException;
import java.lang.String;
import java.util.regex.Pattern;

import javax.sound.midi.InvalidMidiDataException;

import javax.sound.midi.MidiUnavailableException;



/**
 *
 * @author armin
 */
public class ParserTest_Case {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Parser for the big Project "SEQUENCER"
        
        String CommandoX = "Readmidi strasszarathustra.mid";    //"Query String", just for this programm
        String[] Echo = null;
        try
        {
            Echo = Parser(CommandoX);                           //Activate the Parser
         
        }
        catch (IOException e) 
        {
            System.out.println("Error, IOException");          //Safety First
            
        }
        
        if (Echo[0] == null)                        
        {
            System.out.println("NULL, Check the Parser");       //By recieving null we know somethings wrong with the main parser component 
        }
        
        System.out.println("Commando for Action" + Echo[0]);    //Displaying the information
        System.out.println("The necessary information... " + Echo[1]);
        
                
    }
    public static String[] Parser(String CommandoAll) throws IOException
    { 
        String[] FinCommando = new String[100];
        if(!((CommandoAll == null) || (CommandoAll == "")))     //Objects.quals() should be used in the new Version
        {
             
            
            String[] CMSplit = CommandoAll.split("\\s+");       //Splitting the array and making sure its not too big 
            if (CommandoAll.length() > 1000)
            {
                System.out.println("Array way too big");
            }
        
            boolean b = Pattern.matches("[a-zA-Z%]{3,20} [a-zA-Z0-9/.:]{1,60}", CommandoAll);   //analyzing for the right characters
            assert b : "false";
            if (b == true) {
                FinCommando = CMSplit;                          //After passing the pattern check get variable back up the main
            } else {
                FinCommando = null;
            }

            return FinCommando;                                 //Return the variable
        }
        else 
        {
            System.out.println("Nothing found, sorry");
            FinCommando[0] = null; 
            
        }
        return FinCommando;                                     //return 
    }
    
}
    



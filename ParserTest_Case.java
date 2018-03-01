
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
        
        String CommandoX = "Readmidi strasszarathustra.mid";
        String[] Echo = null;
        try
        {
            Echo = Parser(CommandoX);
         
        }
        catch (IOException e) 
        {
            System.out.println("Fehler, IOException");
            
        }
        
        if (Echo[0] == null)
        {
            System.out.println("NULL");
        }
        
        System.out.println("Commando for Action" + Echo[0]);
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
                System.out.println("Array zu gross");
            }
        
            boolean b = Pattern.matches("[a-zA-Z%]{3,20} [a-zA-Z0-9/.:]{1,60}", CommandoAll);   //analyzing the splitted 
            assert b : "false";
            if (b == true) {
                FinCommando = CMSplit;
            } else {
                FinCommando = null;
            }

            return FinCommando;                           //Splite nach Space 
        }
        else 
        {
            System.out.println("Nichts im Kommando vorhanden");
            FinCommando[0] = null; 
            
        }
        return FinCommando;                                                     //return 
    }
    
}
    



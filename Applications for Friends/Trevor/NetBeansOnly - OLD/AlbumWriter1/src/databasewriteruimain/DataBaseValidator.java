/* @author Thomas Ibarra
 */

package databasewriteruimain;


public class DataBaseValidator {

    private String processable;
    private boolean parameters[];

    public DataBaseValidator(){
        processable = "";
        parameters = null;
    }
    public DataBaseValidator(String processable){
        this.processable = processable;
        this.parameters = null;
    }
    public DataBaseValidator(String processable, boolean params[]){
        this.processable = processable;
        this.parameters = params;
    }
    private boolean checkEmpty(){
        if(this.processable.isEmpty()) return true;
        else return false;
    }
    public void validate() throws Exception {
        if(!checkEmpty()){

        } else {
            Exception empty_error = new Exception("Empty String: compiler is unable to complete task.");
        }
    }

    
    public void setProcessable(String processable){ this.processable = processable; }
    public String getProcessable(){ return processable; }
    public void setParams(boolean params[]){ this.parameters = params; }
    public boolean[] getParams(){ return parameters; }
}

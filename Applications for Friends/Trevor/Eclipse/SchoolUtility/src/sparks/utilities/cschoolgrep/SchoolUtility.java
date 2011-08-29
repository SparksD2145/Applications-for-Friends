package sparks.utilities.cschoolgrep;
import java.io.*;
import java.util.*;
import java.net.*;

/* SchoolUtility
	-Developed by-
		Thomas Ibarra
*/

@SuppressWarnings({ "serial", "rawtypes" })
public class SchoolUtility extends ArrayList{
	
	// vars
	private File workingdir;
	private int numberfiles;
	
	private ArrayList<File> tree;
	private ArrayList<File> tree_fixed;
	
	private String dirpaths[] = {"_SchoolUtil", "_SchoolUtil/filetree", 
								"" /*_SchoolUtil/sql_files"*/ ,"_SchoolUtil/filetree/tree.dat", 
								"" /*_SchoolUtil/sql_files/result.sql*/ ,"_SchoolUtil/dupli", 
								"_SchoolUtil/filetree/fixed_tree.dat","_SchoolUtil/log",
								"_SchoolUtil/log/log_complete.dat","_SchoolUtil/log/log_successful.dat",
								"_SchoolUtil/log/log_error.dat"};
	private int treei = 3;
	//private int sqli = 4;
	private int cpydtree = 5;
	private int ftreei = 6;
	
	FileWriter logall;
	FileWriter logworking;
	FileWriter logerror;
	
	private String wrkdirpth;
	
	private File dirs[];
	
	private boolean suppressFirstPass;
	
	// Construct
	public SchoolUtility(){ 
		try{
			workingdir = (new File(new URI(getClass().getProtectionDomain().getCodeSource().getLocation().toString()))).getParentFile();
			numberfiles = 0;
			
			tree = new ArrayList<File>();
			tree_fixed = new ArrayList<File>();
			
			
			wrkdirpth = workingdir.getAbsolutePath() + "/";
			
			suppressFirstPass = true;
			
		} catch(Exception e) {
			message("Failure to initialize. : " + e.getMessage());
		}
	}
	private void message(String msg){
		System.out.println(msg);
		if(logall != null && logworking != null){
			try{
				logall.write(msg+"\r\n");
				logworking.write(msg+"\r\n");
			} catch (Exception e){
				// do not report
			}
		}
	}
	private void error(String err){
		System.out.println(err);
		if(logall != null && logerror != null){
			try{
				logall.write(err+"\r\n");
				logerror.write(err+"\r\n");
			} catch (Exception e){
				// do not report
			}
		}
	}
	public void buildOutputDirs(){
		int buff = 0;
		for(String n : dirpaths){
			if(!n.isEmpty()){
				dirpaths[buff] = (wrkdirpth + n.toString());
				message("Built: "+dirpaths[buff]);
				
				
			}
			buff++;
		}
		
		dirs = new File[dirpaths.length];
		int i = 0;
		
		
		for(String current : dirpaths){
			dirs[i] = new File(current);
			i++;
		}
		for(File current : dirs){
			if(!current.exists()){
				try{				
					if(current.getName().lastIndexOf(".")<0){
						current.mkdir();
					} else if (current.getName().lastIndexOf(".")>=0){
						current.createNewFile();
					} else {
						error("ohgoderrorwtf");
					}
				} catch (IOException e){
					error("ERROR: " + e.getMessage());
				}
			}
		}
	}
	public void process(){
		if(workingdir.isDirectory() && checkPermissions(workingdir)){
			//Pass 1
			for(File c : workingdir.listFiles()){
				searchTree(c);
			}
			
			tree.clear();
			suppressFirstPass = false;
			numberfiles = 0;
			System.gc();
			
			// Pass 2
			for(File c : workingdir.listFiles()){
				searchTree(c);
			}
		} else {
			error("Location invalid: Parent not a directory.");
		}
	}
	private void searchTree(File current){
		if(current.isDirectory() && (current.getName().lastIndexOf("SchoolUtil") < 0)){
			if(checkPermissions(current)){
				numberfiles++;
				
					
				tree.ensureCapacity(numberfiles);
				tree.add(current);
				for(File content : current.listFiles()){
					
					searchTree(content);
					
				}
			}
		} else if(current.isFile()) {
				File fixed = checkDescriptor(current);
				if(fixed != null){
					numberfiles++;
					tree.ensureCapacity(numberfiles);
					tree.add(fixed);
					if(!suppressFirstPass){message("File added: "+ fixed.toString()); }
				} else {
					if(!suppressFirstPass){message("File ignored: " + current.getAbsolutePath());}
				}
		} else {
			if(!suppressFirstPass){error("Error: Unknown file. ("+current.toString()+")");}
		}
	}
	public void printTree(){
		try{
			FileWriter treew = new FileWriter(dirs[treei]);

			for(File f : tree){
				treew.write(f.toString().replace('\\', '/')+"\r\n");
				message("[Writing FileTree] File Added: "+f.toString().replace('\\', '/'));
			}
			treew.close();
			tree.clear();
			tree = null;
			System.gc();
		} catch (Exception e){
			error("Error: "+e.getMessage());
		}
	}
	public void correctTree(){
		try{
			FileReader input = new FileReader(dirpaths[treei]);
			BufferedReader r = new BufferedReader(input);
			
			FileWriter w = new FileWriter(dirs[ftreei]);
			FileWriter finalw = new FileWriter(new File(this.getWorkingDir()+File.separator+"biglistofstuff.txt"));
			
			String buffer = r.readLine();
			
			while(buffer != null){
				File old = new File(buffer);
				
				String test = dirpaths[cpydtree];
				String dest = test + buffer.substring(wrkdirpth.length()-1);
				
				if(!dest.equalsIgnoreCase(wrkdirpth)){
				
					File current = new File(dest);
					w.write(dest.replace('\\', '/')+"\r\n");
					buildTree(current);
					
					message("Created: " + dest);
					
					if(!old.isDirectory()){
					
						FileReader input2 = new FileReader(old);
						BufferedReader r2 = new BufferedReader(input2);
					
						FileWriter w2 = new FileWriter(current);
			
						String buffer2= r2.readLine();
					
						while(buffer2 != null){
							w2.write(buffer2+"\r\n");
							buffer2 = r2.readLine(); 
						}
						
						r2.close();
						w2.close();
						String usable = trimUnusable(current);
						tree_fixed.add(current);
						finalw.write(usable+"\r\n");
					}
				}
				buffer = r.readLine();
			}
			r.close();
			w.close();
			finalw.close();
			System.gc();
		
		} catch (Exception e) {
			error("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
	private void buildTree(File current){
		try{
			if(current.getName().lastIndexOf(".") < 0){
				if(checkPermissions(current.getParentFile())){		
					current.mkdir();
				}
			} else if(current.getName().lastIndexOf(".") >= 0) {
				if(checkPermissions(current.getParentFile())){		
						current.createNewFile();
						message("Generated: " + current.toString());
					} else {
						error("Write error: " + current.getAbsolutePath());
					}
			} else {
				error("Error: Unknown file. ("+current.toString()+")");
			}
		} catch (Exception e){
			error("Error: " + e.getMessage());
		}
	}
	public String trimUnusable(File f){
		String returndata = "";
		try{
			ArrayList<String> contents = new ArrayList<String>();
			FileReader input = new FileReader(f);
			BufferedReader r = new BufferedReader(input);
			String buffer = r.readLine();
			
			while(buffer != null){
				contents.add(buffer);
				buffer = r.readLine();
			}
			
			r.close();
					
			for(String c1 : contents){
				String c = c1.trim();
				if(c.contains(("<h2 style=").subSequence(0,10))){
					if(!c.contains(("About ").subSequence(0,6)) && !c.contains(("Student Diversity").subSequence(0,17)) &&
						!c.contains(("Grade Levels").subSequence(0,12)) && !c.contains(("More information about").subSequence(0,22))
						&& !c.contains(("Are you this school").subSequence(0,19)) && !c.contains(("padding").subSequence(0,7))){
							returndata = (c.substring(28, c.lastIndexOf("</h2>")));	
					}
				}
				if(c.contains(("color:#5d6d6e; float:left;").subSequence(0,26)) && c.contains(("<br />").subSequence(0,6))){
						returndata += (" "+c.substring(39, c.lastIndexOf("<br />")));
				}
				
			}
			message("Junk Removed from file: " + f.getAbsolutePath());
		} catch (Exception e){
			error("Unable to remove junk from file ("+e.getMessage()+"): " + f.getAbsolutePath());
		}
		return returndata;
	}
	
	public File checkDescriptor(File f){
		if(!f.isDirectory()){
			try {
				FileReader input = new FileReader(f);
				BufferedReader r = new BufferedReader(input);
				String doctype = r.readLine();
				r.close();
				
				if(doctype.substring(0,9).equalsIgnoreCase("<!DOCTYPE") && !(f.getName().lastIndexOf(".") >= 0)){
					if(f.renameTo(new File(f.getAbsoluteFile() + ".html"))){
						message("File extension reset successful: " + f.getAbsoluteFile());
						return f;
					} else {
						error("File extension reset failed: " + f.getAbsoluteFile());
						return null;
					}
				} else if(doctype.substring(0,9).equalsIgnoreCase("<!DOCTYPE") && (f.getName().lastIndexOf(".htm") >= 0)){
					message("File compatible: " + f.getAbsoluteFile());
					return f;
				} else {
					return null;
				}
				  
			}catch (ArrayIndexOutOfBoundsException e){
					return null;
			}catch (Exception e){
				return null;
			}
		} else {
			return null;
		}
	}
	
	
	private boolean checkPermissions(File dir){
		if(dir.canRead() && dir.canWrite()){ 
			return true; 
		} else { return false; }
	}
	
	public String getWorkingDir(){
		return workingdir.toString();
	}
	
	public void generateLogs(){
		try{
			logall = new FileWriter(new File(dirpaths[8]));
			logworking = new FileWriter(new File(dirpaths[9]));
			logerror = new FileWriter(new File(dirpaths[10]));
		} catch (Exception e){
			error("Logs could not be generated: "+ e.getMessage());
			e.printStackTrace();
		}
	}
	public void closeLogs(){
		try{
			logall.close();
			logworking.close();
			logerror.close();
		} catch (Exception e){
			error("Logs could not be closed: "+ e.getMessage());
		}
	}
}

class Executor{
	@SuppressWarnings({ "static-access" })
	public static void main(String args[]){
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		SchoolUtility su = new SchoolUtility();

		for(int y = 0; y < 1; y++){for(int x = 0; x < 50; x++){System.out.print("-");}System.out.println();}
		
		for(int y = 0; y < 1; y++){	for(int x = 0; x < 17; x++){System.out.print("-");}
			System.out.print(" School Utility ");
		}for(int y = 0; y < 1; y++){	for(int x = 0; x < 17; x++){System.out.print("-");}	System.out.println();}
		
		for(int y = 0; y < 1; y++){	for(int x = 0; x < 50; x++){System.out.print("-");}	System.out.println();}
		
		for(int y = 0; y < 1; y++){for(int x = 0; x < 7; x++){System.out.print("-");}System.out.print("      Developed by SparksD2145      ");}
		for(int y = 0; y < 1; y++){for(int x = 0; x < 7; x++){System.out.print("-");}System.out.println();}
		for(int y = 0; y < 1; y++){for(int x = 0; x < 7; x++){System.out.print("-");}System.out.print("          (my fingers hurt)         ");}
		for(int y = 0; y < 1; y++){for(int x = 0; x < 7; x++){System.out.print("-");}System.out.println();}
		for(int y = 0; y < 1; y++){for(int x = 0; x < 50; x++){System.out.print("-");}System.out.println();}
		for(int y = 0; y < 1; y++){for(int x = 0; x < 50; x++){System.out.print("-");}System.out.println();}
		
		System.out.println("");System.out.println("");
		try{Thread.currentThread().sleep(2500);}catch(InterruptedException e){ /* do not report */ }
		
		su.buildOutputDirs();
		su.generateLogs();
		su.process();
		su.printTree();
		su.correctTree();		
		su.closeLogs();
	}
}
import java.io.File;
import java.io.IOException;
import javax.swing.JTextArea;

import org.apache.commons.io.FileUtils;


public class CopyFiles {
	public static void Go (String source , String dest , String FileType , JTextArea txtarea ) throws IOException{
		String[] Files = FindSubFilesOrFolders.Files(source);
		String FilePath;
		if(Files != null){
			System.out.println(source.toLowerCase());
			System.out.println(source.indexOf(dest.substring(13).toLowerCase()));
			if(source.indexOf(dest.substring(13).toLowerCase()) == (-1)){
				for(int i =0 ; i<Files.length ; i++){
					FilePath = source + Files[i];
					System.out.println(FilePath);
					String ext;
					int location0 = 0;
					int location1 = 1;
					while(location0 >= 0){
						if(location0 == 0){
							location0 = 1;
							location1 = FileType.indexOf(";");
							if(location1 !=(-1)){
								ext = FileType.substring(0,location1);
							}else{
								ext = FileType;
							}
							
						}else{
							location0 = FileType.indexOf(";", location0+1);
							location1 = FileType.indexOf(";",location0+1);
							if(location0 == (-1)){
								break;
							}
							if(location1 == (-1)){
								ext = FileType.substring(location0+1);
							}else{
								ext = FileType.substring(location0+1 ,location1);
							}
						}
						System.out.println(ext.toLowerCase() + " " + Files[i].substring(Files[i].length()-3).toLowerCase());
						if(ext.toLowerCase().equals(Files[i].substring(Files[i].length()-3).toLowerCase())){
							txtarea.insert(FilePath + "\n", 0);
							txtarea.update(txtarea.getGraphics());
							File SourceFile = new File(source + "\\" + Files[i]);
							File DestFile = new File(dest + "\\" + Files[i]);
							FileUtils.copyFile(SourceFile, DestFile, true);
						}	
					}
				}
			}
		}
		//get folder list and for each folder do the same shit
		String[] Folders = FindSubFilesOrFolders.Folders(source);
		if(Folders != null){
			for(int i =0 ; i<Folders.length ; i++){
				CopyFiles.Go(source + Folders[i] + "\\" , dest + Folders[i] + "\\" , FileType , txtarea);
			}
		}
	}

}

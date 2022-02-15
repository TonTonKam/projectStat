package servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import controller.ImageDao;

/**
 * Servlet implementation class Upload
 */
@WebServlet("/upload")
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ImageDao id = new ImageDao();

    public Upload() {
        super();
        // TODO Auto-generated constructor stub
    }

    /*
     * https://www.guru99.com/jsp-file-upload-download.html
     * https://www.tutorialspoint.com/jsp/jsp_file_uploading.htm
     */
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	try {
			request.setAttribute("listImg", id.listImages());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	request.getRequestDispatcher("upload.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //fonction d'ajout de fichier
    	if(ServletFileUpload.isMultipartContent(request)){
            try {
                List <FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        String name = new File(item.getName()).getName();
                        //modifier adress entre le portable et la tour
                        item.write( new File("E:\\afpa travail\\JEE\\projectStat\\src\\main\\webapp\\profil" + File.separator + name));
                    }
                }
               //File uploaded successfully
               request.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
               request.setAttribute("message", "File Upload Failed due to " + ex);
            }         		
        }else{

            request.setAttribute("message","No File found");
        } // fin d'ajout de fichier
        
        request.getRequestDispatcher("/result1.jsp").forward(request, response);

    }

}

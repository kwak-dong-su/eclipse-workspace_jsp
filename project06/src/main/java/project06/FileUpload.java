package project06;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


@WebServlet("/upload")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandler(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandler(request, response);
	}
	
	protected void doHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		File currentDirPath=new File("c:\\file_repo");
		
		DiskFileItemFactory factory=new DiskFileItemFactory();
		factory.setRepository(currentDirPath); //파일이 저장되는 디렉토리 경로
		factory.setSizeThreshold(1024*1024); //파일 용량 제한
		
		ServletFileUpload upload=new ServletFileUpload(factory);
		
		try 
		{
			List items=upload.parseRequest(request);
			
			//첨부파일 뿐만 아니라 폼 데이터(text)도 전송된다.
			for(int i=0;i<items.size();i++)
			{
				FileItem fileItem=(FileItem)items.get(i);
				
				if(fileItem.isFormField()) //일반 파라미터인지 구분. 일반 파라미터라면 true
				{
					//일반 text 파라미터
					System.out.println(fileItem.getFieldName()+"="+fileItem.getString("utf-8"));
				}
				else
				{
					//첨부파일 파라미터
					System.out.println("파라미터명:"+fileItem.getFieldName());
					System.out.println("파일명:"+fileItem.getName());
					System.out.println("파일크기:"+fileItem.getSize()+"bytes");
					System.out.println("첨부파일타입:"+fileItem.getContentType());
					
					//----- IE 대비해서 처리용
					System.out.println(fileItem.getName().lastIndexOf("\\"));
					System.out.println(fileItem.getName()+"");
					
					if(fileItem.getSize()>0)
					{
						int idx=fileItem.getName().lastIndexOf("\\");
						if(idx==-1) 
						{
							idx=fileItem.getName().lastIndexOf("\\");
						}
						String fileName=fileItem.getName().substring(idx+1);
						System.out.println("filename"+fileName);
						File uploadfile=new File(currentDirPath+"\\"+fileName);
						
						//---추가 문장
						if(uploadfile.exists()) //파일 저장 위치에 해당 이름에 첨부파일이 있다면
						{
							int fileName_idx=fileName.lastIndexOf(".");
							
							SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
							Calendar c=Calendar.getInstance();
							String strToday=sdf.format(c.getTime());
							//중복되지 않는 파일명생성
							String new_fileName=fileName.substring(0, fileName_idx-1)+"_"+strToday
									+fileName.substring(fileName_idx); //확장자
							
							File uploadFile_new=new File(currentDirPath+"\\"+new_fileName);
							fileItem.write(uploadFile_new); //디렉토리에 저장
						}
						else
						{
							fileItem.write(uploadfile); //디렉토리에 저장
						}
						
						
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath()+"/result");
	}

	
}

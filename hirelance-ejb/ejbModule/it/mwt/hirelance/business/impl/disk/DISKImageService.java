package it.mwt.hirelance.business.impl.disk;

import java.io.File;
import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.mwt.hirelance.business.exceptions.BusinessException;
import it.mwt.hirelance.business.model.UploadedFile;
import it.mwt.hirelance.business.utils.FileUploadUtility;
import it.mwt.hirelance.business.ImageServiceRemote;
import it.mwt.hirelance.business.PathPropertyLoader;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.apache.commons.io.FileUtils;

/**
 * Session Bean implementation class DISKImageService
 */
@Stateless
@Remote(ImageServiceRemote.class)
@LocalBean
public class DISKImageService implements ImageServiceRemote {

	
	
	@PersistenceContext(unitName="HL")
	private EntityManager em;
	
	@EJB
	private PathPropertyLoader pathProperty;
	
    /**
     * Default constructor. 
     */
    public DISKImageService() {
        // TODO Auto-generated constructor stub
    }
    

	
	
	@Override
	public void saveProfileImage(UploadedFile image, int userID, String relativePath) throws BusinessException {
		System.out.println("======================= basePAth= " + pathProperty.getBasePath());
		
		System.out.println("relativePath: " + relativePath);
		
		image.setRelativePath(userID + relativePath);
		
		File file = new File(pathProperty.getBasePath() + image.getRelativePath() + image.getFileName());
		
		try {
			FileUtils.writeByteArrayToFile(file, image.getArrayByte());
			System.out.println("  ======================= FILE UPLOAD OK ============================== ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public UploadedFile getImage(int imageID) throws BusinessException {
       
        UploadedFile image = em.find(UploadedFile.class, imageID);
        
        File file = new File(pathProperty.getBasePath() + image.getRelativePath() + image.getFileName());
        
        try {
			image.setArrayByte(FileUtils.readFileToByteArray(file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
		return image;
	}

	@Override
	public void updateProfileImage(UploadedFile image, UploadedFile oldImage) throws BusinessException {
		
		System.out.println("OldPath: " + oldImage.getRelativePath());
		File oldFile = new File(pathProperty.getBasePath() + oldImage.getRelativePath() + oldImage.getFileName());
		File newFile = new File(pathProperty.getBasePath() + oldImage.getRelativePath() + image.getFileName());
		image.setRelativePath(oldImage.getRelativePath());
		oldFile.delete();
		
        	try {
        		FileUtils.writeByteArrayToFile(newFile, image.getArrayByte());
				System.out.println("  ======================= NUOVO FILE UPLOAD OK ============================== ");
				System.out.println(pathProperty.getBasePath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
     }
	
	@Override
	public void deleteImages(String folderPath) throws BusinessException{
		//System.out.println("La directory da cancellare è: "+basePath+folderPath);
		File folder = new File(pathProperty.getBasePath()+folderPath);
		if(folder.exists()){
			try {
				FileUploadUtility.deleteProfileFiles(folder);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		else{
			//System.out.println("La directory non esiste");
		}
	}

}

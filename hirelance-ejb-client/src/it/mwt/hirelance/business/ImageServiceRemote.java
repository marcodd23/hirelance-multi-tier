package it.mwt.hirelance.business;

import it.mwt.hirelance.business.exceptions.BusinessException;
import it.mwt.hirelance.business.model.UploadedFile;

import javax.ejb.Remote;

@Remote
public interface ImageServiceRemote {

	void saveProfileImage(UploadedFile image, int userID, String relativePath) throws BusinessException;
	void updateProfileImage(UploadedFile image, UploadedFile oldImage) throws BusinessException;
	void deleteImages(String folderPath) throws BusinessException;
	UploadedFile getImage(int imageID) throws BusinessException;
}

package com.didiElectrician.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import com.didiElectrician.domain.vo.FileUploadVo;
import org.springframework.web.multipart.MultipartFile;


/**
 * @Description 简单的文件上传工具类
 * @Author <wuyiliang 757210697@qq.com>
 * @Date 2015年8月7日 下午1:29:50
 * @CopyRight 2015 TopView Inc
 * @version V1.0
 */
public class FileUploadUtil {

    private static String fileUploadPath = "didiUpload"; // 相对路径的"父"文件夹
//	private static Calendar calendar = Calendar.getInstance();
    //private static String datePath = calendar.get(Calendar.YEAR) +
    //		"-" + ( calendar.get(Calendar.MONTH)+1<10 ? "0" + calendar.get(Calendar.MONTH)+1 : calendar.get(Calendar.MONTH)+1); 	// 每月生成一次路径，如：2016-11

    /**
     * 保存单个文件,返回文件保存的相对路径
     *
     * @param file
     * @param path
     *            文件夹名
     * @param request
     * @return
     */
    public static FileUploadVo uploadFile(MultipartFile file, String path,
                                          HttpServletRequest request, boolean createFileName) {
        if (file.isEmpty()) {
            return null;
        }
        String projectName = request.getContextPath().substring(1); // 项目名：即
        // "school"
        //path+="/" + datePath;
        String realPath = request.getSession().getServletContext()
                .getRealPath(path);
        realPath = realPath.replace(projectName, fileUploadPath);// 设置文件存储的绝对路径
        String fileName = file.getOriginalFilename();
        if (createFileName) {
            fileName = createFileName(file);
        }
        File file2 = new File(realPath, fileName);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        try {
            file.transferTo(file2); // 保存文件到绝对路径
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        FileUploadVo vo = new FileUploadVo();
        vo.setFileName(fileName);
        vo.setRealPath(realPath);
        vo.setRelativePath("/" + fileUploadPath + "/" + path + "/" + fileName);
        return vo;
    }


    public static String setThumbnailPath(String path,String fileName){
        if(NotEmptyString.isNotEmpty(new String[] {path,fileName})){
            return "/"+ fileUploadPath + "/" +path + "/thumb/" + fileName;
        }
        return "error";
    }

    /**
     * 保存文件数组
     *
     * @param files
     * @param path
     * @param request
     * @return
     */
    public static List<FileUploadVo> uploadFile(MultipartFile[] files,
                                                String path, HttpServletRequest request, boolean createFileName) {
        List<FileUploadVo> vos = new ArrayList<FileUploadVo>();
        for (MultipartFile file : files) {
            FileUploadVo vo = uploadFile(file, path, request, createFileName);
            vos.add(vo);
        }
        return vos;
    }

    /**
     * 根据系统时间生成文件名
     *
     * @param file
     * @return
     */
    private static String createFileName(MultipartFile file) {
        String tempName = file.getOriginalFilename();
        int index = tempName.lastIndexOf(".");
        tempName = tempName.substring(index, tempName.length()); // 截取文件类型
        return UUIDUtil.getUUID().substring(0,3) + System.currentTimeMillis() + tempName;
    }


    /**
     *
     * @Title: getImageEnd
     * @Description: TODO
     * @param @param imgFile
     * @param @param types
     * @param @return
     * @return String
     * @throws
     */
    public static String getImageEnd(String fileName) {

        String types = Arrays.toString(ImageIO.getReaderFormatNames());

        String suffix = null;
        // 获取图片后缀
        if (fileName.indexOf(".") > -1) {
            suffix = fileName.substring(
                    fileName.lastIndexOf(".") + 1);
        }// 类型和图片后缀全部小写，然后判断后缀是否合法
        if (suffix == null
                || types.toLowerCase().indexOf(suffix.toLowerCase()) < 0) {
            System.out.println("the format of this file is not available");
            return null;
        }
        return suffix;
    }


    public static MultipartFile[] orderFiles(MultipartFile[] files, List<String> fileNames) {
        int filesLength = files.length,j=0;
        String simpleName;
        if(filesLength != fileNames.size()) return null;
        MultipartFile[] temp = new MultipartFile[files.length];
        for(int i=0;i<filesLength;i++) {
            simpleName = fileNames.get(i);
            j = 0;
            for(j=0;j<filesLength;j++) {
                if(files[j].getOriginalFilename().equals(simpleName)) {
                    temp[i] = files[j];
                    break;
                }
            }
            if(j == filesLength) return null;
        }
        return temp;
    }


}
